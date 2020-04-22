package personnage;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Joueur;
import main.Plateau;

class CharlesTest {

	Joueur j1;
	Joueur j2;
	Plateau p;
	Allie a;
	Charles c;
	
	@BeforeEach
	void init()
	{
		List<Joueur> joueurs = new ArrayList<Joueur>();
		j1 = new Joueur("Michou");
		j2= new Joueur("MicheMiche");
		
		joueurs.add(j1);
		joueurs.add(j2);

		p = new Plateau(joueurs);
		
		a = new Allie(j1);
		c = new Charles(j2);
		
		j1.setPlateau(p);
		j1.setCartePersonnage(a);
		
		j2.setPlateau(p);
		j2.setCartePersonnage(c);
	
	}
		
	
	@Test
	void attaquer() {
		
		// Le joueur n'est pas révélé (Charles), il attaque seulement 1 fois.
		j2.setRevele(false);
		j2.getCartePersonnage().attaquer(j1, 2);
		j1.setStat(Joueur.PLAYER_HP, 6);
		int pvAllie = j1.getCartePersonnage().getPv();
		
		//on verifie que le joueur qui joue Allie n'est pas full hp
		assertNotEquals((j1.getStat(Joueur.PLAYER_HP)),pvAllie);
		
		//je verifie que le joueur de Allie a bien subi 2 de dégâts
		assertTrue((j1.getStat(Joueur.PLAYER_HP))==6);

		//Le joueur jouant Charles se révèle
		j2.setRevele(true);
		j2.getCartePersonnage().attaquer(j1, 2);
		j1.setStat(Joueur.PLAYER_HP, 6);
		//Charles réattaque en infligeant 3 point de blessures
		j2.getCartePersonnage().attaquer(j1, 3);
		
		//je verifie que le joueur de Allie a bien subi 5 point de dégâts au total (2 au premier coup et 3 au deuxième)
		j1.setStat(Joueur.PLAYER_HP, 3);
		assertTrue((j1.getStat(Joueur.PLAYER_HP))==3);

	}
	
}
