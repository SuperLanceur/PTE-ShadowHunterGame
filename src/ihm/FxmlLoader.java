package ihm;

import java.io.FileNotFoundException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class FxmlLoader {
	private Pane view;
	
	public Pane getPage(String fileName) {
		try {
			URL fileUrl = Main.class.getResource("ressources/" + fileName + ".fxml");
			if (fileUrl == null) {
				throw new FileNotFoundException("Fil fxml pas trouvé");
			}
			
			view = new FXMLLoader().load(fileUrl);
		}catch (Exception e) {
			System.out.println("Pas de file" + fileName);
		}
		return view;
	}
}
