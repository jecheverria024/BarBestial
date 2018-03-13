package packModelo;

import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;

public class ColaEntrada {
	private ListaCartas cartas;
	private static ColaEntrada mColaEntrada;
	
	private ColaEntrada(){
		cartas=new ListaCartas();
	}
	public static ColaEntrada getColaEntrada(){
		if(mColaEntrada==null){
			mColaEntrada= new ColaEntrada();
		}
		return mColaEntrada;
	}
	public void revisarCola(){
		boolean lleno=comprobarColaCompleta();
		if(lleno){
			for(int i=0;i<2;i++){
				CartaAnimal c=cartas.conseguirCarta();
				PuertaDelCielo.getPuertaDelCielo().add(c);
				cartas.borrarCarta(c);
			}
			CartaAnimal c1=cartas.ultimaCarta();
			EsLoQueHay.getEsLoQueHay().addLast(c1);
			cartas.borrarCarta(c1);
		}
	}
	
	public void add(CartaAnimal c) {
		this.cartas.add(c);
	}
	private boolean comprobarColaCompleta(){
		boolean lleno=false;
		if(cartas.longitud()==5){ 
			lleno=true;
		}
		return lleno;
	}
	
	public void echarCarta(CartaAnimal pCarta) {
		cartas.add(pCarta);
	}
	
}
