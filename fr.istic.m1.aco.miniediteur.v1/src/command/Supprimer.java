package command;

import receiver.MoteurEdition;

public class Supprimer extends Command {
	
	public Supprimer(MoteurEdition newem){
		me = newem;
	}
	
	@Override
	public void execute() {	
		me.supprimer();
		System.out.println("SUPPRIMER : "+me.getBuffer().getContenu().toString());
	}

}