package command;

import invoker.IHM;
import receiver.MoteurEdition;

public class Saisir extends Command {

	public Saisir(MoteurEdition moteure,IHM ihmn){
		me = moteure;
		ihm = ihmn;
	}
	
	public void execute(){
		String texte = String.valueOf(ihm.getCar());
		System.out.println("Caractère ajouté : " + texte);
		me.saisir(texte);
	}
	
}
