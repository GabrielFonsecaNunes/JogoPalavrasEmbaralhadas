package Principal;

import fabricamecanicadojogo.FabricaMecanicaDoJogo;
import mecanicadojogo.MecanicaDoJogoSimples;
import bancodepalavras.BancoDePalavras;
import jogador.Player;

import java.util.Scanner;

public class Principal {
	
    public static void main(String[] args) {
    	startGame();
    }
    
    public static void printMenu() {
		System.out.println("** Jogo Palavras Embaralhadas **");
        System.out.println("Selecione uma opção: ");
        System.out.println("1. Novo Jogo");
        System.out.println("2. Ranking Jogadores");
        System.out.println("3. Sair");
	}
    
    public static void printMenuContinuar() {
        System.out.println("Selecione uma opção: ");
        System.out.println("1. Novo Jogo");
        System.out.println("2. Sair");
	}
    
    public static void printChooseNamePlayer() {
        System.out.println("Escolha um nome: ");
	}
	
	public static void mainScreen(String palavraEmbaralhada, Player jogador) {
		String row = String.format("Corações: %d 	Score: %d\n", jogador.getHearts(), jogador.getScore());
		System.out.println(row);
		System.out.printf("Palavra: %s ?\n", palavraEmbaralhada);
		System.out.println("              ");
		for(int i = 0; i < 3; i++) {			
			System.out.println("");
		}
		System.out.print("Palavra desemparalhada: ");
		
		for(int i = 0; i < 3; i++) {			
			System.out.println("");
		}
	}
	
	public static void startGame() {
		// Entrada de dados
		Scanner sc = new Scanner(System.in);
        printMenu();
        
        String option = sc.nextLine().strip();
        
        if(option.strip().contains("1")) {
        	System.out.println("Iniciando...");
        	FabricaMecanicaDoJogo factory = new FabricaMecanicaDoJogo();
        	MecanicaDoJogoSimples engine = factory.getEngine();
        	
        	printChooseNamePlayer();
        	Player jogador = new Player(sc.next().strip());
        	System.out.println(jogador.toString());
        	while(engine.gameOver(jogador) == false) {
        		engine.getPalavraBanco();
        		mainScreen(engine.getPalavraEmbaralhada(), jogador);
        		jogador.setResposta(sc.next().strip());
        		engine.acertouPalavra(jogador);
        	}
        	System.out.println(String.format("Score: %d", jogador.getScore()));
        	System.out.println(String.format("GameOver %s!\n", jogador.getName()));
        	
        	System.out.println("");
        	startGame();
        }
        else if (option.strip().contains("2")) {
			System.out.println("Historico Ranking Jogadores");
		}
        else if (option.strip().contains("3")) {
        	sc.close();
        	System.exit(0);
        }
        else {
        	startGame();
        }
	}
}
