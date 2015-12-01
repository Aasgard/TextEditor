package client;

import java.util.HashMap;

import command.*;
import observer.IHMObserver;
import receiver.MoteurEdition;

public class Client {

	private static MoteurEdition me;
	private static IHMObserver ihmo;
	private static HashMap<String, Command> commandes;

	/**
	 * Classe principale de lancement.
	 * Création d'un MoteurEdition et de l'IHM avec le ME en paramètre (attribution).
	 * Création des commandes, se référant aux objets correspondants, et passés à 
	 * @param args : Paramètre de base
	 * @throws Exception : Exception lancée si erreur
	 */
	public static void main(String[] args) throws Exception {
		me = new MoteurEdition();
		ihmo = new IHMObserver(me);
		
		commandes = new HashMap<String, Command>();
		commandes.put("couper", new Couper(me));
		commandes.put("saisir", new Saisir(me, ihmo));
		commandes.put("coller", new Coller(me));
		commandes.put("copier", new Copier(me));
		commandes.put("effacer", new Effacer(me));
		commandes.put("selectionner", new Selectionner(me, ihmo));
		
		ihmo.setCommands(commandes);
		me.registerObserver(ihmo);
		
		/* Finalisation de l'IHM */
		ihmo.createTextArea();
		ihmo.loadButtons();
		ihmo.launch();
		
	}
	
}
