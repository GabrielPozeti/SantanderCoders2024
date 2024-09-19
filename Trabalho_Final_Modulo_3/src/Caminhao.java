public class Caminhao extends Veiculo implements Locar {
    public Caminhao(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getValorDiaria() {
        return 200.00;
    }
}
