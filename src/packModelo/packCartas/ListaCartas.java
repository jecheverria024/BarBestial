package packModelo.packCartas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import packModelo.ColaEntrada;

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
		for(int i =0;i<lista.size();i++) {
			System.out.println(lista.get(i).getFuerza());
		}
	}
	

}

