package ihm.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import main.Contexte;
import main.GestionnaireJeu;
import main.Joueur;
import main.JoueurVirtuel;

public class ChoisirJoueur implements Initializable {
	@FXML
	private HBox joueurHaut;
	@FXML
	private HBox joueurBas;
	@FXML
	private Label titre;
	@FXML
	private Button btn1;
	@FXML
	private Button btn2;
	@FXML
	private Button btn3;
	@FXML
	private Button btn4;
	@FXML
	private Button btn5;
	@FXML
	private Button btn6;
	@FXML
	private Button btn7;
	@FXML
	private Button btn8;

	private JoueurIHM joueurSelected;
	private List<JoueurIHM> listJoueursIHM;
	private List<Button> buttons;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		this.buttons = new ArrayList<Button>();

		this.buttons.add(btn1);
		this.buttons.add(btn2);
		this.buttons.add(btn3);
		this.buttons.add(btn4);
		this.buttons.add(btn5);
		this.buttons.add(btn6);
		this.buttons.add(btn7);
		this.buttons.add(btn8);
	}

	public void initButtons() {

		int i = 0;

		while (i < listJoueursIHM.size()) {
			Button b = this.buttons.get(i);
			JoueurIHM jihm = listJoueursIHM.get(i);
			b.setOnAction(e -> {
				GestionnaireJeu.notifyPlateau();
				this.joueurSelected = jihm;
			});
			b.setText(jihm.getNom());
			i++;
		}

		for (int j = i; j < buttons.size(); j++) {
			Button b = this.buttons.get(j);
			b.setVisible(false);
		}
	}

	// GETTERS AND SETTERS

	public HBox getJoueurHaut() {
		return joueurHaut;
	}

	public HBox getHBox(int valeur) {
		if (valeur < 4) {
			return joueurHaut;
		} else {
			return joueurBas;
		}
	}

	public void setJoueurHaut(HBox joueurHaut) {
		this.joueurHaut = joueurHaut;
	}

	public HBox getJoueurBas() {
		return joueurBas;
	}

	public void setJoueurBas(HBox joueurBas) {
		this.joueurBas = joueurBas;
	}

	public Label getTitre() {
		return titre;
	}

	public void setTitre(Contexte c) {
		switch (c) {
		case ATTAQUER:
			titre.setText("Choisissez le joueur à attaquer!");
			break;
		case CHOISIR_VISION:
			titre.setText("Choisissez le joueur à qui passer la carte vision!");
			break;
		case VOLER_EQUIP:
			titre.setText("Choisissez le joueur à qui voler un equipement!");
			break;
		default:
		}
	}

	public JoueurIHM getJoueurSelected() {
		return joueurSelected;
	}

	public void setListJoueursIHM(List<JoueurIHM> joueursIHM) {
		this.listJoueursIHM = joueursIHM;
	}

	public void fireBtnIA(JoueurVirtuel jIA, Contexte c) {
		for (Button b : buttons)
			b.setDisable(true);
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
			List<Joueur> joueurs = new ArrayList<>();
			for (JoueurIHM jihm : listJoueursIHM) {
				joueurs.add(jihm.getJoueur());
			}
			Joueur jchoisi = jIA.choisirJoueur(joueurs, c);
			int i = 0;
			boolean found = false;
			while (!found && i < listJoueursIHM.size()) {
				if (listJoueursIHM.get(i).getJoueur().equals(jchoisi)) {
					found = true;
					buttons.get(i).setDisable(false);
					buttons.get(i).fire();
				}
				i++;
			}
		}));
		timeline.play();

	}
}
