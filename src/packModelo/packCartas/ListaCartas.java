package packModelo.packCartas;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.Leon;
import packModelo.Animalada.ACanguro;

public class ListaCartas {
	private ArrayList<CartaAnimal> lista;

	public ListaCartas() {
		lista = new ArrayList<CartaAnimal>();

	}

	public int longitud() {
		return lista.size();
	}
	
	public String infoCartas() {
		System.out.println("longitud: "+this.lista.size());		
		CartaAnimal unaCarta=null;
		Iterator<CartaAnimal> itr= this.getIterador();
		String info=null;
		if(this.lista.size()>0) {
			info=itr.next().info();
			while(itr.hasNext()) {
				unaCarta=itr.next();
				info=info+" "+unaCarta.info();
			}
		}
		return info;
	}
	public void add(CartaAnimal c) {
		lista.add(c);
	}

	private Iterator<CartaAnimal> getIterador() {
		return lista.iterator();
	}

	public void borrarCarta(CartaAnimal c) {
		lista.remove(c);
	}

	public CartaAnimal conseguirCarta() {
		return lista.get(0);
	}

	public void ultimaCarta() {
		CartaAnimal c = lista.get(lista.size() - 1);
		EsLoQueHay.getEsLoQueHay().addLast(c);
		borrarCarta(c);

	}

	public CartaAnimal cogerCartaDelMazo() {
		return lista.get(lista.size() - 1);
	}

	public CartaAnimal getCarta(int i) {
		return lista.get(i);
	}

	public void barajar() {
		Collections.shuffle(lista);
	}

	public void DosPrimeras() {

		for (int i = 0; i < 2; i++) {
			CartaAnimal c = this.conseguirCarta();
			PuertaDelCielo.getPuertaDelCielo().add(c);
			borrarCarta(c);
		}

	}

	public CartaAnimal eliminar(int i) {
		CartaAnimal c = getCarta(i);
		borrarCarta(c);
		return c;

	}


	public void imprimirlista() {
		System.out.println(lista.size());
		for (int i = 0; i < lista.size(); i++) {
			System.out.print(lista.get(i).getColor() + "   ");
			System.out.println(lista.get(i).getFuerza());
		}
	}

	public void avanzarCartaHipopotamo(int fuerza, String color) {
		Iterator<CartaAnimal> itr=this.getIterador();
		int posicion=0;
		CartaAnimal ca=null;
		boolean encontrado=false;
		while(itr.hasNext() && !encontrado) {
			ca=itr.next();
			if(ca.info().equals(fuerza+" "+color)) {
				encontrado=true;
			}
			else {
				posicion++;
			}
		}		
		boolean salir=false;
		while(!salir) {
			posicion=posicion-1;
			System.out.println("Posicion: "+posicion);
			if(posicion>=0 && this.lista.get(posicion).getFuerza()<fuerza && this.lista.get(posicion).getFuerza()!=7  ) {
				this.lista.remove(ca);
				this.lista.add(posicion,ca);
			}
			else {
				salir=true;
			}
		}
	}
	public void avanzarCartaJirafa(int fuerza, String color) {
		Iterator<CartaAnimal> itr=this.getIterador();
		int posicion=0;
		CartaAnimal ca=null;
		boolean encontrado=false;
		while(itr.hasNext() && !encontrado) {
			ca=itr.next();
			if(ca.info().equals(fuerza+" "+color)) {
				encontrado=true;
			}
			else {
				posicion++;
			}
		}
		posicion=posicion-1;
		System.out.println("Posicion: "+posicion);
		if(posicion>=0 && this.lista.get(posicion).getFuerza()<fuerza && this.lista.get(posicion).getFuerza()!=7  ) {
			this.lista.remove(ca);
			this.lista.add(posicion,ca);
		}
	}
	
	public void avanzarCartaCanguro(int num){
		if(lista.size()>=2){
			if(num==1){
				
				CartaAnimal carta= lista.get(lista.size()-1);
				this.lista.remove(carta);
				this.lista.add(lista.size()-1,carta);
				
			}else if(num==2){
				
				CartaAnimal carta= lista.get(lista.size()-1);
				this.lista.remove(carta);
				this.lista.add(lista.size()-2, carta);
				
			}else{
				System.out.println("inserta un 1 o un 2");
				
				
			}
		}else if(lista.size()==1){
				
				CartaAnimal carta= lista.get(lista.size()-1);
				this.lista.remove(carta);
				this.lista.add(lista.size()-1,carta);
			
			
		}else{
			System.out.println("inserta un 1 o un 2");
		}
		
	}
	
	public boolean buscarPorFuerza(int pFuerza){
		Iterator<CartaAnimal> it= this.getIterador();
		CartaAnimal c=null;
		boolean enc= false;
		while(it.hasNext() && !enc){
			c=it.next();
			if(c.getFuerza()==pFuerza){
				enc=true;
			}
		}
	
		return enc;
	}
	public int posicionDeLaCarta(int pFuerza){
		int i=0;
		boolean enc=false;
		while(i<lista.size() && !enc){
			if(lista.get(i).getFuerza()==pFuerza){
				enc=true;
			}else{
				i++;
			}
		}
		if(enc){
			return i;
		}else{
			return -1;
		}
		
	}
	public void avanzarCartaMono(){
		CartaAnimal c= lista.get(lista.size()-1);
		lista.remove(lista.size()-1);
		lista.add(0,c);
		
	}
	public void anadirCartaEnPos(int pos, CartaAnimal c){
		lista.add(pos,c);
	}
	
	public void avanzarCartaCocodrilo(){
		System.out.println("iniciar animalada cocodrilo");
		int i=lista.size()-2;
		boolean salir=false;
		while(i>=0 &&!salir ){
			if(lista.get(i).getFuerza()<10 && lista.get(i).getFuerza()!=7){
					EsLoQueHay.getEsLoQueHay().addLast(lista.get(i));
					lista.remove(i);
					i--;
				}else{
					salir=true;
				}
				
			
		}
	}
	public void avanzarCartaLeon(){
		CartaAnimal c= lista.get(lista.size()-1);
		lista.remove(lista.size()-1);
		lista.add(0,c);
	}

	public void ordenarSegunFuerza() {
		Collections.sort(this.lista);
	}
	public void repelerMayorFuerza() {
		for(int i=0; i<2;i++) {
			int fuerzamax=buscarCartaAlta();
			Iterator<CartaAnimal> it= this.getIterador();
			CartaAnimal c=null;
			while(it.hasNext()){
				c=it.next();
				if(c.getFuerza()==fuerzamax){
					borrarCarta(c);
					EsLoQueHay.getEsLoQueHay().addLast(c);
				}
			}
		}
	}
	private int buscarCartaAlta() {
		Iterator<CartaAnimal> it= this.getIterador();
		CartaAnimal c=null;
		int max=0;
		while(it.hasNext()){
			c=it.next();
			if(c.getFuerza()>max){
				max=c.getFuerza();
			}
		}
		return max;
	}
}
