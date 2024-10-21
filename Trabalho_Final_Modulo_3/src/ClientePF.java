import java.util.Scanner;

public class ClientePF extends Cliente<String> implements ICliente<String> {
    private final int idade;
    private final String cnh;

    public ClientePF(String nome, String documento, String endereco, long telefone, int idade, String cnh) {
        super(nome, documento, endereco, telefone, true);
        this.idade = idade;
        this.cnh = cnh;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        return (diasAlugados > 5) ? 0.05 : 0;
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

    @Override
    public String toString() {
        return String.format("Cliente PF -> Nome: %s | Documento: %s | Endereço: %s | Telefone: %d | Idade: %d | CNH: %s",
                getNome(), getDocumento(), getEndereco(), getTelefone(), idade, cnh);
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

        System.out.println("Documento (CPF): ");
        String documento = input.nextLine();

        System.out.println("Endereço: ");
        String endereco = input.nextLine();

        System.out.println("Telefone: ");
        long telefone = input.nextLong();
        input.nextLine();

        System.out.println("Idade: ");
        int idade = input.nextInt();
        input.nextLine();

        System.out.println("CNH: ");
        String cnh = input.nextLine();

        ClientePF clientePF = new ClientePF(nome, documento, endereco, telefone, idade, cnh);
        sistema.cadastrarCliente(clientePF);

        System.out.println("Cliente Pessoa Física cadastrado com sucesso!");
        clientePF.exibirInformacoes();
    }
}