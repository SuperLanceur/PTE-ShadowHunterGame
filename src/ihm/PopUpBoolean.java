package ihm;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopUpBoolean {
	
	
	@FXML private Pane rootPane;
	private Scene scene; 
	private Stage popup;
	public static boolean result;
	private double xOffSet = 0;
	private double yOffSet = 0;
	
	public PopUpBoolean (Parent p, String titre) {
		
		
		popup = new Stage();
		
		popup.initModality(Modality.WINDOW_MODAL);
		
		popup.initStyle(StageStyle.UNDECORATED);
		
		popup.setTitle(titre);
		
		scene = new Scene(p);
	        
		p.setOnMousePressed(new EventHandler<MouseEvent>() {
		
			@Override
			public void handle(MouseEvent event){
				
				xOffSet = event.getSceneX();
				yOffSet = event.getSceneY();
			}
			
		});
		
		p.setOnMouseDragged(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event){
				
				popup.setX(event.getScreenX() - xOffSet);
				popup.setY(event.getScreenY() - yOffSet);
				
			}
			
		});	
	}
	
	public boolean display() {
		
		popup.setScene(scene);
		
		popup.showAndWait();
	
		return result;
	}
}
