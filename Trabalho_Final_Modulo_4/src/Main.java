import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {
    private static final ExecutorService executor = Executors.newFixedThreadPool(8);

    public static void main(String[] args) {
        String golsFile = "campeonato-brasileiro-gols.csv";
        String cartoesFile = "campeonato-brasileiro-cartoes.csv";
        String estatisticasFile = "campeonato-brasileiro-estatisticas-full.csv";
        String fullFile = "campeonato-brasileiro-full.csv";

        try {
            // Execute as tarefas em threads
            executor.submit(() -> printTimeMaisVencedor2008(fullFile));
            executor.submit(() -> printEstadoMenosJogos(fullFile));
            executor.submit(() -> printJogadorMaisGols(golsFile));
            executor.submit(() -> printJogadorMaisGolsPenaltis(golsFile));
            executor.submit(() -> printJogadorMaisGolsContra(golsFile));
            executor.submit(() -> printJogadorMaisCartoesAmarelos(cartoesFile));
            executor.submit(() -> printJogadorMaisCartoesVermelhos(cartoesFile));
            executor.submit(() -> printPlacarPartidaMaisGols(fullFile));

            // Shutdown executor
            executor.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Métodos para obter as informações solicitadas
    private static void printTimeMaisVencedor2008(String filePath) {
        try {
            String timeMaisVencedor = getTimeMaisVencedor2008(filePath);
            System.out.println("O time que mais venceu jogos no ano 2008: " + timeMaisVencedor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printEstadoMenosJogos(String filePath) {
        try {
            String estadoMenosJogos = getEstadoMenosJogos(filePath);
            System.out.println("O estado que teve menos jogos entre 2003 e 2022: " + estadoMenosJogos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJogadorMaisGols(String filePath) {
        try {
            String jogadorMaisGols = getJogadorMaisGols(filePath);
            System.out.println("O jogador que mais fez gols: " + jogadorMaisGols);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJogadorMaisGolsPenaltis(String filePath) {
        try {
            String jogadorMaisGolsPenaltis = getJogadorMaisGolsPenaltis(filePath);
            System.out.println("O jogador que mais fez gols de pênaltis: " + jogadorMaisGolsPenaltis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJogadorMaisGolsContra(String filePath) {
        try {
            String jogadorMaisGolsContra = getJogadorMaisGolsContra(filePath);
            System.out.println("O jogador que mais fez gols contra: " + jogadorMaisGolsContra);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJogadorMaisCartoesAmarelos(String filePath) {
        try {
            String jogadorMaisCartoesAmarelos = getJogadorMaisCartoesAmarelos(filePath);
            System.out.println("O jogador que mais recebeu cartões amarelos: " + jogadorMaisCartoesAmarelos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printJogadorMaisCartoesVermelhos(String filePath) {
        try {
            String jogadorMaisCartoesVermelhos = getJogadorMaisCartoesVermelhos(filePath);
            System.out.println("O jogador que mais recebeu cartões vermelhos: " + jogadorMaisCartoesVermelhos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printPlacarPartidaMaisGols(String filePath) {
        try {
            String partidaMaisGols = getPlacarPartidaMaisGols(filePath);
            System.out.println("O placar da partida com mais gols: " + partidaMaisGols);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTimeMaisVencedor2008(String filePath) throws IOException {
        Map<String, Integer> timesVitorias = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String ano = dados[0];
                        String vencedor = dados[3];
                        String resultado = dados[4];
                        if ("2008".equals(ano) && "V".equals(resultado)) {
                            timesVitorias.put(vencedor, timesVitorias.getOrDefault(vencedor, 0) + 1);
                        }
                    });
        }
        return Collections.max(timesVitorias.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getEstadoMenosJogos(String filePath) throws IOException {
        Map<String, Integer> estadosJogos = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String estado = dados[2];
                        estadosJogos.put(estado, estadosJogos.getOrDefault(estado, 0) + 1);
                    });
        }
        return Collections.min(estadosJogos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisGols(String filePath) throws IOException {
        Map<String, Integer> jogadorGols = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String jogador = dados[1];
                        jogadorGols.put(jogador, jogadorGols.getOrDefault(jogador, 0) + 1);
                    });
        }
        return Collections.max(jogadorGols.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisGolsPenaltis(String filePath) throws IOException {
        Map<String, Integer> jogadorGolsPenaltis = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String jogador = dados[1];
                        String tipoGol = dados[2];
                        if ("Pênalti".equalsIgnoreCase(tipoGol)) {
                            jogadorGolsPenaltis.put(jogador, jogadorGolsPenaltis.getOrDefault(jogador, 0) + 1);
                        }
                    });
        }
        return Collections.max(jogadorGolsPenaltis.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisGolsContra(String filePath) throws IOException {
        Map<String, Integer> jogadorGolsContra = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String jogador = dados[1];
                        String tipoGol = dados[2];
                        if ("Contra".equalsIgnoreCase(tipoGol)) {
                            jogadorGolsContra.put(jogador, jogadorGolsContra.getOrDefault(jogador, 0) + 1);
                        }
                    });
        }
        return Collections.max(jogadorGolsContra.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisCartoesAmarelos(String filePath) throws IOException {
        Map<String, Integer> jogadorCartoesAmarelos = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String jogador = dados[1];
                        String tipoCartao = dados[2];
                        if ("Amarelo".equalsIgnoreCase(tipoCartao)) {
                            jogadorCartoesAmarelos.put(jogador, jogadorCartoesAmarelos.getOrDefault(jogador, 0) + 1);
                        }
                    });
        }
        return Collections.max(jogadorCartoesAmarelos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getJogadorMaisCartoesVermelhos(String filePath) throws IOException {
        Map<String, Integer> jogadorCartoesVermelhos = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String jogador = dados[1];
                        String tipoCartao = dados[2];
                        if ("Vermelho".equalsIgnoreCase(tipoCartao)) {
                            jogadorCartoesVermelhos.put(jogador, jogadorCartoesVermelhos.getOrDefault(jogador, 0) + 1);
                        }
                    });
        }
        return Collections.max(jogadorCartoesVermelhos.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    private static String getPlacarPartidaMaisGols(String filePath) throws IOException {
        Map<String, Integer> placarGols = new HashMap<>();
        try (Stream<String> linhas = Files.lines(Paths.get(filePath))) {
            linhas.skip(1) // Ignorar cabeçalho
                    .forEach(linha -> {
                        String[] dados = linha.split(",");
                        String placar = dados[5];
                        int totalGols = Arrays.stream(placar.split("-")).mapToInt(Integer::parseInt).sum();
                        placarGols.put(placar, placarGols.getOrDefault(placar, 0) + totalGols);
                    });
        }
        return Collections.max(placarGols.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
