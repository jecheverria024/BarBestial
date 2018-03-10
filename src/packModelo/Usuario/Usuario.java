package packModelo.Usuario;

import packModelo.EnumColor;
import packModelo.packCartas.CartaAnimal;
import packModelo.packCartas.ListaCartas;

public class Usuario {
	private ListaCartas mano;
	private ListaCartas mazo;
	private EnumColor color;
	private int puntos;
	
	public Usuario(EnumColor pColor, int pPuntos){
		puntos=pPuntos;
		color=pColor;
		mano=new ListaCartas();
		mazo=new ListaCartas();
	}
	
	public void echarCarta(CartaAnimal pCarta){
		
	}
	
	public void cogerCarta(){
		CartaAnimal ca=mazo.ultimaCarta();
		mazo.borrarCarta(ca);
		
		mano.add(ca);
	}
	
	
	
}
