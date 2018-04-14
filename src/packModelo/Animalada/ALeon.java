package packModelo.Animalada;

import packModelo.ColaEntrada;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;

public class ALeon implements IAnimalada {
ListaCartas list= ColaEntrada.getColaEntrada().getLista();
	@Override
	public void hacerAnimalada(int pFuerza, String pColor) {
		if(!list.buscarPorFuerza(12)){
			this.eliminarMonos();
			this.moverPrimeraPos();
			
		}else{
			EsLoQueHay.getEsLoQueHay().addLast(list.getCarta(list.longitud()));
			list.borrarCarta(list.getCarta(list.longitud()));
		}

	}
	private void eliminarMonos(){
		boolean salir=false;
		while(!salir){
			if(list.buscarPorFuerza(4)){
				int i=list.posicionDeLaCarta(4);
				list.borrarCarta(list.getCarta(i));
			}else{
				salir=true;
			}
		}
		
	}
	private void moverPrimeraPos(){
		list.avanzarCartaLeon();
	}
}
