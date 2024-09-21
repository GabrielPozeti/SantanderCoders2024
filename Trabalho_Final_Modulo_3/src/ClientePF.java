public class ClientePF extends Clientes {
    private int idade;

    public ClientePF(String nome, String documento, String endereco, int telefone, int idade) {
        super(nome, documento, endereco, telefone);
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        if (diasAlugados > 5) {
            return 0.05;
        }
        return 0;
    }
}