package packModelo.packCartas;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import packModelo.ColaEntrada;
import packModelo.EnumColor;
import packModelo.Animal.Leon;

public class ListaCartas {
	private ArrayList<CartaAnimal> lista;
	
	public ListaCartas(){
	lista=new ArrayList<CartaAnimal>();
	
	}
	public int longitud(){
		return lista.size();
	}
	
	public void add(CartaAnimal c){
		lista.add(c);
	}
	private Iterator<CartaAnimal> getIterador(){
		return lista.iterator();
	}
	public void borrarCarta(CartaAnimal c){
		lista.remove(c);
	}
	public CartaAnimal conseguirCarta(){
		return lista.get(0);
	}
	public void ultimaCarta(){
		CartaAnimal c= lista.get(lista.size()-1);
		EsLoQueHay es= EsLoQueHay.getEsLoQueHay();
		es.addLast(c);
		this.borrarCarta(c);
		
		
	}
	public CartaAnimal cogerCartaDelMazo(){
		return lista.get(lista.size()-1);
	}
	public CartaAnimal getCarta(int i){
		return lista.get(i);
	}
	public void barajar() {
		Collections.shuffle(lista);
	}

	public void DosPrimeras(){
		
		PuertaDelCielo puerta= PuertaDelCielo.getPuertaDelCielo();
		for(int i=0;i<2;i++){
			CartaAnimal c=this.conseguirCarta();
			puerta.add(c);
			this.borrarCarta(c);
		}
	
	}

	public CartaAnimal eliminar(int i) {
		CartaAnimal c=getCarta(i);
		borrarCarta(c);
		return c;
		
	}
	public void imprimirlista() {
		System.out.println(lista.size());
		for(int i =0;i<lista.size();i++) {
			
			System.out.println(lista.get(i).getFuerza());
		}
	}
	public int getFuerzaPosicion(int pos) {
		int fuerza=-1;
		try {
			fuerza= this.getCarta(pos).getFuerza();
		}
		catch(Exception e) {
			System.out.println("No hay carta");
		}
		return fuerza;
	}
	public Color getColorPosicion(int pos) {
		Color color=null;
		
		try {
			
			if (this.getCarta(pos).getColor().name().equals("AZUL")){
				color=Color.blue;
			}
			else if (this.getCarta(pos).getColor().name().equals("AMARILLO")){
				color=Color.yellow;
			}
			else if (this.getCarta(pos).getColor().name().equals("VERDE")){
				color=Color.green;
			}
			else if (this.getCarta(pos).getColor().name().equals("ROJO")){
				color=Color.red;
			}
			System.out.println("sefwefewef"+color.getClass().getName());
		}
		catch(Exception e) {
			System.out.println("No hay carta");
		}
		return color;
	}
}

