package main;
import java.util.ArrayList;
import java.util.List;

import carte.Equipement;
import carte.EquipementStat;
import effet.Effet;


public class JoueurVirtuel extends Joueur {
	
	private int nvDifficulte = 1; //possibilite de 1, 2 ou 3
	
	public JoueurVirtuel (String name) {
		super(name);
	}
	
	public Effet choisirEffet(List<Effet> effets) {
		return effets.get((int)Math.floor(Math.random() * effets.size()));
	}
	
	//on privilegie les equipements qui donnent des stats
	public Equipement choisirEquipement(List<Equipement> equips) {
		List<Equipement> equipstat = trouverEquipStat(equips);
		if(equipstat.size()>0)
			return equipstat.get((int)Math.floor(Math.random() * equipstat.size()));
		return equips.get((int)Math.floor(Math.random() * equips.size()));
	}
	
	public List<Equipement> trouverEquipStat(List<Equipement> equips){
		List<Equipement> res = new ArrayList<>();
		for(Equipement e : equips) {
			if(e instanceof EquipementStat)
				res.add(e);
		}
		return res;
	}
	
	//on choisit les joueurs avec les moins de hp, on ne distingue pas cependant d'amie ou ennemi
	public Joueur choisirJoueur(List<Joueur> joueurs) {
		Joueur res = joueurs.get(0);
		for(int i=1; i<joueurs.size();i++) {
			if(res.getStat("HP")>joueurs.get(i).getStat("HP"))
				res = joueurs.get(i);
		}
		return res;
		//return joueurs.get((int)Math.floor(Math.random() * joueurs.size()));
	}
	
	public int getDifficulte() {
		return nvDifficulte;
	}
	
	public void setDifficulte(int i) {
		nvDifficulte = i;
	}
}
