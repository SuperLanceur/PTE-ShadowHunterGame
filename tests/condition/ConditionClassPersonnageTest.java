package condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.Joueur;
import personnage.Allie;
import personnage.Bob;
import personnage.CartePersonnage;
import personnage.Daniel;

class ConditionClassPersonnageTest {

	@Test
	public void conditionClass_RenvoieAppartenancePersonnage() throws Exception {
		
		
		List<Class<? extends CartePersonnage>> classes = new ArrayList<Class<? extends CartePersonnage>>();
		classes.add(Allie.class);
		classes.add(Daniel.class);
		ConditionClassPersonnage cc = new ConditionClassPersonnage(classes);
		
		Joueur j = new Joueur(null);
		CartePersonnage cp1 = new Allie(j);
		
		
		// Le personnage fait partie des classes.
		j.setCartePersonnage(cp1);
		assertTrue(cc.isTrue(j));
		
		
		CartePersonnage cp2 = new Bob(j);
		// Le personnage ne fait pas partie des classes
		j.setCartePersonnage(cp2);
		assertFalse(cc.isTrue(j));
		
	}
	
	@Test
	public void conditionClass_ListClassVide_RenvoieFalse() throws Exception {
		
		
		List<Class<? extends CartePersonnage>> classes = new ArrayList<Class<? extends CartePersonnage>>();
	
		ConditionClassPersonnage cc = new ConditionClassPersonnage(classes);
		Joueur j = new Joueur(null);
		CartePersonnage cp1 = new Allie(j);
		j.setCartePersonnage(cp1);
		assertFalse(cc.isTrue(j));
		
	}
	
	

}
