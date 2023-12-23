package Principal;

import fabricamecanicadojogo.FabricaMecanicaDoJogo;
import mecanicadojogo.MecanicaDoJogoDinamica;
import mecanicadojogo.MecanicaDoJogoSimples;
import rankingjogador.RankingJogador;
import jogador.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static Scanner sc = new Scanner(System.in);
    private static RankingJogador historico = new RankingJogador();

    public Principal() {
    }

    public static void main(String[] args) {
        Principal.run();
    }

    public static void run() {
        startGame();
    }

    public static void printMenu() {
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓ Jogo Palavras Embaralhadas ▓▓▓▓▓▓");
        System.out.println("█ Selecione uma opção:                      █");
        System.out.println("█ 1. Novo Jogo                              █");
        System.out.println("█ 2. Ranking Jogadores                      █");
        System.out.println("█ 3. Sair                                   █");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
    }

    public static void printChooseNamePlayer() {
        System.out.println("▓▓▓▓▓▓▓▓▓▓ Escolha um nome: ▓▓▓▓▓▓▓▓▓▓");
    }

    public static void mainScreen(String palavraEmbaralhada, Player jogador) {
        System.out.println("+------------------------+");
        System.out.println("|      GAME SCREEN       |");
        System.out.println("+------------------------+");
        System.out.println("| Corações: " + jogador.getHearts() + "  Score: " + jogador.getScore() + "  |");
        System.out.println("|------------------------|");
        System.out.printf("| Embaralhada: %-3s ?        |\n", palavraEmbaralhada);
        System.out.println("|                        |");
        for (int i = 0; i < 1; i++) {
            System.out.println("|                        |");
        }
        System.out.print("| Desembaralhada ? |");

        for (int i = 0; i < 3; i++) {
            System.out.println("|                        |");
        }
        System.out.println("+------------------------+");
    }

    public static void printHistoricRanking(ArrayList<Player> ranking) {
        System.out.println("+--------------------------------+");
        System.out.println("|      TOP 5 JOGADORES           |");
        System.out.println("+--------------------------------+");
        System.out.println("| CLASSIF |   NOME   | PONTUACAO |");
        System.out.println("+---------+----------+-----------+");

        int indexRanking = 1;
        for (Player jogador : ranking) {
            System.out.println(String.format("|    #%d   | %-8s |    %d     |",
                    indexRanking,
                    jogador.getName(),
                    jogador.getScore())
            );
            indexRanking++;
        }
        System.out.println("+---------+----------+-----------+");
        System.out.println();
        System.out.println("▒▒ Quer Limpar o Ranking Sim/Nao ?▒▒▒");
    }

    public static void gameOver(Player jogador) {
        System.out.println("▓▓▓▓▓▓▓▓▓   GAME OVER   ▓▓▓▓▓▓▓▓▓");
        System.out.println(String.format("█ Jogador: %-10s         █", jogador.getName()));
        System.out.println(String.format("█ Score:   %-10d         █", jogador.getScore()));
        System.out.println("█                               █");
        System.out.println("█          Have Happy Day!      █");
        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓");
        System.out.println();
        sc.nextLine();
    }

    public static void displayStartNewGame(){
        System.out.println("▒▒▒▒▒▒▒▒▒▒ Iniciando... ▒▒▒▒▒▒▒▒▒▒");
    }

    private static void displayRanking() {
        System.out.println("▒▒▒▒▒▒▒▒▒▒ Ranking Jogadores ▒▒▒▒▒▒▒▒▒▒");
        ArrayList<Player> jogadores = historico.getTopRanking();
        if (!jogadores.isEmpty()) {
            printHistoricRanking(jogadores);
            String optionClearRanking = sc.nextLine().strip().toLowerCase();
            if(optionClearRanking.contains("s")) {
            	RankingJogador ranking = new RankingJogador();
            	ranking.clearRanking();
            }
            
            startGame();
        } else {
            System.out.println("<Não há nenhum ranking de jogadores>\n");
            startGame();
        }
    }

    private static void playGame(MecanicaDoJogoDinamica engine, Player jogador) {
        while (!engine.gameOver(jogador)) {
            engine.getPalavraBanco();
            mainScreen(engine.getPalavraEmbaralhada(), jogador);
            String resposta = sc.next().strip();
            jogador.setResposta(resposta);

            boolean acertou = engine.acertouPalavra(jogador);
            System.out.println("| Palavra Desembaralhada: " + engine.getLastPalavra());
            System.out.println(acertou ? "Acertou :) +10 Score" : "Errou :( -1 Coração");
        }

        System.out.println("▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n");
        gameOver(jogador);
    }
    
    private static void startNewGame() {
        FabricaMecanicaDoJogo factory = new FabricaMecanicaDoJogo();
        MecanicaDoJogoDinamica engine = factory.getDinamicEngine();
        displayStartNewGame();
        printChooseNamePlayer();
        Player jogador = new Player();
        jogador.setName(sc.nextLine().strip());
        playGame(engine, jogador);
        RankingJogador ranking = new RankingJogador();
        ranking.addJogador(jogador);
        ranking.insertPlayerRakingHistoric();
        startGame();
    }

    private static void exitGame() {
        sc.close();
        System.exit(0);
    }

    public static void startGame() {
        printMenu();
        String option = sc.nextLine().strip();

        if (option.strip().contains("1")) {
            startNewGame();
        }
        else if (option.strip().contains("2")) {
            displayRanking();
        }
        else if (option.strip().contains("3")) {
            exitGame();
        } else {
            startGame();
        } 
    }        
}
