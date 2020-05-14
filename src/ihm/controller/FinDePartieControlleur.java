package ihm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main.Joueur;

public class FinDePartieControlleur implements Initializable {
	
	@FXML private Pane rootPane;	
	@FXML private Label labelWinner;

	public static List<Joueur> listeWinner = new ArrayList<Joueur>();
	
	/* Pour faire des tests
	private Joueur j1 = new Joueur("j1");
	private Joueur j2 = new Joueur("j2");
	private Joueur j3 = new Joueur("j3");
*/
	String names;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		/*
		listeWinner.add(j1);
		listeWinner.add(j2);
		listeWinner.add(j3);
*/
		
		for (Joueur winner : listeWinner) {
			if(names != null) {
				names = names +"\n" +  winner.getNom();
			}
			else {
				names = winner.getNom();
			}
			
		}
		
		
		labelWinner.setText(names);
	}

	public List<Joueur> getListeWinner() {
		return listeWinner;
	}

	public void setListeWinner(List<Joueur> listeWinner) {
		FinDePartieControlleur.listeWinner = listeWinner;
	}
	
	
}
