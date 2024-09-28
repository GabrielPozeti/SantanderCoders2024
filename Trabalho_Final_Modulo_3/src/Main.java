import java.util.Scanner;

public class Main {

    public static Sistema sistema = new Sistema();
    public static Scanner input = new Scanner(System.in);

    public static class Logo {
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";

        public static void exibirLogoLocadora() {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║ ............................." + ANSI_RED + ":" + ANSI_RESET + ".........................║");
            System.out.println("║  ... ... ... ..  ...... ...." + ANSI_RED + "**" + ANSI_RESET + ". ... ... ......  .. ....║");
            System.out.println("║ ...... ... .......... ...  " + ANSI_RED + "+** " + ANSI_RESET + ":..... ... ..........  .║");
            System.out.println("║  ... ... ... ..  ...... ..." + ANSI_RED + "****" + ANSI_RESET + ".... ... ......  .. ....║");
            System.out.println("║ ...... ... .......... ... " + ANSI_RED + "+*****: " + ANSI_RESET + "... ... .......... . ║");
            System.out.println("║  ... ... ... ..  ......::*" + ANSI_RED + "****=" + ANSI_RESET + " ... ......  .. ....... ║");
            System.out.println("║ ...... ... ..........." + ANSI_RED + "+*" + ANSI_RESET + "..." + ANSI_RED + ".:******:." + ANSI_RESET + " ... ..........  .║");
            System.out.println("║  ... ... ... ..  ...." + ANSI_RED + "-**-" + ANSI_RESET + "..." + ANSI_RED + ":******-.." + ANSI_RESET + "......  .... ... ║");
            System.out.println("║ ...... ... .......... " + ANSI_RED + "+***." + ANSI_RESET + "...." + ANSI_RED + ".+*****=" + ANSI_RESET + "... .......... .║");
            System.out.println("║  ... ... ... ..  ...." + ANSI_RED + "-****:" + ANSI_RESET + "....." + ANSI_RED + "-*****=" + ANSI_RESET + ".......  .. ... ║");
            System.out.println("║ ...... ... ..........." + ANSI_RED + "*****=." + ANSI_RESET + "...." + ANSI_RED + "*****" + ANSI_RESET + ".. ..........  ..║");
            System.out.println("║  ... ... ... ..  ......" + ANSI_RED + "+*****:" + ANSI_RESET + " ..." + ANSI_RED + "+***:" + ANSI_RESET + "......  .. .....║");
            System.out.println("║ ..............." + ANSI_RED + "=**+" + ANSI_RESET + "....." + ANSI_RED + "=*****+" + ANSI_RESET + "...." + ANSI_RED + ":*****=:" + ANSI_RESET + ".......... .║");
            System.out.println("║  ... ... " + ANSI_RED + ".:*********" + ANSI_RESET + "... " + ANSI_RED + ".:******:" + ANSI_RESET + ".. " + ANSI_RED + "+*********-... " + ANSI_RESET + "....║");
            System.out.println("║ ......." + ANSI_RED + ":*************:" + ANSI_RESET + "... " + ANSI_RED + ".+*****:" + ANSI_RESET + ".." + ANSI_RED + "*************=.." + ANSI_RESET + " ..║");
            System.out.println("║  ...." + ANSI_RED + "-****************=" + ANSI_RESET + "...." + ANSI_RED + "+=*****." + ANSI_RESET + ":" + ANSI_RED + "***************+:" + ANSI_RESET + "..║");
            System.out.println("║ ...." + ANSI_RED + "+*******************" + ANSI_RESET + "....." + ANSI_RED + "=****+******************" + ANSI_RESET + "..║");
            System.out.println("║ ..." + ANSI_RED + "*********************:. " + ANSI_RESET + ".." + ANSI_RED + "+***********************" + ANSI_RESET + "..║");
            System.out.println("║ ..." + ANSI_RED + "=**********************=" + ANSI_RESET + ".. " + ANSI_RED + "+**********************" + ANSI_RESET + "..║");
            System.out.println("║ ..." + ANSI_RED + ":***********************+" + ANSI_RESET + ".." + ANSI_RED + "+**********************" + ANSI_RESET + "..║");
            System.out.println("║ ...." + ANSI_RED + ":***********************-+**********************+" + ANSI_RESET + "..║");
            System.out.println("║ ......" + ANSI_RED + "=********************************************:" + ANSI_RESET + ".. ║");
            System.out.println("║ ........" + ANSI_RED + ":+**************************************=" + ANSI_RESET + "..... ║");
            System.out.println("║ ............" + ANSI_RED + "-+*****************************+=:" + ANSI_RESET + "........ ║");
            System.out.println("║ ................." + ANSI_RED + "::=++**************+=-:" + ANSI_RESET + ".............. ║");
            System.out.println("║ ...................................................... ║");
            System.out.println("║                                                        ║");
            System.out.println("║      Bem-vindo(a) à Locadora Santander Coders 2024!    ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");
            System.out.println();

        }
    }

    public static void main(String[] args) {

        while (true) {
            Logo.exibirLogoLocadora();
            exibirMenu();
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    sistema.listarClientes();
                    break;
                case 4:
                    cadastrarVeiculo();
                    break;
                case 5:
                    alterarVeiculo();
                    break;
                case 6:
                    buscarVeiculo();
                    break;
                case 7:
                    listarVeiculos();
                    break;
                case 8:
                    cadastrarAgencia();
                    break;
                case 9:alterarAgencia();
                break;
                case 10: listarAgencias();
                break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha inválida, por favor digite uma opção válida");
                    break;
            }
        }
    }


    public static void exibirMenu() {
        System.out.println("""
                Menu Aluguel de Veículos:
                (Digite o número da opção desejada)
                                
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
                                
                0- Sair""");

    }

    //CLIENTES

    public static void cadastrarCliente() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                    Cadastro de Cliente:
                    (Digite o número da opção desejada)
                                        
                    1- Cadastrar nova Pessoa Física
                    2- Cadastrar nova Pessoa Jurídica
                    0- Retornar ao menu inicial""");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1:
                    ClientePF.realizarCadastro(sistema);
                    continuar = false;
                    break;

                case 2:
                    ClientePJ.realizarCadastro(sistema);
                    continuar = false;
                    break;
                case 0:
                    System.out.println("Retornando ao menu inicial...");
                    continuar = false;
                    break;

                default:
                    System.out.println("Escolha inválida, por favor digite uma opção válida.");
            }
        }
    }


    public static void buscarCliente() {
        System.out.println("Digite o documento do cliente que está buscando: ");
        String documento = input.nextLine();

        Cliente buscaCliente = sistema.buscarClientePorDocumento(documento);
        if (buscaCliente != null) {
            System.out.println("Cliente encontrado no sistema!");
        } else {
            System.out.println("Cliente não encontrado no sistema.");
        }
    }

    //VEÍCULOS

    public static void cadastrarVeiculo() {
        System.out.println("\nCadastro de Veículo:\n");
        System.out.println("Modelo: ");
        String modelo = input.nextLine();

        System.out.println("Placa: ");
        String placa = input.nextLine();

        System.out.println("Cor: ");
        String cor = input.nextLine();

        System.out.println("""
                Tipo de Veículo:
                (Digite o número da opção desejada)

                1- Carro
                2- Moto
                3- Caminhão""");
        int tipoVeiculo = input.nextInt();
        input.nextLine();

        Veiculo veiculo = null;
        switch (tipoVeiculo) {
            case 1:
                veiculo = new Carro(modelo, placa, cor);
            case 2:
                veiculo = new Moto(modelo, placa, cor);
            case 3:
                veiculo = new Caminhao(modelo, placa, cor);
                sistema.cadastrarVeiculo(veiculo);
            default:
                System.out.println("Escolha inválida, veículo não cadastrado.");
                return;
        }
    }


    public static void alterarVeiculo() {
        System.out.println("Digite o modelo do veículo que deseja alterar: ");
        String modelo = input.nextLine();

        Veiculo veiculo = sistema.buscarVeiculoPorModelo(modelo);
        if (veiculo == null) {
            System.out.println("Veículo não encontrado no sistema.");
        } else {
            System.out.println("Placa atual: " + veiculo.getPlaca() + "\nNova Placa: ");
            String novaPlaca = input.nextLine();

            System.out.println("Cor atual: " + veiculo.getCor() + "\nNova Cor: ");
            String novaCor = input.nextLine();

            sistema.alterarVeiculo(modelo, novaPlaca, novaCor);
        }
    }


    public static void buscarVeiculo() {
        System.out.println("Digite o modelo do veículo que deseja encontrar: ");
        String parteDoNome = input.nextLine();

        Veiculo veiculo = sistema.buscarVeiculoPorModelo(parteDoNome);
        if (veiculo != null) {
            System.out.println(veiculo);
        } else {
            System.out.println("Veículo não encontrado no sistema.");
        }
    }


    public static void listarVeiculos() {
        System.out.println("Lista de Veículos: ");
        sistema.listarVeiculos();
    }

    //AGÊNCIA

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

        Agencia agencia = sistema.buscarAgenciaPorCidade(cidade);
        if (agencia == null) {
            System.out.println("Agência não encontrada no sistema.");
        return;
        }

        System.out.println("Nome atual: " + agencia.getNome() + "\nNovo Nome: ");
        String novoNome = input.nextLine();

        System.out.println("Cidade atual: " + agencia.getCidade() + "\nNova Cidade: ");
        String novaCidade = input.nextLine();

        sistema.alterarAgencia(novoNome, cidade,novaCidade);
    }


    public static void listarAgencias() {
        System.out.println("Lista de Agências: ");
        sistema.listarAgencias();
    }
}
