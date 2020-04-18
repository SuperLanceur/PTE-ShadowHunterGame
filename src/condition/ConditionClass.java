package condition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.Joueur;


public class ConditionClass<T> extends Condition{

	private List<Class<T>> classes;
	
	
	public ConditionClass(Class<T> ... classes){
		// TODO
		this.classes = new ArrayList<Class<T>>();
		this.classes.addAll(Arrays.asList(classes));
	}


	/**
	 * Vérifie qu'il existe au moins une classe qui correspond soit au Type soit au Personnage du Joueur.
	 * <br><br>
	 * exemple : 
	 * 
	 * classes = { Emi.class, Metamorphe.class, ... etc } ou classes = { Hunter.class, Shadow.class, Neutre.class }
	 * <br>
	 * Si la class de la carte du joueur correspond à un des élements dans classes alors on renvoie vrai, même chose pour les types.
	 * 
	 * @param joueur Le joueur sur lequel on vérifie les conditions.
	 * @return boolean
	 */
	@Override
	public boolean isTrue(Joueur joueur)
	{
		Class<? extends T> ccp = (Class<? extends T>) joueur.getCartePersonnage().getClass();
		Class<? extends T> cct = (Class<? extends T>) joueur.getEquipe().getClass();
		
		for(Class<? extends T> classe : classes) {
			
			
			if(ccp.getClass() == classe.getClass() || cct.getClass() == classe.getClass() ) return true;
		}
		return false;
	}
	
}
