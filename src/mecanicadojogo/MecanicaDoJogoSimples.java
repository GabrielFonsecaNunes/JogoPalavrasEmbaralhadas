package mecanicadojogo;
import java.util.ArrayList;

import bancodepalavras.BancoDePalavras;
import embaralhar.EmbaralhadorSimples;
import jogador.Player;

public class MecanicaDoJogoSimples implements MecanicaDoJogo {
	
	private BancoDePalavras banco;
	private EmbaralhadorSimples embaralhador;
	private String palavra;
	private ArrayList<String> palavras = new ArrayList<String>();
	
	public MecanicaDoJogoSimples(){
		this.banco = this.getBanco();
		this.embaralhador = this.getEmbaralhador();
	}
		
	public BancoDePalavras getBanco() {
		return new BancoDePalavras();
	}
	
	public EmbaralhadorSimples getEmbaralhador() {
		return new EmbaralhadorSimples();
	}
	
	public String getLastPalavra() {
		int index = palavras.size() - 1;
		return this.palavras.get(index);
	}
	
	public String getPalavraBanco() {
		this.palavra = this.banco.getPalavraAleatoria();
		this.palavras.add(this.palavra);
		return this.palavra;
	}
	
	public String getPalavraEmbaralhada() {
		return this.embaralhador.embaralhar(this.palavra);
	}
	
	public ArrayList<String> getPalavras() {
		return palavras;
	}
	
	@Override
	public Boolean acertouPalavra(Player jogador) {
		boolean flag = palavra.equals(jogador.getResposta());
		if(flag) 
			jogador.inscreaseScore();
		else
			jogador.descreaseHearts();
		return flag;
	}
	
	@Override
	public Boolean gameOver(Player jogador) {
		return jogador.getHearts() > 0  ? false : true;
	}
}
