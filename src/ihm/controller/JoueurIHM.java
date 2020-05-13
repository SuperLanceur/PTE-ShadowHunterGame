package ihm.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import carte.CarteEquipement;
import database.RessourceLoader;
import ihm.ImageViewEquipement;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.Joueur;

public class JoueurIHM {

	private int position;
	private Joueur joueur;
	private Pane zoneJoueur;
	private GestionnaireDePions gestionnaireDePions;
	private Color color;
	private PlateauController pc;
	private boolean estRevele = false;

	public JoueurIHM(int i, Joueur joueur, Pane zoneJoueur, Color color, GridPane gridPaneVie, GridPane gridPaneLieux,
			PlateauController pc /* , boolean carteVisible */ ) {

		this.setPosition(i);
		this.setJoueur(joueur);
		this.zoneJoueur = zoneJoueur;
		this.color = color;
		this.gestionnaireDePions = new GestionnaireDePions(this.color, gridPaneVie, gridPaneLieux);
		this.pc = pc;

		zoneJoueur.setBorder(
				new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

		String name = joueur.getNom();
		setLabelJoueur(name);
		initRevealButton();
		initCheckIdentity();
		initZoneEquipement();
	}

	
	
	private void initZoneEquipement() {
		HBox hb = getPaneEquipement();

	}

	private void initRevealButton() {
		Button btn = getRevealButton();
		btn.setOnAction(x -> {

			this.joueur.reveal();
			ImageView iv = this.getCartePersonnage();
			System.out.println(this.joueur.getCartePersonnage());
			Image im = this.pc.getImageCarte(this.joueur.getCartePersonnage());
			GridPane gp = (GridPane) iv.getParent();
			iv.setImage(im);
			iv.fitHeightProperty().bind(gp.heightProperty());
			initButtonEffect(btn);
			//btn.setDisable(true);
			btn.setText("Utiliser Effet");
			estRevele = true;
		});
	}

	public Button getRevealButton() {
		Pane p = (Pane) zoneJoueur.getChildren().get(2);
		return (Button) p.getChildren().get(1);
	}

	private void initCheckIdentity() {
		ImageView iv = getCartePersonnage();

		iv.setOnMousePressed(press -> {

			if (estRevele == false) {

				Image im = this.pc.getImageCarte(this.joueur.getCartePersonnage());
				GridPane gp = (GridPane) iv.getParent();
				iv.setImage(im);
				iv.fitHeightProperty().bind(gp.heightProperty());
				iv.fitHeightProperty().bind(gp.heightProperty());
			}

		});

		iv.setOnMouseReleased(release -> {

			if (estRevele == false) {

				Image im = this.pc.getImageDosCarte(RessourceLoader.DOS_PERSONNAGE);
				GridPane gp = (GridPane) iv.getParent();
				iv.setImage(im);
				iv.fitHeightProperty().bind(gp.heightProperty());
				iv.fitHeightProperty().bind(gp.heightProperty());
			}

		});

	}

	public ImageView getCartePersonnage() {
		Pane p = (Pane) zoneJoueur.getChildren().get(2);
		return (ImageView) p.getChildren().get(0);
	}

	public void initButtonEffect(Button btn) {

		btn.setOnAction(click -> {
			System.out.println(this.joueur.getCartePersonnage().getNom() + " va user de son pouvoir");
			threadUtiliserCapacite();
			System.out.println(this.joueur.getCartePersonnage().getNom() + " a réussi à utiliser son pouvoir");
			btn.setDisable(true);
		});
	}
	
	private void utiliserCapacite() {

		AnchorPane save = getZoneJoueur();
		joueur.utiliserCapacite();
		Pane pane = null;
		Platform.runLater(() -> {
			Pane p = pane;
			if(save != null && save.getChildren().size() > 0) {
				p = (Pane) save.getChildren().get(0);
			}
			
			if(p != null) {
				setZoneJoueur(p);
		}});	
	}
	
	private void threadUtiliserCapacite() {
		Runnable task = new Runnable() {

			@Override
			public void run() {
				utiliserCapacite();	
			}
		};
		
		Thread thread = new Thread(task);
		thread.setDaemon(true);
		thread.start();
	}
	
	public AnchorPane getZoneJoueur() {
		return (AnchorPane) zoneJoueur.getChildren().get(1);
	}

	public void setZoneJoueur(Pane p) {

		AnchorPane ap = (AnchorPane) zoneJoueur.getChildren().get(1);
		ap.getChildren().setAll(p);

		// ap.prefWidthProperty().bind(ap.widthProperty());
		// ap.prefHeightProperty().bind(ap.heightProperty());

		AnchorPane.setBottomAnchor(p, 0.0);
		AnchorPane.setLeftAnchor(p, 0.0);
		AnchorPane.setRightAnchor(p, 0.0);
		AnchorPane.setTopAnchor(p, 0.0);
	}

	public Label getLabelJoueur() {
		return (Label) zoneJoueur.getChildren().get(0);
	}

	public void setLabelJoueur(String name) {
		Label label = getLabelJoueur();
		label.setText(name);
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

	public void replacerPionLieu() {
		this.gestionnaireDePions.deplacerPionLieux(this.joueur);
	}

	public void choisir() {

	}

	public void resetZoneJoueur() {
		this.getZoneJoueur().getChildren().setAll();
	}

	public HBox getPaneEquipement() {
		ScrollPane sp = (ScrollPane) this.zoneJoueur.getChildren().get(3);
		AnchorPane p = (AnchorPane) sp.getContent();
		return (HBox) p.getChildren().get(0);
	}

	public void ajouterEquipement(CarteEquipement e) {
		HBox hb = getPaneEquipement();
		ImageViewEquipement ive = new ImageViewEquipement(e);
		hb.getChildren().add(ive);
		ive.setPreserveRatio(true);
		ive.fitHeightProperty().bind(hb.heightProperty());
		//ive.fitWidthProperty().bind(hb.widthProperty());
	}

	public void retirerEquipement(CarteEquipement e) {
		
		HBox hb = getPaneEquipement();
		List<ImageView> liv = new ArrayList<ImageView>();
		for(Iterator<Node> iterator = hb.getChildren().iterator(); iterator.hasNext();) {
				Node n = iterator.next();
				
				if (n instanceof ImageViewEquipement) {
					ImageViewEquipement ive = (ImageViewEquipement) n;
					if (ive.contains(e)) {
						liv.add(ive);
					}
				}
			}
		
		hb.getChildren().removeAll(liv);
	}

	public String getNom() {
		return this.joueur.getNom();
	}

}
