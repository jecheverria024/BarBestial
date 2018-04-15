package packModelo.Animalada;

import packModelo.ColaEntrada;

public class ALoro implements IAnimalada {

	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		ColaEntrada.getColaEntrada().asustarLoro();

	}


}
