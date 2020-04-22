package effet.action;
 
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;
import personnage.Allie;

class ActionAttaquerTest {

	Joueur j1;
	Joueur j2;
	Plateau p;
	
	@BeforeEach
	void init()
	{
		List<Joueur> joueurs = new ArrayList<Joueur>();
		j1 = new Joueur("Michel");
		j2 = new Joueur("Gérard");
		
		Allie allie1 = new Allie(j1);
		Allie allie2 = new Allie(j2);
		
		joueurs.add(j1);
		joueurs.add(j2);
		
		p = new Plateau(joueurs);
		
		j1.setPlateau(p);
		j2.setPlateau(p);
	
	}
	
	/*
	 * L'attaque du plateau se base sur des tirages aléatoires de dés.
	 * La réussite moyenne d'une attaque est d'environ 80 %
	 * En autorisant une erreur d'environ 5 %
	 * 
	 * On vérifie que la différence du nombre d'attaques réussie avec la moyenne 
	 * des attaques réussie est bien inférieure à 5 %.
	 */
	@Test
	void attaquer_BaissePV() {
	
		int error = 5;
		ActionAttaquer aa = new ActionAttaquer();
		
		int pvBaseJ2 = 100;
		
		for(int j = 0; j< 100; j++) {
		
			int countNb = 0;
			
			for(int i = 0; i < 2000; i++)
			{
				j2.setStat(Joueur.PLAYER_HP, pvBaseJ2);
				aa.affecte(j1, j2);
				
				if(j2.getStat(Joueur.PLAYER_HP) < pvBaseJ2) countNb++;
			}
			
			countNb /= 20;
			assertTrue(Math.abs(countNb-80) <= error);
			}
	}
}
