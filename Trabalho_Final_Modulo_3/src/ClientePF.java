import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientePF extends Cliente<String> {
    private final int idade;
    private final String cnh;

    public ClientePF(String nome, String documento, String endereco, long telefone, int idade, String cnh) {
        super(nome, documento, endereco, telefone);
        this.idade = idade;
        this.cnh = cnh;
    }

    public int getIdade() {
        return idade;
    }

    public String getCnh() {
        return cnh;
    }

    private static List<ClientePF> listaDeClientesPF = new ArrayList<>();

    public static List<ClientePF> getListaDeClientesPF() {
        return listaDeClientesPF;
    }

    public static void setListaDeClientesPF(List<ClientePF> listaDeClientesPF) {
        ClientePF.listaDeClientesPF = listaDeClientesPF;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        if (diasAlugados > 5) {
            return 0.05;
        }
        return 0;
    }

    public static void realizarCadastro(Sistema sistema) {
        Scanner input = new Scanner(System.in);

        System.out.println("Cadastro de nova Pessoa Física:");
        System.out.print("Digite o seu nome: ");
        String nome = input.nextLine();

        for (ClientePF cliente : listaDeClientesPF) {
            if (cliente.getNome().equals(nome)) {
                System.out.println("Usuário já cadastrado.");
                return;
            }
        }

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
        listaDeClientesPF.add(novoCliente);
        System.out.println("Cadastro realizado com sucesso!\n");
    }
}
