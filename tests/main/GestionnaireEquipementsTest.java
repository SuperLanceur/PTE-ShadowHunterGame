package main;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carte.EquipementStat;
import condition.Condition;
import effet.EffetSelf;
import effet.action.ActionAltererStatistiquesJoueur;
import personnage.Allie;

class GestionnaireEquipementsTest {

	Joueur j1;
	Joueur j2;
	Plateau p;
	Random rand;
	Allie a1;
	Allie a2;
	
	@BeforeEach
	void init()
	{
		rand = new Random();
		List<Joueur> joueurs = new ArrayList<Joueur>();
		j1 = new Joueur("Michel");
		j2 = new Joueur("Antoine");
		
		joueurs.add(j1);
		joueurs.add(j2);

		p = new Plateau(joueurs);
		
		a1 = new Allie(j1);
		a2 = new Allie(j2);
		j1.setCartePersonnage(a1);
		j2.setCartePersonnage(a2);
		
	
	}
	
	@Test
	void ajouterEquipement_NbEquipements() {
		
		int nbEffets = 20;
		
		for(int i = 0; i < 20; i++) {
			
			EquipementStat es = new EquipementStat("AddDamage", "desc");
			es.setEffet(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 2, true)));
			es.setCondition(new Condition());
			j1.ajouterEquipement(es);
			
		}
		
		assertEquals(nbEffets, j1.getStat(Joueur.PLAYER_NB_EQUIPEMENTS));
	}
	
	
	@Test
	void ajouterEquipement_StackingStats() {
		
		int nbEffets = 20;
		int valeurEffet = 3;
		
		for(int i = 0; i < 20; i++) {
			
			EquipementStat es = new EquipementStat("AddDamage", "desc");
			es.setEffet(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, valeurEffet, true)));
			es.setCondition(new Condition());
			j1.ajouterEquipement(es);
		}
		
		assertEquals(nbEffets*valeurEffet, j1.getStat(Joueur.PLAYER_DAMAGE));
	}
	
	@Test
	void ajouterEquipement_RetirerEffet() {
		
		int valeurEffet = 3;
		
		EquipementStat es = new EquipementStat("AddDamage", "desc");
		es.setEffet(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, valeurEffet, true)));
		es.setCondition(new Condition());
		j1.ajouterEquipement(es);
		
		assertEquals(valeurEffet, j1.getStat(Joueur.PLAYER_DAMAGE));
		
		j1.retirerEquipement(es);
		
		assertEquals(0, j1.getStat(Joueur.PLAYER_DAMAGE));
	}
	
}
