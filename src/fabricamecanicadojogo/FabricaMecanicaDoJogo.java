package fabricamecanicadojogo;

import mecanicadojogo.MecanicaDoJogoDinamica;
import mecanicadojogo.MecanicaDoJogoSimples;

public class FabricaMecanicaDoJogo {
	public FabricaMecanicaDoJogo() {
	}

	public MecanicaDoJogoSimples getSimpleEngine() {
		return new MecanicaDoJogoSimples();
	}
	
	public MecanicaDoJogoDinamica getDinamicEngine() {
		return new MecanicaDoJogoDinamica();
	}
}
