public class Caminhao extends Veiculo {
    public Caminhao(String placa, String modelo, String cor) {
        super(placa, modelo, cor);
    }

    @Override
    public double getValorDiaria() {
        return 200.00;
    }

    @Override
    public void alugar() {

    }

    @Override
    public void devolver() {

    }
}
