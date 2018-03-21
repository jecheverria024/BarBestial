package packModelo.Usuario;

import packModelo.EnumColor;

public class Jugador extends Usuario {
	private String nom;
	private static Jugador mJugador;
	
	private Jugador(EnumColor pColor, int pPuntos) {
		super(pColor, pPuntos);
		//nom=pNom;
		
	}
	
	
	public static Jugador getJugador(){
		if(mJugador==null){
			mJugador= new Jugador(EnumColor.AZUL,0);
		}
		return mJugador;
	}
	
	public String getNombre() {
		return nom;
	}
	
	public void asignarColor(EnumColor pColor){
		
	}
	
	public void actualizarPuntos(int pPuntos){
		
	}
	
	public void asignarNombre(String pNombre){
		this.nom=pNombre;
	}
	
	
	

}
