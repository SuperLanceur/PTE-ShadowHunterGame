package main;
import java.util.ArrayList;
import java.util.List;

import main.Joueur.Equipe;

public class ControleurIA {

	public static boolean choixUtiliserPouvoirLieu() {
		double res = getRandomPercentage();
		if (res < 80)
			return true;
		return false;
	}

	// precondition 1 : la liste joueursLieu ne contiendra pas jIA lui-meme
	// precondition 2 : on n'appellera pas cette methode si jIA est seul sur le lieu
	public static boolean choixSiAttaquer(JoueurVirtuel jIA, List<Joueur> joueursLieu) {
		double res = getRandomPercentage();
		if (getEnnemisJoueurs(jIA, joueursLieu).size() > 0) {
			int diff = jIA.getDifficulte();
			switch (diff) {
			case 1:
				if (res < 25)
					return true;
				break;
			case 2:
				if (res < 50)
					return true;
				break;
			case 3:
				if (res < 75)
					return true;
				break;
			default:
			}
		} else if (res < 10)
			return true;
		return false;
	}

	public static double getRandomPercentage() {
		return Math.floor(Math.random() * 100);
	}

	public static List<Joueur> getEnnemisJoueurs(JoueurVirtuel jIA, List<Joueur> joueursLieu) {
		List<Joueur> res = new ArrayList<>();
		Equipe equipejIA = jIA.getEquipe();
		if (equipejIA == Joueur.Equipe.NEUTRE)
			res = joueursLieu;
		else {
			for (Joueur j : joueursLieu) {
				if (!equipejIA.equals(j.getEquipe()))
					res.add(j);
			}
		}
		return res;
	}

	// loup-garou : si attaquee par joueur pas du meme camps 60%? devoilement
	public static boolean devoilerIALoupGarou(JoueurVirtuel jIA, Joueur jAttaquant) {
		Equipe equipejIA = jIA.getEquipe();
		double rand = getRandomPercentage();
		if (!equipejIA.equals(jAttaquant.getEquipe())) {
			if (rand < 60)
				return true;
		}
		return false;
	}

	// metamorphe : si re�oit carte vision 50%? mentir sans se devoiler
	public static boolean mentirIAMetamorphe(JoueurVirtuel jIA) {
		if (getRandomPercentage() < 50)
			return true;
		return false;
	}

	// vampire : si attaque joueur et propre vie<10?hp 60%? (plus vie baisse, plus
	// proba augmente) devoilement
	public static boolean devoilerIAVampire(JoueurVirtuel jIA, Joueur jAttaquee) {
		Equipe equipejIA = jIA.getEquipe();
		double rand = getRandomPercentage();
		if (!equipejIA.equals(jAttaquee.getEquipe())) {
			if (rand < 940 / 9 - (40 * jIA.getStat("HP")))
				return true;
		}
		return false;
	}

	// emi : si pas de shadow sur lieu actuel mais un sur lieu adjacent 60%?
	// devoilement
	public static boolean devoilerIAEmi(JoueurVirtuel jIA, CarteLieu cl) {
		List<Joueur> joueursProx = cl.getJoueurs();
		if (getEnnemisJoueurs(jIA, joueursProx).size() > 0)
			return false;
		List<Joueur> joueursAdj = cl.getJoueursAdjacents();
		if (getEnnemisJoueurs(jIA, joueursAdj).size() > 0)
			return true;
		return false;
	}

	// georges: si vie d'un shadow <=4hp 90%? devoilement avant de commencer le tour
	public static boolean devoilerIAGeorges(JoueurVirtuel jIA, List<Joueur> jPlateau) {
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
	public static boolean devoilerIAFranklin(JoueurVirtuel jIA, List<Joueur> jPlateau) {
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
	public static boolean devoilerIAAllie(JoueurVirtuel jIA) {
		if (getRandomPercentage() < 110 - 10 * jIA.getStat("HP"))
			return true;
		return false;
	}

	// bob : si attaque joueur possedant equipement 70?% devoilement
	public static boolean devoilerIABob(JoueurVirtuel jIA, Joueur jAttaquee) {
		if (jAttaquee.getNbEquipments() > 0 && getRandomPercentage() < 70)
			return true;
		return false;
	}

	// charles : si attaque joueur possedant moins de vie que attaque de charles
	// 85?% devoilement
	public static boolean devoilerIACharles(JoueurVirtuel jIA, Joueur jAttaquee) {
		if (jAttaquee.getStat("HP") <= jIA.getStat("DAMAGE") && jIA.getStat("HP") >= 2 && getRandomPercentage() <= 85)
			return true;
		return false;
	}

}