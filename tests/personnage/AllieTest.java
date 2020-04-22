package personnage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class AllieTest {

	Joueur j1;
	Plateau p;
	Random rand;
	Allie a;
	
	@BeforeEach
	void init()
	{
		rand = new Random();
		List<Joueur> joueurs = new ArrayList<Joueur>();
		j1 = new Joueur("Michel");
		
		joueurs.add(j1);

		p = new Plateau(joueurs);
		
		a = new Allie(j1);
		j1.setPlateau(p);
		j1.setCartePersonnage(a);
	
	}
	
	@Test
	void utiliser_SoinTotal() {
		
		j1.setStat(Joueur.PLAYER_HP, 0);
		j1.getCartePersonnage().utiliser();
		
		int pvAllie = j1.getCartePersonnage().getPv();
		
		// Le joueur n'est pas révélé, le soin n'a pas eu lieu.
		assertEquals(j1.getStat(Joueur.PLAYER_HP),0);
		
		j1.setRevele(true);
		j1.getCartePersonnage().utiliser();
		
		// Le soin a fonctionné la première fois, il est désormais "utilisé".
		assertEquals(j1.getStat(Joueur.PLAYER_HP),pvAllie);
		
		
		j1.setStat(Joueur.PLAYER_HP, 0);
		j1.getCartePersonnage().utiliser();
		
		// Le soin a déjà été utilisé
		assertEquals(0,j1.getStat(Joueur.PLAYER_HP));
		
	}
	
	@Test
	void victoire() {
		
		j1.setStat(Joueur.PLAYER_HP, 0);
		p.setStat(Plateau.PARTIE_FINIE, 1);
		assertTrue(a.victoire());
		
	}
	
}
