import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Sistema {
    private final List<Veiculo> veiculos;
    private final List<Cliente> clientes;
    private final List<ClientePJ> listaDeClientesPJ;
    private final List<Agencia> agencias;
    private final List<LocadoraSantander> alugueis;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Sistema() {
        veiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        listaDeClientesPJ = new ArrayList<>();
        agencias = new ArrayList<>();
        alugueis = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        if (veiculos.contains(veiculo)) return;
        veiculos.add(veiculo);
    }

    public Optional<Veiculo> buscarVeiculoPorModelo(String parteDoNome) {
        return veiculos.stream()
                .filter(veiculo -> veiculo.getModelo().toLowerCase().contains(parteDoNome.toLowerCase()))
                .findFirst();
    }

    public void alterarVeiculo(String placaAntiga, String novaPlaca, String modelo, String novaCor) {
        veiculos.stream()
                .filter(v -> v.getModelo().equals(modelo) && v.getPlaca().equals(placaAntiga))
                .findFirst()
                .ifPresent(veiculo -> {
                    veiculo.setPlaca(novaPlaca);
                    veiculo.setCor(novaCor);
                });
    }

    public void listarVeiculos() {
        veiculos.forEach(System.out::println);
    }

    public void cadastrarAgencia(Agencia agencia) {
        if (agencias.contains(agencia)) return;
        agencias.add(agencia);
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
        buscarAgenciaPorCidade(cidade)
                .ifPresent(agencia -> {
                    agencia.setNome(novoNome);
                    agencia.setCidade(novaCidade);
                });
    }

    public void listarAgencias() {
        agencias.forEach(System.out::println);
    }

    public void cadastrarCliente(Cliente cliente) {
        if (clientes.contains(cliente)) return;
        clientes.add(cliente);
        if (cliente instanceof ClientePJ) listaDeClientesPJ.add((ClientePJ) cliente);
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
            for (Cliente cliente : clientes) {
                if (cliente instanceof ClientePF) {
                    ClientePF clientePF = (ClientePF) cliente;
                    System.out.printf("Cliente PF -> Nome: %s | Documento: %s | Idade: %d | Telefone: %d%n",
                            clientePF.getNome(), clientePF.getDocumento(), clientePF.getIdade(), clientePF.getTelefone());
                } else if (cliente instanceof ClientePJ) {
                    ClientePJ clientePJ = (ClientePJ) cliente;
                    System.out.printf("Cliente PJ -> Nome da Empresa: %s | CNPJ: %s | Idade do Responsável: %d | Telefone: %d%n",
                            clientePJ.getNome(), clientePJ.getDocumento(), clientePJ.getIdadeDoResponsavel(), clientePJ.getTelefone());
                }
            }
        }
    }

    public void listarLocacoes() {
        alugueis.forEach(System.out::println);
    }

    public void alugarVeiculo(String documentoCliente, String modeloVeiculo, String cidadeAgencia) {
        Optional<Cliente> clienteOpt = procurarClientePeloDocumento(documentoCliente);
        Optional<Veiculo> veiculoOpt = buscarVeiculoPorModelo(modeloVeiculo);
        Optional<Agencia> agenciaOpt = buscarAgenciaPorCidade(cidadeAgencia);

        if (clienteOpt.isEmpty() || veiculoOpt.isEmpty() || agenciaOpt.isEmpty() || veiculoOpt.get().isAlugado()) return;

        LocadoraSantander aluguel = new LocadoraSantander(veiculoOpt.get(), clienteOpt.get(), agenciaOpt.get(), LocalDateTime.now());
        alugueis.add(aluguel);
        veiculoOpt.get().alugar();
    }

    public void entregarVeiculo(String documentoCliente, String modeloVeiculo, String cidadeAgenciaDevolucao) {
        alugueis.stream()
                .filter(aluguel -> aluguel.getCliente().getDocumento().equals(documentoCliente) &&
                        aluguel.getVeiculo().getModelo().equals(modeloVeiculo) &&
                        aluguel.getDevolucaoData() == null)
                .findFirst()
                .ifPresent(aluguel -> {
                    Agencia agenciaDevolucao = buscarAgenciaPorCidade(cidadeAgenciaDevolucao).orElse(null);
                    if (agenciaDevolucao != null) {
                        aluguel.entregarVeiculo(LocalDateTime.now(), agenciaDevolucao);
                    }
                });
    }

    private void criarPastaSeNaoExistir(String caminhoPasta) throws IOException {
        Path path = Paths.get(caminhoPasta);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }
    }

    public void salvarClientesExcel() throws IOException {
        String caminhoPasta = "dados";
        String caminhoArquivo = caminhoPasta + "/clientes.csv";
        criarPastaSeNaoExistir(caminhoPasta);

        List<String> linhas = clientes.stream()
                .map(cliente -> {
                    String idade = (cliente instanceof ClientePF) ? String.valueOf(((ClientePF) cliente).getIdade()) :
                            (cliente instanceof ClientePJ) ? String.valueOf(((ClientePJ) cliente).getIdadeDoResponsavel()) : "N/A";
                    return String.join(",", cliente.getNome(), cliente.getDocumento(), idade, String.valueOf(cliente.getTelefone()));
                })
                .collect(Collectors.toList());
        Files.write(Paths.get(caminhoArquivo), linhas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void salvarVeiculosExcel() throws IOException {
        String caminhoPasta = "dados";
        String caminhoArquivo = caminhoPasta + "/veiculos.csv";
        criarPastaSeNaoExistir(caminhoPasta);

        List<String> linhas = veiculos.stream()
                .map(veiculo -> String.join(",", veiculo.getModelo(), veiculo.getPlaca(), veiculo.getCor(), String.valueOf(veiculo.isAlugado())))
                .collect(Collectors.toList());
        Files.write(Paths.get(caminhoArquivo), linhas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void salvarAgenciasExcel() throws IOException {
        String caminhoPasta = "dados";
        String caminhoArquivo = caminhoPasta + "/agencias.csv";
        criarPastaSeNaoExistir(caminhoPasta);

        List<String> linhas = agencias.stream()
                .map(agencia -> String.join(",", agencia.getNome(), agencia.getCidade()))
                .collect(Collectors.toList());
        Files.write(Paths.get(caminhoArquivo), linhas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public List<String> lerArquivoCSV(String caminhoArquivo) throws IOException {
        Path path = Paths.get(caminhoArquivo);
        if (Files.exists(path)) {
            return Files.readAllLines(path);
        }
        return new ArrayList<>();
    }

    public void atualizarArquivoCSV(String caminhoArquivo, List<String> novasLinhas) throws IOException {
        Files.write(Paths.get(caminhoArquivo), novasLinhas, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }

    public void editarCliente(String documento, String novoNome, String novoDocumento, String novaIdade, String novoTelefone) throws IOException {
        String caminhoArquivo = "dados/clientes.csv";
        List<String> linhas = lerArquivoCSV(caminhoArquivo);
        List<String> novasLinhas = linhas.stream()
                .map(linha -> {
                    String[] dados = linha.split(",");
                    if (dados[1].equals(documento)) {
                        return String.join(",", novoNome, novoDocumento, novaIdade, novoTelefone);
                    }
                    return linha;
                })
                .collect(Collectors.toList());
        atualizarArquivoCSV(caminhoArquivo, novasLinhas);
    }

    public void editarVeiculo(String placa, String novoModelo, String novaPlaca, String novaCor, boolean alugado) throws IOException {
        String caminhoArquivo = "dados/veiculos.csv";
        List<String> linhas = lerArquivoCSV(caminhoArquivo);
        List<String> novasLinhas = linhas.stream()
                .map(linha -> {
                    String[] dados = linha.split(",");
                    if (dados[1].equals(placa)) {
                        return String.join(",", novoModelo, novaPlaca, novaCor, String.valueOf(alugado));
                    }
                    return linha;
                })
                .collect(Collectors.toList());
        atualizarArquivoCSV(caminhoArquivo, novasLinhas);
    }

    public void editarAgencia(String nome, String novaCidade) throws IOException {
        String caminhoArquivo = "dados/agencias.csv";
        List<String> linhas = lerArquivoCSV(caminhoArquivo);
        List<String> novasLinhas = linhas.stream()
                .map(linha -> {
                    String[] dados = linha.split(",");
                    if (dados[0].equals(nome)) {
                        return String.join(",", nome, novaCidade);
                    }
                    return linha;
                })
                .collect(Collectors.toList());
        atualizarArquivoCSV(caminhoArquivo, novasLinhas);
    }
}

