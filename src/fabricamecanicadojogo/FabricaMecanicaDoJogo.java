package fabricamecanicadojogo;

import mecanicadojogo.MecanicaDoJogoSimples;

public class FabricaMecanicaDoJogo {
	public FabricaMecanicaDoJogo() {
	}

	public MecanicaDoJogoSimples getEngine() {
		return new MecanicaDoJogoSimples();
	}
}
