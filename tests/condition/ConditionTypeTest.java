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

class ConditionTypeTest {

	
	
	@Test
	public void conditionType_RenvoieAppartenanceEquipe() {
		
		
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
	public void conditionClass_ListTypeVide_RenvoieFalse() {
		
		
		List<Joueur.Equipe> equipes  = new ArrayList<Joueur.Equipe>();
	
		ConditionType ct = new ConditionType(equipes);
		Joueur j = new Joueur(null);
		assertFalse(ct.isTrue(j));
		
	}
	
	

}
