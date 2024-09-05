import java.util.Random;
import java.util.Scanner;

public class Roleta {

    public static void iniciarRoleta(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean jogarNovamente = true;

        while (jogarNovamente) {
            System.out.println("Bem-vindo à Roleta!");

            System.out.println("Seu saldo atual é: R$ " + usuario.getSaldo());
            System.out.print("Escolha o valor da aposta: ");
            double valorAposta = scanner.nextDouble();

            if (valorAposta > usuario.getSaldo()) {
                System.out.println("Saldo insuficiente para realizar essa aposta.");
                return;
            }

            System.out.print("Aposte em um número de 0 a 36: ");
            int numeroApostado = scanner.nextInt();

            System.out.print("Escolha uma cor (Vermelho ou Preto): ");
            String corApostada = scanner.next();

            int numeroSorteado = random.nextInt(37);
            String corSorteada = random.nextBoolean() ? "Vermelho" : "Preto";

            System.out.println("A roleta parou no número " + numeroSorteado + " e na cor " + corSorteada + ".");

            if (numeroApostado == numeroSorteado && corApostada.equalsIgnoreCase(corSorteada)) {
                double ganho = valorAposta * 20;
                usuario.setSaldo(usuario.getSaldo() + ganho);
                System.out.println("Parabéns! Você ganhou R$ " + ganho + "! Seu novo saldo é: R$ " + usuario.getSaldo());
            } else {
                usuario.setSaldo(usuario.getSaldo() - valorAposta);
                System.out.println("Que pena! Você perdeu. Seu novo saldo é: R$ " + usuario.getSaldo());
            }

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Jogar novamente");
            System.out.println("2. Voltar ao menu inicial");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    jogarNovamente = false;
                    break;
                case 0:
                    jogarNovamente = false;
                    System.out.println("Obrigado por jogar Roleta!");
                    break;
                default:
                    System.out.println("Opção inválida. Saindo do jogo.");
                    jogarNovamente = false;
                    break;
            }
        }
    }
}
