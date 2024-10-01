import java.util.Scanner;

public class ClientePJ extends Cliente<String> implements ICliente<String> {
    private final String nomeDoResponsavel;
    private final String cnhDoResponsavel;
    private final int idadeDoResponsavel;
    private final String funcaoDoResponsavel;

    public ClientePJ(String nome, String documento, String endereco, long telefone,
                     String nomeDoResponsavel, String cnhDoResponsavel,
                     int idadeDoResponsavel, String funcaoDoResponsavel) {
        super(nome, documento, endereco, telefone);
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
        return String.format("Cliente PJ -> Nome da Empresa: %s | CNPJ: %s | Endereço: %s | Telefone: %d | Nome do Responsável: %s | CNH do Responsável: %s | Idade do Responsável: %d | Função do Responsável: %s",
                getNome(), getDocumento(), getEndereco(), getTelefone(), nomeDoResponsavel, cnhDoResponsavel, idadeDoResponsavel, funcaoDoResponsavel);
    }


    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public String getDocumento() {
        return super.getDocumento();
    }

    @Override
    public String getEndereco() {
        return super.getEndereco();
    }

    @Override
    public long getTelefone() {
        return super.getTelefone();
    }


    public static void realizarCadastro(Sistema sistema) {
        Scanner input = new Scanner(System.in);

        System.out.println("Cadastro de nova Pessoa Jurídica:");
        System.out.print("Digite o nome da empresa: ");
        String nomeDaEmpresa = input.nextLine();

        System.out.print("Digite o CNPJ: ");
        String cnpj = input.nextLine();

        System.out.print("Digite o endereço da empresa: ");
        String endereco = input.nextLine();

        System.out.print("Digite o telefone da empresa: ");
        long telefone = input.nextLong();
        input.nextLine();

        System.out.print("Digite o nome do responsável: ");
        String nomeDoResponsavel = input.nextLine();

        System.out.print("Digite o número da CNH do responsável: ");
        String cnhDoResponsavel = input.nextLine();

        System.out.print("Digite a idade do responsável: ");
        int idadeDoResponsavel = input.nextInt();
        input.nextLine();

        System.out.print("Função do Responsável: ");
        String funcaoDoResponsavel = input.nextLine();

        ClientePJ novoCliente = new ClientePJ(nomeDaEmpresa, cnpj, endereco, telefone,
                nomeDoResponsavel, cnhDoResponsavel, idadeDoResponsavel, funcaoDoResponsavel);

        sistema.cadastrarCliente(novoCliente);
    }
}
