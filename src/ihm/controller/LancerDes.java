package ihm.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LancerDes implements Initializable{
	@FXML private Label d6;
	@FXML private Label d4;
	@FXML private Button btnStop;
	@FXML private Button btnLancer;
	
	private int resultatD6;
	private int resultatD4;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		btnStop.setVisible(false);
		
		btnLancer.setOnAction(e -> {
			lancement();
			btnLancer.setVisible(false);
			btnStop.setVisible(true);
		});
		
		btnStop.setOnAction(e -> {
			//à remplir avec les valeurs donné par le gestionnaire de jeux
			d6.setText(Integer.toString(resultatD6));
			d4.setText(Integer.toString(resultatD4));
		});
	}

	public void lancement() {
		/*for (int i=1; i<7; i++) {
			Thread.sleep(500);
			d6.setText(Integer.toString(i));
		}
		
		for (int i=1; i<5; i++) {
			Thread.sleep(500);
			d4.setText(Integer.toString(i));
		}*/
	}
}
