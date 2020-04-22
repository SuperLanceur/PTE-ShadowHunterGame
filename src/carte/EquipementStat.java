package carte;

public class EquipementStat extends Equipement{
	int blessures;
	public EquipementStat(String nom, String description, int b) {
		super(nom, description);
		blessures = b;
	}
	
	public int getBlessures() {
		return blessures;
	}
}
