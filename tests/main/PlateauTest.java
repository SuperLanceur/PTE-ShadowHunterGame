package main;

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
	
		List<CartePiochable<TypeLumiere>> list1 = new ArrayList<>();
		List<CartePiochable<TypeTenebre>> list2 = new ArrayList<>();
		
		for(int i = 0; i < 60; i++) {
			
			CartePiochable<TypeLumiere> carte1 = new CartePiochable<TypeLumiere>("Eau bénite", "Soin 2");
			carte1.setEffet(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 2, true)));
			list1.add(carte1);
			
			CartePiochable<TypeTenebre> carte2 = new CartePiochable<TypeTenebre>("Eau maudite", "Damage 2");
			carte2.setEffet(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)));
			list2.add(carte2);
		}
	
		
		Pioche<TypeLumiere> piocheLumiere = new Pioche<TypeLumiere>(list1);
		Pioche<TypeTenebre> piocheTenebre = new Pioche<TypeTenebre>(list2);
		
		
		CarteLieu lieu1 = new CarteLieuType<TypeTenebre>("Antre de l'Ermite","desc",new Point(2,3),piocheTenebre);
		CarteLieu lieu2 = new CarteLieuType<TypeTenebre>("Cimetière","desc",new Point(-1,8),piocheTenebre);
		CarteLieu lieu3 = new CarteLieu("Forêt hantée","desc",new Point(-1,9));
		lieu3.setEffet(new EffetChoisirEffet(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-2,true)),
											new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,1,true))));
		CarteLieu lieu4 = new CarteLieuType<TypeLumiere>("Monastère","desc",new Point(-1,6),piocheLumiere);
		
		CarteLieu lieu5 = new CarteLieuType<TypeTenebre>("Sanctuaire Ancien","desc",new Point(4,5),piocheTenebre);
		CarteLieu lieu6 = new CarteLieu("Sanctuaire Ancien","desc",new Point(-1,9));
		lieu6.setEffet(new EffetChoisirCible(new ActionVoler()));
	
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
	
}
