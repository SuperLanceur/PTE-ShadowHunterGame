package ihm;

//adaptation du code a la source : https://stackoverflow.com/questions/50021161/java-how-to-update-dice-image-when-button-clicked-and-equal-to-number-given
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author blj0011
 */
public class Die {
	ImageView dieFace;
	Image[] images;
	int currentFace;

	public Die(Image[] images) {
		this.images = images;
		dieFace = new ImageView(this.images[0]);// set default to image 0
	}

	public Die(Image[] images, int dieFaceValue) {
		// Need to catch for values less than 1 and greater than 6!
		this.images = images;
		dieFace = new ImageView(this.images[dieFaceValue - 1]);
	}

	public ImageView getdieFace() {
		return dieFace;
	}

	public int getCurrentFace() {
		return currentFace;
	}

	public void setDieFace(int dieFaceValue) {
		// Need to catch for values less than 1 and greater than 6!
		dieFace.setImage(this.images[dieFaceValue - 1]);
		currentFace = dieFaceValue;
	}
}