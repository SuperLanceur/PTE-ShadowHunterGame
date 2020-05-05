package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import effet.Effet;
import ihm.controller.PlateauController;
import javafx.application.Platform;

public class GestionnaireJeu {
	
	private static GestionnaireJeu gj;	
	
	private Map<Integer, Joueur> mapJoueurs;
	
	private static Plateau plateau;
	private static PlateauController pc;
	
	private GestionnaireJeu() {}
	
	public static GestionnaireJeu getGestionnaireJeu(){
        if(gj == null){
            gj = new GestionnaireJeu();
        }
        return gj;
    }

	
	public Plateau getPlateau() {
		return plateau;
	}

	public void lancerPartie() {
		plateau.start();
	}
	
	public void jouer(Configuration c) {
		
	}
	
	public static Configuration lancerConfiguration() {	
		//TODO
		return null;
	}

	public Joueur choisirParmisTous(Joueur joueur, List<Joueur> joueurs) {
		return joueurs.get(0);
		
	}

	public Effet choisirEffet(Joueur joueur, Effet[] effets) {
		return effets[0];
	}

	public Joueur choisirAdjacents(Joueur joueur, List<Joueur> joueurs) {
		return joueurs.get(0);
	}

	public void deplacer(Joueur currentJoueur) {
		
		Platform.runLater(() -> {
			pc.deplacer(currentJoueur);
		});		
	}
	
	public boolean choisir(Joueur joueur) {
		
		Platform.runLater(() -> {
			try {
				pc.afficherChoisir(joueur);
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		
		});
		
		this.waitPlateau();
	
		final FutureTask<Boolean> query = new FutureTask<Boolean>(new Callable<Boolean>() {
		    @Override
		    public Boolean call() throws Exception {
		    	return pc.getChoix(joueur);
		    }
		});
		
		Platform.runLater(query);
		
		try {
			return query.get().booleanValue();
		} catch (InterruptedException | ExecutionException e) {
		
			e.printStackTrace();
		}
		
		return false;
	}
	
	public void waitPlateau() {
		
		synchronized(plateau) {
			try {
				plateau.wait();
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	public static void notifyPlateau() {
		
		synchronized(plateau) {	
			plateau.notify();
		}
		
	}
	
	public void rollDice(Joueur joueur, int typeDice, int ... rolls){
		
		pc.rollDice(joueur,typeDice,rolls);
		
	}
	
	public void setConfiguration(Configuration c) {
	
		Map<Integer, Joueur> mapJoueurs = convertConfiguration(c);
		this.mapJoueurs = mapJoueurs;
		
		List<Joueur> joueurs = new ArrayList();
		
		for(Joueur j : mapJoueurs.values()) {
			joueurs.add(j);
		}
		
		this.plateau = new Plateau(joueurs);
		
	}

	public Map<Integer, Joueur> convertConfiguration(Configuration c) {
		
		return c.toJoueurs();
	}

	public Map<Integer, Joueur> getMapJoueurs() {
		return this.mapJoueurs;
	}

	public void setPlateauController(PlateauController pc2) {
		this.pc = pc2;
		
	}

	public void updateVieJoueur(Joueur joueur, int damage) {
		pc.updateVieJoueur(joueur, damage);
		
	}

	public static void endGame() {
		plateau.stop();
	}

	

	
}
