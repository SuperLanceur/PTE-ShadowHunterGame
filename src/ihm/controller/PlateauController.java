package ihm.controller;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import carte.Carte;
import carte.CarteEquipement;
import carte.CarteLieu;
import carte.CartePiochable;
import carte.CartePiochable.Type;
import database.RessourceLoader;
import effet.action.Action;
import ihm.EffetSonore;
import ihm.PopUp;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import main.Contexte;
import main.GestionnaireJeu;
import main.Joueur;
import main.JoueurVirtuel;

public class PlateauController implements Initializable {

	private List<Joueur> listJoueur = new ArrayList<Joueur>();
	private List<JoueurIHM> joueursIHM;

	@FXML
	private AnchorPane rootPane;
	@FXML
	private GridPane gridPaneVie;
	@FXML
	public GridPane gridPaneLieux;

	private ChoisirBoolean cb;
	private ChoisirEquipement ce;
	private ChoisirJoueur cj;
	private PiocherCarte pc;
	private LancerDes ld;

	private static Map<Carte, BufferedImage> mapRessourcesCartes;
	private static Map<String, BufferedImage> mapRessourcesDosCartes;

	public static int DICE_SIX = 1;
	public static int DICE_QUATRE = 0;
	public static int DICE_BOTH = 2;

	private final double RES = 200. / 2250.;
	private ResourceBundle resourceBundle;

	/**
	 * initialise les données du plateau
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// System.out.println("Création du plateau ...");

		this.resourceBundle = arg1;
		this.joueursIHM = new ArrayList<JoueurIHM>();
		GestionnaireJeu gj = GestionnaireJeu.getGestionnaireJeu();
		RessourceLoader rl = gj.getRessourceLoader();

		Map<Integer, Joueur> map = gj.getMapJoueurs();

		for (int i = 0; i < gridPaneVie.getChildren().size(); i++) {

			Pane p = (Pane) gridPaneVie.getChildren().get(i);
			Label l = (Label) p.getChildren().get(1);
			l.setText(i + "");

		}

		for (int i : map.keySet()) {
			System.out.println(i);
			joueursIHM.add(new JoueurIHM(i, map.get(i), getPaneJoueur(i),
					new Color(Math.random(), Math.random(), Math.random(), 1), gridPaneVie, gridPaneLieux, this));
		}

		for (int i = 0; i < joueursIHM.size(); i++) {
			joueursIHM.get(i).deplacerPionVie(0);
		}

		mapRessourcesCartes = rl.getRessourceCartes();
		setMapRessourcesDosCartes(rl.getRessourceDosCartes());

		List<CarteLieu> cl = gj.getCartesLieux();
		List<ImageView> ivs = this.getLieux();

		applyImages(cl, ivs);

	}

	private void applyImages(List<CarteLieu> cls, List<ImageView> ivs) {

		int size = cls.size();
		if (cls.size() == ivs.size()) {

			for (int i = 0; i < size; i++) {

				CarteLieu cl = cls.get(i);
				ImageView iv = ivs.get(i);

				BufferedImage bi = mapRessourcesCartes.get(cl);
				Image image = RessourceLoader.toJavaFX(bi);
				applyImageLieu(iv, image);
			}
		}
	}

	private void applyImageLieu(ImageView iv, Image im) {

		iv.setImage(im);
		Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		iv.setFitWidth(RES * screenSize.width);
		// iv.fitHeightProperty().bind(sp.heightProperty());
		// iv.fitWidthProperty().bind(sp.widthProperty());

		iv.setPreserveRatio(true);
		// iv.fitWidthProperty().bind(sp.widthProperty());
	}

	private Pane getPaneJoueur(int i) {

		System.out.println("i " + i);
		int position = i % 8;
		HBox hb = (HBox) rootPane.getChildren().get(0);
		GridPane gp = null;

		// BAS
		if (position < 2) {
			VBox group = (VBox) hb.getChildren().get(1);
			gp = (GridPane) group.getChildren().get(2);

			// DROITE
		} else if (position < 4) {
			System.out.println("Oui");
			Group group = (Group) hb.getChildren().get(2);
			gp = (GridPane) group.getChildren().get(0);

			// HAUT
		} else if (position < 6) {

			VBox group = (VBox) hb.getChildren().get(1);
			gp = (GridPane) group.getChildren().get(0);

			// GAUCHE
		} else if (position < 8) {
			Group group = (Group) hb.getChildren().get(0);
			gp = (GridPane) group.getChildren().get(0);

		}

		return (Pane) gp.getChildren().get(i % 2);
	}

	private List<ImageView> getLieux() {

		List<ImageView> views = new ArrayList<ImageView>();
		for (int i = 0; i < gridPaneLieux.getChildren().size(); i++) {

			HBox p = (HBox) gridPaneLieux.getChildren().get(i);
			for (int j = 0; j < p.getChildren().size(); j++) {
				StackPane sp = (StackPane) p.getChildren().get(j);
				ImageView iv = (ImageView) sp.getChildren().get(0);
				views.add(iv);
			}
		}
		return views;
	}

	/**
	 * Affiche aux yeux de tous la carte personnage du joueur
	 * 
	 * @param j : Le joueur sur lequel on a cliqué
	 */
	public void seReveler(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " se revele");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Reveler_son_identite.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Parent root = fxmlLoader.load();

		RevelationController rc = fxmlLoader.getController();
		rc.showInformation(listJoueur.get(numJoueur));

		PopUp popup = new PopUp(root, bundle.getString("consulter.sa.carte"));
		popup.display();
	}

	public JoueurIHM getJoueurIHM(Joueur j) {

		for (JoueurIHM joueurIHM : joueursIHM) {
			if (joueurIHM.getJoueur().equals(j))
				return joueurIHM;
		}
		return null;
	}

	/**
	 * Permet de consulter sa carte perssonage en cas d'oublie
	 * 
	 * @param j : Le joueur sur lequel on a cliqu�
	 */
	public void consulterSaCarte(int numJoueur) throws IOException {
		System.out.println(listJoueur.get(numJoueur).getNom() + " consulte sa carte");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/afficher_carte_perso.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Parent root = fxmlLoader.load();

		AfficherCarteController acc = fxmlLoader.getController();
		acc.showInformation(listJoueur.get(numJoueur));

		PopUp popup = new PopUp(root, bundle.getString("consulter.sa.carte"));
		popup.display();
	}

	/**
	 * Place les joueurs au bon endroit sur le plateau
	 * 
	 * @param j : map donnant le joueur et son numero
	 */
	public void placerJoueurs(Map<Integer, Joueur> j) {
		Set<Integer> set = j.keySet();

		for (int i = 0; i < 8; i++) {
			if (!set.contains(i)) {
				getPaneJoueur(i).getChildren().setAll();
			}
		}
	}

	public void rollDice(Joueur joueur, int typeDice, int[] rolls, Contexte c) {

		this.ld = new LancerDes(typeDice, rolls, c);
		JoueurIHM jihm = getJoueurIHM(joueur);
		jihm.setZoneJoueur(ld.initLancer(joueur));
	}

	public void afficherChoisir(Joueur j, Contexte contexte) throws IOException {
		final URL fxmlURL = getClass().getResource("/ihm/ressources/choisirBoolean.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane) fxmlLoader.load();
		this.cb = fxmlLoader.getController();
		cb.setTitre(contexte);
		if (j instanceof JoueurVirtuel) {
			switch (contexte) {
			case ACTIVER_EFFET_LIEU:
				cb.fireBtnIAEffetLieu();
				break;
			case ATTAQUER:
				cb.fireBtnIAattaquer((JoueurVirtuel) j, j.getJoueursRange());
				break;
			case CHOISIR_VISION:
				cb.fireBtnIAVision();
				;
				break;
			}
		}
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.setZoneJoueur(root);
	}

	public void afficherChoisirEquipementVole(Joueur j, List<CarteEquipement> lce) throws IOException {
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Jouer_tour(2a)voler_equipement.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane) fxmlLoader.load();
		this.ce = fxmlLoader.getController();
		this.ce.setListCarteEquipements(lce);
		this.ce.initChoisirEquipement();
		if (j instanceof JoueurVirtuel)
			this.ce.fireBtnIA((JoueurVirtuel) j, Contexte.VOLER_EQUIP);
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.setZoneJoueur(root);
	}

	public void afficherAlterationVie(Joueur j, int valeur) throws IOException, InterruptedException {

		final URL fxmlURL = getClass().getResource("/ihm/ressources/AlterationVieZJ.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane) fxmlLoader.load();
		AlterationVieZJ avzj = fxmlLoader.getController();
		avzj.changeLabel(valeur);

		JoueurIHM jihm = getJoueurIHM(j);
		Pane p = (Pane) jihm.getZoneJoueur();
		Pane pane = new Pane();

		if (p.getChildren() != null && p.getChildren().size() > 0) {

			pane = (Pane) p.getChildren().get(0);
		}

		jihm.setZoneJoueur(root);
		Pane pp = pane;
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> {

			jihm.resetZoneJoueur();
			jihm.setZoneJoueur(pp);
			GestionnaireJeu.notifyPlateau();
		}));
		timeline.play();
	}

	public void afficherLieu(Joueur j) throws IOException {

		final URL fxmlURL = getClass().getResource("/ihm/ressources/LieuZJ.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane) fxmlLoader.load();
		LieuZJ lzj = fxmlLoader.getController();
		lzj.setImageView(this.getImageCarte(j.getCarteLieu()));
		if (j instanceof JoueurVirtuel)
			lzj.fireBtnIA();
		JoueurIHM jihm = getJoueurIHM(j);
		if (jihm.getPosition() == 4 || jihm.getPosition() == 5) {
			SplitPane s = (SplitPane) root.getChildren().get(0);
			AnchorPane a = (AnchorPane) s.getItems().get(0);
			VBox v = (VBox) a.getChildren().get(0);
			AnchorPane b = (AnchorPane) s.getItems().get(1);
			ImageView i = (ImageView) b.getChildren().get(0);

			v.setRotate(180);
			i.setRotate(180);
			s.setRotate(180);
		}

		jihm.setZoneJoueur(root);
	}

	public void afficherChoisirJoueur(Joueur j, List<Joueur> joueurs, Contexte contexte) throws IOException {
		final URL fxmlURL = getClass().getResource("/ihm/ressources/choixJoueurAttq.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane) fxmlLoader.load();

		List<JoueurIHM> joueursIHM = toJoueursIHM(joueurs);

		this.cj = fxmlLoader.getController();
		cj.setTitre(contexte);
		this.cj.setListJoueursIHM(joueursIHM);
		this.cj.initButtons();
		if (j instanceof JoueurVirtuel)
			cj.fireBtnIA((JoueurVirtuel) j, contexte);
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.setZoneJoueur(root);
	}

	private List<JoueurIHM> toJoueursIHM(List<Joueur> joueurs) {

		List<JoueurIHM> list = new ArrayList<JoueurIHM>();

		for (Joueur j : joueurs) {
			list.add(getJoueurIHM(j));
		}

		return list;
	}

	public void afficherPiocher(Joueur j) throws IOException {

		final URL fxmlURL = getClass().getResource("/ihm/ressources/Jouer_tour(2b)piocher_carte.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		
		Pane root = (Pane)fxmlLoader.load();
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.setZoneJoueur(root);
	}
	
	public void afficherEffet(Joueur j) throws IOException {
		
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Jouer_tour(2b)piocher_carte.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane)fxmlLoader.load();
		
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.setZoneJoueur(root);
	}

	public CarteEquipement getChoixEquipementVole(Joueur joueur) {
		JoueurIHM jihm = getJoueurIHM(joueur);
		CarteEquipement result = this.ce.getResult();
		this.ce = null;
		jihm.getZoneJoueur().getChildren().setAll();
		return result;
	}

	public boolean getChoix(Joueur joueur) {
		JoueurIHM jihm = getJoueurIHM(joueur);
		boolean result = this.cb.getResult();
		this.cb = null;
		jihm.getZoneJoueur().getChildren().setAll();
		return result;
	}

	public Joueur getChoixJoueur(Joueur joueur) {
		JoueurIHM jihm = getJoueurIHM(joueur);
		JoueurIHM result = this.cj.getJoueurSelected();
		this.cj = null;
		jihm.getZoneJoueur().getChildren().setAll();
		return result.getJoueur();
	}

	public Type getChoixCarte(Joueur joueur) {
		JoueurIHM jihm = getJoueurIHM(joueur);
		Type result = this.pc.getCarte();
		this.pc = null;
		jihm.getZoneJoueur().getChildren().setAll();
		return result;
	}

	public void deplacer(Joueur currentJoueur) {
		JoueurIHM jIHM = getJoueurIHM(currentJoueur);
		jIHM.replacerPionLieu();

	}

	public void updateVieJoueur(Joueur joueur, int damage) {
		JoueurIHM jIHM = getJoueurIHM(joueur);
		jIHM.deplacerPionVie(damage);
	}

	@FXML
	public void mettreEnPause(MouseEvent me) throws IOException {

		InputStream fileSound1 = getClass().getResourceAsStream("/ihm/ressources/musique/BEEP1.wav");
		EffetSonore.playSoundEffect(fileSound1);

		System.out.println("Jeu en pause ...");
		final URL fxmlURL = getClass().getResource("/ihm/ressources/Pause.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane) fxmlLoader.load();

		PopUp pu = new PopUp(root, bundle.getString("cacher.carte.vision"));
		pu.display();
	}

	public static Image getImageCarte(Carte carte) {
		BufferedImage bi = mapRessourcesCartes.get(carte);
		return RessourceLoader.toJavaFX(bi);
	}

	public static Image getImageDosCarte(String s) {
		BufferedImage bi = mapRessourcesDosCartes.get(s);
		return RessourceLoader.toJavaFX(bi);
	}

	public void ajouterEquipement(Joueur j, CarteEquipement e) {
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.ajouterEquipement(e);
	}

	public void retirerEquipement(Joueur j, CarteEquipement e) {
		JoueurIHM jihm = getJoueurIHM(j);
		jihm.retirerEquipement(e);
	}

	public void close() throws IOException {
		final URL fxmlURL = PlateauController.class.getResource("/ihm/ressources/Menu.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane pane = fxmlLoader.load();
		rootPane.getChildren().setAll(pane);
	}

	public void afficherLT(Joueur j, CartePiochable cartePiochable) throws IOException {

		Image i = getImageCarte(cartePiochable);
		ImageView iv = new ImageView(i);
		Pane p = new Pane(iv);
		PopUp pu = new PopUp(p, "Image");
		pu.getStage().focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
			if (!isNowFocused) {
				GestionnaireJeu.notifyPlateau();
				pu.getStage().hide();
			}
		});
		if (j instanceof JoueurVirtuel) {
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(3000), ae -> {
				pu.getStage().hide();
			}));
			timeline.play();
		}
		pu.display();

	}

	public void afficherVision(Joueur j, CartePiochable cartePiochable) throws IOException {

		final URL fxmlURL = getClass().getResource("/ihm/ressources/RecevoirCarte.fxml");
		final ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.langue", ParametreController.LaLangue);
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL, bundle);
		Pane root = (Pane) fxmlLoader.load();
		RecevoirCarte lzj = fxmlLoader.getController();
		Image im = getImageCarte(cartePiochable);
		lzj.setImageView(im);
		lzj.setText(bundle.getString("cacher.carte.vision"));
		if (j instanceof JoueurVirtuel)
			lzj.fireBtnIA();
		JoueurIHM jihm = getJoueurIHM(j);
		
		if(jihm.getPosition()==4 || jihm.getPosition()==5) {
			SplitPane s=(SplitPane)root.getChildren().get(0);
		AnchorPane a=(AnchorPane)s.getItems().get(0);
			VBox v= (VBox)a.getChildren().get(0);
			AnchorPane b=(AnchorPane)s.getItems().get(1);
			ImageView i= (ImageView)b.getChildren().get(0);
		
			v.setRotate(180);
			i.setRotate(180);
			s.setRotate(180);
		}
		jihm.getZoneJoueur();
		jihm.setZoneJoueur(root);
	}


	public Map<String, BufferedImage> getMapRessourcesDosCartes() {

		return mapRessourcesDosCartes;
	}

	public void setMapRessourcesDosCartes(Map<String, BufferedImage> mapRessourcesDosCartes) {
		this.mapRessourcesDosCartes = mapRessourcesDosCartes;
	}

	private Action choixAction;

	public void afficherChoisirAction(Joueur joueur, List<Action> list) {

		List<Button> buttons = new ArrayList<Button>();

		for (Action a : list) {
			Button button = interpret(a);
			buttons.add(button);
			button.setOnAction(x -> {	
				
			this.choixAction = a;
			GestionnaireJeu.notifyPlateau();
		});

		}

		VBox v = new VBox();
		v.getChildren().addAll(buttons);
		v.setAlignment(Pos.CENTER);
		v.setSpacing(20.0);
		JoueurIHM jihm = getJoueurIHM(joueur);
		jihm.setZoneJoueur(v);

		if (joueur instanceof JoueurVirtuel) {
			for (Button b : buttons)
				b.setDisable(true);
			Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
				Button bchoisi = ((JoueurVirtuel)joueur).choisirEffet(buttons);
				bchoisi.setDisable(false);
				bchoisi.fire();
			}));
			timeline.play();
		}
	}

	public Action getChoixAction(Joueur joueur) {
		return this.choixAction;
	}

	private Button interpret(Action a) {

		String styles = "-fx-border-color: #e2e2e2;" + "-fx-border-width: 2;" + "-fx-background-radius: 0;"
				+ "-fx-background-color: #1d1d1d;" + "-fx-text-fill: #d8d8d8;"
				+ "-fx-background-insets: 0 0 0 0, 0, 1, 2;";

		String s = a.toString();
		Button b = new Button(s);
		b.setStyle(styles);
		return b;
	}

	public void revealJoueur(Joueur joueur) {
		JoueurIHM jihm = getJoueurIHM(joueur);
		jihm.reveler();
	}

}