import java.time.LocalDateTime;

public class LocadoraSantander {
    private Veiculo veiculo;
    private Cliente cliente;
    private Agencia agencia;
    private LocalDateTime aluguelData;
    private LocalDateTime devolucaoData;

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public LocalDateTime getAluguelData() {
        return aluguelData;
    }

    public void setAluguelData(LocalDateTime aluguelData) {
        this.aluguelData = aluguelData;
    }

    public LocalDateTime getDevolucaoData() {
        return devolucaoData;
    }

    public void setDevolucaoData(LocalDateTime devolucaoData) {
        this.devolucaoData = devolucaoData;
    }

    public LocadoraSantander(Veiculo veiculo, Cliente cliente, Agencia agencia, LocalDateTime aluguelData) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.agencia = agencia;
        this.aluguelData = aluguelData;
        this.devolucaoData = null;
        veiculo.setAlugado(true);
    }

    public void entregarVeiculo(LocalDateTime entregaData, Agencia agencia) {
        this.devolucaoData = entregaData;
        veiculo.setAlugado(false);
    }

    public double verificarValorTotal() {
        long diasAlugados = java.time.Duration.between(aluguelData, devolucaoData).toDays();
        double valorBase = veiculo.getValorDiaria() * diasAlugados;
        double desconto = cliente.calcularDescontoDias((int) diasAlugados);
        return valorBase * (1 - desconto);
    }
}