import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    List<Veiculo> veiculos;
    List<Cliente> clientes;
    List<Agencia> agencias;
    List<LocadoraSantander> alugueis;

    public Sistema() {
        veiculos = new ArrayList<>();
        clientes = new ArrayList<>();
        agencias = new ArrayList<>();
        alugueis = new ArrayList<>();
    }

    //VEÍCULOS

    public void cadastrarVeiculo(Veiculo veiculo) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equals(veiculo.getPlaca())) {
                System.out.println("Veículo já cadastrado no sistema.");
                return;
            }
        }
        veiculos.add(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }


    public Veiculo buscarVeiculoPorModelo(String parteDoNome) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().contains(parteDoNome)) {
                return veiculo;
            }
        }
        return null;
    }


    public void alterarVeiculo(String NovaPlaca, String modelo, String NovaCor) {
        Veiculo veiculo = buscarVeiculoPorModelo(modelo);
        if (veiculo != null) {
            veiculo.setPlaca(NovaPlaca);
            veiculo.setCor(NovaCor);
            System.out.println("Veículo alterado com sucesso!");
        } else {
            System.out.println("Veículo não encontrado no sistema.");
        }
    }

    public void listarVeiculos() {
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado no sistema.");
        } else {
            for (Veiculo v : veiculos) {
                System.out.println(v);
            }
        }
    }

    //AGÊNCIA

    public void cadastrarAgencia(Agencia agencia) {
        boolean agenciaExiste = false;
        for (Agencia a : agencias) {
            if (a.getNome().equals(agencia.getNome())) {
                agenciaExiste = true;
                break;
            }
        }
        if (!agenciaExiste) {
            agencias.add(agencia);
            System.out.println("Nova agência cadastrada com sucesso!");
        } else {
            System.out.println("Agência já cadastrada no sistema.");
        }
    }


    public Agencia buscarAgenciaPorNome(String nome) {
        for (Agencia agencia : agencias) {
            if (agencia.getNome().equals(nome)) {
                return agencia;
            }
        }
        return null;
    }


    public Agencia buscarAgenciaPorCidade(String cidade) {
        for (Agencia agencia : agencias) {
            if (agencia.getCidade().equals(cidade)) {
                return agencia;
            }
        }
        return null;
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
            for (Agencia a : agencias) {
                System.out.println(a);
            }
        }
    }

    //CLIENTES

    public void cadastrarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            if (c.getDocumento().equals(cliente.getDocumento())) {
                System.out.println("Cliente já cadastrado no sistema.");
                return;
            }
        }
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }


    public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado no sistema.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    //LOCAÇÃO

    public void alugarVeiculo(String documentoCliente, String modeloVeiculo, String cidadeAgencia) {
        Cliente cliente = buscarClientePorDocumento(documentoCliente);
        Veiculo veiculo = buscarVeiculoPorModelo(modeloVeiculo);
        Agencia agencia = buscarAgenciaPorCidade(cidadeAgencia);

        if (cliente == null) {
            System.out.println("Cliente não encontrado no sistema.");
        }
        if (veiculo == null) {
            System.out.println("Veículo não encontrado no sistema.");
        }
        if (agencia == null) {
            System.out.println("Agência não encontrada no sistema.");
        }
        if (!veiculo.isAlugado()) {
            LocadoraSantander aluguel = new LocadoraSantander(veiculo, cliente, agencia, LocalDateTime.now());
            alugueis.add(aluguel);
            veiculo.setAlugado(true);

            System.out.println("""
                    Veículo alugado com sucesso!
                    
                    ***Comprovante:***""");
            System.out.println("Dados do Cliente: ");
            System.out.println("Nome: " + aluguel.getCliente().getNome());
            System.out.println("Documento: " + aluguel.getCliente().getDocumento() + "\n");
            System.out.println("Dados do Veículo: ");
            System.out.println("Modelo: " + aluguel.getVeiculo().getModelo());
            System.out.println("Placa: " + aluguel.getVeiculo().getPlaca());
            System.out.println("Cor: " + aluguel.getVeiculo().getCor() + "\n");
            System.out.println("Alugado na Agência: " + aluguel.getAgencia().getNome() + ", na cidade de " + aluguel.getAgencia().getCidade() + "\n");
            System.out.println("Data do Aluguel: " + aluguel.getAluguelData());

        } else {
            System.out.println("O veículo não está disponível para aluguel no momento.");
        }
    }


    public void entregarVeiculo(String documentoCliente, String modeloVeiculo, String cidadeAgencia) {
        LocadoraSantander aluguelEncontrado = null;
        for (LocadoraSantander aluguel : alugueis) {
            if (aluguel.getCliente().getDocumento().equals(documentoCliente) &&
                    aluguel.getVeiculo().getModelo().equals(modeloVeiculo) &&
                    aluguel.getDevolucaoData() == null) {
                aluguelEncontrado = aluguel;
                break;
            }
        }
        if (aluguelEncontrado != null) {
            aluguelEncontrado.entregarVeiculo(LocalDateTime.now(), buscarAgenciaPorCidade(cidadeAgencia));
            System.out.println("""
                    Veículo entregue com sucesso!
                    
                    ***Comprovante:***""");
            System.out.println("Dados do Cliente: ");
            System.out.println("Nome: " + aluguelEncontrado.getCliente().getNome());
            System.out.println("Documento: " + aluguelEncontrado.getCliente().getDocumento() + "\n");
            System.out.println("Dados do Veículo: ");
            System.out.println("Modelo: " + aluguelEncontrado.getVeiculo().getModelo());
            System.out.println("Placa: " + aluguelEncontrado.getVeiculo().getPlaca());
            System.out.println("Cor: " + aluguelEncontrado.getVeiculo().getCor() + "\n");
            System.out.println("Entregue na Agência: " + aluguelEncontrado.getAgencia().getNome()+ ", na cidade de " + aluguelEncontrado.getAgencia().getCidade() + "\n");
            System.out.println("Data da Entrega: " + aluguelEncontrado.getAluguelData());
            System.out.println("Valor pago: R$" + aluguelEncontrado.getValorTotal());

        }
        else {
            System.out.println("Veículo não encontrado no sistema.");
        }
    }


    public void listarLocacoes() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel encontrado no sistema.");
        }
        else {
            for (LocadoraSantander aluguel : alugueis) {
                System.out.println(aluguel);
            }
        }
    }
}
