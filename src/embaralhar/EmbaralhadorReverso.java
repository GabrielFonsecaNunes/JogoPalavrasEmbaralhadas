package embaralhar;

public class EmbaralhadorReverso implements Embaralhador{
	
	public EmbaralhadorReverso() {
	}
	
	@Override
	public String embaralhar(String palavra) {
		String palavraEmbaralhada = "";
		int l = palavra.length() - 1;
		for(int i = l; i >= 0; i--) {
			palavraEmbaralhada += palavra.charAt(i);
		}
		return	palavraEmbaralhada.toUpperCase();
	}
}