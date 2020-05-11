package ihm;

import carte.CarteEquipement;
import javafx.scene.image.ImageView;

public class ImageViewEquipement extends ImageView{

	private CarteEquipement ce;

	public ImageViewEquipement(CarteEquipement ce) {
		this.ce = ce;
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
