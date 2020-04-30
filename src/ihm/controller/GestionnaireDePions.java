package ihm.controller;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GestionnaireDePions {

	private Pion pionVie;
	private Pion pionLieu;	
	
	private GridPane gridPaneVie;
	
	public GestionnaireDePions(Color color,GridPane gridPaneVie) {
		
		this.gridPaneVie = gridPaneVie;
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
		
		StackPane nNew = (StackPane) gp.getChildren().get(damage);
		FlowPane fpNew = (FlowPane) nNew.getChildren().get(0);
		fpNew.getChildren().add(pionVie);
	}
	
	public void deplacerPionLieux() {
		
	}
}
