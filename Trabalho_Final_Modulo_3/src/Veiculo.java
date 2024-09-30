public abstract class Veiculo implements Locar {
    private String modelo;
    private String placa;
    private String cor;
    private boolean alugado;

    public Veiculo(String modelo, String placa, String cor) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.alugado = false; // Inicializa como não alugado
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public boolean isAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public abstract double getValorDiaria();

    public String toString() {
        return "Veículo -> Modelo: " + modelo + " | Placa: " + placa + " | Cor: " + cor + " | " + "Alugado: " + alugado;
    }

    public abstract void alugar();

    public abstract void devolver();
}