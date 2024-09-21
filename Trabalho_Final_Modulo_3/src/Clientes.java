public abstract class Clientes {
    private String nome;
    private String documento;
    private String endereco;
    private int telefone;

    public Clientes(String nome, String documento, String endereco, int telefone) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
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

    public int getTelefone() {
        return telefone;
    }

    public abstract double calcularDescontoDias(int diasAlugados);
}
