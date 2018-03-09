import java.util.ArrayList;

import java.util.Iterator;

public class ListaCartas {
	private ArrayList<CartaAnimal> lista;
	
	public ListaCartas(){
	
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
		return lista.get(1);
	}
	public CartaAnimal ultimaCarta(){
		Iterator<CartaAnimal> it= getIterador();
		CartaAnimal c=it.next();
		while(it.hasNext()){
			c=it.next();
		}
		return c;
	}
}
