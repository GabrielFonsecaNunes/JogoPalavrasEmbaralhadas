public class EmbaralhadorSimples implements Embaralhador {

	public EmbaralhadorSimples(String palavra) {
	}

	@Override
	public String embaralhar(String palavra) {
		String palavraEmbaralhada = "";
		int n = palavra.length();
		int m = n / 2;
		String subString1 = palavra.substring(0, m);
		String subString2 = palavra.substring(m, n);
		palavraEmbaralhada = subString2 + subString1;
		
		return	palavraEmbaralhada.toUpperCase();
	}
}