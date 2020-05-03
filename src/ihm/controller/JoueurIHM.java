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
	private Pane zoneJoueur;
	private GestionnaireDePions gestionnaireDePions;
	private Color color;
	
	public JoueurIHM(int i, Joueur joueur, Pane zoneJoueur, Color color, GridPane gridPaneVie) {
		
		this.setPosition(i);
		this.setJoueur(joueur);
		this.zoneJoueur = zoneJoueur;
		this.color = color;
		this.gestionnaireDePions = new GestionnaireDePions(this.color,gridPaneVie);
		
		zoneJoueur.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));
		
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
		Pane p = (Pane) zoneJoueur.getChildren().get(2);
		return (Button) p.getChildren().get(1);
	}
	
	public ImageView getCartePersonnage() {
		Pane p = (Pane) zoneJoueur.getChildren().get(2);
		return (ImageView) p.getChildren().get(0);
	}
	
	public AnchorPane getZoneJoueur() {
		return (AnchorPane) zoneJoueur.getChildren().get(1);
	}
	
	public void setZoneJoueur(Pane p) {
		AnchorPane ap = (AnchorPane) zoneJoueur.getChildren().get(1);
		ap.getChildren().setAll(p);
		
		//ap.prefWidthProperty().bind(ap.widthProperty());
		//ap.prefHeightProperty().bind(ap.heightProperty());
		
		AnchorPane.setBottomAnchor(p,0.0);
		AnchorPane.setLeftAnchor(p,0.0);
		AnchorPane.setRightAnchor(p,0.0);
		AnchorPane.setTopAnchor(p,0.0);
		
	}
	
	
	
	public Label getLabelJoueur() {
		return (Label) zoneJoueur.getChildren().get(0);
	}
	
	public void setLabelJoueur(String name) {
		Label label = getLabelJoueur();
		label.setText(name);
	}
	
	public Label getPaneEquipement() {
		Pane p = (Pane) zoneJoueur.getChildren().get(2);
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

	public void choisir() {
	
		
	}

}
