package packObservable;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class ObservableAbstracto {
	private ArrayList<IObserver> observadores;
	
	public ObservableAbstracto() {
		observadores=new ArrayList<IObserver>();
	}
	public void registrarObservador(IObserver pObserver) {
		System.out.println("registarrarr");
		if(!observadores.contains(pObserver)) {
			observadores.add(pObserver);
		}
	}
	public void eliminarObservador(IObserver pObserver) {
		if(observadores.contains(pObserver)) {
			observadores.add(pObserver);
		}
	}
	public void notificar() {
		IObserver observador;
		Iterator<IObserver> it=observadores.iterator();
		System.out.println("notificar");
		System.out.println(this.observadores.size());
		while(it.hasNext()) {		
			it.next().update();
		}
	}
}
