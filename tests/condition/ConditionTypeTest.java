package condition;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.Joueur;

class ConditionTypeTest {

	
	
	@Test
	public void isTrue_RenvoieAppartenanceEquipe() {
		
		
		List<Joueur.Equipe> equipes  = new ArrayList<Joueur.Equipe>();
		equipes.add(Joueur.Equipe.HUNTER);
		equipes.add(Joueur.Equipe.NEUTRE);
		ConditionType ct = new ConditionType(equipes);
		
		Joueur j = new Joueur(null);
		j.setEquipe(Joueur.Equipe.NEUTRE);
		
	
		assertTrue(ct.isTrue(j));
		
		j.setEquipe(Joueur.Equipe.SHADOW);
		assertFalse(ct.isTrue(j));
		
	}
	
	@Test
	public void isTrue_ListTypeVide_False() {
		
		
		List<Joueur.Equipe> equipes  = new ArrayList<Joueur.Equipe>();
	
		ConditionType ct = new ConditionType(equipes);
		Joueur j = new Joueur(null);
		assertFalse(ct.isTrue(j));
		
	}
	
	

}
