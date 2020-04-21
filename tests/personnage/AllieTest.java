package personnage;

import static org.junit.Assert.assertEquals;

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
		
		j1.setStat("HP", 0);
		j1.getCartePersonnage().utiliser();
		
		int pvAllie = j1.getCartePersonnage().getPv();
		
		assertEquals(pvAllie,j1.getStat("HP"));
		
		j1.setStat("HP", 0);
		j1.getCartePersonnage().utiliser();
		
		// Le soin n'a fonctionné qu'une seule fois
		assertEquals(0,j1.getStat("HP"));
		
	}
	
}
