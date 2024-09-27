import java.util.Scanner;

public class Main {

    public static Sistema sistema = new Sistema();
    public static Scanner input = new Scanner(System.in);

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

        while (true) {
            Logo.exibirLogoLocadora();
            exibirMenu();
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1: cadastrarCliente();
                case 2: buscarCliente();
                case 3: cadastrarVeiculo();
                case 0: System.exit(0);
                default: System.out.println("Escolha inválida, por favor digite uma opção válida");
            }
        }
    }


    public static void exibirMenu() {
        System.out.println("""
                Menu Aluguel de Veículos:
                (Digite o número da opção desejada)
                
                Clientes:
                1- Cadastrar novo cliente
                2- Buscar cliente
                3- Verificar lista de clientes
                
                Veículos:
                4- Cadastrar novo veículo
                5- Alterar veículo cadastrado
                6- Buscar veículo
                7- Verificar lista de veículos
                
                Agência:
                8- Cadastrar nova agência
                9- Alterar agência cadastrada
                10- Verificar lista de agências
                
                Locação:
                11- Alugar veículo
                12- Devolver veículo
                13- Verificar lista de veículos alugados
                
                0- Sair""");

    }


    public static void cadastrarCliente() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                    Cadastro de Cliente:
                    (Digite o número da opção desejada)
                    
                    1- Cadastrar nova Pessoa Física
                    2- Cadastrar nova Pessoa Jurídica
                    0- Retornar ao menu inicial""");
            int escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1: ClientePF.realizarCadastro(sistema);
                case 2 : ClientePJ.realizarCadastro(sistema);
                case 0: {
                    System.out.println("Retornando ao menu inicial...");
                    continuar = false;
                }
                default: System.out.println("Escolha inválida, por favor digite uma opção válida.");
            }
        }
    }


    public static void buscarCliente() {
        System.out.println("Digite o documento do cliente que está buscando: ");
        String documento = input.nextLine();

        Cliente buscaCliente = sistema.buscarClientePorDocumento(documento);
        if (buscaCliente != null) {
            System.out.println("Cliente encontrado no sistema!");
        }
        else {
            System.out.println("Cliente não encontrado no sistema.");
        }
    }


    public static void cadastrarVeiculo() {
        System.out.println("\nCadastro de Veículo:\n");
        System.out.println("Modelo: ");
        String modelo = input.nextLine();

        System.out.println("Placa: ");
        String placa = input.nextLine();

        System.out.println("Cor: ");
        String cor = input.nextLine();

        System.out.println("""
                Tipo de Veículo:
                (Digite o número da opção desejada)

                1- Carro
                2- Moto
                3- Caminhão""");
        int tipoVeiculo = input.nextInt();
        input.nextLine();

        Veiculo NovoVeiculo = null;
        switch (tipoVeiculo) {
            case 1: NovoVeiculo = new Carro(modelo, placa, cor);
            case 2: NovoVeiculo = new Moto(modelo, placa, cor);
            case 3: NovoVeiculo = new Caminhao(modelo, placa, cor);
            default:
                System.out.println("Escolha inválida, veículo não cadastrado.");
                return;
        }
    }
}
