public abstract class Cliente<T> {
    protected String nome;
    protected String documento;
    protected String endereco;
    protected long telefone;

    public Cliente(String nome, String documento, String endereco, long telefone) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone; // Agora está incluído no construtor
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getTelefone() { // Método para acessar o telefone
        return telefone;
    }

    public abstract double calcularDescontoDias(int diasAlugados);
}
