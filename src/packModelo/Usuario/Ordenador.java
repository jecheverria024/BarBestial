package packModelo.Usuario;

import packModelo.BarBestial;
import packModelo.EnumColor;

public class Ordenador  extends Usuario{
	private static Ordenador mOrdenador;
	private Ordenador(EnumColor pColor, int pPuntos) {
		super(pColor, pPuntos);
		
	}
	public static Ordenador getOrdenador(){
		if(mOrdenador==null){
			mOrdenador= new Ordenador(EnumColor.AMARILLO, 0);
		}
		return mOrdenador;
	}
	
	public void jugar() {
		
		echarCarta(1);
		
	}
	public void asignarColor(EnumColor pColor){
		
	}
	
	public void actualizarPuntos(int pPuntos){
		
	}
	
	public void asignarNombre(String pNombre){
		
	}
}
