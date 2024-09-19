public class Moto extends Veiculo implements Locar {
    public Moto(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getValorDiaria() {
        return 100.00;
    }
}
