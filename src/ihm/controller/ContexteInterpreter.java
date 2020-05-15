package ihm.controller;

import java.util.ResourceBundle;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import main.Contexte;

public abstract class ContexteInterpreter {

	public static void setContexteToPane(Contexte contexte, Pane root) {
		
		ResourceBundle bundle1 = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		
		if(contexte.equals(Contexte.ATTAQUER)) {
			
			Label l = (Label) root.getChildren().get(0);
			l.setText(bundle1.getString("souhaiter.vous.attaquer"));
		}
		
		if(contexte.equals(Contexte.ACTIVER_EFFET_LIEU)) {
			
			Label l = (Label) root.getChildren().get(0);
			l.setText(bundle1.getString("souhaiter.vous.activer.effet.lieu"));
		}
	}

}
