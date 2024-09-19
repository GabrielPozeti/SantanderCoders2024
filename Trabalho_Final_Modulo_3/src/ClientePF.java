public class ClientePF extends Clientes {
    public ClientePF(String nome, String documento) {
        super(nome, documento);
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        if (diasAlugados > 5) {
            return 0.05;
        }
        return 0;
    }
}