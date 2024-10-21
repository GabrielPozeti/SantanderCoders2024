import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    final private List<Veiculo> veiculos;
    final private List<Cliente> clientes;
    final private List<ClientePJ> listaDeClientesPJ;
    final private List<Agencia> agencias;
    final private List<LocadoraSantander> alugueis;

    LocalDateTime dataHoraAluguel = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    String dataHoraFormatada = dataHoraAluguel.format(formatter);

    public Sistema() {
        veiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        listaDeClientesPJ = new ArrayList<>();
        agencias = new ArrayList<>();
        alugueis = new ArrayList<>();
    }

    // VEÍCULOS
    public void cadastrarVeiculo(Veiculo veiculo) {
        if (veiculos.contains(veiculo)) {
            System.out.println("Veículo já cadastrado no sistema.");
            return;
        }
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    public Veiculo buscarVeiculoPorModelo(String parteDoNome) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getModelo().toLowerCase().contains(parteDoNome.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public void alterarVeiculo(String placaAntiga, String novaPlaca, String modelo, String novaCor) {
        veiculos.stream()
                .filter(veiculo -> veiculo.getModelo().equals(modelo) && veiculo.getPlaca().equals(placaAntiga))
                .findFirst()
                .ifPresentOrElse(veiculo -> {
                    veiculo.setPlaca(novaPlaca);
                    veiculo.setCor(novaCor);
                    System.out.println("Veículo alterado com sucesso!");
                }, () -> System.out.println("Veículo não encontrado no sistema."));
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado no sistema.");
        } else {
            veiculos.forEach(System.out::println);
        }
    }

    // AGÊNCIA
    public void cadastrarAgencia(Agencia agencia) {
        if (agencias.contains(agencia)) {
            System.out.println("Agência já cadastrada no sistema.");
            return;
        }
        agencias.add(agencia);
        System.out.println("Nova agência cadastrada com sucesso!");
    }

    public Agencia buscarAgenciaPorNome(String nome) {
        return agencias.stream()
                .filter(agencia -> agencia.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public Agencia buscarAgenciaPorCidade(String cidade) {
        return agencias.stream()
                .filter(agencia -> agencia.getCidade().equalsIgnoreCase(cidade))
                .findFirst()
                .orElse(null);
    }

    public void alterarAgencia(String novoNome, String cidade, String novaCidade) {
        Agencia agencia = buscarAgenciaPorCidade(cidade);
        if (agencia != null) {
            agencia.setNome(novoNome);
            agencia.setCidade(novaCidade);
            System.out.println("Agência alterada com sucesso!");
        } else {
            System.out.println("Agência não encontrada no sistema.");
        }
    }

    public void listarAgencias() {
        if (agencias.isEmpty()) {
            System.out.println("Nenhuma agência cadastrada no sistema.");
        } else {
            agencias.forEach(System.out::println);
        }
    }

    // CLIENTES
    public void cadastrarCliente(Cliente cliente) {
        if (clientes.contains(cliente)) {
            System.out.println("Cliente já cadastrado no sistema.");
            return;
        }
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");

        if (cliente instanceof ClientePJ) {
            listaDeClientesPJ.add((ClientePJ) cliente);
        }
    }

    public Cliente procurarClientePeloDocumento(String documento) {
        return clientes.stream()
                .filter(cliente -> cliente.getDocumento().equals(documento))
                .findFirst()
                .orElse(null);
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no sistema.");
        } else {
            clientes.forEach(System.out::println);
        }
    }

    // LOCAÇÃO
    public void listarLocacoes() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhuma locação registrada no sistema.");
        } else {
            System.out.println("Lista de Locações:");
            alugueis.forEach(System.out::println);
        }
    }

    public void alugarVeiculo(String documentoCliente, String modeloVeiculo, String cidadeAgencia) {
        Cliente cliente = procurarClientePeloDocumento(documentoCliente);
        Veiculo veiculo = buscarVeiculoPorModelo(modeloVeiculo);
        Agencia agencia = buscarAgenciaPorCidade(cidadeAgencia);

        if (cliente == null) {
            System.out.println("Cliente não encontrado no sistema.");
            return;
        }
        if (veiculo == null) {
            System.out.println("Veículo não encontrado no sistema.");
            return;
        }
        if (agencia == null) {
            System.out.println("Agência não encontrada no sistema.");
            return;
        }
        if (veiculo.isAlugado()) {
            System.out.println("Veículo já está alugado.");
            return;
        }

        LocadoraSantander aluguel = new LocadoraSantander(veiculo, cliente, agencia, LocalDateTime.now());
        alugueis.add(aluguel);
        veiculo.alugar();
        System.out.println("Veículo alugado com sucesso!\n");
        System.out.println("Comprovante:");
        System.out.println("Dados do Cliente: ");
        System.out.println("Nome: " + aluguel.getCliente().getNome());
        System.out.println("Documento: " + aluguel.getCliente().getDocumento() + "\n");
        System.out.println("Dados do Veículo: ");
        System.out.println("Modelo: " + aluguel.getVeiculo().getModelo());
        System.out.println("Placa: " + aluguel.getVeiculo().getPlaca());
        System.out.println("Cor: " + aluguel.getVeiculo().getCor() + "\n");
        System.out.println("Alugado na Agência: " + aluguel.getAgencia().getNome() + ", na cidade de " + aluguel.getAgencia().getCidade() + "\n");
        System.out.println("Data e Hora do Aluguel: " + dataHoraFormatada);
    }

    public void entregarVeiculo(String documentoCliente, String modeloVeiculo, String cidadeAgenciaDevolucao) {
        LocadoraSantander aluguelEncontrado = alugueis.stream()
                .filter(aluguel -> aluguel.getCliente().getDocumento().equals(documentoCliente) &&
                        aluguel.getVeiculo().getModelo().equals(modeloVeiculo) &&
                        aluguel.getDevolucaoData() == null)
                .findFirst()
                .orElse(null);

        if (aluguelEncontrado != null) {
            Agencia agenciaDevolucao = buscarAgenciaPorCidade(cidadeAgenciaDevolucao);
            if (agenciaDevolucao == null) {
                System.out.println("Agência para devolução não encontrada.");
                return;
            }

            aluguelEncontrado.entregarVeiculo(LocalDateTime.now(), agenciaDevolucao);
            System.out.println("Veículo entregue com sucesso!\n");
            System.out.println("Comprovante:");
            System.out.println("Dados do Cliente: ");
            System.out.println("Nome: " + aluguelEncontrado.getCliente().getNome());
            System.out.println("Documento: " + aluguelEncontrado.getCliente().getDocumento());
            System.out.println("Telefone: " + aluguelEncontrado.getCliente().getTelefone() + "\n");
            System.out.println("Dados do Veículo: ");
            System.out.println("Modelo: " + aluguelEncontrado.getVeiculo().getModelo());
            System.out.println("Placa: " + aluguelEncontrado.getVeiculo().getPlaca());
            System.out.println("Cor: " + aluguelEncontrado.getVeiculo().getCor() + "\n");
            System.out.println("Agência: " + aluguelEncontrado.getAgencia().getNome() + ", na cidade de " + aluguelEncontrado.getAgencia().getCidade() + "\n");
            System.out.println("Data e Hora da Devolução: " + dataHoraFormatada + "\n");
            System.out.printf("Valor Total: R$%.2f\n", aluguelEncontrado.getValorTotal());
        } else {
            System.out.println("Nenhum aluguel encontrado para este cliente e veículo.");
        }
    }
}
