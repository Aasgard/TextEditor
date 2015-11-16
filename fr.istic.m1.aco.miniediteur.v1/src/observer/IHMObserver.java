package observer;

import invoker.IHM;
import receiver.MoteurEdition;

public class IHMObserver extends IHM implements Observer {

	protected Subject sub;
	
	public IHMObserver(Subject subject){
		this.sub = subject;
	}
	
	@Override
	public void notifyMe() {
		MoteurEdition m = (MoteurEdition) this.sub;
	}

}
