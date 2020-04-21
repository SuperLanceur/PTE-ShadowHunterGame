package condition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class ConditionStatistiquesTest {

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
	void isTrue_ComparisonOperatorsBehaveCorrectly() {
		
		Random rand = new Random();
		
		int randInt1 = rand.nextInt();
		int randInt3 = rand.nextInt();
		plateau.setStat("test", randInt1);
		joueur.setStat("test", randInt3);
		

		int randInt2 = rand.nextInt(); 
		
		//Conditions sur le Plateau
		ConditionStatistiques cs = new ConditionStatistiques(true,"test",randInt2,ConditionStatistiques.EQUAL);
		assertEquals(cs.isTrue(joueur),randInt1 == randInt2);
		
		cs = new ConditionStatistiques(true,"test",randInt2,ConditionStatistiques.MORE);
		assertEquals(cs.isTrue(joueur),randInt1 >= randInt2);
		
		cs = new ConditionStatistiques(true,"test",randInt2,ConditionStatistiques.LESS);
		assertEquals(cs.isTrue(joueur),randInt1 <= randInt2);
		
		
		//Conditions sur Joueur
		cs = new ConditionStatistiques(false,"test",randInt2,ConditionStatistiques.MORE);
		assertEquals(cs.isTrue(joueur),randInt3 >= randInt2);
		
		cs = new ConditionStatistiques(false,"test",randInt2,ConditionStatistiques.MORE);
		assertEquals(cs.isTrue(joueur),randInt3 >= randInt2);
		
		cs = new ConditionStatistiques(false,"test",randInt2,ConditionStatistiques.LESS);
		assertEquals(cs.isTrue(joueur),randInt3 <= randInt2);
		
	}
	
	@Test
	void isTrue_InvalidEqualMoreLessParameter_False() {
		
		plateau.setStat("test", 10);
		joueur.setStat("test", 20);
		ConditionStatistiques cs = new ConditionStatistiques(true,"test",0,
		//Valeur censée être comprise entre 0 et 2
		20);
		assertFalse(cs.isTrue(joueur));
	
		cs = new ConditionStatistiques(true,"test",0,
		//Valeur censée être comprise entre 0 et 2
		-1);
		
		assertFalse(cs.isTrue(joueur));
	}
	

}
