package effet;
import main.Joueur;
public class ActionAltererStatistiquesJoueur {

	private String key;
	private int valeur;
	private boolean ajouter;
	
	public ActionAltererStatistiquesJoueur(String key, int valeur, boolean ajouter)
	{
		this.key = key;
		this.valeur = valeur;
		this.ajouter = ajouter;
	}
	
	public void affecter(Joueur j1, Joueur j2)
	{
		if(ajouter)
		{
			j2.setStat(key, j2.getStat(key)+valeur);
		}else {
			j2.setStat(key, valeur);
		}
		
	}
	
}
