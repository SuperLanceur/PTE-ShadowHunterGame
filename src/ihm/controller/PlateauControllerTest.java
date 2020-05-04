package ihm.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ihm.PopUpBoolean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import main.Joueur;

public class PlateauControllerTest implements Initializable {


	@FXML private BorderPane root;
	
	
	
	/**
	 * initialise les donn�es du plateau
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//initialisation des attributs des joueurs
		
		for(int i = 0; i < 8; i++) {
			
			
			AnchorPane ap = getAnchorPaneJoueur(i);
			Pane p;
			try {
				p = FXMLLoader.load(getClass().getResource("/ihm/ressources/MenuJoueur.fxml"));
				if(i > 1 && i < 3) {
					rotateContent(p, 90);
				}
				setContentAnchorPane(ap, p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public GridPane getGridPaneJoueur(int pos) {
		
		int position = pos%8 / 2;
		
		position++;
		
		AnchorPane apParent = (AnchorPane) root.getChildren().get(position);
		
		GridPane gp = (GridPane) apParent.getChildren().get(0);
		
		return (GridPane) gp.getChildren().get(pos%2);
	}
	
	
	public AnchorPane getAnchorPaneJoueur(int pos) {
		
		GridPane gp = getGridPaneJoueur(pos);
		return (AnchorPane) gp.getChildren().get(0);
	}
	
	public ImageView getImageViewJoueur(int pos) {
		
		GridPane gp = getGridPaneJoueur(pos);
		return (ImageView) gp.getChildren().get(1);
	}
	
	public ScrollPane getScrollPaneJoueur(int pos) {
		
		GridPane gp = getGridPaneJoueur(pos);
		return (ScrollPane) gp.getChildren().get(2);
	}
	

	public void setContentAnchorPane(AnchorPane ap, Pane p) {
		
		ap.getChildren().setAll(p);
		
		AnchorPane.setTopAnchor(p, 0.0);
		AnchorPane.setBottomAnchor(p, 0.0);
		AnchorPane.setLeftAnchor(p, 0.0);
		AnchorPane.setRightAnchor(p, 0.0);
		
	}
	
	public void rotateContent(Pane p, double rotation) {
		p.setRotate(rotation);
	}
	
	
		
	/*
		int OFFSET_X = 0;
		int OFFSET_Y = 0;
		int WIDTH = 557;
		int HEIGHT = 557;
		int COUNT = 6;
		int COLUMNS = 6;
	
		//anchorPane1.getChildren().setAll(imageView);
		
		
		ImageView imageView;
		try {
			imageView = FXMLLoader.load(getClass().getResource("../ressources/Dés.fxml"));
			imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

			imageView.fitWidthProperty().bind(anchorPane1.widthProperty()); 
			final SpriteAnimation animation = new SpriteAnimation(
			        imageView,
			        Duration.millis(250),
			        COUNT, COLUMNS,
			        OFFSET_X, OFFSET_Y,
			        WIDTH, HEIGHT
			);
			animation.setCycleCount(Animation.INDEFINITE);
			animation.play();
			anchorPane1.getChildren().addAll(new Group(imageView));
			anchorPane1.setOnMousePressed(new EventHandler<Event>(
					
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
*/
	
	
	

	
	
	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	
	
	public boolean choisir(Joueur j) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("../ressources/choisirBoolean.fxml"));
		Parent root = loader.load();
        
		PopUpBoolean popup = new PopUpBoolean(root, "Consulter sa carte");
		return popup.display();
		
		
	}
	
	public void rollDice(Joueur j, int typeDice, int[] resultats) {
		
	}
	
	/**
	 * Permet de consulter sa carte perssonage en cas d'oublie
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	
	
}
