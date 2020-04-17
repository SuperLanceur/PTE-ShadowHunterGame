package main;
import java.util.List;


public class JoueurVirtuel extends Joueur {
	
	private int nvDifficulte = 1; //possibilite de 1, 2 ou 3
	
	public JoueurVirtuel (String name) {
		super(name);
		this.setVirtual();
	}
	
	public Effet choisirEffet(List<Effet> effets) {
		return effets.get((int)Math.floor(Math.random() * effets.size()));
	}
	
	public Equipement choisirEquipement(List<Equipement> equips) {
		return equips.get((int)Math.floor(Math.random() * equips.size()));
	}
	
	public Joueur choisirJoueur(List<Joueur> joueurs) {
		return joueurs.get((int)Math.floor(Math.random() * joueurs.size()));
	}
	
	public int getDifficulte() {
		return nvDifficulte;
	}
}