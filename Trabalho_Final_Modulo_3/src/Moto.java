public class Moto extends Veiculo {
    public Moto(String placa, String modelo, String cor) {
        super(modelo, placa, cor);
    }

    @Override
    public double getValorDiaria() {
        return 100.00; // Valor da diária da moto
    }

    @Override
    public void alugar() {
        // Implementação da lógica de aluguel para a moto (se necessário)
        System.out.println("Moto " + getModelo() + " alugada com sucesso!");
    }

    @Override
    public void devolver() {
        // Implementação da lógica de devolução para a moto (se necessário)
        System.out.println("Moto " + getModelo() + " devolvida com sucesso!");
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Moto"; // Chama o toString da classe pai
    }
}
