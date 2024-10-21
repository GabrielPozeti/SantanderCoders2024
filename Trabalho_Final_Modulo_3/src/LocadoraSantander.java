import java.time.LocalDateTime;

public class LocadoraSantander {
    private Veiculo veiculo;
    private Cliente cliente;
    private Agencia agencia;
    private LocalDateTime dataHoraAluguel;
    private LocalDateTime devolucaoData;
    private double valorTotal;

    public LocadoraSantander(Veiculo veiculo, Cliente cliente, Agencia agencia, LocalDateTime dataHoraAluguel) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.agencia = agencia;
        this.dataHoraAluguel = dataHoraAluguel;
        this.valorTotal = calcularValorTotal();
    }

    public void entregarVeiculo(LocalDateTime devolucaoData, Agencia agenciaDevolucao) {
        this.devolucaoData = devolucaoData;
        this.agencia = agenciaDevolucao;
        veiculo.devolver();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    private double calcularValorTotal() {

        return 100.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public LocalDateTime getDataHoraAluguel() {
        return dataHoraAluguel;
    }

    public LocalDateTime getDevolucaoData() {
        return devolucaoData;
    }

    @Override
    public String toString() {
        return "LocadoraSantander{" +
                "veiculo=" + veiculo +
                ", cliente=" + cliente +
                ", agencia=" + agencia +
                ", dataHoraAluguel=" + dataHoraAluguel +
                ", devolucaoData=" + devolucaoData +
                ", valorTotal=" + valorTotal +
                '}';
    }
}
