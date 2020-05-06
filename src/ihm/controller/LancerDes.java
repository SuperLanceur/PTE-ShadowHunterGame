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
	
	private int[] valeurD6 = {1, 2, 3, 4, 5, 6};
	private int[] valeurD4 = {1, 2, 3, 4};
	
	private int resultatD6;
	private int resultatD4;
	
	private boolean lancement = true;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		btnStop.setVisible(false);
		
		btnLancer.setOnAction(e -> {
			try {
				btnLancer.setVisible(false);
				btnStop.setVisible(true);
				lancement();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		
		btnStop.setOnAction(e -> {
			//à remplir avec les valeurs donné par le gestionnaire de jeux
			lancement = false;
			d6.setText(Integer.toString(resultatD6));
			d4.setText(Integer.toString(resultatD4));
		});
	}

	public void lancement() throws InterruptedException {
		/*int i=0;
		while (lancement) {
			d6.setText(Integer.toString(valeurD6[i%6]));
			d4.setText(Integer.toString(valeurD4[i%4]));
			i++;
			//Thread.sleep(500);
		}*/
	}
}
