package condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.Joueur;
import personnage.Allie;
import personnage.CartePersonnage;
import personnage.Vampire;

class ConditionTypeTest {

	
	
	@Test
	public void isTrue_RenvoieAppartenanceEquipe() {
		
		
		List<CartePersonnage.Equipe> equipes  = new ArrayList<CartePersonnage.Equipe>();
		equipes.add(CartePersonnage.Equipe.HUNTER);
		equipes.add(CartePersonnage.Equipe.NEUTRE);
		ConditionType ct = new ConditionType(equipes);
		
		Joueur j = new Joueur(null);
		
		j.setCartePersonnage(new Allie(j));
	
		
	
		assertTrue(ct.isTrue(j));
		
		j.setCartePersonnage(new Vampire(j));
	
		assertFalse(ct.isTrue(j));
		
	}
	
	@Test
	public void isTrue_ListTypeVide_False() {
		
		
		List<CartePersonnage.Equipe> equipes  = new ArrayList<CartePersonnage.Equipe>();
	
		ConditionType ct = new ConditionType(equipes);
		Joueur j = new Joueur(null);
		j.setCartePersonnage(new Allie(j));
		assertFalse(ct.isTrue(j));
		
	}
	
	

}
