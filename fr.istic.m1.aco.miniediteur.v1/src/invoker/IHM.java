package invoker;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import command.Command;

public class IHM extends JFrame{

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private ArrayList<Bouton> lesBoutons;
	
	private TextArea texteA;
	
	private Command copier;
	private Command couper;
	private Command selectionner;
	private Command saisir;
	private Command coller;
	
	public IHM(){
		this.setTitle("Editeur de texte - V1");
		this.setSize(new Dimension(800, 500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		lesBoutons = new ArrayList<Bouton>();
		
		HashMap<String, Command> h = new HashMap<String, Command>();
		h.put("selectionner", selectionner);
		h.put("saisir", saisir);
		
		this.texteA = new TextArea(h);
		
		Bouton bCouper = new Bouton("Couper", this.couper);
		bCouper.setBounds(10, 10, 90, 30);
		
		Bouton bCopier = new Bouton("Copier", this.copier);
		bCopier.setBounds(110, 10, 90, 30);
		
		Bouton bColler = new Bouton("Coller", this.coller);
		bColler.setBounds(210, 10, 90, 30);
		
		this.texteA.setBounds(10, 50, 775, 415);
		
		this.add(bCopier);
		this.add(bColler);
		this.add(bCouper);
		
		this.add(texteA);
	}
	
	public void launch(){
		this.setVisible(true);
	}
	
	public char getCar() {
		return this.texteA.getDernierCar();
	}
	
	public int getDebutSelection() {
		return this.texteA.getDebutSelection();
	}

	public int getLongueurSelection() {
		return this.texteA.getLongueurSelection();
	}
	
	public void setCommands(HashMap<String, Command> h) throws Exception {
		this.couper = h.get("couper");
		if (this.couper == null) throw new Exception("commande \"couper\" manquante");
		this.copier = h.get("copier");
		if (this.copier == null) throw new Exception("commande \"copier\" manquante");
		this.coller = h.get("coller");
		if (this.coller == null) throw new Exception("commande \"coller\" manquante");
		this.selectionner = h.get("selectionner");
		if (this.selectionner == null) throw new Exception("commande \"selectionner\" manquante");
		this.saisir = h.get("saisir");
		if (this.saisir == null) throw new Exception("commande \"saisir\" manquante");
	}
	
}
