package invoker;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import command.Command;

public class TextArea extends JTextArea {

	private static final long serialVersionUID = 1L;
	
	private int debutSelection;
	private int longueurSelection;
	private String texte;
	private char dernierCar;
	
	public TextArea(HashMap<String, Command> comm) {

		final Command selectionner = comm.get("selectionner");
		final Command saisir = comm.get("saisir");
		final Command effacer = comm.get("effacer");
		final Command supprimer = comm.get("supprimer");
		
		System.out.println("Constructeur du TA : " + comm);
		
		this.setLineWrap(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(BorderFactory.createCompoundBorder(border,BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		this.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				int i = Math.min(e.getDot(), e.getMark());
				int j = Math.max(e.getDot(), e.getMark());
				int l = j - i;

				if (i != getDebutSelection() || l != getLongueurSelection()) {
					setSelection(i, l);
					selectionner.execute();
				}
			}
		});

		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
				char keyChar = e.getKeyChar();
				if (e.getKeyChar() != '\b' && (int)keyChar != 127){ //127 est la touche suppression
					dernierCar = e.getKeyChar();
					saisir.execute();
					setSelection(getDebutSelection()+1, 0);
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {
					e.consume();
					if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
						effacer.execute();
						System.out.println("On appuie sur retour arriere");
					}
					if (e.getKeyCode() == KeyEvent.VK_DELETE){
						e.consume();
						supprimer.execute();
					}
				}
			}
		});
	}
	
	public int getDebutSelection() {
		return debutSelection;
	}

	public int getLongueurSelection() {
		return longueurSelection;
	}

	public void setSelection(int debut, int longueur) {
		debutSelection = debut;
		longueurSelection = longueur;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
		this.setText(texte);
	}

	public char getDernierCar() {
		return dernierCar;
	}
	
	public void rafraichir(String texte, int start, int lg) {
		this.setTexte(texte);
		this.setSelectionStart(start);
		this.setSelectionEnd(start + lg);
		this.setSelection(start, lg);
	}
	
}
