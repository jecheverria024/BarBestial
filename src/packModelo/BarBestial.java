package packModelo;

import packModelo.Usuario.Jugador;
import packModelo.Usuario.Ordenador;
import packModelo.packCartas.CartaAnimal;
//import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;
import packModelo.Usuario.Jugador;

public class BarBestial {
	private static BarBestial mBarBestial;
	private boolean turno; // true = Usuario, false = Ordenador
	private boolean juegoFinalizado;

	
	private BarBestial(){
		
	}
	
	public static BarBestial getBarBestial(){
		if(mBarBestial==null){
			mBarBestial= new BarBestial();
		}
		return mBarBestial;
	}

	public void iniciarPartida() {
		this.inicializarPartida();
		this.repartirCartas();
	}
	
	public void inicializarPartida() {
		ColaEntrada.getColaEntrada();
		PuertaDelCielo.getPuertaDelCielo();	
		Jugador.getJugador().asignarNombre("jug");	
		turno = true;
		juegoFinalizado = false;
		imprimirmazo();
	}
	
	public void repartirCartas() {
		Jugador.getJugador().barajar();
		Ordenador.getOrdenador().barajar();
		for (int i=0 ; i<4;i++) {
			Jugador.getJugador().cogerCarta();
			Ordenador.getOrdenador().cogerCarta();
		}
	}
	
	public void setTurno(boolean pTurno) {
		turno = pTurno;
		if (!turno) {
			
			Ordenador.getOrdenador().jugar();
			
		}
	}
	/*public void echarCarta(int pi) {
		if(!jugador.echarCarta(pi)) {
			if(finalizarPartida()) {
				juegoFinalizado=true;
			}
		}
		
	}*/
	//aqui hay dudas
	
	public void finalizarPartida() {
		if(Jugador.getJugador().getPuntos()>Ordenador.getOrdenador().getPuntos()) {
			System.out.println("el jugador"+Jugador.getJugador().getNombre()+"ha ganado");	
		}else System.out.println("el ordenador ha ganado");
		this.juegoFinalizado=true;
	
	}
	
	private void imprimirmazo() {
		Jugador.getJugador().imprimirmazo();
		System.out.println("ordenador");
		Ordenador.getOrdenador().imprimirmazo();
	}
}
