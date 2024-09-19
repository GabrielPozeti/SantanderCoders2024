public abstract class Clientes {
    private String nome;
    private String documento;

    public Clientes(String nome, String documento) {
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public abstract double calcularDescontoDias(int diasAlugados);
}
