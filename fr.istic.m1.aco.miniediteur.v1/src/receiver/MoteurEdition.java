package receiver;

import java.util.ArrayList;

import observer.Observer;
import observer.Subject;

public class MoteurEdition extends Subject implements IMoteurEdition {

	private Buffer buffer;
	private Selection selection;
	private PressePapier pressePapier;
	
	public MoteurEdition() {
		observers = new ArrayList<Observer>();
		this.buffer = new Buffer();
		this.selection = new Selection(0, 0, "");
		this.pressePapier = new PressePapier("");
	}
	
	@Override
	public void coller() {

	}

	@Override
	public void copier() {

	}

	@Override
	public void couper() {

	}

	@Override
	public void saisir(String texte) {

	}

	@Override
	public void selectionner(Integer debut, Integer longueur) {

	}
	
	public Buffer getBuffer(){
		return this.buffer;
	}

	public PressePapier getPressePapier(){
		return this.pressePapier;
	}

	public Selection getSelection(){
		return this.selection;
	}

	@Override
	public void notifyObservers() {
		
	}

	@Override
	public void registerObserver(Observer o) {
		
	}

	@Override
	public void unregisterObserver(Observer o) {
		
	}

}
