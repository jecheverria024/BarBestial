package packModelo.Animal;

import packModelo.Animalada.IAnimalada;

public abstract class Animal {
	// private String descripcion;
	private IAnimalada animalada;

	public Animal() {
	}
	public void ejecutarAnimalada(int fuerza, String color) {
		System.out.println("pr2");
		this.animalada.hacerAnimalada(fuerza, color);
	}
	public void inicializarAnimalada(IAnimalada ia) {
		this.animalada=ia;
	}
}
