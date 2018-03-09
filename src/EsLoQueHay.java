
public class EsLoQueHay {
	private ListaCartas cartas;
	private static EsLoQueHay mEsLoQueHay;
	
	private EsLoQueHay(){
		
	}
	
	public static EsLoQueHay getEsLoQueHay(){
		if(mEsLoQueHay==null){
			mEsLoQueHay=new EsLoQueHay();
		}
		return mEsLoQueHay;
	}
	
	public void addLast(CartaAnimal c){
		cartas.add(c);
	}
}
