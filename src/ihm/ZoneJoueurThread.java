package ihm;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ZoneJoueurThread extends Thread {

	private boolean finished;
	
	
	
	public ZoneJoueurThread(AnchorPane anchorPane, Pane pane) {
		this.finished = false;
	}
	
	public void run() {
		while(!finished) {
			
		}
		
	}
}
