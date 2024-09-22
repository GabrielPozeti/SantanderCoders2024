public class ClientePJ extends Cliente {
    private String nomeDoResponsavel;
    private String cnhDoResponsavel;
    private int idadeDoResponsavel;
    private String funcaoDoResponsavel;

    public ClientePJ(String nomeDaEmpresa, String cnpj, String endereco, int telefone, String nomeDoResponsavel, String cnhDoResponsavel, int idadeDoResponsavel, String funcaoDoResponsavel) {
        super(nomeDaEmpresa, cnpj, endereco, telefone);
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.cnhDoResponsavel = cnhDoResponsavel;
        this.idadeDoResponsavel = idadeDoResponsavel;
        this.funcaoDoResponsavel = funcaoDoResponsavel;
    }

    public String getNomeDoResponsavel() {
        return nomeDoResponsavel;
    }

    public String getCnhDoResponsavel() {
        return cnhDoResponsavel;
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
