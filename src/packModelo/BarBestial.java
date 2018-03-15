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
	Jugador jugador;
	Ordenador ordenador;
	private boolean turno; // true = Usuario, false = Ordenador
	private boolean juegoFinalizado;

	
	private BarBestial(){
		mBarBestial= new BarBestial();
	}
	
	public static BarBestial getBarBestial(){
		if(mBarBestial==null){
			mBarBestial= new BarBestial();
		}
		return mBarBestial;
	}
	
	private void inicializar() {
		jugador = Jugador.getJugador();
		jugador.asignarNombre("jug");	
		ordenador = Ordenador.getOrdenador();
		turno = true;
		juegoFinalizado = false;
		PuertaDelCielo.getPuertaDelCielo();
		ColaEntrada.getColaEntrada();
		
		/*jugador.barajar();
		ordenador.barajar();
		for (int i=0 ; i<4;i++) {
			jugador.cogerCarta();
			ordenador.cogerCarta();
		}*/

	}
	public void setTurno(boolean pTurno) {
		turno = pTurno;
		if (!turno) {
			
				ordenador.jugar();
			
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
				if(jugador.getPuntos()>ordenador.getPuntos()) {
					System.out.println("el jugador"+jugador.getNombre()+"ha ganado");	
				}else System.out.println("el ordenador ha ganado");
			
	}
}
