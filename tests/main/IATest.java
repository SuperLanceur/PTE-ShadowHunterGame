package main;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.Joueur.Equipe;

public class IATest {
	ControleurIA cIA = new ControleurIA();
	JoueurVirtuel jIA = new JoueurVirtuel("bonhomme");
	List<Joueur> joueurs = new ArrayList<>();
	Joueur j1 = new Joueur("j1");
	Joueur j2 = new Joueur("j2");

	@Test
	public void choixAttaquerTest() {
		//setup
		jIA.setEquipe(Equipe.SHADOW);
		j1.setEquipe(Equipe.HUNTER);
		j2.setEquipe(Equipe.SHADOW);
		jIA.setDifficulte(1);
		cIA.setSeed(24);
		
		//test 1 : il y a un ennemi sur le lieu, on chosit de attaquer
		joueurs.add(j1);
		joueurs.add(j2);
		assertTrue(cIA.choixSiAttaquer(jIA, joueurs));
		
		//test 2 : il n'y a pas d'ennemi sur le lieu, on chosit de attaquer avec 10%
		joueurs.clear();
		joueurs.add(j2);
		cIA.setSeed(9);
		assertTrue(cIA.choixSiAttaquer(jIA, joueurs));
	}

	@Test
	public void choixPouvoirLieuTest() {
		cIA.setSeed(79);
		assertTrue(cIA.choixUtiliserPouvoirLieu());
	}
	
	@Test
	public void devoilerMetamorpheTest() {
		cIA.setSeed(50);
		assertTrue(cIA.mentirIAMetamorphe());

	}
	
	@Test
	public void devoilerLoupGarouTest() {
		//setup
		cIA.setSeed(59);
		jIA.setEquipe(Equipe.SHADOW);
		j1.setEquipe(Equipe.HUNTER);
		j2.setEquipe(Equipe.SHADOW);
		
		//test 1 : joueur ami, on ne se devoile pas
		assertFalse(cIA.devoilerIALoupGarou(jIA, j2));
		
		//test 2 : joueur ennemi, on se devoile
		assertTrue(cIA.devoilerIALoupGarou(jIA, j1));

	}
	
	@Test
	public void devoilerVampireTest() {
		//setup
		cIA.setSeed(59);
		jIA.setEquipe(Equipe.SHADOW);
		j1.setEquipe(Equipe.HUNTER);
		j2.setEquipe(Equipe.SHADOW);
		
		//test 1 : joueur ami, on ne se devoile pas
		jIA.setStat("HP", 10);
		assertFalse(cIA.devoilerIAVampire(jIA, j2));
		
		//test 2 : joueur ennemi et peu de HP, on se devoile
		assertTrue(cIA.devoilerIAVampire(jIA, j1));
		
		//test 3 : joueur ennemi et beaucoup de HP, on se devoile pas
		jIA.setStat("HP", 12);
		assertFalse(cIA.devoilerIAVampire(jIA, j1));

	}
	
	@Test
	public void devoilerGeorgesTest() {
		//setup
		cIA.setSeed(89);
		jIA.setEquipe(Equipe.HUNTER);
		j1.setEquipe(Equipe.HUNTER);
		j2.setEquipe(Equipe.SHADOW);
		joueurs.add(j1);
		joueurs.add(j2);
		
		//test 1 : ennemi avec moins de 4 hp, on se devoile 
		j2.setStat("HP", 4);
		assertTrue(cIA.devoilerIAGeorges(jIA, joueurs));
		
		//test 2 : pas d'ennemi avec moins de 4 hp, on se devoile pas
		j2.setStat("HP", 6);
		assertFalse(cIA.devoilerIAGeorges(jIA, joueurs));
		
	}
	
	@Test
	public void devoilerFranklinTest() {
		//setup
		cIA.setSeed(89);
		jIA.setEquipe(Equipe.HUNTER);
		j1.setEquipe(Equipe.HUNTER);
		j2.setEquipe(Equipe.SHADOW);
		joueurs.add(j1);
		joueurs.add(j2);
		
		//test 1 : ennemi avec moins de 6 hp, on se devoile 
		j2.setStat("HP", 6);
		assertTrue(cIA.devoilerIAFranklin(jIA, joueurs));
		
		//test 2 : pas d'ennemi avec moins de 6 hp, on se devoile pas
		j2.setStat("HP", 8);
		assertFalse(cIA.devoilerIAFranklin(jIA, joueurs));
		
	}
	
	@Test
	public void devoilerAllieTest() {
		//setup
		cIA.setSeed(59);
		
		//test 1 : pas beaucoup de hp, on se devoile
		jIA.setStat("HP", 5);
		assertTrue(cIA.devoilerIAAllie(jIA));

		//test 2 : beaucoup de hp, on se devoile pas
		jIA.setStat("HP", 6);
		assertFalse(cIA.devoilerIAAllie(jIA));
		
	}
	
	@Test
	public void devoilerCharlesTest() {
		//setup
		cIA.setSeed(84);
		j2.setStat("HP", 4);

		//test 1 : ennemi affaibli, on se devoile
		jIA.setStat("HP", 10);
		jIA.setStat("DAMAGE", 4);
		assertTrue(cIA.devoilerIACharles(jIA, j2));
		
		//test 2 : ennemi affaibli mais pas assez de dmg pour le tuer, on se devoile pas
		jIA.setStat("DAMAGE", 3);
		assertFalse(cIA.devoilerIACharles(jIA, j2));

		//test 3 : charles n'a pas beaucoup de hp, on se devoile pas
		jIA.setStat("DAMAGE", 4);
		jIA.setStat("HP", 1);
		assertFalse(cIA.devoilerIACharles(jIA, j2));
	}
	
	//TODO : devoilement emi et devoilement bob

}
