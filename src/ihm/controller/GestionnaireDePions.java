package ihm.controller;

import carte.CarteLieu;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Joueur;

public class GestionnaireDePions {

	private Pion pionVie;
	private Pion pionLieu;	
	
	private GridPane gridPaneVie;
	private GridPane gridPaneLieux;
	
	public GestionnaireDePions(Color color,GridPane gridPaneVie,GridPane gridPaneLieux) {
		
		this.gridPaneVie = gridPaneVie;
		this.gridPaneLieux = gridPaneLieux;
		this.pionVie = new Pion(color);
		this.pionLieu = new Pion(color);
	}
	
	public void deplacerPionVie(int damage) {
		GridPane gp = this.gridPaneVie;
		System.out.println(gp);
		int row = pionVie.getPosition().x;
		
		StackPane nAncient = (StackPane) gp.getChildren().get(row);
		FlowPane fpAncient = (FlowPane) nAncient.getChildren().get(0);
		fpAncient.getChildren().remove(pionVie);
		
		System.out.println(damage);
		if(damage < 0) {
			damage = 0;
		}else if(damage > gp.getChildren().size()-1) {
			damage = gp.getChildren().size()-1;
		}
		StackPane nNew = (StackPane) gp.getChildren().get(damage);
		FlowPane fpNew = (FlowPane) nNew.getChildren().get(0);
		
		if(!fpNew.getChildren().contains(pionVie)) fpNew.getChildren().add(pionVie);
		
	}
	
	public void deplacerPionLieux(Joueur j) {
		
		CarteLieu cl = j.getCarteLieu();
		int indexCL = j.getPlateau().getLieux().indexOf(cl);
		HBox hbox;
		System.out.println("GridPaneLieux "+this.gridPaneLieux);
		if(indexCL < 2) {
			hbox = (HBox) this.gridPaneLieux.getChildren().get(0);
			
		}else if(indexCL < 4) {
			hbox = (HBox) this.gridPaneLieux.getChildren().get(1);
			
		}else {
			hbox = (HBox) this.gridPaneLieux.getChildren().get(2);	
		}
		
		StackPane sp = (StackPane) hbox.getChildren().get(indexCL%2);
		FlowPane fp = (FlowPane) sp.getChildren().get(1);
	
		if(!fp.getChildren().contains(this.pionLieu)) fp.getChildren().add(this.pionLieu);	
		
	}
	
	
	public void animationDeplacer(double x, double y, Pion p) {
		
		
		TranslateTransition translate = new TranslateTransition();  
		
		translate.setByX(x);
		translate.setByY(y);
		translate.setDuration(Duration.millis(2000)); 
		translate.setNode(p);
		translate.play();
	}

}
