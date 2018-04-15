package packModelo.Animalada;

import java.util.Scanner;

import packModelo.ColaEntrada;

public class ALoro implements IAnimalada {

	@Override
public void hacerAnimalada(int pFuerza, String pColor) {
		int num=0;
		boolean correcto=false;
		
		while(!correcto) {
			Scanner sc= new Scanner(System.in);
			System.out.println("Inserta la posicion del animal que deseas eliminar");
			//falta implementar para que seleccionen un numero desde la interfaz
			num=sc.nextInt();
			if(num>-1 && num<ColaEntrada.getColaEntrada().getLista().longitud()) {
				correcto=true;
			}
		}
		ColaEntrada.getColaEntrada().asustarLoro(num);

	}


}
