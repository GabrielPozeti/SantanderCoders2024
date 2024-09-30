import java.time.LocalDateTime;

public class LocadoraSantander {
    private Veiculo veiculo;
    private Cliente cliente;
    private Agencia agencia;
    private LocalDateTime aluguelData;
    private LocalDateTime devolucaoData;

    public LocadoraSantander(Veiculo veiculo, Cliente cliente, Agencia agencia, LocalDateTime aluguelData) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.agencia = agencia;
        this.aluguelData = aluguelData;
        this.devolucaoData = null; // Inicializa como nulo
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public LocalDateTime getAluguelData() {
        return aluguelData;
    }

    public LocalDateTime getDevolucaoData() {
        return devolucaoData;
    }

    public void entregarVeiculo(LocalDateTime dataDevolucao, Agencia agencia) {
        this.devolucaoData = dataDevolucao;
        this.agencia = agencia;
        veiculo.setAlugado(false);
    }

    public double getValorTotal() {
        if (devolucaoData != null) {
            long dias = aluguelData.until(devolucaoData, java.time.temporal.ChronoUnit.DAYS) + 1;
            return veiculo.getValorDiaria() * dias;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Locação: " +
                "Veículo: " + veiculo.getModelo() +
                ", Cliente: " + cliente.getNome() +
                ", Agência: " + agencia.getNome() +
                ", Data do Aluguel: " + aluguelData +
                ", Data de Devolução: " + devolucaoData;
    }
}
