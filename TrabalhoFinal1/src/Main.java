import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        List<String> listaDeNomes = new ArrayList<>();
        List<Long> listaDeNumeros = new ArrayList<>();
        List<String> listaDeEmails = new ArrayList<>();
        boolean loop = true;

        while(loop){

            menu(listaDeNomes, listaDeNumeros, listaDeEmails);

            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha){

                case 1:
                    adicionar(listaDeNomes, listaDeNumeros, listaDeEmails, input);
                    break;

                case 2:
                    detalhar(listaDeNomes, listaDeNumeros, listaDeEmails, input);
                    break;

                case 3:
                    editar(listaDeNomes, listaDeNumeros, listaDeEmails, input);
                    break;

                case 4:
                    remover(listaDeNomes, listaDeNumeros, listaDeEmails, input);
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    loop = false;
                    break;

                default:
                    System.out.println("Número inválido, por favor digite um número válido.");
                    break;
            }
        }
    }
    public static void menu (List<String> listaDeNomes, List<Long> listaDeNumeros, List<String> listaDeEmails){

        System.out.println("\n##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################");
        System.out.println("\n>>>> Contatos <<<<");
        for (int i = 0; i < listaDeNomes.size(); i++) {
            System.out.println("Id = " + (i+1) + "   | " + "Nome: " + listaDeNomes.get(i) + " | " + "Telefone: " + listaDeNumeros.get(i) + " | " + "E-mail: " + listaDeEmails.get(i) + " | ");
        }
        System.out.println("\n>>>> Menu Contato <<<<");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Detalhar Contato");
        System.out.println("3 - Editar Contato");
        System.out.println("4 - Remover Contato");
        System.out.println("5 - Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    public static void adicionar(List<String> listaDeNomes, List<Long> listaDeNumeros, List<String> listaDeEmails, Scanner input){


        System.out.println("Por favor, digite o nome do contato que deseja adicionar:");
        String nome = input.nextLine();
        if (listaDeNomes.contains(nome)) {
            System.out.println("Esse nome já é de um contato salvo na agenda.\n");
            return;
        } else {
            listaDeNomes.add(nome);
        }

        System.out.println("Agora, digite o número do contato em questão:");
        long numero = 0;
        boolean loopNumero = true;
        while (loopNumero) {
            try {
                numero = input.nextLong();
                input.nextLine();
                if (listaDeNumeros.contains(numero)) {
                    System.out.println("Esse número já é de um contato salvo na agenda.\n");
                    listaDeNomes.remove(nome);
                    return;
                } else {
                    listaDeNumeros.add(numero);
                    loopNumero = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite apenas números.");
                input.nextLine();
            }
        }

        System.out.println("Por fim, digite o E-mail do contato em questão:");
        String email = input.nextLine();
        if (listaDeEmails.contains(email)) {
            System.out.println("Esse E-mail já é de um contato salvo na agenda.\n");
            listaDeNomes.remove(nome);
            listaDeNumeros.remove(numero);
            return;
        } else {
            listaDeEmails.add(email);
        }

        System.out.println("Contato adicionado com sucesso.");
    }

    public static void remover (List<String> listaDeNomes, List<Long> listaDeNumeros, List<String> listaDeEmails, Scanner input){

        long numeroParaConsulta = 0;
        boolean loopNumero = true;

        System.out.println("Por favor, digite o número do contato que deseja remover:");
        while (loopNumero){
            try {
                numeroParaConsulta = input.nextLong();
                input.nextLine();
                loopNumero = false;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite apenas números.");
                input.nextLine();
            }
        }
        int indiceDoNumero = listaDeNumeros.indexOf(numeroParaConsulta);
        if (indiceDoNumero >= 0){
            listaDeNomes.remove(indiceDoNumero);
            listaDeNumeros.remove(indiceDoNumero);
            listaDeEmails.remove(indiceDoNumero);
            System.out.println("Contato deletado com sucesso.");
        } else {
            System.out.println("Nome não encontrado.");
        }
    }

    public static void detalhar(List<String> listaDeNomes, List<Long> listaDeNumeros, List<String> listaDeEmails, Scanner input){

        long numeroParaConsulta = 0;
        boolean loopNumero = true;

        System.out.println("Por favor, digite o número do contato que deseja ver todos os detalhes:");
        while (loopNumero){
            try {
                numeroParaConsulta = input.nextLong();
                input.nextLine();
                loopNumero = false;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite apenas números.");
                input.nextLine();
            }
        }
        int indiceDoNumero = listaDeNumeros.indexOf(numeroParaConsulta);
        if(indiceDoNumero >= 0) {
            System.out.println("\nId do Contato: " + (indiceDoNumero+1) + "\nNome do Contato: " + listaDeNomes.get(indiceDoNumero) + "\nNúmero do Contato: " + listaDeNumeros.get(indiceDoNumero) + "\nE-mail do Contato: " + listaDeEmails.get(indiceDoNumero) + "\n");
        } else {
            System.out.println("\nNome não encontrado.");
        }

    }

    public static void editar(List<String> listaDeNomes, List<Long> listaDeNumeros, List<String> listaDeEmails, Scanner input) {
        long numeroParaConsulta = 0;
        boolean loopNumero = true;
        System.out.println("Por favor, digite o número do contato que deseja alterar:");
        while (loopNumero){
            try {
                numeroParaConsulta = input.nextLong();
                input.nextLine();
                loopNumero = false;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, digite apenas números.");
                input.nextLine();
            }
        }
        int indiceDoNumero = listaDeNumeros.indexOf(numeroParaConsulta);
        if(indiceDoNumero >= 0) {
            boolean loop3 = true;
            System.out.println("O que você deseja alterar?");
            System.out.println("1 - Nome do Contato");
            System.out.println("2 - Número do Contato");
            System.out.println("3 - E-mail do Contato");
            System.out.println("(Digite o número da opção selecionada)");
            int escolherAlterar = input.nextInt();
            input.nextLine();
            while(loop3) {
                switch (escolherAlterar) {
                    case 1:
                        System.out.println("Digite o novo nome do contato:");
                        String nomeNovo = input.nextLine();
                        listaDeNomes.set(indiceDoNumero, nomeNovo);
                        loop3 = false;
                        break;

                    case 2:
                        System.out.println("Digite o novo número do contato:");
                        long numeroNovo = input.nextLong();
                        listaDeNumeros.set(indiceDoNumero, numeroNovo);
                        loop3 = false;
                        break;

                    case 3:
                        System.out.println("Digite o novo e-mail do contato:");
                        String emailNovo = input.nextLine();
                        listaDeEmails.set(indiceDoNumero, emailNovo);
                        loop3 = false;
                        break;

                    default:
                        System.out.println("Opção Inválida");
                }
            }
        }
        else {
            System.out.println("Número não encontrado, tente novamente.");
        }
    }
}
