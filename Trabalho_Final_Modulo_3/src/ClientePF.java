import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientePF extends Cliente {
    private int idade;

    public ClientePF(String nome, String documento, String endereco, int telefone, String senha, int idade) {
        super(nome, documento, endereco, senha, telefone);
        this.idade = idade;
    }

    private static List<ClientePF> listaDeClientesPF = new ArrayList<>();

    public static List<ClientePF> getListaDeClientesPF() {
        return listaDeClientesPF;
    }

    public static void setListaDeClientesPF(List<ClientePF> listaDeClientesPF) {
        ClientePF.listaDeClientesPF = listaDeClientesPF;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public double calcularDescontoDias(int diasAlugados) {
        if (diasAlugados > 5) {
            return 0.05;
        }
        return 0;
    }

    public static void realizarCadastro() {
        Scanner input = new Scanner(System.in);

        System.out.println("Cadastro de nova Pessoa Física:");
        System.out.print("Digite o seu nome: ");
        String nome = input.nextLine();

        System.out.print("Digite o numero do seu documento (CNH ou CPF): ");
        String documento = input.nextLine();

        System.out.print("Digite a sua senha: ");
        String senha = input.nextLine();

        System.out.print("Digite a sua idade: ");
        int idade = input.nextInt();
        input.nextLine();

        if (idade < 18) {
            System.out.println("Desculpe, apenas maiores de 18 anos podem se cadastrar.\n");
            return;
        }

        for (ClientePF cliente : listaDeClientesPF) {
            if (cliente.getNome().equals(nome)) {
                System.out.println("Usuário já cadastrado.");
                return;
            }
        }

        System.out.print("Endereço: ");
        String endereco = input.nextLine();

        System.out.print("Telefone: ");
        int telefone = input.nextInt();
        input.nextLine();

        ClientePF novoCliente = new ClientePF(nome, documento, endereco, telefone, senha, idade);
        listaDeClientesPF.add(novoCliente);
        System.out.println("Cadastro realizado com sucesso!\n");
    }
}
