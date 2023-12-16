package Principal;

import embaralhar.*;

public class Principal {
	public static void main(String[] args) {
		String palavra = "BANANA";
		EmbaralhadorReverso embaralhador = new EmbaralhadorReverso(palavra);
		String palavraEmbaralhada = embaralhador.embaralhar(palavra);
		System.out.println(palavraEmbaralhada);
	}
}
