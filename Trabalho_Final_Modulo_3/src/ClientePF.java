import java.util.Scanner;

public class ClientePF extends Cliente implements ICliente {
    private final int idade;
    private final String cnh;

    public ClientePF(String nome, String documento, String endereco, long telefone, int idade, String cnh) {
        super(nome, documento, endereco, telefone);
        this.idade = idade;
        this.cnh = cnh;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        return (diasAlugados > 5) ? 0.05 : 0;
    }

    @Override
    public String toString() {
        return String.format("Cliente PF -> Nome: %s | Documento: %s | Endereço: %s | Telefone: %d | Idade: %d | CNH: %s",
                getNome(), getDocumento(), getEndereco(), getTelefone(), idade, cnh);
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

        System.out.println("Cadastro de nova Pessoa Física:");
        System.out.print("Digite o seu nome: ");
        String nome = input.nextLine();

        System.out.print("Digite o seu CPF ou RG: ");
        String documento = input.nextLine();

        System.out.print("Digite o número da sua CNH: ");
        String cnh = input.nextLine();

        System.out.print("Digite a sua idade: ");
        int idade = input.nextInt();
        input.nextLine();

        System.out.print("Endereço: ");
        String endereco = input.nextLine();

        System.out.print("Telefone: ");
        long telefone = input.nextLong();
        input.nextLine();

        ClientePF novoCliente = new ClientePF(nome, documento, endereco, telefone, idade, cnh);
        sistema.cadastrarCliente(novoCliente);
    }
}
