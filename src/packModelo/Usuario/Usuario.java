package packModelo.Usuario;

import java.util.Collections;

import packModelo.BarBestial;
import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.Animal;
import packModelo.Animal.AnimalFactory;
import packModelo.Animal.Leon;
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
		mano.add((new CartaAnimal(" ",3,EnumColor.ROJO, new Leon())));
		mazo=inicializarMazo(pColor);
	}
	
	public void echarCarta(int pi){
	
		CartaAnimal pCarta=mano.eliminar(pi);
		ColaEntrada.getColaEntrada().echarCarta(pCarta);
		
	}
	
	public void cogerCarta(){
		CartaAnimal ca=mazo.cogerCartaDelMazo();
		mazo.borrarCarta(ca);
		mano.add(ca);
	}
	public void comprobarCartas() {
		if(mano.longitud()==0) {
			//devuelve false si ya no le quedan cartas para finalizar la partida
			BarBestial.getBarBestial().finalizarPartida();
			//return false;
		}//else return true;
	}
	public int getPuntos() {
		return  puntos;
	}
	public  EnumColor getColor(){
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
		//imprimirmazo();
	}
	public void imprimirmazo() {
		
		mazo.imprimirlista();
	}
	public void imprimirmano() {
		
		mano.imprimirlista();
	}
	
}
