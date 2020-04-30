package ihm.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.Joueur;

public class JoueurIHM {

	private int position;
	private Joueur joueur;
	private Pane pane;
	private GestionnaireDePions gestionnaireDePions;
	private Color color;
	
	public JoueurIHM(int i, Joueur joueur, Pane pane, Color color, GridPane gridPaneVie) {
		
		this.setPosition(i);
		this.setJoueur(joueur);
		this.pane = pane;
		this.color = color;
		this.gestionnaireDePions = new GestionnaireDePions(this.color,gridPaneVie);
		
		pane.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
		
		String name = joueur.getNom();
		setLabelJoueur(name);
		initRevealButton();
	}
	
	private void initRevealButton() {
		Button btn = getRevealButton();
		btn.setOnAction(x -> {
			
			this.joueur.reveal();
			ImageView iv = this.getCartePersonnage();
			// TODO		
			//this.joueur.getCartePersonnage().getId();
			//iv.setImage(arg0);
			System.out.println(joueur.getRevele());
			btn.setDisable(true);
		});
		
	}

	public Button getRevealButton() {
		Pane p = (Pane) pane.getChildren().get(1);
		return (Button) p.getChildren().get(1);
	}
	
	public ImageView getCartePersonnage() {
		Pane p = (Pane) pane.getChildren().get(1);
		return (ImageView) p.getChildren().get(0);
	}
	
	public AnchorPane getZoneJoueur() {
		return (AnchorPane) pane.getChildren().get(0);
	}
	
	public Label getLabelJoueur() {
		Pane p = (Pane) pane.getChildren().get(2);
		return (Label) p.getChildren().get(0);
	}
	
	public void setLabelJoueur(String name) {
		Label label = getLabelJoueur();
		label.setText(name);
	}
	
	public Label getPaneEquipement() {
		Pane p = (Pane) pane.getChildren().get(2);
		return (Label) p.getChildren().get(1);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	public void deplacerPionVie(int damage) {
		this.gestionnaireDePions.deplacerPionVie(damage);
	}

}
