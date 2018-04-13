package packModelo;

import java.util.Arrays;

import packInterface.VentanaPrincipal;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.EsLoQueHay;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;
import packObservable.ObservableAbstracto;

public class ColaEntrada extends ObservableAbstracto {
	private ListaCartas cartas;
	private static ColaEntrada mColaEntrada;

	private ColaEntrada() {

		super();
		cartas = new ListaCartas();
	}

	public static ColaEntrada getColaEntrada() {
		if (mColaEntrada == null) {
			mColaEntrada = new ColaEntrada();
		}
		return mColaEntrada;
	}

	public boolean revisarCola() {
		boolean lleno = comprobarColaCompleta();
		if (lleno) {
			cartas.DosPrimeras();
			cartas.ultimaCarta();
		}
		return lleno;
	}

	public void add(CartaAnimal c) {

		cartas.add(c);

	}

	private boolean comprobarColaCompleta() {
		boolean lleno = false;
		if (cartas.longitud() == 5) {
			lleno = true;
		}
		return lleno;
	}
	public String infoCartas() {
		return this.cartas.infoCartas();
	}
	public void echarCarta(CartaAnimal pCarta) {
		cartas.add(pCarta);
		//mantener este if hasta que esten todas las animaladas hechas 
		if(pCarta.getFuerza()==11 || pCarta.getFuerza()==9 || pCarta.getFuerza()==8) {
			pCarta.ejecutarAnimalada();
		}
		this.revisarCola();
		System.out.println("Notificar Cola entrada");
		this.notificar(this, this.infoCartas());
	}

	public ListaCartas getLista() {
		return this.cartas;
	}

	public void imprimir() {
		System.out.println("Lista de cartas en la cola al finalizar");
		cartas.imprimirlista();
	}

	public void avanzarCartaHipopotamo(int fuerza, String color) {
		cartas.avanzarCartaHipopotamo(fuerza, color);
	}
	public void avanzarCartaJirafa(int fuerza, String color) {
		cartas.avanzarCartaJirafa(fuerza, color);
	}

	public void ordenar() {
		this.cartas.ordenarSegunFuerza();
	}
}
