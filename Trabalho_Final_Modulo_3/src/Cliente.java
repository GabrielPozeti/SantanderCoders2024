public abstract class Cliente<T> {
    protected String nome;
    protected T documento;
    protected String endereco;
    protected long telefone;
    protected boolean isPessoaFisica;

    public Cliente(String nome, T documento, String endereco, long telefone, boolean isPessoaFisica) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.isPessoaFisica = isPessoaFisica;
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

    public boolean isPessoaFisica() {
        return isPessoaFisica;
    }

    public abstract double calcularDescontoDias(int diasAlugados);
}
