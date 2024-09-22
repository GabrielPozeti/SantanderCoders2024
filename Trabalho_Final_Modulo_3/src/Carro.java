public class Carro extends Veiculo {
    public Carro(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getValorDiaria() {
        return 150.00;
    }
}
