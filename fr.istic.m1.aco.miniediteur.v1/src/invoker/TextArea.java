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
		
		this.setLineWrap(true);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		this.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

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
				if (e.getKeyChar() != '\b') {
					dernierCar = e.getKeyChar();
					saisir.execute();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {
					e.consume();
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
