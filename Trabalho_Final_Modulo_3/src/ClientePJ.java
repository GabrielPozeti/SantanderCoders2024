import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientePJ extends Cliente {
    private String nomeDoResponsavel;
    private String cnhDoResponsavel;
    private int idadeDoResponsavel;
    private String funcaoDoResponsavel;

    public ClientePJ(String nomeDaEmpresa, String cnpj, String endereco, int telefone, String senha,
                     String nomeDoResponsavel, String cnhDoResponsavel, int idadeDoResponsavel, String funcaoDoResponsavel) {
        super(nomeDaEmpresa, cnpj, endereco, senha, telefone);
        this.nomeDoResponsavel = nomeDoResponsavel;
        this.cnhDoResponsavel = cnhDoResponsavel;
        this.idadeDoResponsavel = idadeDoResponsavel;
        this.funcaoDoResponsavel = funcaoDoResponsavel;
    }

    private static List<ClientePJ> listaDeClientesPJ = new ArrayList<>();

    public static List<ClientePJ> getListaDeClientesPJ() {
        return listaDeClientesPJ;
    }

    public static void setListaDeClientesPJ(List<ClientePJ> listaDeClientesPJ) {
        ClientePJ.listaDeClientesPJ = listaDeClientesPJ;
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
        return diasAlugados > 7 ? 0.1 : 0.0;  // Exemplo: 10% de desconto para mais de 7 dias
    }

    public static void realizarCadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("Cadastro de nova Pessoa Jurídica:");
        System.out.print("Digite o nome da empresa: ");
        String nomeDaEmpresa = input.nextLine();

        for (ClientePJ cliente : listaDeClientesPJ) {
            if (cliente.getNome().equals(nomeDaEmpresa)) {
                System.out.println("Empresa já cadastrada.");
                return;
            }
        }

        System.out.print("Digite o CNPJ: ");
        String cnpj = input.nextLine();

        System.out.print("Digite o endereço da empresa: ");
        String endereco = input.nextLine();

        System.out.print("Digite o telefone da empresa: ");
        int telefone = input.nextInt();
        input.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = input.nextLine();

        System.out.print("Digite o nome do responsável: ");
        String nomeDoResponsavel = input.nextLine();

        System.out.print("Digite o  número da CNH do responsável: ");
        String cnhDoResponsavel = input.nextLine();

        System.out.print("Digite a idade do responsável: ");
        int idadeDoResponsavel = input.nextInt();
        input.nextLine();

        if (idadeDoResponsavel < 18) {
            System.out.println("Desculpe, apenas responsáveis maiores de 18 anos podem se cadastrar.\n");
            return;
        }

        System.out.print("Função do Responsável: ");
        String funcaoDoResponsavel = input.nextLine();


        ClientePJ novoCliente = new ClientePJ(nomeDaEmpresa, cnpj, endereco, telefone, senha,nomeDoResponsavel, cnhDoResponsavel, idadeDoResponsavel, funcaoDoResponsavel);
        listaDeClientesPJ.add(novoCliente);
        System.out.println("Cadastro realizado com sucesso!\n");
    }
}
