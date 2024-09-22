public abstract class Veiculo implements Locar {
    private String placa;
    private String modelo;
    private String cor;
    private boolean alugado;

    public Veiculo(String placa, String modelo, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
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

    public void alugar() {
    if (alugado) {
        alugado = true;
        System.out.println(modelo + " está alugado.");
    } else {
        System.out.println(modelo + " está disponível.");
    }
    }

    public void devolver() {
        if (!alugado) {
            alugado = false;
            System.out.println(modelo + " foi devolvido.");
        } else {
            System.out.println(modelo + " está disponível.");
        }
    }
}
