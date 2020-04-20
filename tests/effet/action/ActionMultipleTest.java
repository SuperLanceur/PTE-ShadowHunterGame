package effet.action;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class ActionMultipleTest {

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
	void affecte_StatsAddedUp() {
		
		int entier = 2;
		int pvBaseJoueur = j2.getStat(Joueur.PLAYER_HP);
		int nbEffets = 15;
		
		List<Action> actions = new ArrayList<Action>();
		
		for(int i = 0; i<15; i++)
		{
			ActionAltererStatistiquesJoueur aasj = new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, entier, true);
			actions.add(aasj);
		}
		
		ActionMultiple am = new ActionMultiple(actions);
		am.affecte(j1, j2);
		
		assertEquals(j2.getStat(Joueur.PLAYER_HP),pvBaseJoueur+entier*nbEffets);	
	}

}
