package main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import carte.CarteLieu;
import carte.CarteLieuType;
import carte.CartePiochable;
import effet.EffetChoisirCible;
import effet.EffetChoisirEffet;
import effet.EffetSelf;
import effet.action.ActionAltererStatistiquesJoueur;
import effet.action.ActionVoler;
import personnage.Allie;
import personnage.CartePersonnage;
import personnage.Franklin;
import personnage.Vampire;

class PlateauTest {

	Plateau p;
	Joueur j1;
	Joueur j2;
	
	@BeforeEach
	void init() {
		
		//Pioche<TypeVision> piocheVision = new Pioche<TypeVision>(new ArrayList<>());
		
		
		
		//CarteLieu lieu1 = new CarteLieuType<TypeVision>("Antre de l'Ermite","desc",new Point(2,3),piocheVision);
		
		j1 = new Joueur("Mohamed");
		j2 = new Joueur("Pierrot");
		
		Allie allie1 = new Allie(j1);
		Allie allie2 = new Allie(j2);
		
		j1.setCartePersonnage(allie1);
		j2.setCartePersonnage(allie2);
		
		List<Joueur> joueurs = new ArrayList<Joueur>();
		joueurs.add(j2);
		joueurs.add(j1);
		
		p = new Plateau(joueurs);
	
		List<CartePiochable> list1 = new ArrayList<>();
		List<CartePiochable> list2 = new ArrayList<>();
		
		for(int i = 0; i < 60; i++) {
			
			CartePiochable carte1 = new CartePiochable(CartePiochable.Type.LUMIERE,"Eau bénite", "Soin 2");
			carte1.setEffet(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 2, true)));
			list1.add(carte1);
			
			CartePiochable carte2 = new CartePiochable(CartePiochable.Type.TENEBRE,"Eau maudite", "Damage 2");
			carte2.setEffet(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)));
			list2.add(carte2);
		}
	
		
		Pioche piocheLumiere = new Pioche(CartePiochable.Type.LUMIERE,list1);
		Pioche piocheTenebre = new Pioche(CartePiochable.Type.TENEBRE,list2);
		
		
		CarteLieu lieu1 = new CarteLieuType(CartePiochable.Type.TENEBRE,"Antre de l'Ermite","desc",new Point(2,3),piocheTenebre);
		CarteLieu lieu2 = new CarteLieuType(CartePiochable.Type.TENEBRE,"Cimetière","desc",new Point(-1,8),piocheTenebre);
		CarteLieu lieu3 = new CarteLieu("Forêt hantée","desc",new Point(-1,9));
		lieu3.setEffet(new EffetChoisirEffet(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-2,true)),
											new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,1,true))));
		CarteLieu lieu4 = new CarteLieuType(CartePiochable.Type.LUMIERE,"Monastère","desc",new Point(-1,6),piocheLumiere);
		
		CarteLieu lieu5 = new CarteLieuType(CartePiochable.Type.LUMIERE,"Sanctuaire Ancien","desc",new Point(4,5),piocheTenebre);
		CarteLieu lieu6 = new CarteLieu("Sanctuaire Ancien","desc",new Point(-1,9));
		lieu6.setEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER)));
	
		List<CarteLieu> cls = new ArrayList<CarteLieu>();
		cls.add(lieu6);
		cls.add(lieu5);
		cls.add(lieu4);
		cls.add(lieu3);
		cls.add(lieu2);
		cls.add(lieu1);
		
		p.setLieux(cls);
		
	}
	
	@Test
	void deplacer_lieuDepartDifferentLieuArrive() {
		p.deplacer(j1);
		CarteLieu lieuDepart = j1.getCarteLieu();
		
		p.deplacer(j1);
		
		assertNotEquals(lieuDepart, j1.getCarteLieu());
	}
	
	/*
	 * L'attaque du plateau se base sur des tirages aléatoires de dés.
	 * La réussite moyenne d'une attaque est d'environ 80 %
	 * En autorisant une erreur d'environ 2 %
	 * 
	 * ,on vérifie que la différence du nombre d'attaques réussie avec la moyenne 
	 * des attaques réussie est bien inférieure à 2 %.
	 */
	@Test
	void attaquer_attaqueBienEnvoyee() {
		
		int error = 2;
		int pvBaseJ2 = 100;
		
		
		for(int j = 0; j< 1000; j++) {
		
			int countNb = 0;
			
			for(int i = 0; i < 10000; i++)
			{
				j2.setStat(Joueur.PLAYER_HP, pvBaseJ2);
				p.attaquer(j1, j2);
				if(j2.getStat(Joueur.PLAYER_HP) < 100) countNb++;
			}
					
			countNb /= 100;
			assertTrue(Math.abs(countNb-80) <= error);
			}
	}
	
	@Test
	void initCartePersonnage() throws Exception {
		
		
		Joueur j;
		
		for(int k = 4 ; k < 9 ;k++) {
			
		
			int nbJoueurs = k;
			List<Joueur> joueurs = new ArrayList<Joueur>();
			List<CartePersonnage> personnages = new ArrayList<CartePersonnage>(5);
			
			int nbShadowHunters = 0;
			int nbNeutres = 0;
			
			switch(nbJoueurs) {
			
			case 4:
				nbShadowHunters = 2;
				nbNeutres = 0;
				break;
			case 5:
				nbShadowHunters = 2;
				nbNeutres = 1;
				break;
			case 6:
				nbShadowHunters = 2;
				nbNeutres = 2;
				break;
			case 7:
				nbShadowHunters = 2;
				nbNeutres = 3;
				break;
			case 8:
				nbShadowHunters = 3;
				nbNeutres = 2;
				break;}
			
			
			
			
			for (int i = 0; i < nbJoueurs; i++) {
				j = new Joueur("Michel");
				joueurs.add(new Joueur("Michel"));
			}
			
			for(int i = 0 ; i <nbShadowHunters ; i++) {
				
				personnages.add(new Franklin());
				personnages.add(new Vampire());
			}
			
			for(int i = 0; i < nbNeutres; i++) {
				personnages.add(new Allie());
			}
			
			Plateau plateau = new Plateau(joueurs);
			plateau.initCartePersonnage(personnages);
			
			
			for(Joueur js : joueurs) {
				assertNotNull(js.getCartePersonnage());
			}
			
	}}
	
}
