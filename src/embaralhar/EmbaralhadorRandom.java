
package embaralhar;

import java.util.ArrayList;
import java.util.Collections;

public class EmbaralhadorRandom implements Embaralhador{
	public EmbaralhadorRandom(String palavra) {
	}
	
	@Override
	public String embaralhar(String palavra) {
		
		String palavraEmbaralhada = "";
		ArrayList<Character> Letters = new ArrayList<Character>();
		for (Character character : palavra.toCharArray()) {
			Letters.add(character);
		}
		
		Collections.shuffle(Letters);
		for (Character character : Letters) {
			palavraEmbaralhada += character;
		}
		
		return palavraEmbaralhada.toUpperCase();
	}
}