package packModelo;

import packInterface.VentanaPrincipal;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;
import packObservable.ObservableAbstracto;

public class ColaEntrada extends ObservableAbstracto {
	private ListaCartas cartas;
	private static ColaEntrada mColaEntrada;
	
	private ColaEntrada(){
		
		super();
		VentanaPrincipal v=new VentanaPrincipal();
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
			cartas.DosPrimeras();
			cartas.ultimaCarta();

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
		this.revisarCola();
		System.out.println("Notificar Cola entrada");
		this.notificar(this);
	}
	public ListaCartas getLista() {
		return this.cartas;
	}
}
