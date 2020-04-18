package condition;

import main.Joueur;

public class ConditionStatistiques extends Condition {
	
	public static final boolean PLATEAU = false;
	public static final boolean JOUEUR = true;
	
	public static final int EQUAL = 0;
	public static final int MORE = 1;
	public static final int LESS = 2;
	
	
	private boolean plateauJoueur;
	private String key;
	private int value;
	private int equalMoreLess;
	
	
	/**
	 * 
	 * @param plateauJoueur
	 * @param key
	 * @param value
	 * @param equalMoreLess
	 */
	public ConditionStatistiques(boolean plateauJoueur,String key,int value,int equalMoreLess) {
		
		if(equalMoreLess >= 0 && equalMoreLess <= 2) this.equalMoreLess = equalMoreLess;
		else // TODO exception
		
		this.key = key;
		this.value = value;
		
		this.plateauJoueur = plateauJoueur;
	}
	
	/**
	 * @param joueur sur lequel on vérifie la condition
	 * 
	 */
	@Override
	public boolean isTrue(Joueur joueur) {
		
		int valeur;
		if(this.plateauJoueur)
		{
			valeur = joueur.getPlateau().getStat(key);
			
		}else {
			valeur = joueur.getStat(key);
		}
		
		switch(this.equalMoreLess) {
			case EQUAL:
				return this.value == valeur;
			case MORE:
				return this.value <= valeur;
			case LESS:
				return this.value >= valeur;
			default:
				// TODO exception
				return false;
		}
	}
}
