public class ClientePF extends Cliente<String> implements ICliente<String> {
    private final int idade;
    private final String cnh;

    public ClientePF(String nome, String documento, String endereco, long telefone, int idade, String cnh) {
        super(nome, documento, endereco, telefone, true);  // true para PF
        this.idade = idade;
        this.cnh = cnh;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        return (diasAlugados > 5) ? 0.05 : 0;
    }
}
