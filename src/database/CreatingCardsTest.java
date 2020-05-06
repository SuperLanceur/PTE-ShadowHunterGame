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
			QueryGenerator.queryInsertObject(2,new CartePiochable(CartePiochable.Type.LUMIERE,
			new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_IMMUNITY, 1, true))));
			
			//Avénement suprême
			QueryGenerator.queryInsertObject(3,new CartePiochable(CartePiochable.Type.LUMIERE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
					,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
					));
			
			//Barre de chocolat 
			
			QueryGenerator.queryInsertObject(4,new CartePiochable(CartePiochable.Type.LUMIERE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
					,new ConditionMultiple(new ConditionClassPersonnage(Allie.class,Emi.class,Metamorphe.class), new ConditionReveal())
					));
			
			//Bénédiction
			
			QueryGenerator.queryInsertObject(5,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetChoisirCible(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,6, true))));
				
			// BOUSSOLE mystique
				
			// 6
				
			// 7
				
			// 8
				
			// Eau bénite
			QueryGenerator.queryInsertObject(9,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,2, true))));
			QueryGenerator.queryInsertObject(10,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP,2, true))));
			
			// Eclair purificateur
			
			QueryGenerator.queryInsertObject(11,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetCiblerTous(new ActionAltererStatistiquesJoueurRoll(Joueur.PLAYER_HP, -2, true))));
			
			// Lance de longinus
			
			QueryGenerator.queryInsertObject(12,new CarteEquipementStat(CartePiochable.Type.LUMIERE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 2, true))
					,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
					));
			
			// Miroir divin
			
			QueryGenerator.queryInsertObject(13,new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionReveal()),new ConditionClassPersonnage(Vampire.class,LoupGarou.class)));


			// Premiers secours
			
			QueryGenerator.queryInsertObject(14, new CartePiochable(CartePiochable.Type.LUMIERE,new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 7, false))));


			//Savoir ancestral
			
			QueryGenerator.queryInsertObject(15, new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_TURN, 1, true))));



			//Toge sainte
			
			QueryGenerator.queryInsertObject(16, new CartePiochable(CartePiochable.Type.LUMIERE,new EffetSelf(new ActionMultiple(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_RESISTANCE, 1, true),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, -1, true)))));


			// Ténèbre
			
			// Araignée Sanguinaire
			
			QueryGenerator.queryInsertObject(17, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)))));
			
			
			// Chauve - souris vampire
			
			QueryGenerator.queryInsertObject(18, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			QueryGenerator.queryInsertObject(19, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			QueryGenerator.queryInsertObject(20, new CartePiochable(CartePiochable.Type.TENEBRE,new EffetMultiple(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)),
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 1, true)))));
			
			// Dynamite
			
			// 21
			
			
			// Hache tueuse
			QueryGenerator.queryInsertObject(22,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
			
			// Hachoir maudit
			QueryGenerator.queryInsertObject(23,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));
			
			
			// Mitrailleuse funeste
			// 24
			
			// Peau de banane 
			// 25
			
			// Poupé démoniaque
			// 26
			
			QueryGenerator.queryInsertObject(28,new CartePiochable(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 20, true))
					,new ConditionMultiple(new ConditionEquipe(CartePersonnage.Equipe.SHADOW), new ConditionReveal())
					));

			// 29
			
			QueryGenerator.queryInsertObject(30,new CartePiochable(CartePiochable.Type.TENEBRE,
					new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER))));
			
			QueryGenerator.queryInsertObject(31,new CartePiochable(CartePiochable.Type.TENEBRE,
					new EffetChoisirCible(new ActionVoler(ActionVoler.VOLER))));
			
			QueryGenerator.queryInsertObject(32,new CarteEquipementStat(CartePiochable.Type.TENEBRE,
					new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, 1, true))));

			
			// Vision clairvoyante
			QueryGenerator.queryInsertObject(33, new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -1, true)), 
					new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 11, ConditionStatistiques.LESS)));

			// Vision cupide
			
			QueryGenerator.queryInsertObject(34,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			QueryGenerator.queryInsertObject(35,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			
			// Vision destructrice 
			
			QueryGenerator.queryInsertObject(36, new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, -2, true)), 
					new ConditionStatistiques(ConditionStatistiques.JOUEUR, Joueur.PLAYER_HP, 12, ConditionStatistiques.MORE)));
			
			
			// Vision divine
			
			// Vision enivrante 

			QueryGenerator.queryInsertObject(38,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));
			
			QueryGenerator.queryInsertObject(39,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.NEUTRE,CartePersonnage.Equipe.SHADOW)));

			// Vision Foudroyante
			
			QueryGenerator.queryInsertObject(40,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));


			// Vision furtive
			
			QueryGenerator.queryInsertObject(41,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
			
			QueryGenerator.queryInsertObject(42,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirEffet(new EffetChoisirCible(new ActionVoler(ActionVoler.DONNER)),new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true))),
					new ConditionEquipe(CartePersonnage.Equipe.HUNTER,CartePersonnage.Equipe.SHADOW)));
			
			// Vision Mortifère
			
			QueryGenerator.queryInsertObject(43,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-1,true)),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
			
			
			// Vision lugubre
			
			QueryGenerator.queryInsertObject(45,new CartePiochable(CartePiochable.Type.VISION,new EffetChoisirCible(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP,-2,true)),
					new ConditionEquipe(CartePersonnage.Equipe.SHADOW)));
			
			// Vision réconfortante
			
			// Vision suprême
			
			QueryGenerator.queryInsertObject(48,new Allie());
			QueryGenerator.queryInsertObject(49,new Bob());
			QueryGenerator.queryInsertObject(50,new Charles());
			
			QueryGenerator.queryInsertObject(51,new Daniel());
			QueryGenerator.queryInsertObject(52,new Emi());
			QueryGenerator.queryInsertObject(53,new Franklin());
			
			QueryGenerator.queryInsertObject(54,new Georges());
			QueryGenerator.queryInsertObject(55,new LoupGarou());
			QueryGenerator.queryInsertObject(56,new Metamorphe());
			QueryGenerator.queryInsertObject(57,new Vampire());
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
