package condition;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class ConditionMultipleTest {

	Joueur joueur;
	Plateau plateau;
	
	@BeforeEach
	void init()
	{
		
		List<Joueur> list = new ArrayList<Joueur>();
		joueur = new Joueur("Jack");
		list.add(joueur);
		plateau = new Plateau(list);
		joueur.setPlateau(plateau);
	}
	@Test
	public void conditionMultiple_Vide_RenvoieTrue() throws Exception {
		
		Condition condition = new ConditionMultiple(new ArrayList<Condition>());
		
		assertTrue(condition.isTrue(joueur));	
	}
	
	@Test
	public void conditionMultipleOR_Vide_False() throws Exception {
		
		Condition condition = new ConditionMultipleOR(new ArrayList<Condition>());
		assertFalse(condition.isTrue(joueur));	
	}
	
	@Test
	public void conditionMultiple_AllTrue_True() throws Exception {
		
		plateau.setStat("test", 20);
		List<Condition> list = new ArrayList<Condition>();
		
		for(int i = 0; i <= 20;i++)
		{
			ConditionStatistiques cs = new ConditionStatistiques(true,"test",20,ConditionStatistiques.EQUAL);
			list.add(cs);
		}
		
		Condition condition = new ConditionMultiple(list);
		
		assertTrue(condition.isTrue(joueur));	
	}
	
	@Test
	public void conditionMultiple_OneFalse_False() throws Exception {
		
		plateau.setStat("test", 20);
		List<Condition> list = new ArrayList<Condition>();
		
		for(int i = 0; i <= 20;i++)
		{
			ConditionStatistiques cs = new ConditionStatistiques(true,"test",20,ConditionStatistiques.EQUAL);
			list.add(cs);
		}
		
		// False one 
		ConditionStatistiques cs = new ConditionStatistiques(true,"test",30,ConditionStatistiques.EQUAL);
		list.add(cs);
		
		Condition condition = new ConditionMultiple(list);
		
		assertFalse(condition.isTrue(joueur));	
	}
	
	@Test
	public void conditionMultiple_AllFalse_False() throws Exception {
		
		plateau.setStat("test", 20);
		List<Condition> list = new ArrayList<Condition>();
		
		for(int i = 0; i <= 20;i++)
		{
			ConditionStatistiques cs = new ConditionStatistiques(true,"test",30,ConditionStatistiques.EQUAL);
			list.add(cs);
		}
		
		Condition condition = new ConditionMultiple(list);
		
		assertFalse(condition.isTrue(joueur));	
	}
	
	@Test
	public void conditionMultipleOR_OneFalse_True() throws Exception {
		
		plateau.setStat("test", 20);
		List<Condition> list = new ArrayList<Condition>();
		
		for(int i = 0; i <= 20;i++)
		{
			ConditionStatistiques cs = new ConditionStatistiques(true,"test",20,ConditionStatistiques.EQUAL);
			list.add(cs);
		}
		
		// False one 
		ConditionStatistiques cs = new ConditionStatistiques(true,"test",30,ConditionStatistiques.EQUAL);
		list.add(cs);
		
		Condition condition = new ConditionMultipleOR(list);
		
		assertTrue(condition.isTrue(joueur));	
	}

}
