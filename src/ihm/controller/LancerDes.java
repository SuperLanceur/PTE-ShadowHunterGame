package ihm.controller;

import java.util.Random;

import ihm.Die;
import ihm.DieImages;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;
import main.Contexte;
import main.GestionnaireJeu;
import main.Joueur;
import main.JoueurVirtuel;

public class LancerDes {
	private int resultat;
	private Contexte contexte;
	private int typeDe;
	private int[] rolls;
	
	private final static int LANCER_DE_4 = 0;
	private final static int LANCER_DE_6 = 1;
	private final static int LANCER_DES = 2;
	
	public LancerDes(int typeDe, int[] rolls, Contexte c){
		this.typeDe = typeDe;
		this.rolls = rolls;
		this.contexte = c;
	}
	
	public VBox initLancer(Joueur joueur) {
		switch (typeDe) {
		case LANCER_DE_4:
			return initLancerD4(joueur);
		case LANCER_DE_6:
			return initLancerD6(joueur);
		case LANCER_DES:
			return initLancerBoth(joueur);
		default :
			return null;
		}
	}
	

	private VBox initLancerD4(Joueur j) {
		DieImages images = new DieImages(4);
		Die die = new Die(images.getImages());
		ImageView stackpane = die.getdieFace();
		stackpane.setFitHeight(100);
		stackpane.setFitWidth(100);
		Button btn = new Button();
		Text txt = new Text("Lancez le dé");
	    txt.setFont(Font.font(null, null, null, 12));
	    txt.setFill(Color.WHITE);
		btn.setText("Lancer dé");
		btn.setOnAction((ActionEvent event) -> {
			btn.setDisable(true);// Disable Button
			Random random = new Random();
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), (actionEvent) -> {
				int tempRandom = random.nextInt(4)+1;
				die.setDieFace(tempRandom);
			}));
			
			timeline.setCycleCount(20);
			timeline.play();
			timeline.setOnFinished(actionEvent -> {
				
				die.setDieFace(rolls[0]);
				txt.setText("Vous avez obtenu "+rolls[0]);
			Timeline timeline2 = new Timeline(new KeyFrame(
			        Duration.millis(2000),
			        ae ->  {
			        	
			  
			        	GestionnaireJeu.notifyPlateau(); 
			}));
			timeline2.play();
		});
		});
		
		HBox des = new HBox(stackpane);
		des.setAlignment(Pos.CENTER);
		VBox root = new VBox(txt,des, new StackPane(btn));
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		if(j instanceof JoueurVirtuel)
		btn.fire();
		return root;
	}

	private VBox initLancerD6(Joueur j) {
		DieImages images = new DieImages(6);
		Die die = new Die(images.getImages());
		ImageView stackpane = die.getdieFace();
		stackpane.setFitHeight(100);
		stackpane.setFitWidth(100);
		Button btn = new Button();
		Text txt = new Text("Lancez le dé");
	    txt.setFont(Font.font(null, null, null, 12));
	    txt.setFill(Color.WHITE);
		btn.setText("Lancer dé");
		btn.setOnAction((ActionEvent event) -> {
			btn.setDisable(true);// Disable Button
			Random random = new Random();
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.1), (actionEvent) -> {
				int tempRandom = random.nextInt(6)+1;
				die.setDieFace(tempRandom);
			}));
			
			timeline.setCycleCount(20);
			timeline.play();
			timeline.setOnFinished(actionEvent -> {
				
				die.setDieFace(rolls[0]);
				txt.setText("Vous avez obtenu "+rolls[0]);
			Timeline timeline2 = new Timeline(new KeyFrame(
			        Duration.millis(2000),
			        ae ->  {
			        	GestionnaireJeu.notifyPlateau(); 
			}));
			timeline2.play();
		});
		});
		
		HBox des = new HBox(stackpane);
		des.setAlignment(Pos.CENTER);
		VBox root = new VBox(txt,des, new StackPane(btn));
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		if(j instanceof JoueurVirtuel)
			btn.fire();
		return root;
	}
	
	private VBox initLancerBoth(Joueur j) {
		DieImages images = new DieImages(6);
		DieImages images2 = new DieImages(4);
		Die die = new Die(images.getImages());
		Die die2 = new Die(images2.getImages());
		ImageView stackpane = die.getdieFace();
		ImageView stackpane2 = die2.getdieFace();
		stackpane.setFitHeight(100);
		stackpane2.setFitHeight(100);
		stackpane.setFitWidth(100);
		stackpane2.setFitWidth(100);
		Button btn = new Button();
		Text txt = new Text("Lancez les dés");
	    txt.setFont(Font.font(null, null, null, 12));
	    txt.setFill(Color.WHITE);
		btn.setText("Lancer dés");
		btn.setOnAction((ActionEvent event) -> {
			btn.setDisable(true);// Disable Button
			Random random = new Random();
			
			Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.1), (actionEvent) -> {
				int tempRandom = random.nextInt(6)+1;
				int tempRandom2 = random.nextInt(4)+1;
				die.setDieFace(tempRandom);
				die2.setDieFace(tempRandom2);
			}));
			
			timeline.setCycleCount(20);
			timeline.play();
			timeline.setOnFinished(actionEvent -> {
				
				die.setDieFace(rolls[1]);
				die2.setDieFace(rolls[0]);
				
				int result = rolls[0]+rolls[1];
				
				txt.setText("Vous avez obtenu "+result);
			Timeline timeline2 = new Timeline(new KeyFrame(
			        Duration.millis(2000),
			        ae ->  {
			       GestionnaireJeu.notifyPlateau();
			       
			}));
			timeline2.play();
		});
		
		});
		
		HBox des = new HBox(stackpane, stackpane2);
		des.setAlignment(Pos.CENTER);
		VBox root = new VBox(txt,des, new StackPane(btn));
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);
		if(j instanceof JoueurVirtuel)
			btn.fire();
		return root;
	}

	public int getResult() {
		return resultat;
	}
}
