package packModelo.Usuario;

import packModelo.EnumColor;

public class Jugador extends Usuario {
	private String nom;
	private static Jugador mJugador;
	private Jugador(EnumColor pColor, int pPuntos, String pNom) {
		super(pColor, pPuntos);
		nom=pNom;
		
	}
	
	public Jugador getJugador(){
		if(mJugador==null){
			mJugador= new Jugador(getColor(), getPuntos(), nom);
		}
		return mJugador;
	}
	
	public String getNombre() {
		return nom;
	}
	
	
	
	
	

}
