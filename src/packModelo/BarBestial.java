package packModelo;

import packModelo.Usuario.Jugador;
import packModelo.Usuario.Ordenador;
import packModelo.packBarcos.BarcoNoEncException;
import packModelo.packCartas.ListaCartas;
import packModelo.packCartas.PuertaDelCielo;
import packModelo.packJugador.Usuario;

public class BarBestial {
	private static BarBestial mBarBestial;
	Jugador jugador;
	Ordenador ordenador;
	private boolean turno; // true = Usuario, false = Ordenador
	private boolean juegoFinalizado;

	
	private BarBestial(){
		mBarBestial= new BarBestial();
	}
	
	public static BarBestial getPuertaDelCielo(){
		if(mBarBestial==null){
			mBarBestial= new BarBestial();
		}
		return mBarBestial;
	}
	
	private void inicializar() {
		jugador =new Jugador(EnumColor.ROJO,0, "jug");
		ordenador =new Ordenador(EnumColor.AMARILLO,0);
		turno = true;
		juegoFinalizado = false;
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
			if(!ordenador.comprobarCartas()) {
				ordenador.jugar();
			}else finalizarPartida();
			
		}
	}
	
	private boolean finalizarPartida() {
		if(!jugador.comprobarCartas()) {
			if(!ordenador.comprobarCartas()) {
				if(jugador.getPuntos()>ordenador.getPuntos()) {
					System.out.println("el jugador"+jugador.getNombre());	
				}else System.out.println("el ordenador ha ganado");
				return true;
			}
		}return false;
	}
}
