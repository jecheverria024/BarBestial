package packModelo.Animal;

import packModelo.Animalada.ACocodrilo;

public abstract class Cocodrilo extends Animal implements IRecurrente {

	public Cocodrilo() {
		this.inicializarAnimalada(new ACocodrilo());
	}

}
