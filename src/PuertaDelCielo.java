
public class PuertaDelCielo {
	private ListaCartas cartas;
	private static PuertaDelCielo mPuertaDelCielo;
	
	private PuertaDelCielo(){
		
	}
	
	public static PuertaDelCielo getPuertaDelCielo(){
		if(mPuertaDelCielo==null){
			mPuertaDelCielo= new PuertaDelCielo();
		}
		return mPuertaDelCielo;
	}
	
	public void add(CartaAnimal carta){
		cartas.add(carta);
	}

}
