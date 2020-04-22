package personnage;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class VampireTest {

	Joueur j1;
	Joueur j2;
	Plateau p;
	Random rand;
	Vampire v;
	Allie a;
	
	@BeforeEach
	void init()
	{
		rand = new Random();
		List<Joueur> joueurs = new ArrayList<Joueur>();
		j1 = new Joueur("Michel");
		j2 = new Joueur("Saad");
		
		joueurs.add(j1);
		joueurs.add(j2);

		p = new Plateau(joueurs);
		v = new Vampire(j1);
		a = new Allie(j2);
	}
	
	
	
	@Test
	void attaquer_Vampirisme() {
		
		int pvVampireBase = 0;
		int pvAllieBase = a.getPv();
		
		int countHP = 0;
		
		for(int j = 0; j < 100; j++) {
			
			countHP = 0;
			
			for(int i = 0; i < 2000; i++) {
	
				// Le joueur n'est pas révélé
				j1.setRevele(false);
				j1.setStat(Joueur.PLAYER_HP, pvVampireBase);
				j2.setStat(Joueur.PLAYER_HP, pvAllieBase);
				
				p.attaquer(j1, j2);
				
				// Vampire n'a pas récupéré de pv's lors de son attaque
				assertTrue(j1.getStat(Joueur.PLAYER_HP) == 0);
				
				
				// Joueur se révéle
				j1.reveal();
				j2.setStat(Joueur.PLAYER_HP, pvAllieBase);
				p.attaquer(j1, j2);
				
				// Il récupère des pv's si la blessure est supérieure à 0
				// On compte le nombre de fois où il récupère des pv's
				if(j2.getStat(Joueur.PLAYER_HP) < pvAllieBase && j1.getStat(Joueur.PLAYER_HP) > 0) {
					countHP++;
				}
			}
			
			// On boost le coverage
			v.utiliser();
			
			// On ramène en %
			countHP /= 20;
			
			// En moyenne une attaque réussie 80 % du temps, avec une marge d'erreur de 5 %
			assertTrue(Math.abs(80-countHP) < 5);
	}}
	
	@Test
	void victoire() {
		
		j1.setStat(Joueur.PLAYER_HP, 0);
		p.setStat( Plateau.NB_MORTS_NEUTRAL, 5);
		assertTrue(v.victoire());
		
	}
}
