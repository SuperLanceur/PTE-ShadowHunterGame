package ihm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import carte.CarteEquipement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import main.Joueur;
import main.Plateau;

public class ChoisirJoueur implements Initializable{
	@FXML private HBox joueurHaut;
	@FXML private HBox joueurBas;
	@FXML private Label titre;
/*	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
*/


	
	private int joueurSelected;
	private List<Joueur> joueurs = Plateau.jselectionne;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	/*	List<Button> buttons = new ArrayList();
		buttons.add(btn1);
		buttons.add(btn2);
      	buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        if(8-joueurs.size()>0) {
        	for(int i=0;i<8-joueurs.size();i++) {
        		buttons.get(buttons.size()-1-i).setVisible(false);
        	}
        	for(int i=0;i<joueurs.size();i++) {
        		buttons.get(i).setText(joueurs.get(i).getNom());
        	}
        }*/


		
		for (int i=0; i<joueurHaut.getChildren().size(); i++) {
			int numJoueur = i;
			joueurHaut.getChildren().get(i).setOnMouseClicked(e -> {
				System.out.println("Vous avez choisi le joueur " + (numJoueur+1));
				this.joueurSelected = numJoueur;
			});
		}
		
		for (int i=0; i<joueurBas.getChildren().size(); i++) {
			int numJoueur = i+4;
			joueurBas.getChildren().get(i).setOnMouseClicked(e -> {
				System.out.println("Vous avez choisi le joueur " + (numJoueur+1));
				this.joueurSelected = numJoueur;
			});
		} 
	}

	//GETTERS AND SETTERS
	public HBox getJoueurHaut() {
		return joueurHaut;
	}

	public void setJoueurHaut(HBox joueurHaut) {
		this.joueurHaut = joueurHaut;
	}

	public HBox getJoueurBas() {
		return joueurBas;
	}

	public void setJoueurBas(HBox joueurBas) {
		this.joueurBas = joueurBas;
	}

	public Label getTitre() {
		return titre;
	}

	public void setTitre(Label titre) {
		this.titre = titre;
	}

	public int getJoueurSelected() {
		return joueurSelected;
	}

	public void setJoueurSelected(int joueurSelected) {
		this.joueurSelected = joueurSelected;
	}

	public List<Joueur> getJoueur() {
		return joueurs;
	}

	public void setJoueur(List<Joueur> joueur) {
		this.joueurs = joueur;
	}
}
