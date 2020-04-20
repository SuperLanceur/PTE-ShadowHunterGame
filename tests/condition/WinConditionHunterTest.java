package condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class WinConditionHunterTest {

	Plateau plateau;
	Joueur joueur;
	
	@BeforeEach
	void init() {
		List<Joueur> list = new ArrayList<Joueur>();
		joueur = new Joueur("Jack");
		list.add(joueur);
		plateau = new Plateau(list);
		joueur.setPlateau(plateau);
	}
	
	@Test
	void isTrue_AllShadowsAreDead_True() {
	
		WinConditionHunter wch = new WinConditionHunter();
		plateau.setStat(Plateau.NB_SHADOWS, 2);
		plateau.setStat(Plateau.NB_MORTS_SHADOW, 2);
	
		assertTrue(wch.isTrue(joueur));
	}
	
	@Test
	void isTrue_NotAllShadowsAreDead_False() {
	
		WinConditionHunter wch = new WinConditionHunter();
		plateau.setStat(Plateau.NB_SHADOWS, 20);
		plateau.setStat(Plateau.NB_MORTS_SHADOW, 8);
	
		assertFalse(wch.isTrue(joueur));
	}

}
