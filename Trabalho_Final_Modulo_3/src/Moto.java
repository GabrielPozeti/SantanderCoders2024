public class Moto extends Veiculo {
    public Moto(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getValorDiaria() {
        return 100.00;
    }
}
