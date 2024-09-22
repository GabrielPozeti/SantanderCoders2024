public class ClientePF extends Cliente {
    private int idade;

    public ClientePF(String nome, String cnh, String endereco, int telefone, int idade) {
        super(nome, cnh, endereco, telefone);
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