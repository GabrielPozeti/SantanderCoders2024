import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Veiculo> buscarVeiculoPorModelo(String parteDoNome) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getModelo().toLowerCase().contains(parteDoNome.toLowerCase()))
                .findFirst();
    }

    public void alterarVeiculo(String placaAntiga, String novaPlaca, String modelo, String novaCor) {
        Optional<Veiculo> veiculoOpt = veiculos.stream()
                .filter(v -> v.getModelo().equals(modelo) && v.getPlaca().equals(placaAntiga))
                .findFirst();

        veiculoOpt.ifPresentOrElse(veiculo -> {
            veiculo.setPlaca(novaPlaca);
            veiculo.setCor(novaCor);
            System.out.println("Veículo alterado com sucesso!");
        }, () -> System.out.println("Veículo não encontrado no sistema."));
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado no sistema.");
        } else {
            veiculos.stream()
                    .map(Veiculo::toString)
                    .forEach(System.out::println);
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

    public Optional<Agencia> buscarAgenciaPorNome(String nome) {
        return agencias.stream()
                .filter(agencia -> agencia.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public Optional<Agencia> buscarAgenciaPorCidade(String cidade) {
        return agencias.stream()
                .filter(agencia -> agencia.getCidade().equalsIgnoreCase(cidade))
                .findFirst();
    }

    public void alterarAgencia(String novoNome, String cidade, String novaCidade) {
        Optional<Agencia> agenciaOpt = buscarAgenciaPorCidade(cidade);
        agenciaOpt.ifPresentOrElse(agencia -> {
            agencia.setNome(novoNome);
            agencia.setCidade(novaCidade);
            System.out.println("Agência alterada com sucesso!");
        }, () -> System.out.println("Agência não encontrada no sistema."));
    }

    public void listarAgencias() {
        if (agencias.isEmpty()) {
            System.out.println("Nenhuma agência cadastrada no sistema.");
        } else {
            agencias.stream()
                    .map(Agencia::toString)
                    .forEach(System.out::println);
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

    public Optional<Cliente> procurarClientePeloDocumento(String documento) {
        return clientes.stream()
                .filter(cliente -> cliente.getDocumento().equals(documento))
                .findFirst();
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no sistema.");
        } else {
            clientes.stream()
                    .map(Cliente::toString)
                    .forEach(System.out::println);
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
        Optional<Cliente> clienteOpt = procurarClientePeloDocumento(documentoCliente);
        Optional<Veiculo> veiculoOpt = buscarVeiculoPorModelo(modeloVeiculo);
        Optional<Agencia> agenciaOpt = buscarAgenciaPorCidade(cidadeAgencia);

        if (clienteOpt.isEmpty()) {
            System.out.println("Cliente não encontrado no sistema.");
            return;
        }
        if (veiculoOpt.isEmpty()) {
            System.out.println("Veículo não encontrado no sistema.");
            return;
        }
        if (agenciaOpt.isEmpty()) {
            System.out.println("Agência não encontrada no sistema.");
            return;
        }
        if (veiculoOpt.get().isAlugado()) {
            System.out.println("Veículo já está alugado.");
            return;
        }

        LocadoraSantander aluguel = new LocadoraSantander(veiculoOpt.get(), clienteOpt.get(), agenciaOpt.get(), LocalDateTime.now());
        alugueis.add(aluguel);
        veiculoOpt.get().alugar();
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
        Optional<LocadoraSantander> aluguelOpt = alugueis.stream()
                .filter(aluguel -> aluguel.getCliente().getDocumento().equals(documentoCliente) &&
                        aluguel.getVeiculo().getModelo().equals(modeloVeiculo) &&
                        aluguel.getDevolucaoData() == null)
                .findFirst();

        if (aluguelOpt.isPresent()) {
            Agencia agenciaDevolucao = buscarAgenciaPorCidade(cidadeAgenciaDevolucao).orElse(null);
            if (agenciaDevolucao == null) {
                System.out.println("Agência para devolução não encontrada.");
                return;
            }

            aluguelOpt.get().entregarVeiculo(LocalDateTime.now(), agenciaDevolucao);
            System.out.println("Veículo entregue com sucesso!\n");
            System.out.println("Comprovante:");
            System.out.println("Dados do Cliente: ");
            System.out.println("Nome: " + aluguelOpt.get().getCliente().getNome());
            System.out.println("Documento: " + aluguelOpt.get().getCliente().getDocumento());
            System.out.println("Telefone: " + aluguelOpt.get().getCliente().getTelefone() + "\n");
            System.out.println("Dados do Veículo: ");
            System.out.println("Modelo: " + aluguelOpt.get().getVeiculo().getModelo());
            System.out.println("Placa: " + aluguelOpt.get().getVeiculo().getPlaca());
            System.out.println("Cor: " + aluguelOpt.get().getVeiculo().getCor() + "\n");
            System.out.println("Agência: " + aluguelOpt.get().getAgencia().getNome() + ", na cidade de " + aluguelOpt.get().getAgencia().getCidade() + "\n");
            System.out.println("Data e Hora da Devolução: " + dataHoraFormatada + "\n");
            System.out.printf("Valor Total: R$%.2f\n", aluguelOpt.get().getValorTotal());
        } else {
            System.out.println("Nenhum aluguel encontrado para este cliente e veículo.");
        }
    }
}
