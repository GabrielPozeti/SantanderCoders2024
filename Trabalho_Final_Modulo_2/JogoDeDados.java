import java.util.Random;
import java.util.Scanner;

public class JogoDeDados {

    public static void iniciarJogoDeDados(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Bem-vindo ao Jogo de Dados!");
        System.out.println("Seu saldo atual é: R$ " + usuario.getSaldo());
        System.out.print("Escolha o valor da aposta: ");
        double valorAposta = scanner.nextDouble();

        if (valorAposta > usuario.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar essa aposta.");
            return;
        }

        System.out.print("Aposte em um número de 2 a 12 (soma de dois dados): ");
        int numeroApostado = scanner.nextInt();

        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        int somaDados = dado1 + dado2;

        System.out.println("Os dados rolaram " + dado1 + " e " + dado2 + ". Soma: " + somaDados);

        if (numeroApostado == somaDados) {
            double ganho = valorAposta * 10;
            usuario.setSaldo(usuario.getSaldo() + ganho);
            System.out.println("Parabéns! Você ganhou R$ " + ganho + "! Seu novo saldo é: R$ " + usuario.getSaldo());
        } else {
            usuario.setSaldo(usuario.getSaldo() - valorAposta);
            System.out.println("Que pena! Você perdeu. Seu novo saldo é: R$ " + usuario.getSaldo());
        }
    }
}
