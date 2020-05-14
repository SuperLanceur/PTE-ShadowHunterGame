package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import carte.CarteEquipement;
import carte.CarteEquipementStat;
import effet.Effet;
import javafx.scene.control.Button;

public class JoueurVirtuel extends Joueur {

	private int nvDifficulte = 1; // possibilite de 1, 2 ou 3

	public JoueurVirtuel(String name) {
		super(name);
	}

	public JoueurVirtuel(String nom, int lvlIa) {
		super(nom);
		nvDifficulte = lvlIa;
	}

	public Button choisirEffet(List<Button> effets) {
		return effets.get((int) Math.floor(Math.random() * effets.size()));
	}

	// on privilegie les equipements qui donnent des stats
	public CarteEquipement choisirEquipement(List<CarteEquipement> equips) {
		List<CarteEquipement> equipstat = trouverEquipStat(equips);
		if (equipstat.size() > 0)
			return equipstat.get((int) Math.floor(Math.random() * equipstat.size()));
		return equips.get((int) Math.floor(Math.random() * equips.size()));
	}

	public List<CarteEquipement> trouverEquipStat(List<CarteEquipement> equips) {
		List<CarteEquipement> res = new ArrayList<>();
		for (CarteEquipement e : equips) {
			if (e instanceof CarteEquipementStat)
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
		case CHOISIR_VISION:
			res = joueurs.get((int) Math.floor(Math.random() * joueurs.size())); // a revoir inshallah
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
			if (res.getStat("nb_equipements") < resliste.get(i).getStat("nb_equipements"))
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
