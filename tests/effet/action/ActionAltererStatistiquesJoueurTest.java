package effet.action;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class ActionAltererStatistiquesJoueurTest {

	Joueur j1;
	Joueur j2;
	Plateau p;
	Random rand;
	
	@BeforeEach
	void init()
	{
		rand = new Random();
		List<Joueur> joueurs = new ArrayList<Joueur>();
		j1 = new Joueur("Michel");
		j2 = new Joueur("Gérard");
		
		joueurs.add(j1);
		joueurs.add(j2);
		
		p = new Plateau(joueurs);
		
		j1.setPlateau(p);
		j2.setPlateau(p);
		
		
	}
	
	@Test
	void affecte_StatHasChanged() {
		
		int entier = rand.nextInt();
		ActionAltererStatistiquesJoueur aasj = new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, entier, false);
		aasj.affecte(j1, j2);
		
		assertEquals(j2.getStat(Joueur.PLAYER_HP),entier);	
	}
	
	@Test
	void affecte_StatsAddedUp() {
		
		int entier = rand.nextInt();
		
		int pvBaseJoueur = j2.getStat(Joueur.PLAYER_HP);
		ActionAltererStatistiquesJoueur aasj = new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, entier, true);
		aasj.affecte(j1, j2);
		
		assertEquals(j2.getStat(Joueur.PLAYER_HP),pvBaseJoueur+entier);	
	}

}
