public class ClientePJ extends Clientes {
    public ClientePJ(String nome, String documento) {
        super(nome, documento);
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        if (diasAlugados > 3) {
            return 0.10;
        }
        return 0;
    }
}
