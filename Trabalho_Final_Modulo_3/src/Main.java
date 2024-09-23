import java.util.Scanner;

public class Main {

    public static class Logo {
        public static final String ANSI_RESET = "\u001B[0m";
        public static final String ANSI_RED = "\u001B[31m";

        public static void exibirLogoLocadora() {
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║ ............................." + ANSI_RED + ":" + ANSI_RESET + ".........................║");
            System.out.println("║  ... ... ... ..  ...... ...." + ANSI_RED + "**" + ANSI_RESET + ". ... ... ......  .. ....║");
            System.out.println("║ ...... ... .......... ...  " + ANSI_RED + "+** " + ANSI_RESET + ":..... ... ..........  .║");
            System.out.println("║  ... ... ... ..  ...... ..." + ANSI_RED + "****" + ANSI_RESET + ".... ... ......  .. ....║");
            System.out.println("║ ...... ... .......... ... " + ANSI_RED + "+*****: " + ANSI_RESET + "... ... .......... . ║");
            System.out.println("║  ... ... ... ..  ......::*" + ANSI_RED + "****=" + ANSI_RESET + " ... ......  .. ....... ║");
            System.out.println("║ ...... ... ..........." + ANSI_RED + "+*" + ANSI_RESET +"..." + ANSI_RED + ".:******:." + ANSI_RESET + " ... ..........  .║");
            System.out.println("║  ... ... ... ..  ...." + ANSI_RED + "-**-" + ANSI_RESET + "..." + ANSI_RED + ":******-.." + ANSI_RESET + "......  .... ... ║");
            System.out.println("║ ...... ... .......... " + ANSI_RED + "+***." + ANSI_RESET + "...." + ANSI_RED + ".+*****=" + ANSI_RESET + "... .......... .║");
            System.out.println("║  ... ... ... ..  ...." + ANSI_RED + "-****:" + ANSI_RESET + "....." + ANSI_RED + "-*****=" + ANSI_RESET + ".......  .. ... ║");
            System.out.println("║ ...... ... ..........." + ANSI_RED + "*****=." + ANSI_RESET +  "...." + ANSI_RED + "*****" + ANSI_RESET + ".. ..........  ..║");
            System.out.println("║  ... ... ... ..  ......" + ANSI_RED + "+*****:" + ANSI_RESET + " ..." + ANSI_RED + "+***:" + ANSI_RESET + "......  .. .....║");
            System.out.println("║ ..............." + ANSI_RED + "=**+" + ANSI_RESET + "....." + ANSI_RED +  "=*****+" + ANSI_RESET + "...." + ANSI_RED + ":*****=:" + ANSI_RESET + ".......... .║");
            System.out.println("║  ... ... " + ANSI_RED + ".:*********" + ANSI_RESET + "... " + ANSI_RED + ".:******:" + ANSI_RESET +".. " + ANSI_RED + "+*********-... " + ANSI_RESET + "....║");
            System.out.println("║ ......." + ANSI_RED + ":*************:" + ANSI_RESET + "... " + ANSI_RED + ".+*****:" + ANSI_RESET +".." + ANSI_RED + "*************=.." + ANSI_RESET +  " ..║");
            System.out.println("║  ...." + ANSI_RED + "-****************=" + ANSI_RESET + "...." + ANSI_RED +  "+=*****." + ANSI_RESET + ":" + ANSI_RED + "***************+:" + ANSI_RESET + "..║");
            System.out.println("║ ...." + ANSI_RED + "+*******************" + ANSI_RESET + "....." + ANSI_RED + "=****+******************" + ANSI_RESET + "..║");
            System.out.println("║ ..." + ANSI_RED + "*********************:. " + ANSI_RESET + ".." + ANSI_RED +"+***********************" + ANSI_RESET +"..║");
            System.out.println("║ ..." + ANSI_RED + "=**********************=" + ANSI_RESET + ".. " + ANSI_RED + "+**********************" + ANSI_RESET + "..║");
            System.out.println("║ ..." + ANSI_RED + ":***********************+" + ANSI_RESET +".." + ANSI_RED + "+**********************" + ANSI_RESET + "..║");
            System.out.println("║ ...." + ANSI_RED + ":***********************-+**********************+" + ANSI_RESET + "..║");
            System.out.println("║ ......" + ANSI_RED + "=********************************************:" + ANSI_RESET + ".. ║");
            System.out.println("║ ........" + ANSI_RED + ":+**************************************=" + ANSI_RESET + "..... ║");
            System.out.println("║ ............" + ANSI_RED + "-+*****************************+=:" + ANSI_RESET + "........ ║");
            System.out.println("║ ................." + ANSI_RED + "::=++**************+=-:" + ANSI_RESET + ".............. ║");
            System.out.println("║ ...................................................... ║");
            System.out.println("║                                                        ║");
            System.out.println("║      Bem-vindo(a) à Locadora Santander Coders 2024!    ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            Logo.exibirLogoLocadora();

            System.out.println("Sistema de Cadastro e Login:\n");
            System.out.println("1. Cadastrar novo usuário");
            System.out.println("2. Fazer login");
            System.out.println("0. Sair\n");
            System.out.println("Digite abaixo a opção desejada: \n");

            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1 -> CadastrarUsuario();
                case 2 -> System.out.println("Função de login ainda não implementada.");
                case 0 -> System.exit(0);
                default -> System.out.println("Escolha inválida, por favor digite uma opção válida");
            }
        }
    }

    public static void CadastrarUsuario() {
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Cadastrar nova Pessoa Física");
            System.out.println("2. Cadastrar nova Pessoa Jurídica");
            System.out.println("0. Retornar ao menu inicial");

            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1 -> ClientePF.realizarCadastro();
                case 2 -> ClientePJ.realizarCadastro();
                case 0 -> {
                    System.out.println("Retornando ao menu inicial...");
                    continuar = false;
                }
                default -> System.out.println("Escolha inválida, por favor digite uma opção válida.");
            }
        }
    }
}
