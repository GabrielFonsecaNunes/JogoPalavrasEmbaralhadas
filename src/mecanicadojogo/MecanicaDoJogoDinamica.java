package mecanicadojogo;
import java.util.ArrayList;

import bancodepalavras.BancoDePalavras;
import embaralhar.Embaralhador;
import embaralhar.EmbaralhadorSimples;
import fabricaembaralhadores.FabricaEmbaralhadores;
import jogador.Player;

public class MecanicaDoJogoDinamica implements MecanicaDoJogo {
	
	private BancoDePalavras banco;
	private Embaralhador embaralhador;
	private String palavra;
	private FabricaEmbaralhadores fabricaEmbaralhadores;
	private ArrayList<String> palavras = new ArrayList<String>();
	
	public MecanicaDoJogoDinamica(){
		this.banco = this.getBanco();
		this.fabricaEmbaralhadores = this.getFabricaEmbaralhadores();
		this.embaralhador = this.getEmbaralhador();
	}
		
	public BancoDePalavras getBanco() {
		return new BancoDePalavras();
	}

	public Embaralhador getEmbaralhador() {
		return this.fabricaEmbaralhadores.getEmbaralhador();
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
		return embaralhador.embaralhar(this.palavra);
	}
	
	public ArrayList<String> getPalavras() {
		return palavras;
	}
	
	public FabricaEmbaralhadores getFabricaEmbaralhadores() {
		return new FabricaEmbaralhadores();
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
