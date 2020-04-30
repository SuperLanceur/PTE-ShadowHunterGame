package ihm.controller;

import javafx.scene.layout.Pane;
import main.Joueur;

public class JoueurIHM {

	private int position;
	private Joueur joueur;
	private Pane pane;
	
	public JoueurIHM(int i, Joueur joueur, Pane pane) {
		this.position = i;
		this.joueur = joueur;
		this.pane = pane;
	}
	

	
}
