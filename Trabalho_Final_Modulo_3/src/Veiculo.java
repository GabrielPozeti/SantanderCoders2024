public abstract class Veiculo {
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
        if (placa == null || placa.isEmpty()) {
            throw new IllegalArgumentException("A placa não pode ser nula ou vazia.");
        }
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

    @Override
    public String toString() {
        return String.format("Veículo -> Modelo: %s | Placa: %s | Cor: %s | Alugado: %b", modelo, placa, cor, alugado);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Veiculo)) return false;
        Veiculo other = (Veiculo) obj;
        return placa.equals(other.placa);
    }

    @Override
    public int hashCode() {
        return placa.hashCode();
    }

    public abstract void alugar();

    public abstract void devolver();
}
