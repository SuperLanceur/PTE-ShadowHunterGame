package ihm;

//adaptation du code a la source : https://stackoverflow.com/questions/50021161/java-how-to-update-dice-image-when-button-clicked-and-equal-to-number-given

import javafx.scene.image.Image;

/**
 *
 * @author blj0011
 */
public class DieImages {
	final Image die1 = new Image(getClass().getResourceAsStream("ressources/img/des1.png"));
	final Image die2 = new Image(getClass().getResourceAsStream("ressources/img/des2.png"));
	final Image die3 = new Image(getClass().getResourceAsStream("ressources/img/des3.png"));
	final Image die4 = new Image(getClass().getResourceAsStream("ressources/img/des4.png"));
	final Image die5 = new Image(getClass().getResourceAsStream("ressources/img/des5.png"));
	final Image die6 = new Image(getClass().getResourceAsStream("ressources/img/des6.png"));

	final Image dief1 = new Image(getClass().getResourceAsStream("ressources/img/desf1.png"));
	final Image dief2 = new Image(getClass().getResourceAsStream("ressources/img/desf2.png"));
	final Image dief3 = new Image(getClass().getResourceAsStream("ressources/img/desf3.png"));
	final Image dief4 = new Image(getClass().getResourceAsStream("ressources/img/desf4.png"));

	final Image[] images = new Image[6];
	int taille;

	public DieImages(int i) {

		switch (i) {
		case 6:
			images[0] = die1;
			images[1] = die2;
			images[2] = die3;
			images[3] = die4;
			images[4] = die5;
			images[5] = die6;
			taille = 6;
			break;
		case 4:
			images[0] = dief1;
			images[1] = dief2;
			images[2] = dief3;
			images[3] = dief4;
			taille = 4;
			break;
		default:
			images[0] = die1;
			images[1] = die2;
			images[2] = die3;
			images[3] = die4;
			images[4] = die5;
			images[5] = die6;
			taille = 6;
		}
	}

	public Image[] getImages() {
		return images;
	}
}