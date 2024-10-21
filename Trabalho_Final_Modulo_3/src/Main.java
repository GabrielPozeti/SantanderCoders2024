import java.util.Optional;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.IOException;

public class Main {

    public static Sistema sistema = new Sistema();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Logo.exibirLogoLocadora();
        while (true) {
            exibirMenu();
            int escolha = obterEscolhaMenu();

            switch (escolha) {
                case 1 -> cadastrarCliente();
                case 2 -> buscarCliente();
                case 3 -> sistema.listarClientes();
                case 4 -> cadastrarVeiculo();
                case 5 -> alterarVeiculo();
                case 6 -> buscarVeiculo();
                case 7 -> listarVeiculos();
                case 8 -> cadastrarAgencia();
                case 9 -> alterarAgencia();
                case 10 -> listarAgencias();
                case 11 -> alugarVeiculo();
                case 12 -> entregarVeiculo();
                case 13 -> listarLocacoes();
                case 14 -> salvarClientesNoExcel();
                case 15 -> salvarVeiculosNoExcel();
                case 16 -> salvarAgenciasNoExcel();
                case 0 -> System.exit(0);
                default -> System.out.println("Escolha inválida, por favor digite uma opção válida");
            }
        }
    }

    public static void exibirMenu() {
        System.out.println("""
                \nMenu Aluguel de Veículos:
                
                Clientes:
                1- Cadastrar novo cliente
                2- Buscar cliente
                3- Verificar lista de clientes
                
                Veículos:
                4- Cadastrar novo veículo
                5- Alterar veículo cadastrado
                6- Buscar veículo
                7- Verificar lista de veículos
                
                Agência:
                8- Cadastrar nova agência
                9- Alterar agência cadastrada
                10- Verificar lista de agências
                
                Locação:
                11- Alugar veículo
                12- Devolver veículo
                13- Verificar lista de veículos alugados
                
                Exportação:
                14- Exportar clientes para CSV
                15- Exportar veículos para CSV
                16- Exportar agências para CSV
                
                0- Sair
                
                Digite o número da opção desejada:
                """);
    }

    private static int obterEscolhaMenu() {
        int escolha;
        while (true) {
            try {
                escolha = input.nextInt();
                input.nextLine();
                return escolha;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                input.nextLine();
            }
        }
    }

    public static void cadastrarCliente() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                Cadastro de Cliente:
                (Digite o número da opção desejada)
                1- Cadastrar nova Pessoa Física
                2- Cadastrar nova Pessoa Jurídica
                0- Retornar ao menu inicial""");
            int escolha = obterEscolhaMenu();

            switch (escolha) {
                case 1 -> {
                    ClientePF.realizarCadastro(sistema);
                    continuar = false;
                }
                case 2 -> {
                    ClientePJ.realizarCadastro(sistema);
                    continuar = false;
                }
                case 0 -> {
                    System.out.println("Retornando ao menu inicial...");
                    continuar = false;
                }
                default -> System.out.println("Escolha inválida, por favor digite uma opção válida.");
            }
        }
    }

    public static void buscarCliente() {
        System.out.print("Digite o documento do cliente a ser buscado: ");
        String documento = input.nextLine();

        Optional<Cliente> buscaCliente = sistema.procurarClientePeloDocumento(documento);
        if (buscaCliente.isPresent()) {
            System.out.println("Cliente encontrado: " + buscaCliente.get());
        } else {
            System.out.println("Cliente não encontrado no sistema.");
        }
    }

    public static void cadastrarVeiculo() {
        System.out.println("\nCadastro de Veículo:\n");
        int tipoVeiculo = -1;

        while (tipoVeiculo < 1 || tipoVeiculo > 3) {
            System.out.println("""
                Tipo de Veículo:
                (Digite o número da opção desejada)
                1- Carro
                2- Moto
                3- Caminhão""");

            tipoVeiculo = obterEscolhaMenu();

            if (tipoVeiculo < 1 || tipoVeiculo > 3) {
                System.out.println("Escolha inválida, por favor digite uma opção válida.");
            }
        }

        System.out.println("Modelo do Veículo: ");
        String modelo = input.nextLine();

        System.out.println("Placa: ");
        String placa = input.nextLine();

        System.out.println("Cor: ");
        String cor = input.nextLine();

        Veiculo veiculo;
        switch (tipoVeiculo) {
            case 1 -> veiculo = new Carro(modelo, placa, cor);
            case 2 -> veiculo = new Moto(modelo, placa, cor);
            case 3 -> veiculo = new Caminhao(modelo, placa, cor);
            default -> {
                System.out.println("Escolha inválida, veículo não cadastrado.");
                return;
            }
        }

        sistema.cadastrarVeiculo(veiculo);
    }

    public static void alterarVeiculo() {
        System.out.print("Digite o modelo do veículo que deseja alterar: ");
        String modelo = input.nextLine();

        Optional<Veiculo> veiculo = sistema.buscarVeiculoPorModelo(modelo);
        if (veiculo.isEmpty()) {
            System.out.println("Veículo não encontrado no sistema.");
            return;
        }

        System.out.println("Placa atual: " + veiculo.get().getPlaca());
        String placaAntiga = veiculo.get().getPlaca();

        System.out.print("Nova Placa: ");
        String novaPlaca = input.nextLine();

        System.out.print("Cor atual: " + veiculo.get().getCor() + "\nNova Cor: ");
        String novaCor = input.nextLine();

        sistema.alterarVeiculo(placaAntiga, novaPlaca, modelo, novaCor);
    }

    public static void buscarVeiculo() {
        System.out.print("Digite o modelo do veículo que deseja encontrar: ");
        String parteDoNome = input.nextLine();

        Optional<Veiculo> veiculo = sistema.buscarVeiculoPorModelo(parteDoNome);
        if (veiculo.isPresent()) {
            System.out.println("Veículo encontrado: " + veiculo.get());
        } else {
            System.out.println("Veículo não encontrado no sistema.");
        }
    }

    public static void listarVeiculos() {
        System.out.println("Lista de Veículos: ");
        sistema.listarVeiculos();
    }

    public static void cadastrarAgencia() {
        System.out.println("Nome da Agência: ");
        String nome = input.nextLine();

        System.out.println("Cidade da Agência: ");
        String cidade = input.nextLine();

        Agencia agencia = new Agencia(nome, cidade);
        sistema.cadastrarAgencia(agencia);
    }

    public static void alterarAgencia() {
        System.out.println("Digite a cidade da agência que deseja alterar");
        String cidade = input.nextLine();

        Optional<Agencia> agencia = sistema.buscarAgenciaPorCidade(cidade);
        if (agencia.isEmpty()) {
            System.out.println("Agência não encontrada no sistema.");
            return;
        }

        System.out.println("Nome atual: " + agencia.get().getNome() + "\nNovo Nome: ");
        String novoNome = input.nextLine();

        System.out.println("Cidade atual: " + agencia.get().getCidade() + "\nNova Cidade: ");
        String novaCidade = input.nextLine();

        sistema.alterarAgencia(novoNome, cidade, novaCidade);
    }

    public static void listarAgencias() {
        System.out.println("Lista de Agências: ");
        sistema.listarAgencias();
    }

    public static void alugarVeiculo() {
        System.out.println("Documento do cliente: ");
        String documentoCliente = input.nextLine();

        Optional<Cliente> cliente = sistema.procurarClientePeloDocumento(documentoCliente);
        if (cliente.isEmpty()) {
            System.out.println("Cliente não encontrado. Não é possível alugar o veículo.");
            return;
        }

        System.out.println("Modelo do veículo: ");
        String modeloVeiculo = input.nextLine();

        System.out.println("Cidade da agência de retirada: ");
        String cidadeAgencia = input.nextLine();

        sistema.alugarVeiculo(documentoCliente, modeloVeiculo, cidadeAgencia);
    }

    public static void entregarVeiculo() {
        System.out.println("Digite o documento do cliente que deseja entregar o veículo: ");
        String documentoCliente = input.nextLine();

        System.out.println("Digite o modelo do veículo: ");
        String modeloVeiculo = input.nextLine();

        System.out.println("Digite a cidade da agência: ");
        String cidadeAgencia = input.nextLine();

        sistema.entregarVeiculo(documentoCliente, modeloVeiculo, cidadeAgencia);
    }

    public static void listarLocacoes() {
        sistema.listarLocacoes();
    }

    public static void salvarClientesNoExcel() {
        try {
            sistema.salvarClientesExcel();
            System.out.println("Clientes exportados com sucesso para");
        } catch (IOException e) {
            System.out.println("Erro ao exportar clientes: " + e.getMessage());
        }
    }

    public static void salvarVeiculosNoExcel() {
        try {
            sistema.salvarVeiculosExcel();
            System.out.println("Veículos exportados com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao exportar veículos: " + e.getMessage());
        }
    }

    public static void salvarAgenciasNoExcel() {
        try {
            sistema.salvarAgenciasExcel();
            System.out.println("Agências exportadas com sucesso");
        } catch (IOException e) {
            System.out.println("Erro ao exportar agências: " + e.getMessage());
        }
    }
}
