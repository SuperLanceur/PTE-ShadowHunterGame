package condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Joueur;
import personnage.CartePersonnage;


public class ConditionClassPersonnage extends Condition{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2298344287059138254L;
	private List<Class<? extends CartePersonnage>> classes;
	
	
	/**
	 * Construit une condition qui vérifie la possession d'un certain Personnage dans une liste définie.
	 * exemple : 
	 * 
	 * classes = { Emi.class, Metamorphe.class, ... etc }
	 * 
	 * @param classes Les Class des différents Personnage's.
	 */
	public ConditionClassPersonnage(List<Class<? extends CartePersonnage>> classes){
		this.classes = new ArrayList<Class<? extends CartePersonnage>>();
		this.classes.addAll(classes);
	}




	public ConditionClassPersonnage(Class<? extends CartePersonnage>...classes) {
		this.classes = new ArrayList<Class<? extends CartePersonnage>>();
		this.classes.addAll(Arrays.asList(classes));
	}




	/**
	 * Vérifie qu'il existe au moins une classe qui correspond au Personnage du Joueur.
	 * <br><br>
	 * exemple : 
	 * 
	 * classes = { Emi.class, Metamorphe.class, ... etc }
	 * <br>
	 * Si la class de la carte du joueur correspond à un des élements dans classes alors on renvoie vrai.
	 * 
	 * @param joueur Le joueur sur lequel on vérifie les conditions.
	 * @return boolean
	 */
	@Override
	public boolean isTrue(Joueur joueur)
	{
		Class<? extends CartePersonnage> ccp = joueur.getCartePersonnage().getClass();
		
		for(Class<? extends Object> classe : classes) {
		
			if(ccp == classe
					//|| cct.getClass() == classe.getClass() 
					) return true;
		}
		return false;
	}
	
}
