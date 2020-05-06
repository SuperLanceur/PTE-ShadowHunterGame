package database;

import java.io.IOException;
import java.sql.SQLException;

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
		try {
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
			
			DatabaseManager.queryInsertObject(17, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)))));
			
			
			// Chauve - souris vampire
			
			DatabaseManager.queryInsertObject(18, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			DatabaseManager.queryInsertObject(19, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			DatabaseManager.queryInsertObject(20, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			// Dynamite
			
			// 21
			
			
			// Hache tueuse
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
			
			DatabaseManager.queryInsertObject(32,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));

			
			// Vision clairvoyante
			DatabaseManager.queryInsertObject(33, new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -1, true)), 
					new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 11, ConditionStatistiques.LESS)));

			// Vision cupide
			
			DatabaseManager.queryInsertObject(34,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			DatabaseManager.queryInsertObject(35,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			
			// Vision destructrice 
			
			DatabaseManager.queryInsertObject(36, new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)), 
					new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 12, ConditionStatistiques.MORE)));
			
			
			// Vision divine
			
			// Vision enivrante 

			DatabaseManager.queryInsertObject(38,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			DatabaseManager.queryInsertObject(39,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));

			// Vision Foudroyante
			
			DatabaseManager.queryInsertObject(40,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));


			// Vision furtive
			
			DatabaseManager.queryInsertObject(41,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
			
			DatabaseManager.queryInsertObject(42,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
			
			// Vision Mortifère
			
			DatabaseManager.queryInsertObject(43,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
			
			
			// Vision lugubre
			
			DatabaseManager.queryInsertObject(45,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-2,true)),
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
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
