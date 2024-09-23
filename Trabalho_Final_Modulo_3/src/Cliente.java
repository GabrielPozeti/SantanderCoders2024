public abstract class Cliente {
    private String nome;
    private String documento;
    private String endereco;
    private String senha;
    private int telefone;

    public Cliente(String nome, String documento, String endereco, String senha, int telefone) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.senha = senha;
        this.telefone = telefone;
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

    public String getSenha() {
        return senha;
    }

    public int getTelefone() {
        return telefone;
    }

    public abstract double calcularDescontoDias(int diasAlugados);
}
