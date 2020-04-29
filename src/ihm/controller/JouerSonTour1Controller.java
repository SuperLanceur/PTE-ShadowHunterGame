package ihm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import carte.CarteLieu;
import ihm.SpriteAnimation;
import javafx.animation.Animation;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import main.Joueur;

public class JouerSonTour1Controller implements Initializable{
	private Joueur joueur;
	
	@FXML private Pane rootPane;
	@FXML private Label nomJoueur;
	@FXML private AnchorPane d6;
	@FXML private AnchorPane d4;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//nomJoueur.setText(joueur.getNom());
		
		int OFFSET_X = 0;
		int OFFSET_Y = 0;
		int WIDTH = 80;
		int HEIGHT = 80;
		int COUNT = 6;
		int COLUMNS = 6;
	
		//anchorPane1.getChildren().setAll(imageView);
		
		
		ImageView imageView;
		try {
			imageView = FXMLLoader.load(getClass().getResource("../ressources/img/des.fxml"));
			imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

			imageView.fitWidthProperty().bind(d6.widthProperty()); 
			final SpriteAnimation animation = new SpriteAnimation(
			        imageView,
			        Duration.millis(250),
			        COUNT, COLUMNS,
			        OFFSET_X, OFFSET_Y,
			        557, 557
			);
			animation.setCycleCount(Animation.INDEFINITE);
			animation.play();
			d6.getChildren().addAll(new Group(imageView));
			d6.setOnMousePressed(new EventHandler<Event>(
					
					) {

						@Override
						public void handle(Event arg0) {
							animation.stop();
						
						}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML 
	public void lancerDes(MouseEvent mouseEvent) throws IOException, InterruptedException{
		
		
		Thread.sleep(1000);
		
		Pane pane = FXMLLoader.load(getClass().getResource("../ressources/Jouer_tour(2)carte_lieux.fxml"));
        rootPane.getChildren().setAll(pane);
	}
	
	public void deplacerPion(CarteLieu lieux) {
		
	}
}
