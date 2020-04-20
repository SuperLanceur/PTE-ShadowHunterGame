package condition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import main.Joueur;
import main.Plateau;

class ConditionStatistiquesTest {

	Plateau plateau;
	Joueur joueur;
	
	@Before
	void init() {
		List<Joueur> list = new ArrayList<Joueur>();
		joueur = new Joueur("Jack");
		list.add(joueur);
		plateau = new Plateau(list);
		joueur.setPlateau(plateau);
	}
	
	//TODO
}
