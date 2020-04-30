package main;

import java.util.ArrayList;
import java.util.List;

import carte.Equipement;
import carte.EquipementStat;
import effet.Effet;

public class JoueurVirtuel extends Joueur {

	private int nvDifficulte = 1; // possibilite de 1, 2 ou 3

	public JoueurVirtuel(String name) {
		super(name);
	}

	public Effet choisirEffet(List<Effet> effets) {
		return effets.get((int) Math.floor(Math.random() * effets.size()));
	}

	// on privilegie les equipements qui donnent des stats
	public Equipement choisirEquipement(List<Equipement> equips) {
		List<Equipement> equipstat = trouverEquipStat(equips);
		if (equipstat.size() > 0)
			return equipstat.get((int) Math.floor(Math.random() * equipstat.size()));
		return equips.get((int) Math.floor(Math.random() * equips.size()));
	}

	public List<Equipement> trouverEquipStat(List<Equipement> equips) {
		List<Equipement> res = new ArrayList<>();
		for (Equipement e : equips) {
			if (e instanceof EquipementStat)
				res.add(e);
		}
		return res;
	}

	public Joueur choisirJoueur(List<Joueur> joueurs, Contexte c) {
		Joueur res;
		switch (c) {
		case ATTAQUER:
			res = choisirJoueurEnnemi(joueurs);
			break;
		case VOLER_EQUIP:
			res = choisirJoueurAVoler(joueurs);
			break;
		case EFFET_NEGATIF_SUR_AUTRES:
			res = choisirJoueurEnnemi(joueurs);
			break;
		case EFFET_POSITIF_SUR_AUTRES:
			res = choisirJoueurAmi(joueurs);
			break;
		default:
			res = null; // faire exception?
		}
		return res;
	}

	// on choisit les joueurs avec les moins de hp, on met en priorite les ennemis
	public Joueur choisirJoueurEnnemi(List<Joueur> joueurs) {
		List<Joueur> resliste;
		List<Joueur> ennemis = ControleurIA.getEnnemisJoueurs(this, joueurs);
		if (ennemis.size() > 0)
			resliste = ennemis;
		else
			resliste = joueurs;
		Joueur res = resliste.get(0);
		for (int i = 1; i < resliste.size(); i++) {
			if (res.getStat("HP") > resliste.get(i).getStat("HP"))
				res = resliste.get(i);
		}
		return res;
		// return joueurs.get((int)Math.floor(Math.random() * joueurs.size()));
	}

	// on choisit les joueurs avec le plus d'equipements, on met en priorite les
	// ennemis
	public Joueur choisirJoueurAVoler(List<Joueur> joueurs) {
		List<Joueur> resliste;
		List<Joueur> ennemis = ControleurIA.getEnnemisJoueurs(this, joueurs);
		if (ennemis.size() > 0)
			resliste = ennemis;
		else
			resliste = joueurs;
		Joueur res = resliste.get(0);
		for (int i = 1; i < resliste.size(); i++) {
			if (res.getStat("nb_equipements") > resliste.get(i).getStat("nb_equipements"))
				res = resliste.get(i);
		}
		return res;
	}

	// on choisit les joueurs avec les moins de hp, on met en priorite les amis (ex:
	// pour les soigner?)
	public Joueur choisirJoueurAmi(List<Joueur> joueurs) {
		List<Joueur> resliste;
		List<Joueur> ennemis = ControleurIA.getAmisJoueurs(this, joueurs);
		if (ennemis.size() > 0)
			resliste = ennemis;
		else
			resliste = joueurs;
		Joueur res = resliste.get(0);
		for (int i = 1; i < resliste.size(); i++) {
			if (res.getStat("HP") > resliste.get(i).getStat("HP"))
				res = resliste.get(i);
		}
		return res;
		// return joueurs.get((int)Math.floor(Math.random() * joueurs.size()));
	}

	public int getDifficulte() {
		return nvDifficulte;
	}

	public void setDifficulte(int i) {
		nvDifficulte = i;
	}
}
