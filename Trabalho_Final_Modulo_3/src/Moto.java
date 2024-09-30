public class Moto extends Veiculo {
    public Moto(String placa, String modelo, String cor) {
        super(modelo, placa, cor);
    }

    @Override
    public double getValorDiaria() {
        return 100.00;
    }

    @Override
    public void alugar() {

        System.out.println("Moto " + getModelo() + " alugada com sucesso!");
    }

    @Override
    public void devolver() {

        System.out.println("Moto " + getModelo() + " devolvida com sucesso!");
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Moto";
    }
}
