package mecanicadojogo;

import bancodepalavras.BancoDePalavras;
import embaralhar.Embaralhador;
import embaralhar.EmbaralhadorSimples;
import jogador.Player;

public class MecanicaDoJogoSimples implements MecanicaDoJogo {
	
	private BancoDePalavras banco;
	private EmbaralhadorSimples embaralhador;
	private String palavra;
	
	public MecanicaDoJogoSimples() {
		this.banco = this.getBanco();
		this.embaralhador = this.getEmbaralhador();
		this.palavra = this.getPalavraBanco();
	}
		
	public BancoDePalavras getBanco() {
		return new BancoDePalavras();
	}
	
	public EmbaralhadorSimples getEmbaralhador() {
		return new EmbaralhadorSimples();
	}
	
	public String getPalavraBanco() {
		return this.banco.getPalavraAleatoria();
	}
	
	public String getPalavraEmbaralhada() {
		return this.embaralhador.embaralhar(this.palavra);
	}
	
	@Override
	public Boolean acertouPalavra(Player jogador) {
		boolean flag = palavra.equals(jogador.getResposta());
		if(flag) 
			jogador.inscreaseScore();
		else
			jogador.descreaseHearts();
		
		this.palavra = this.getPalavraBanco();
		return flag;
	}
	
	@Override
	public Boolean gameOver(Player jogador) {
		return jogador.getHearts() > 0  ? false : true;
	}
}
