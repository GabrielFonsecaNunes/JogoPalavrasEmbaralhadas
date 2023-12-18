package mecanicadojogo;

import jogador.Player;

public interface MecanicaDoJogo {
	public Boolean gameOver(Player jogador);
	public Boolean acertouPalavra(Player jogador);
}
