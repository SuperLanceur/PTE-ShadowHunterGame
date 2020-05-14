package database;

import java.awt.Point;
import java.io.IOException;
import java.sql.SQLException;

import carte.CarteEquipementStat;
import carte.CarteLieu;
import carte.CarteLieuMultiple;
import carte.CarteLieuType;
import carte.CartePiochable;
import carte.CarteVision;
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
import effet.action.ActionMultipleChoisir;
import effet.action.ActionReveal;
import effet.action.ActionVoler;
import main.Joueur;
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
		try {
			
			for(int i = 0; i < 67; i++) {
				DatabaseManager.queryInsertObject(i, null);
			}
			
			
			DatabaseManager.queryInsertObject(2,new CartePiochable(CartePiochable.Type.LUMIERE,
			new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_IMMUNITY, 1, true))));
			
			//Avénement suprême
			DatabaseManager.queryInsertObject(3,new CartePiochable(CartePiochable.Type.LUMIERE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
					,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
					));
			
			//Barre de chocolat 
			
			DatabaseManager.queryInsertObject(4,new CartePiochable(CartePiochable.Type.LUMIERE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
					,new ConditionMultiple(new ConditionClassPersonnage(Allie.class,Emi.class,Metamorphe.class), new ConditionReveal())
					));
			
			//Bénédiction
			
			DatabaseManager.queryInsertObject(5,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetChoisirCible(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,6, true))));
				
			// BOUSSOLE mystique
				
			// 6
				
			// 7
				
			// 8
				
			// Eau bénite
			DatabaseManager.queryInsertObject(9,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,2, true))));
			DatabaseManager.queryInsertObject(10,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,2, true))));
			
			// Eclair purificateur
			
			DatabaseManager.queryInsertObject(11,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetCiblerTous(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP, -2, true))));
			
			// Lance de longinus
			
			DatabaseManager.queryInsertObject(12,new CarteEquipementStat(CartePiochable.Type.LUMIERE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 2, true))
					,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
					));
			
			// Miroir divin
			
			DatabaseManager.queryInsertObject(13,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionReveal()),new ConditionClassPersonnage(Vampire.class,LoupGarou.class)));


			// Premiers secours
			
			DatabaseManager.queryInsertObject(14, new CartePiochable(CartePiochable.Type.LUMIERE,new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 7, false))));


			//Savoir ancestral
			
			DatabaseManager.queryInsertObject(15, new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_TURN, 1, true))));



			//Toge sainte
			
			DatabaseManager.queryInsertObject(16, new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionMultiple(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_RESISTANCE, 1, true),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, -1, true)))));


			// Ténèbre
			
			// Araignée Sanguinaire
			
			DatabaseManager.queryInsertObject(17, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)))));
			
			
			// Chauve - souris vampire
			
			DatabaseManager.queryInsertObject(18, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			DatabaseManager.queryInsertObject(19, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			DatabaseManager.queryInsertObject(20, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			// Dynamite
			
			// 21
			
			
			// Hache tueuse
			
			DatabaseManager.queryInsertObject(22,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
						new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
			
			
			DatabaseManager.queryInsertObject(22,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
			
			// Hachoir maudit
			DatabaseManager.queryInsertObject(23,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
			
			
			// Mitrailleuse funeste
			// 24
			
			// Peau de banane 
			// 25
			
			// Poupé démoniaque
			// 26

			
			DatabaseManager.queryInsertObject(28,new CartePiochable(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
					,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.SHADOW), new ConditionReveal())
					));

			// 29
			
			DatabaseManager.queryInsertObject(30,new CartePiochable(CartePiochable.Type.TENEBRE,
					new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER))));
			
			DatabaseManager.queryInsertObject(31,new CartePiochable(CartePiochable.Type.TENEBRE,
					new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER))));
			
			/*
			DatabaseManager.queryInsertObject(32,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));

			*/
			// Vision clairvoyante
			DatabaseManager.queryInsertObject(33, new CarteVision(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -1, true), 
					new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 11, ConditionStatistiques.LESS)));

			// Vision cupide
			
			DatabaseManager.queryInsertObject(34,new CarteVision(new ActionMultipleChoisir(new ActionVoler(ActionVoler.DONNER),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			DatabaseManager.queryInsertObject(35,new CarteVision(new ActionMultipleChoisir(new ActionVoler(ActionVoler.DONNER),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			
			// Vision destructrice 
			
			DatabaseManager.queryInsertObject(36, new CarteVision(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true), 
					new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 12, ConditionStatistiques.MORE)));
			
			
			// Vision divine
			
			// Vision enivrante 

			DatabaseManager.queryInsertObject(38,new CarteVision(new ActionMultipleChoisir(new ActionVoler(ActionVoler.DONNER),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			DatabaseManager.queryInsertObject(39,new CarteVision(	new ActionMultipleChoisir(new ActionVoler(ActionVoler.DONNER),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));

			// Vision Foudroyante
			
			DatabaseManager.queryInsertObject(40,new CarteVision(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));


			// Vision furtive
			
			DatabaseManager.queryInsertObject(41,new CarteVision(new ActionMultipleChoisir(new ActionVoler(ActionVoler.DONNER),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
			
			DatabaseManager.queryInsertObject(42,new CarteVision(new ActionMultipleChoisir(new ActionVoler(ActionVoler.DONNER),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
			
			// Vision Mortifère
			
			DatabaseManager.queryInsertObject(43,new CarteVision(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
			
			
			// Vision lugubre
			
			DatabaseManager.queryInsertObject(45,new CarteVision(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-2,true),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
			
			// Vision réconfortante
			
			// Vision suprême
			
			DatabaseManager.queryInsertObject(48,new Allie());
			DatabaseManager.queryInsertObject(49,new Bob());
			DatabaseManager.queryInsertObject(50,new Charles());
			
			DatabaseManager.queryInsertObject(51,new Daniel());
			DatabaseManager.queryInsertObject(52,new Emi());
			DatabaseManager.queryInsertObject(53,new Franklin());
			
			DatabaseManager.queryInsertObject(54,new Georges());
			DatabaseManager.queryInsertObject(55,new LoupGarou());
			DatabaseManager.queryInsertObject(56,new Metamorphe());
			DatabaseManager.queryInsertObject(57,new Vampire());
			
	
			//62
			
		
			//CarteLieu lieu1 = new CarteLieuType(CartePiochable.Type.VISION,new Point(2,3));
			
			DatabaseManager.queryInsertObject(62,new CarteLieuType(CartePiochable.Type.VISION,new Point(2,3)));
			
			//63
			CarteLieu lieu2 = new CarteLieuType(CartePiochable.Type.TENEBRE,new Point(-1,8));
			
			DatabaseManager.queryInsertObject(63,lieu2);
			
			// 64
			CarteLieu lieu3 = new CarteLieu(new Point(-1,9));
			lieu3.setEffet(new EffetChoisirCible(new ActionMultipleChoisir(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-2,true),	
				new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,1,true))));
		
			DatabaseManager.queryInsertObject(64,lieu3);
			// 65
			CarteLieu lieu4 = new CarteLieuType(CartePiochable.Type.LUMIERE,new Point(-1,6));
			
			DatabaseManager.queryInsertObject(65,lieu4);
			
			CarteLieu lieu5 = new CarteLieuMultiple(new Point(4,5));
			
			DatabaseManager.queryInsertObject(66,lieu5);
			// 66
			CarteLieu lieu6 = new CarteLieu(new Point(-1,9));
			lieu6.setEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER)));
			
			DatabaseManager.queryInsertObject(67,lieu6);
			
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

