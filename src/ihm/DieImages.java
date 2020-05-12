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

	final Image[] images = new Image[6];

	public DieImages() {
		images[0] = die1;
		images[1] = die2;
		images[2] = die3;
		images[3] = die4;
		images[4] = die5;
		images[5] = die6;
		for (int i = 0; i < images.length; i++) {

		}
	}

	public Image[] getImages() {
		return images;
	}
}