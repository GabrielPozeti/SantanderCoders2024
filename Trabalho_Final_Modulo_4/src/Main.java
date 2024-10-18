import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String golsFile = "C:\\Users\\gabri\\OneDrive\\Documentos\\Github\\SantanderCoders2024\\Trabalho_Final_Modulo_4\\src\\campeonato-brasileiro-gols.csv";
        String cartoesFile = "C:\\Users\\gabri\\OneDrive\\Documentos\\Github\\SantanderCoders2024\\Trabalho_Final_Modulo_4\\src\\campeonato-brasileiro-cartoes.csv";
        String estatisticasFile = "C:\\Users\\gabri\\OneDrive\\Documentos\\Github\\SantanderCoders2024\\Trabalho_Final_Modulo_4\\src\\campeonato-brasileiro-estatisticas-full.csv";
        String fullFile = "C:\\Users\\gabri\\OneDrive\\Documentos\\Github\\SantanderCoders2024\\Trabalho_Final_Modulo_4\\src\\campeonato-brasileiro-full.csv";

        try {
            // Pergunta 1: O time que mais venceu jogos no ano 2008
            String timeMaisVencedor2008 = getTimeMaisVencedor2008(fullFile);
            System.out.println("O time que mais venceu jogos no ano 2008: " + timeMaisVencedor2008);

            // Pergunta 2: O estado que teve menos jogos de 2003 a 2022
            String estadoMenosJogos = getEstadoMenosJogos(fullFile);
            System.out.println("O estado que teve menos jogos entre 2003 e 2022: " + estadoMenosJogos);

            // Pergunta 3: O jogador que mais fez gols
            String jogadorMaisGols = getJogadorMaisGols(golsFile);
            System.out.println("O jogador que mais fez gols: " + jogadorMaisGols);

            // Pergunta 4: O jogador que mais fez gols de pênaltis
            String jogadorMaisGolsPenaltis = getJogadorMaisGolsPenaltis(golsFile);
            System.out.println("O jogador que mais fez gols de pênaltis: " + jogadorMaisGolsPenaltis);

            // Pergunta 5: O jogador que mais fez gols contra
            String jogadorMaisGolsContra = getJogadorMaisGolsContra(golsFile);
            System.out.println("O jogador que mais fez gols contra: " + jogadorMaisGolsContra);

            // Pergunta 6: O jogador que mais recebeu cartões amarelos
            String jogadorMaisCartoesAmarelos = getJogadorMaisCartoesAmarelos(cartoesFile);
            System.out.println("O jogador que mais recebeu cartões amarelos: " + jogadorMaisCartoesAmarelos);

            // Pergunta 7: O jogador que mais recebeu cartões vermelhos
            String jogadorMaisCartoesVermelhos = getJogadorMaisCartoesVermelhos(cartoesFile);
            System.out.println("O jogador que mais recebeu cartões vermelhos: " + jogadorMaisCartoesVermelhos);

            // Pergunta 8: O placar da partida com mais gols
            String partidaMaisGols = getPlacarPartidaMaisGols(fullFile);
            System.out.println("O placar da partida com mais gols: " + partidaMaisGols);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Métodos para obter as informações solicitadas

    private static String getTimeMaisVencedor2008(String filePath) throws IOException {
        Map<String, Integer> timesVitorias = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String ano = dados[0];
                String vencedor = dados[3].replace("\"", "").trim(); // Remove aspas e espaços
                String resultado = dados[4];
                if ("2008".equals(ano) && "V".equals(resultado)) {
                    timesVitorias.put(vencedor, timesVitorias.getOrDefault(vencedor, 0) + 1);
                }
            }
        }
        // Depuração
        System.out.println("Vitórias em 2008: " + timesVitorias);

        if (timesVitorias.isEmpty()) {
            return "Nenhum time venceu jogos em 2008.";
        }
        return Collections.max(timesVitorias.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getEstadoMenosJogos(String filePath) throws IOException {
        Map<String, Integer> estadosJogos = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String estado = dados[2].replace("\"", "").trim(); // Remove aspas e espaços
                estadosJogos.put(estado, estadosJogos.getOrDefault(estado, 0) + 1);
            }
        }
        // Depuração
        System.out.println("Jogos por estado: " + estadosJogos);

        if (estadosJogos.isEmpty()) {
            return "Nenhum estado registrado.";
        }
        return Collections.min(estadosJogos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisGols(String filePath) throws IOException {
        Map<String, Integer> jogadorGols = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String jogador = dados[1].replace("\"", "").trim(); // Remove aspas e espaços
                jogadorGols.put(jogador, jogadorGols.getOrDefault(jogador, 0) + 1);
            }
        }
        // Depuração
        System.out.println("Gols por jogador: " + jogadorGols);

        if (jogadorGols.isEmpty()) {
            return "Nenhum gol registrado.";
        }
        return Collections.max(jogadorGols.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisGolsPenaltis(String filePath) throws IOException {
        Map<String, Integer> jogadorGolsPenaltis = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String jogador = dados[1].replace("\"", "").trim(); // Remove aspas e espaços
                String tipoGol = dados[2].replace("\"", "").trim(); // Remove aspas e espaços
                if ("Pênalti".equalsIgnoreCase(tipoGol)) {
                    jogadorGolsPenaltis.put(jogador, jogadorGolsPenaltis.getOrDefault(jogador, 0) + 1);
                }
            }
        }
        // Depuração
        System.out.println("Gols de pênalti por jogador: " + jogadorGolsPenaltis);

        if (jogadorGolsPenaltis.isEmpty()) {
            return "Nenhum gol de pênalti registrado.";
        }
        return Collections.max(jogadorGolsPenaltis.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisGolsContra(String filePath) throws IOException {
        Map<String, Integer> jogadorGolsContra = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String jogador = dados[1].replace("\"", "").trim(); // Remove aspas e espaços
                String tipoGol = dados[2].replace("\"", "").trim(); // Remove aspas e espaços
                if ("Contra".equalsIgnoreCase(tipoGol)) {
                    jogadorGolsContra.put(jogador, jogadorGolsContra.getOrDefault(jogador, 0) + 1);
                }
            }
        }
        // Depuração
        System.out.println("Gols contra por jogador: " + jogadorGolsContra);

        if (jogadorGolsContra.isEmpty()) {
            return "Nenhum gol contra registrado.";
        }
        return Collections.max(jogadorGolsContra.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisCartoesAmarelos(String filePath) throws IOException {
        Map<String, Integer> jogadorCartoesAmarelos = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String jogador = dados[1].replace("\"", "").trim(); // Remove aspas e espaços
                String tipoCartao = dados[2].replace("\"", "").trim(); // Remove aspas e espaços
                if ("Amarelo".equalsIgnoreCase(tipoCartao)) {
                    jogadorCartoesAmarelos.put(jogador, jogadorCartoesAmarelos.getOrDefault(jogador, 0) + 1);
                }
            }
        }
        // Depuração
        System.out.println("Cartões amarelos por jogador: " + jogadorCartoesAmarelos);

        if (jogadorCartoesAmarelos.isEmpty()) {
            return "Nenhum cartão amarelo registrado.";
        }
        return Collections.max(jogadorCartoesAmarelos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisCartoesVermelhos(String filePath) throws IOException {
        Map<String, Integer> jogadorCartoesVermelhos = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String jogador = dados[1].replace("\"", "").trim(); // Remove aspas e espaços
                String tipoCartao = dados[2].replace("\"", "").trim(); // Remove aspas e espaços
                if ("Vermelho".equalsIgnoreCase(tipoCartao)) {
                    jogadorCartoesVermelhos.put(jogador, jogadorCartoesVermelhos.getOrDefault(jogador, 0) + 1);
                }
            }
        }
        // Depuração
        System.out.println("Cartões vermelhos por jogador: " + jogadorCartoesVermelhos);

        if (jogadorCartoesVermelhos.isEmpty()) {
            return "Nenhum cartão vermelho registrado.";
        }
        return Collections.max(jogadorCartoesVermelhos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getPlacarPartidaMaisGols(String filePath) throws IOException {
        Map<String, Integer> placarGols = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String linha;
            reader.readLine(); // Ignorar cabeçalho
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length > 5) { // Certifique-se de que há dados suficientes
                    String placar = dados[5].replace("\"", "").trim(); // Remove aspas e espaços
                    String[] partes = placar.split("-");
                    if (partes.length == 2) { // Verifique se o placar está no formato correto
                        try {
                            int totalGols = Arrays.stream(partes)
                                    .mapToInt(Integer::parseInt)
                                    .sum();
                            placarGols.put(placar, placarGols.getOrDefault(placar, 0) + totalGols);
                        } catch (NumberFormatException e) {
                            System.out.println("Erro ao converter o placar: " + placar);
                        }
                    }
                }
            }
        }
        // Depuração
        System.out.println("Placar por partidas: " + placarGols);

        if (placarGols.isEmpty()) {
            return "Nenhuma partida registrada.";
        }
        return Collections.max(placarGols.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
