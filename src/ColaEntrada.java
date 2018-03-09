

public class ColaEntrada {
	private ListaCartas cartas;
	private static ColaEntrada mColaEntrada;
	
	private ColaEntrada(){
		
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
			PuertaDelCielo p= PuertaDelCielo.getPuertaDelCielo();
			EsLoQueHay e=EsLoQueHay.getEsLoQueHay();
			for(int i=0;i<2;i++){
				CartaAnimal c=cartas.conseguirCarta();
				p.add(c);
				cartas.borrarCarta(c);
			}
			CartaAnimal c1=cartas.ultimaCarta();
			e.addLast(c1);
			cartas.borrarCarta(c1);
		}
	}
	
	private boolean comprobarColaCompleta(){
		boolean lleno=false;
		if(cartas.longitud()+1==5){ //si empieza en cero esta bien 
			lleno=true;
		}
		return lleno;
	}

}
