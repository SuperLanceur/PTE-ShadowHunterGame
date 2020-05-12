package ihm;


import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PopUp{
	private Scene scene; 
	private Stage popup;

	private double xOffSet = 0;
	private double yOffSet = 0;
	
	public PopUp (Parent p, String titre) {
		
		
		popup = new Stage();
	
		
		
		popup.initModality(Modality.NONE);
		
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
		
		popup.focusedProperty().addListener((obs,wasFocused,isNowFocused) -> {
			
			if(!isNowFocused) {
				popup.hide();
			}
			
		});		
	}
	
	public Stage getStage() {
		return popup;
	}
	
	public Scene getScene() {
		return scene;
	}
	

	public void display() {
		
		popup.setScene(scene);
		
		popup.showAndWait();
		
		
	}
}
