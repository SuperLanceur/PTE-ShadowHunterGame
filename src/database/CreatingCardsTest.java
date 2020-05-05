package database;

import carte.CarteEquipementStat;
import carte.CartePiochable;
import condition.Condition;
import condition.ConditionClassPersonnage;
import condition.ConditionMultiple;
import condition.ConditionReveal;
import condition.ConditionType;
import effet.EffetChoisirCible;
import effet.EffetCiblerTous;
import effet.EffetSelf;
import effet.action.Action;
import effet.action.ActionAltererStatistiquesJoueur;
import effet.action.ActionAltererStatistiquesJoueurRoll;
import effet.action.ActionMultiple;
import effet.action.ActionReveal;
import main.Joueur;
import main.TypeLumiere;
import personnage.Allie;
import personnage.CartePersonnage;
import personnage.Emi;
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
				,new ConditionMultiple(new ConditionType(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
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
				,new ConditionMultiple(new ConditionType(CartePersonnage.Equipe.HUNTER), new ConditionReveal())
				));
		
		// Miroir divin
		
		insert(13,new CartePiochable<TypeLumiere>(new EffetSelf(new ActionReveal()),new ConditionClassPersonnage(Vampire.class,LoupGarou.class)));

	
		// Premiers secours
		
		insert(14, new CartePiochable<TypeLumiere>(new EffetCiblerTous(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_HP, 7, false))));
	
	
		//Savoir ancestral
		
		insert(15, new CartePiochable<TypeLumiere>(new EffetSelf(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_TURN, 1, true))));
	
	

		//Toge sainte
		
		insert(16, new CartePiochable<TypeLumiere>(new EffetSelf(new ActionMultiple(new ActionAltererStatistiquesJoueur(Joueur.PLAYER_RESISTANCE, 1, true),new ActionAltererStatistiquesJoueur(Joueur.PLAYER_DAMAGE, -1, true)))));
	}
	
	
	public static void insert(int row, Object obj) {
		
	}
	
}
