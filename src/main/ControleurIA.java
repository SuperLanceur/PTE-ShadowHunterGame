package main;
import java.util.ArrayList;
import java.util.List;

import carte.CarteLieu;
import personnage.CartePersonnage;
import personnage.CartePersonnage.Equipe;

public class ControleurIA {
	int seed;
	
	public ControleurIA() {
		seed = 100;
	}
	
	public void setSeed(int i) {
		seed = i;
	}

	public boolean choixUtiliserPouvoirLieu() {
		double res = getRandomPercentage();
		if (res < 80)
			return true;
		return false;
	}

	// precondition 1 : la liste joueursLieu ne contiendra pas jIA lui-meme
	// precondition 2 : on n'appellera pas cette methode si jIA est seul sur le lieu
	public boolean choixSiAttaquer(JoueurVirtuel jIA, List<Joueur> joueursLieu) {
		double res = getRandomPercentage();
		if (getEnnemisJoueurs(jIA, joueursLieu).size() > 0) {
			int diff = jIA.getDifficulte();
			switch (diff) {
			case 1:
				if (res < 60)
					return true;
				break;
			case 2:
				if (res < 80)
					return true;
				break;
			case 3:
				if (res < 100)
					return true;
				break;
			default:
			}
		} else if (res < 30)
			return true;
		return false;
	}

	public double getRandomPercentage() {
		return Math.floor(Math.random() * seed);
	}
	
	public static List<Joueur> getEnnemisJoueurs(JoueurVirtuel jIA, List<Joueur> joueursLieu) {
		List<Joueur> res = new ArrayList<>();
		Equipe equipejIA = jIA.getEquipe();
		if (equipejIA == CartePersonnage.Equipe.NEUTRE)
			res = joueursLieu;
		else {
			for (Joueur j : joueursLieu) {
				if (!equipejIA.equals(j.getEquipe()))
					res.add(j);
			}
		}
		return res;
	}
	
	public static List<Joueur> getAmisJoueurs(JoueurVirtuel jIA, List<Joueur> joueursLieu) {
		List<Joueur> res = new ArrayList<>();
		Equipe equipejIA = jIA.getEquipe();
		if (equipejIA == CartePersonnage.Equipe.NEUTRE)
			res = joueursLieu;
		else {
			for (Joueur j : joueursLieu) {
				if (equipejIA.equals(j.getEquipe()))
					res.add(j);
			}
		}
		return res;
	}

	// loup-garou : si attaquee par joueur pas du meme camps 60%? devoilement
	public boolean devoilerIALoupGarou(JoueurVirtuel jIA, Joueur jAttaquant) {
		Equipe equipejIA = jIA.getEquipe();
		double rand = getRandomPercentage();
		if (!equipejIA.equals(jAttaquant.getEquipe())) {
			if (rand < 60)
				return true;
		}
		return false;
	}

	// metamorphe : si recoit carte vision 50%? mentir sans se devoiler
	public boolean mentirIAMetamorphe() {
		if (getRandomPercentage() < 50)
			return true;
		return false;
	}

	// vampire : si attaque joueur et propre vie<10?hp 60%? (plus vie baisse, plus
	// proba augmente) devoilement
	public boolean devoilerIAVampire(JoueurVirtuel jIA, Joueur jAttaquee) {
		Equipe equipejIA = jIA.getEquipe();
		double rand = getRandomPercentage();
		if (!equipejIA.equals(jAttaquee.getEquipe()) && jIA.getStat("HP")<11) {
			if (rand < 940 / 9 - (40 * jIA.getStat("HP")/9))
				return true;
		}
		return false;
	}

	// emi : si pas de shadow sur lieu actuel mais un sur lieu adjacent 60%?
	// devoilement
	public boolean devoilerIAEmi(JoueurVirtuel jIA, CarteLieu cl) {
		List<Joueur> joueursProx = cl.getJoueurs();
		if (getEnnemisJoueurs(jIA, joueursProx).size() > 0)
			return false;
		List<Joueur> joueursAdj = jIA.getJoueursAdjacents();
		if (getEnnemisJoueurs(jIA, joueursAdj).size() > 0)
			return true;
		return false;
	}

	// georges: si vie d'un shadow <=4hp 90%? devoilement avant de commencer le tour
	public boolean devoilerIAGeorges(JoueurVirtuel jIA, List<Joueur> jPlateau) {
		List<Joueur> jEnnemis = getEnnemisJoueurs(jIA, jPlateau);
		boolean devoiler = false;
		double rand = getRandomPercentage();
		for (Joueur j : jEnnemis) {
			if (j.getStat("HP") <= 4)
				devoiler = true;
		}
		if (devoiler && rand < 90)
			return true;
		return false;
	}

	// franklin: si vie d'un shadow <=6hp 90%? devoilement avant de commencer le
	// tour
	public boolean devoilerIAFranklin(JoueurVirtuel jIA, List<Joueur> jPlateau) {
		List<Joueur> jEnnemis = getEnnemisJoueurs(jIA, jPlateau);
		boolean devoiler = false;
		double rand = getRandomPercentage();
		for (Joueur j : jEnnemis) {
			if (j.getStat("HP") <= 6)
				devoiler = true;
		}
		if (devoiler && rand < 90)
			return true;
		return false;
	}

	// allie : si vie<5?hp (plus vie baisse, plus proba augmente) 60%? devoilement
	public boolean devoilerIAAllie(JoueurVirtuel jIA) {
		if (getRandomPercentage() < 110 - 10 * jIA.getStat("HP") && jIA.getStat("HP")<6)
			return true;
		return false;
	}

	// bob : si attaque joueur possedant equipement 70?% devoilement
	public boolean devoilerIABob(JoueurVirtuel jIA, Joueur jAttaquee) {
		if (jAttaquee.getStat(Joueur.PLAYER_NB_EQUIPEMENTS) > 0 && getRandomPercentage() < 70)
			return true;
		return false;
	}

	// charles : si attaque joueur possedant moins de vie que attaque de charles
	// 85?% devoilement
	public boolean devoilerIACharles(JoueurVirtuel jIA, Joueur jAttaquee) {
		if (jAttaquee.getStat("HP") <= jIA.getStat("DAMAGE") && jIA.getStat("HP") >= 2 && getRandomPercentage() <= 85)
			return true;
		return false;
	}

}