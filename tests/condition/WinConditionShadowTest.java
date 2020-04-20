package condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class WinConditionShadowTest {

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
	void isTrue_AllHuntersAreDead_LessThan3NeutralsAreDead_True(){
	
		WinConditionShadow wch = new WinConditionShadow();
		plateau.setStat(Plateau.NB_HUNTERS, 2);
		plateau.setStat(Plateau.NB_MORTS_HUNTER, 2);
		
		plateau.setStat(Plateau.NB_MORTS_NEUTRAL, 2);
	
		assertTrue(wch.isTrue(joueur));
	}

	@Test
	void isTrue_AllHuntersAreDead_MoreThan3NeutralsAreDead_True(){
	
		WinConditionShadow wch = new WinConditionShadow();
		plateau.setStat(Plateau.NB_HUNTERS, 2);
		plateau.setStat(Plateau.NB_MORTS_HUNTER, 2);
		
		plateau.setStat(Plateau.NB_MORTS_NEUTRAL, 4);
	
		assertTrue(wch.isTrue(joueur));
	}
	
	@Test
	void isTrue_NotAllHuntersAreDead_MoreThan3NeutralsAreDead_True(){
	
		WinConditionShadow wch = new WinConditionShadow();
		plateau.setStat(Plateau.NB_HUNTERS, 20);
		plateau.setStat(Plateau.NB_MORTS_HUNTER, 8);
		
		plateau.setStat(Plateau.NB_MORTS_NEUTRAL, 4);
	
		assertTrue(wch.isTrue(joueur));
	}
	
	
	@Test
	void isTrue_NotAllHuntersAreDead_LessThan3NeutralsAreDead_False(){
	
		WinConditionShadow wch = new WinConditionShadow();
		plateau.setStat(Plateau.NB_HUNTERS, 20);
		plateau.setStat(Plateau.NB_MORTS_HUNTER, 8);
	
		plateau.setStat(Plateau.NB_MORTS_NEUTRAL, 2);
		
		assertFalse(wch.isTrue(joueur));
	}

}
