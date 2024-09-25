public abstract class Cliente<T> {
    private String nome;
    private T documento;
    private String endereco;
    private int telefone;

    public Cliente(String nome, T documento, String endereco, int telefone) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public T getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public abstract double calcularDescontoDias(int diasAlugados);
}
