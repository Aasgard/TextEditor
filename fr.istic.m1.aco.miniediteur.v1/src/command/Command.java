package command;

import invoker.IHM;
import receiver.MoteurEdition;

public abstract class Command {

	protected MoteurEdition me;
	protected IHM ihm;
	
	/**
	 * Fonction abstraite.
	 */
	public abstract void execute();
	
}
