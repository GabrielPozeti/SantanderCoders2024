public abstract class Veiculo implements Locar {
    private String modelo;
    private String placa;
    private String cor;
    private boolean alugado;

    public Veiculo(String modelo, String placa, String cor) {
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
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

    public void alugar() {
        if (!alugado) {
            alugado = true;
            System.out.println(modelo + " foi alugado.");
        } else {
            System.out.println(modelo + " já está alugado.");
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

    public String toString() {
        return "Veículo -> Modelo: " + modelo + " | Placa: " + placa + " | Cor: " + cor + ". " + alugado;
    }
}
