import java.time.LocalDateTime;

public class LocadoraSantander {
    private Veiculo veiculo;
    private Clientes cliente;
    private Agencia agencia;
    private LocalDateTime aluguelData;
    private LocalDateTime entregaData;

    public LocadoraSantander(Veiculo veiculo, Clientes cliente, Agencia agencia, LocalDateTime aluguelData) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.agencia = agencia;
        this.aluguelData = aluguelData;
        this.entregaData = null;
        veiculo.setAlugado(true);
    }

    public void entregarVeiculo(LocalDateTime entregaData) {
        this.entregaData = entregaData;
        veiculo.setAlugado(false);
    }

    public double verificarValorTotal() {
        long diasAlugados = java.time.Duration.between(aluguelData, entregaData).toDays();
        double valorBase = veiculo.getValorDiaria() * diasAlugados;
        double desconto = cliente.calcularDescontoDias((int) diasAlugados);
        return valorBase * (1 - desconto);
    }
}