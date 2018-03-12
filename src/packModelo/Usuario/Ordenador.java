package packModelo.Usuario;

import packModelo.EnumColor;

public class Ordenador  extends Usuario{
	private static Ordenador mOrdenador;
	private Ordenador(EnumColor pColor, int pPuntos) {
		super(pColor, pPuntos);
		
	}
	public  Ordenador getOrdenador(){
		if(mOrdenador==null){
			mOrdenador= new Ordenador(getColor(), getPuntos());
		}
		return mOrdenador;
	}
	
	public void jugar() {
		
	}

}
