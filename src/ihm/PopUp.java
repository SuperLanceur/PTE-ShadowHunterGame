package ihm;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp {
	private Scene scene; 
	private Stage popupwindow;
	
	public PopUp (Parent p, String titre) {
		
		popupwindow = new Stage();
		popupwindow.initModality(Modality.APPLICATION_MODAL);
		popupwindow.setTitle(titre);
		
		scene = new Scene(p);
	}

	public void display() {
		popupwindow.setScene(scene);
		popupwindow.showAndWait();
	}
}
