package main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import carte.CarteLieu;
import carte.CarteLieuType;
import carte.CartePiochable;
import effet.Effet;
import effet.EffetChoisirCible;
import effet.EffetChoisirEffet;
import effet.EffetSelf;
import effet.action.ActionAltererStatistiquesJoueur;
import effet.action.ActionVoler;
import ihm.controller.PlateauController;
import personnage.Allie;
import personnage.CartePersonnage;
import personnage.Franklin;
import personnage.Vampire;

public class Plateau {
	
	private GestionnaireJeu gj;
	private List<Joueur> joueurs;
	private List<CarteLieu> lieux;
	

	public static final String NB_HUNTERS = "nb_hunters";
	public static final String NB_SHADOWS = "nb_shadows";
	public static final String NB_NEUTRES = "nb_neutres";
	public static final String NB_MORTS = "nb_morts";
	public static final String NB_MORTS_NEUTRAL = "nb_morts_neutral";
	public static final String NB_MORTS_HUNTER = "nb_morts_hunter";
	public static final String NB_MORTS_SHADOW = "nb_morts_shadow";
	public static final String PARTIE_FINIE = "partie_finie";
	
	private Map<String, Integer> stats;
	
	public Plateau(List<Joueur> joueurs) {
		
		gj = GestionnaireJeu.getGestionnaireJeu();
		
		this.lieux = new ArrayList<>();
		this.stats = new HashMap<>();
		
		joueurs.forEach(x -> x.setPlateau(this));
		this.joueurs = joueurs;
		
		
		this.stats.put(NB_MORTS, 0);
		this.stats.put(NB_MORTS_NEUTRAL, 0);
		this.stats.put(NB_MORTS_HUNTER, 0);
		this.stats.put(NB_MORTS_SHADOW, 0);
		this.stats.put(PARTIE_FINIE, 0);
		
		this.stats.put(NB_HUNTERS, 0);
		this.stats.put(NB_SHADOWS, 0);
		this.stats.put(NB_NEUTRES, 0);
		
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
		
		List<CartePersonnage> personnages = new ArrayList<CartePersonnage>();
		
		
		for(int i = 0 ; i <3 ; i++) {
			
			personnages.add(new Franklin());
			personnages.add(new Vampire());
		}
		
		for(int i = 0; i < 2; i++) {
			personnages.add(new Allie());
		}
		
		try {
			initCartePersonnage(personnages);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLieux(cls);
		shuffleLieux();
		
	}	
	
	public void initCartePersonnage(List<CartePersonnage> cps) throws Exception {
		
		
		int nbJoueurs = this.joueurs.size();
		List<CartePersonnage> lcp = new ArrayList<>(nbJoueurs);
		
		switch(nbJoueurs) {
		
		case 4:
			lcp = getRandomListPersonnages(cps,2,0);
			break;
		case 5:
			lcp = getRandomListPersonnages(cps,2,1);
			break;
		case 6:
			lcp = getRandomListPersonnages(cps,2,2);
			break;
		case 7:
			lcp = getRandomListPersonnages(cps,2,3);
			break;
		case 8:
			lcp = getRandomListPersonnages(cps,3,2);
			break;
		default:
			throw new Exception();
		}
		
		for(int i = 0; i< nbJoueurs; i++) {
			
			Joueur j = joueurs.get(i);
			j.setCartePersonnage(lcp.get(i));
			lcp.get(i).setJoueur(j);
		}
	}
	
	private List<CartePersonnage> getRandomListPersonnages(List<CartePersonnage> cps,int nbEquipeShadowHunter, int nbNeutres) {
		
		List<CartePersonnage> lcp = new ArrayList<CartePersonnage>();
		
		Collections.shuffle(cps);
		
		
		int nbShadow = nbEquipeShadowHunter;
		int nbHunter = nbEquipeShadowHunter;
		int nbNeutre = nbNeutres;
		
		
	
		for(CartePersonnage cp : cps) {
			
			
			if(nbHunter > 0 && cp.getEquipe() == CartePersonnage.Equipe.HUNTER) {
				nbHunter--;
				lcp.add(cp);
			}
			
			if(nbNeutre > 0 && cp.getEquipe() == CartePersonnage.Equipe.NEUTRE) {
				nbNeutre--;
				lcp.add(cp);
			}
			
			if(nbShadow > 0 && cp.getEquipe() == CartePersonnage.Equipe.SHADOW) {
				nbShadow--;
				lcp.add(cp);
			}
		}
		return lcp;
	}

	public void jeu() {
		
		int nbJoueurs = this.joueurs.size()-1;
		int i = 1;
		
		while(true) {
			
			Joueur currentJoueur = this.joueurs.get(nbJoueurs % i);
			System.out.println("\n\n\n\n\n");
			System.out.println("Au tour de "+currentJoueur.getNom());
			System.out.println("Lancement des dés.");
			deplacer(currentJoueur);
			System.out.println("Vous êtes désormais sur le lieu "+currentJoueur.getCarteLieu().getNom());
			System.out.println("Voulez vous activer l'effet du lieu ?");
			if(currentJoueur.choisir()) {
				System.out.println("Vous activez l'effet du lieu.");
				System.out.println("Vous avez "+currentJoueur.getStat(Joueur.PLAYER_HP)+" pv");
				currentJoueur.utiliserEffetLieu();
				System.out.println("Vous passez a "+currentJoueur.getStat(Joueur.PLAYER_HP)+" pv");
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n");
			
			System.out.println("Souhaitez vous attaquer quelqu'un ?");
			if(currentJoueur.choisir()){
				if(currentJoueur.hasOpponents()) {
					Joueur cible = currentJoueur.choisirAdjacents();
					attaquer(currentJoueur,cible);
				}else {
					System.out.println("Il n'y a personne a attaquer.");
				}
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
			
					e.printStackTrace();
				}
			}
			
			i++;
		}
	}
	
	public void deplacer(Joueur currentJoueur) {
		
		boolean attributed = false;
		
		while(!attributed) {
			int roll = sumRolls(currentJoueur);
			for(CarteLieu cl : lieux) {
				
				if(cl.coordinatesContains(roll) && currentJoueur.getCarteLieu() != cl){
					
					currentJoueur.deplacer(cl);
					attributed = true;
					break;
				}
			}
		}
	}
	
	public void attaquer(Joueur joueur1, Joueur joueur2) {
		
		int attaque = diffRolls(joueur1);
		
		if(attaque != 0) {
			System.out.println(joueur1.getNom()+" attaque "+joueur2.getNom());
			System.out.println(joueur2.getNom()+" a "+joueur2.getStat(Joueur.PLAYER_HP)+" pv");
			joueur1.attaquer(joueur2,attaque);
			System.out.println(joueur2.getNom()+" passe à "+joueur2.getStat(Joueur.PLAYER_HP)+" pv");
			
		}
	}
	
	public Joueur selectionnerJoueur() {
		return new Joueur("0");
	}
	
	public int diffRolls(Joueur j) {
		
		int roll4 =rollRandom(4);
		int roll6 = rollRandom(6);
		
	
		gj.rollDice(j, PlateauController.DICE_BOTH, roll4,roll6);
		return Math.abs(roll4-roll6);
	}
	
	public int roll4(Joueur j) {
		
		int roll = this.rollRandom(4);
		gj.rollDice(j, PlateauController.DICE_QUATRE, roll);
		return roll;
	}
	
	public int roll6(Joueur j) {
		
		int roll = this.rollRandom(6);
		gj.rollDice(j, PlateauController.DICE_QUATRE, roll);
		return roll;
	}
	
	private int rollRandom(int nb) {
		
		int roll = (int) Math.floor(Math.random() * (nb-1))+1;
		return roll;
	}

	public int sumRolls(Joueur j)
	{
		return roll6(j) + roll4(j);
	}
	
	public List<Joueur> getJoueurs() {
		return this.joueurs;
	}

	public void setStat(String key, int valeur) {
		this.stats.put(key, valeur);
	}
	
	public int getStat(String key) {
		
		if(this.stats.containsKey(key))
		{
			return this.stats.get(key);
		}else {
		
			return -1;
		}
		
	}
	
	public void shuffleLieux(){
		
		this.lieux.forEach(x -> x.setVoisin(null));
		
		if(lieux.size() % 2 == 0) {
			
			Collections.shuffle(lieux);
			
			for(int i = 0; i < lieux.size(); i += 2) {
				
				lieux.get(i).setVoisin(lieux.get(i+1));
				lieux.get(i+1).setVoisin(lieux.get(i));
			}
			
		}else {
			
		}
	}
	
	public void setLieux(List<CarteLieu> lieux) {
		this.lieux = lieux;
		shuffleLieux();
	}

	public boolean choisir(Joueur joueur) {
		return gj.choisir(joueur);
	}

	public Joueur choisirAdjacents(Joueur joueur) {
		List<Joueur> joueurs = new ArrayList<Joueur>();
		CarteLieu cl = joueur.getCarteLieu();
		
		joueurs.addAll(cl.getJoueurs());
		joueurs.remove(joueur);
		joueurs.addAll(cl.getJoueursAdjacents());
		
		return gj.choisirAdjacents(joueur, joueurs);
			
		}

	public Effet choisirEffet(Joueur joueur, Effet[] effets) {
		return gj.choisirEffet(joueur,effets);
	}

	public Joueur choisirParmisTous(Joueur joueur) {
		List<Joueur> joueurs = this.getJoueurs();
		return gj.choisirParmisTous(joueur,joueurs);
	}
}
