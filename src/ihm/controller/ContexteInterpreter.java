package ihm.controller;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main.Contexte;

public abstract class ContexteInterpreter {

	public static void setContexteToPane(Contexte contexte, Pane root) {
		
		if(contexte.equals(Contexte.ATTAQUER)) {
			
			Label l = (Label) root.getChildren().get(0);
			l.setText("Souhaitez vous attaquer ?");
		}
		
		if(contexte.equals(Contexte.ACTIVER_EFFET_LIEU)) {
			
			Label l = (Label) root.getChildren().get(0);
			l.setText("Souhaitez vous activer l'effet du lieu ?");
		}
	}

}
