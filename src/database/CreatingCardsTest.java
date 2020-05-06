package database;

import carte.CarteEquipementStat;
import carte.CartePiochable;
import condition.ConditionClassPersonnage;
import condition.ConditionEquipe;
import condition.ConditionMultiple;
import condition.ConditionReveal;
import condition.ConditionStatistiques;
import effet.EffetChoisirCible;
import effet.EffetChoisirEffet;
import effet.EffetCiblerTous;
import effet.EffetMultiple;
import effet.EffetSelf;
import effet.action.ActionAltererStatistiquesJoueur;
import effet.action.ActionAltererStatistiquesJoueurRoll;
import effet.action.ActionMultiple;
import effet.action.ActionReveal;
import effet.action.ActionVoler;
import main.Joueur;
import main.TypeLumiere;
import main.TypeTenebre;
import main.TypeVision;
import personnage.Allie;
import personnage.Bob;
import personnage.CartePersonnage;
import personnage.Charles;
import personnage.Daniel;
import personnage.Emi;
import personnage.Franklin;
import personnage.Georges;
import personnage.LoupGarou;
import personnage.Metamorphe;
import personnage.Vampire;

public class CreatingCardsTest {

	public static void main(String[] args) {
		
		// Lumière
		
		//Ange gardien
		insert(2,new CartePiochable<TypeLumiere>(
		new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_IMMUNITY, 1, true))));
		
		
		//Avénement suprême
		insert(3,new CartePiochable<TypeLumiere>(
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
				,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
				));
		
		//Barre de chocolat 
		
		insert(4,new CartePiochable<TypeLumiere>(
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
				,new ConditionMultiple(new ConditionClassPersonnage(Allie.class,Emi.class,Metamorphe.class), new ConditionReveal())
				));
		
		//Bénédiction
		
		insert(5,new CartePiochable<TypeLumiere>(new EffetChoisirCible(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,6, true))));
			
			
		// BOUSSOLE mystique
			
		// 6
			
		// 7
			
		// 8
			
		// Eau bénite
		insert(9,new CartePiochable<TypeLumiere>(new EffetSelf(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,2, true))));
		insert(10,new CartePiochable<TypeLumiere>(new EffetSelf(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,2, true))));
		
		// Eclair purificateur
		
		insert(11,new CartePiochable<TypeLumiere>(new EffetCiblerTous(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP, -2, true))));
		
		// Lance de longinus
		
		insert(12,new CarteEquipementStat<TypeLumiere>(
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 2, true))
				,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
				));
		
		// Miroir divin
		
		insert(13,new CartePiochable<TypeLumiere>(new EffetSelf(new ActionReveal()),new ConditionClassPersonnage(Vampire.class,LoupGarou.class)));

	
		// Premiers secours
		
		insert(14, new CartePiochable<TypeLumiere>(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 7, false))));
	
	
		//Savoir ancestral
		
		insert(15, new CartePiochable<TypeLumiere>(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_TURN, 1, true))));
	
	

		//Toge sainte
		
		insert(16, new CartePiochable<TypeLumiere>(new EffetSelf(new ActionMultiple(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_RESISTANCE, 1, true),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, -1, true)))));
	
	
		// Ténèbre
		
		// Araignée Sanguinaire
		
		insert(17, new CartePiochable<TypeTenebre>(new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)))));
		
		
		// Chauve - souris vampire
		
		insert(18, new CartePiochable<TypeTenebre>(new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
		
		insert(19, new CartePiochable<TypeTenebre>(new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
		
		insert(20, new CartePiochable<TypeTenebre>(new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
		
		// Dynamite
		
		// 21
		
		
		// Hache tueuse
		insert(22,new CarteEquipementStat<TypeTenebre>(
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
		
		// Hachoir maudit
		insert(23,new CarteEquipementStat<TypeTenebre>(
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
		
		
		// Mitrailleuse funeste
		// 24
		
		// Peau de banane 
		// 25
		
		// Poupé démoniaque
		// 26
		
		insert(28,new CartePiochable<TypeTenebre>(
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
				,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.SHADOW), new ConditionReveal())
				));
	
		// 29
		
		insert(30,new CartePiochable<TypeTenebre>(
				new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER))));
		
		insert(31,new CartePiochable<TypeTenebre>(
				new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER))));
		
		insert(32,new CarteEquipementStat<TypeTenebre>(
				new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
	
		
		// Vision clairvoyante
		insert(33, new CartePiochable<TypeVision>(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -1, true)), 
				new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 11, ConditionStatistiques.LESS)));
	
		// Vision cupide
		
		insert(34,new CartePiochable<TypeVision>(new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
				new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
		
		insert(35,new CartePiochable<TypeVision>(new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
				new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
		
		
		// Vision destructrice 
		
		insert(36, new CartePiochable<TypeVision>(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)), 
				new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 12, ConditionStatistiques.MORE)));
		
		
		// Vision divine
		
		// Vision enivrante 
	
		insert(38,new CartePiochable<TypeVision>(new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
				new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
		
		insert(39,new CartePiochable<TypeVision>(new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
				new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
	
		// Vision Foudroyante
		
		insert(40,new CartePiochable<TypeVision>(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
				new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
	
	
		// Vision furtive
		
		insert(41,new CartePiochable<TypeVision>(new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
				new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
		
		insert(42,new CartePiochable<TypeVision>(new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
				new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
		
		// Vision Mortifère
		
		insert(43,new CartePiochable<TypeVision>(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
				new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
		
		
		// Vision lugubre
		
		insert(45,new CartePiochable<TypeVision>(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-2,true)),
				new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
		
		// Vision réconfortante
		
		// Vision suprême
		
		insert(48,new Allie(null));
		insert(49,new Bob(null));
		insert(50,new Charles(null));
		
		insert(51,new Daniel(null));
		insert(52,new Emi(null));
		insert(53,new Franklin(null));
		
		insert(54,new Georges(null));
		insert(55,new LoupGarou(null));
		insert(56,new Metamorphe(null));
		insert(57,new Vampire(null));
		
	}
	
	
	public static void insert(int row, Object obj) {
		
	}
	
}
