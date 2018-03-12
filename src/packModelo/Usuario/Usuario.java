package packModelo.Usuario;

import java.util.Collections;

import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.Animal;
import packModelo.Animal.AnimalFactory;
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
	public EnumColor getColor(){
		return color;
	}
	private ListaCartas inicializarMazo(EnumColor pColor) {
		mazo= new ListaCartas();
		String pImagen;
		for (int i=1;i<12;i++){
			Animal a= AnimalFactory.getAnimalFactory().crearAnimal(i);
			pImagen=a.getClass().getName(); 
			CartaAnimal c= new CartaAnimal(pImagen,i,pColor,a);
			mazo.add(c);
		}
		return mazo;
	}
	
	public void barajar() {
		mazo.barajar();
	}
	
	
}
