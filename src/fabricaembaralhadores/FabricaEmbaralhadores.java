package fabricaembaralhadores;

import java.util.ArrayList;
import java.util.Collections;

import embaralhar.Embaralhador;
import embaralhar.EmbaralhadorRandom;
import embaralhar.EmbaralhadorReverso;
import embaralhar.EmbaralhadorSimples;

public class FabricaEmbaralhadores {
	
	public FabricaEmbaralhadores() {
		
	}
	
	public Embaralhador getEmbaralhador() {
		ArrayList<Embaralhador> embaralhadores = new ArrayList<Embaralhador>();
		EmbaralhadorSimples embaralhadorSimples = new EmbaralhadorSimples();
		EmbaralhadorReverso embaralhadorReverso = new EmbaralhadorReverso();
		EmbaralhadorRandom embaralhadorRandom = new EmbaralhadorRandom();
		
		embaralhadores.add(embaralhadorSimples);
		embaralhadores.add(embaralhadorRandom);
		embaralhadores.add(embaralhadorReverso);
		Collections.shuffle(embaralhadores);
		return embaralhadores.get(0);
	}
}
