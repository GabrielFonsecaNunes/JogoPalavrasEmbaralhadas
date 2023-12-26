package jogador;

import java.util.ArrayList;

public class Player {
    private static final ArrayList<Player> jogadores = new ArrayList<>();
    private int score = 0;
    private int hearts = 3;
    private String name;
    private String resposta;

    public Player() {
        jogadores.add(this);
    }

	public Player(String name) {
		this.setName(name);
        jogadores.add(this);
    }
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void inscreaseScore() {
        this.score += 10;
    }

    public void inscreaseHearts() {
        this.hearts++;
    }

    public void descreaseHearts() {
        this.hearts--;
    }

    public int getHearts() {
        return hearts;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta.strip().toUpperCase();
    }

    public String getResposta() {
        return resposta;
    }
}