package ihm;

import carte.CarteEquipement;
import ihm.controller.PlateauController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageViewEquipement extends ImageView{

	private CarteEquipement ce;

	public ImageViewEquipement(CarteEquipement ce) {
		this.ce = ce;
		Image im = PlateauController.getImageCarte(ce);
		this.setImage(im);
	}
	
	public CarteEquipement getCp() {
		return ce;
	}

	public void setCp(CarteEquipement ce) {
		this.ce = ce;
	}
	
	public boolean contains(CarteEquipement ce) {
		return this.ce == ce;
	}
	
}
