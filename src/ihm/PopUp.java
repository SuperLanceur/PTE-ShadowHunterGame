package ihm;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUp {
	private Scene scene; 
	private Stage popupwindow;
	private Pane pane;
	
	public PopUp (Pane p, String titre) {
		
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
