public abstract class Cliente<T> {
    protected String nome;
    protected T documento;
    protected String endereco;
    protected long telefone;


    public Cliente(String nome, T documento, String endereco, long telefone) {
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

    public long getTelefone() {
        return telefone;
    }

    public abstract double calcularDescontoDias(int diasAlugados);
}
