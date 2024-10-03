import java.util.Scanner;

public class ClientePJ extends Cliente<String> implements ICliente<String> {
    private final String nomeDoResponsavel;
    private final String cnhDoResponsavel;
    private final int idadeDoResponsavel;
    private final String funcaoDoResponsavel;

    public ClientePJ(String nome, String documento, String endereco, long telefone,
                     String nomeDoResponsavel, String cnhDoResponsavel, int idadeDoResponsavel, String funcaoDoResponsavel) {
        super(nome, documento, endereco, telefone, false);
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.cnhDoResponsavel = cnhDoResponsavel;
        this.idadeDoResponsavel = idadeDoResponsavel;
        this.funcaoDoResponsavel = funcaoDoResponsavel;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        return (diasAlugados > 3) ? 0.10 : 0;
    }

    @Override
    public String toString() {
        return "ClientePJ{" +
                "nome='" + getNome() + '\'' +
                ", documento='" + getDocumento() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone=" + getTelefone() +
                ", nomeDoResponsavel='" + nomeDoResponsavel + '\'' +
                ", cnhDoResponsavel='" + cnhDoResponsavel + '\'' +
                ", idadeDoResponsavel=" + idadeDoResponsavel +
                ", funcaoDoResponsavel='" + funcaoDoResponsavel + '\'' +
                '}';
    }

    public void exibirInformacoes() {
        System.out.println("Informações do Cliente:");
        System.out.println("Nome: " + getNome());
        System.out.println("Documento: " + getDocumento());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
    }

    public static void realizarCadastro(Sistema sistema) {
        Scanner input = new Scanner(System.in);

        System.out.println("Nome: ");
        String nome = input.nextLine();

        System.out.println("Documento (CNPJ): ");
        String documento = input.nextLine();

        System.out.println("Endereço: ");
        String endereco = input.nextLine();

        System.out.println("Telefone: ");
        long telefone = input.nextLong();
        input.nextLine();

        System.out.println("Nome do Responsável: ");
        String nomeDoResponsavel = input.nextLine();

        System.out.println("CNH do Responsável: ");
        String cnhDoResponsavel = input.nextLine();

        System.out.println("Idade do Responsável: ");
        int idadeDoResponsavel = input.nextInt();
        input.nextLine();

        System.out.println("Função do Responsável: ");
        String funcaoDoResponsavel = input.nextLine();

        ClientePJ clientePJ = new ClientePJ(nome, documento, endereco, telefone,
                nomeDoResponsavel, cnhDoResponsavel, idadeDoResponsavel, funcaoDoResponsavel);
        sistema.cadastrarCliente(clientePJ);

        System.out.println("Cliente Pessoa Jurídica cadastrado com sucesso!");
        clientePJ.exibirInformacoes();
    }
}
