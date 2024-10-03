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
    public String toString() {
        return "ClientePF{" +
                "nome='" + super.getNome() + '\'' +
                ", documento='" + super.getDocumento() + '\'' +
                ", endereco='" + super.getEndereco() + '\'' +
                ", telefone=" + super.getTelefone() +
                ", idade=" + idade +
                ", cnh='" + cnh + '\'' +
                '}';
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
    }
}
