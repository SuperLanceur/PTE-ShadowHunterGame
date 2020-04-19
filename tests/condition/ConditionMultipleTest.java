package condition;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.Joueur;

class ConditionMultipleTest {

	@Test
	public void conditionMultipleVideRenvoieTrue() {
		
		Condition condition = new ConditionMultiple();
		Joueur j = new Joueur(null);
		
		assertTrue(condition.isTrue(j));	
	}
	
	@Test
	public void conditionMultipleORVideRenvoieFalse() {
		
		Condition condition = new ConditionMultipleOR();
		Joueur j = new Joueur(null);
		
		assertFalse(condition.isTrue(j));	
	}

}
