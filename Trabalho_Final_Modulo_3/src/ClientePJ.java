public class ClientePJ extends Clientes {
    private String nomeDoResponsavel;
    private String documentoDoResponsavel;
    private int idadeDoResponsavel;
    private String funcaoDoResponsavel;

    public ClientePJ(String nomeDaEmpresa, String cnpj, String endereco, int telefone, String nomeDoResponsavel, String documentoDoResponsavel, int idadeDoResponsavel, String funcaoDoResponsavel) {
        super(nomeDaEmpresa, cnpj, endereco, telefone);
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.documentoDoResponsavel = documentoDoResponsavel;
        this.idadeDoResponsavel = idadeDoResponsavel;
        this.funcaoDoResponsavel = funcaoDoResponsavel;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public String getDocumentoDoResponsavel() {
        return documentoDoResponsavel;
    }

    public int getIdadeDoResponsavel() {
        return idadeDoResponsavel;
    }

    public String getFuncaoDoResponsavel() {
        return funcaoDoResponsavel;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        if (diasAlugados > 3) {
            return 0.10;
        }
        return 0;
    }
}
