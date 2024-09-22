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
        this.devolucaoData = null;
        veiculo.setAlugado(true);
    }

    public void entregarVeiculo(LocalDateTime entregaData) {
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