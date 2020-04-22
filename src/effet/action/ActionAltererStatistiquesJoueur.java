package effet.action;
import main.Joueur;
public class ActionAltererStatistiquesJoueur extends Action{

	private String key;
	private int valeur;
	private boolean ajouter;
	
	/**
	 * Constructeur ActionAltererStatistiquesJoueur
	 * @param key Le clé qui correspond à la valeur à modifier
	 * @param valeur La valeur
	 * @param ajouter Permet d'ajouter ou non "valeur" à la valeur précendente
	 * <br><br>
	 * Exemple : 
	 * <br><br>
	 * ActionAltererStatistiquesJoueur("PV", -2, true)
	 * <br>
	 * Fait subir 2 PV's de dégâts au joueur
	 * <br><br>
	 * ActionAltererStatistiquesJoueur("PV", 2, false)
	 * <br>
	 * Change les PV's du joueur à 2
	 */
	
	public ActionAltererStatistiquesJoueur(String key, int valeur, boolean ajouter)
	{
		this.key = key;
		this.valeur = valeur;
		this.ajouter = ajouter;
	}

	/**
	 * Lance l'action de modification de statistiques 
	 * @param j1 Le joueur qui modifie
	 * @param j2 Le joueur dont les statistiques sont modifiées
	 * @return void
	 */
	public void affecte(Joueur j1, Joueur j2)
	{
		if(ajouter)
		{
			j2.addToStat(key, valeur);
		}else {
			j2.setStat(key, valeur);
		}
	}
}
