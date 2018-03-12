package packModelo.Usuario;

import java.util.Collections;

import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.ListaCartas;

public class Usuario {
	private ListaCartas mano;
	private ListaCartas mazo;
	private EnumColor color;
	private int puntos;
	
	
	public Usuario(EnumColor pColor, int pPuntos){
		
		puntos=pPuntos;
		color=pColor;
		mano=new ListaCartas();
		mazo=inicializarMazo(pColor);
	}
	
	public boolean echarCarta(CartaAnimal pCarta){
		ColaEntrada.getColaEntrada().echarCarta(pCarta);
		mano.borrarCarta(pCarta);
		return comprobarCartas();
		
	}
	
	public void cogerCarta(){
		CartaAnimal ca=mazo.ultimaCarta();
		mazo.borrarCarta(ca);
		mano.add(ca);
	}
	public boolean comprobarCartas() {
		if(mano.longitud()==0) {
			//devuelve false si ya no le quedan cartas para finalizar la partida
			return false;
		}else return true;
	}
	public int getPuntos() {
		return  puntos;
	}
	private ListaCartas inicializarMazo(EnumColor pColor) {
		
		return new ListaCartas();
	}
	
	public void barajar() {
		mazo.barajar();
	}
	
	
}
