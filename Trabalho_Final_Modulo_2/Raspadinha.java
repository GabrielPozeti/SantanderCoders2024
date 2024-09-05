import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Raspadinha {

    public static void iniciarJogo(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo à Raspadinha!");
        System.out.println("Seu saldo atual é: R$ " + usuario.getSaldo());
        System.out.print("Escolha o valor da aposta: ");
        double valorAposta = lerDouble(scanner);

        if (valorAposta > usuario.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar essa aposta.");
            return;
        }

        // Criação das opções com 7 prêmios e 13 valores "Nada"
        String[] opcoes = new String[20];
        for (int i = 0; i < opcoes.length; i++) {
            opcoes[i] = "Nada";
        }

        // Distribuição dos prêmios
        int[] indicesPremios = {0, 1, 2, 3, 4, 5, 6}; // Índices fixos para prêmios específicos
        opcoes[indicesPremios[0]] = "10x o valor apostado";
        opcoes[indicesPremios[1]] = "5x o valor apostado";
        opcoes[indicesPremios[2]] = "Dobro do valor apostado";
        opcoes[indicesPremios[3]] = "R$ 50";
        opcoes[indicesPremios[4]] = "R$ 20";
        opcoes[indicesPremios[5]] = "R$ 10";
        opcoes[indicesPremios[6]] = "R$ 5";

        // Embaralhar as opções
        for (int i = opcoes.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String temp = opcoes[i];
            opcoes[i] = opcoes[j];
            opcoes[j] = temp;
        }

        // Mostrar opções para o usuário
        System.out.println("Escolha uma das 20 opções:");
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println((i + 1) + ". Opção " + (i + 1));
        }

        int escolha = lerEscolha(scanner);

        if (escolha < 1 || escolha > 20) {
            System.out.println("Opção inválida. Tente novamente.");
            return;
        }

        // Mostrar resultado
        String premioEscolhido = opcoes[escolha - 1];
        System.out.println("Você escolheu a opção " + escolha);
        System.out.println("Resultado: " + premioEscolhido);

        double valorPremio = 0;
        if (premioEscolhido.equals("10x o valor apostado")) {
            valorPremio = valorAposta * 10;
        } else if (premioEscolhido.equals("5x o valor apostado")) {
            valorPremio = valorAposta * 5;
        } else if (premioEscolhido.equals("Dobro do valor apostado")) {
            valorPremio = valorAposta * 2;
        } else if (premioEscolhido.equals("R$ 50")) {
            valorPremio = 50;
        } else if (premioEscolhido.equals("R$ 20")) {
            valorPremio = 20;
        } else if (premioEscolhido.equals("R$ 10")) {
            valorPremio = 10;
        } else if (premioEscolhido.equals("R$ 5")) {
            valorPremio = 5;
        } else {
            valorPremio = 0;
        }

        if (valorPremio > 0) {
            usuario.setSaldo(usuario.getSaldo() + valorPremio);
            System.out.println("Parabéns! Você ganhou " + premioEscolhido);
        } else {
            usuario.setSaldo(usuario.getSaldo() - valorAposta);
            System.out.println("Você não ganhou nada. Tente novamente!");
        }

        // Mostrar valores de todas as opções
        System.out.println("Valores das opções restantes:");
        for (int i = 0; i < opcoes.length; i++) {
            if (i != escolha - 1) {
                System.out.println((i + 1) + ". " + opcoes[i]);
            }
        }

        System.out.println("Seu novo saldo é: R$ " + usuario.getSaldo());
    }

    private static double lerDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine(); 
            }
        }
    }

    private static int lerEscolha(Scanner scanner) {
        while (true) {
            System.out.print("Escolha uma opção: ");
            try {
                int escolha = scanner.nextInt();
                scanner.nextLine(); 
                return escolha;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
                scanner.nextLine(); 
            }
        }
    }
}
