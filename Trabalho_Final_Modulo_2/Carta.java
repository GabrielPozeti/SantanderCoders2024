public class Carta {
    private String naipe;
    private String valor;

    public Carta(String naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getValor() {
        return valor;
    }

    public int getValorNumerico() {
        switch (valor) {
            case "A": return 11;
            case "2": case "3": case "4": case "5": case "6":
            case "7": case "8": case "9": case "10": return Integer.parseInt(valor);
            case "J": case "Q": case "K": return 10;
            default: throw new IllegalArgumentException("Valor da carta inválido");
        }
    }

    @Override
    public String toString() {
        return valor + " de " + naipe;
    }
}
