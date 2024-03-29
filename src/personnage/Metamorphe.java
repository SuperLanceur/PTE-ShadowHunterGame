package personnage;

import condition.WinConditionShadow;
import main.Joueur;

public class Metamorphe extends CartePersonnage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8415184267445994107L;
	public final static int  HP = 11;
	
	public Metamorphe() {
		super("METAMORPHE","desc", HP, null);
		this.setEquipe(CartePersonnage.Equipe.SHADOW);
		this.setCondition(new WinConditionShadow());
	}
	
	public Metamorphe(Joueur j) {
		super("METAMORPHE","desc", HP, j);
		this.setEquipe(CartePersonnage.Equipe.SHADOW);
		this.setCondition(new WinConditionShadow());
	}
	
	public Metamorphe(String nom, String desc ,int hp, Joueur joueur) {
		super(nom,desc, hp, joueur);
		this.setEquipe(CartePersonnage.Equipe.SHADOW);
		this.setCondition(new WinConditionShadow());
	}

	public void utiliser() {
	}
}
