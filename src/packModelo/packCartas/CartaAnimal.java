package packModelo.packCartas;

import packModelo.EnumColor;
import packModelo.Animal.Animal;

public class CartaAnimal extends CartaGeneral {
	private int fuerza;
	private EnumColor color;
	private Animal animal;

	public CartaAnimal(String pImagen, int pFuerza, EnumColor pColor, Animal a) {
		// TODO Auto-generated constructor stub
		super(pImagen);
		// TODO Auto-generated constructor stub
		fuerza = pFuerza;
		color = pColor;
		animal = a;
	}

	public int getFuerza() {
		return fuerza;
	}

	public EnumColor getColor() {
		return color;
	}

}
