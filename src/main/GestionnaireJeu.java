package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import carte.CarteEquipement;
import carte.CarteLieu;
import carte.CartePiochable;
import carte.CartePiochable.Type;
import database.RessourceLoader;
import effet.Effet;
import ihm.controller.PlateauController;
import javafx.application.Platform;

public class GestionnaireJeu {
	
	private static GestionnaireJeu gj;	
	
	private Map<Integer, Joueur> mapJoueurs;

	private RessourceLoader ressourceLoader;

	private static Stack<Thread> threads = new Stack<Thread>();
	
	private static Plateau plateau;
	public static PlateauController pc;
	
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

	public Effet choisirEffet(Joueur joueur, Effet[] effets) {
		return effets[0];
	}
	

	public void deplacer(Joueur currentJoueur) {
		
		Platform.runLater(() -> {
			pc.deplacer(currentJoueur);
		});	
	}
	
	public void afficherLieu(Joueur currentJoueur) {
		Platform.runLater(() -> {
			try {
				pc.afficherLieu(currentJoueur);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		this.waitPlateau();
	}
	
	public void updateVieJoueur(Joueur joueur, int damage) {
		
		Platform.runLater(() -> {
			pc.updateVieJoueur(joueur, damage);
		});
	}
	
	public boolean choisir(Joueur joueur, Contexte contexte) {
		
		Platform.runLater(() -> {
			try {	
				pc.afficherChoisir(joueur, contexte);
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
	
	@SuppressWarnings("unchecked")
	public Object choisir(Joueur joueur, List<?> list, Class<?> cls) {
		
		
		
		if(cls == CarteEquipement.class) {
			return choisirEquipementVole(joueur, (List<CarteEquipement>) list);
		}else if(cls == Joueur.class) {
			
			return choisirJoueur(joueur, (List<Joueur>) list, Contexte.ACTIVER_EFFET_LIEU);
		}
		return list.get(0);
	}
	
	public CarteEquipement choisirEquipementVole(Joueur joueur, List<CarteEquipement> lce) {
		Platform.runLater(() -> {
			try {	
				pc.afficherChoisirEquipementVole(joueur);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		this.waitPlateau();
	
		final FutureTask<CarteEquipement> query = new FutureTask<CarteEquipement>(new Callable<CarteEquipement>() {
		    @Override
		    public CarteEquipement call() throws Exception {
		    	return pc.getChoixEquipementVole(joueur);
		    }
		});
		
		Platform.runLater(query);
		
		try {
			return query.get();
		} catch (InterruptedException | ExecutionException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void alterationVie(Joueur joueur, int valeur) {
		
		Platform.runLater(() -> {
			try {
				pc.afficherAlterationVie(joueur,valeur);
				
			} catch (IOException | InterruptedException e1) {
				e1.printStackTrace();
			}

		});
		
		this.waitPlateau();
	}
	

	public void rollDice(Joueur joueur, int typeDice, int ... rolls){
		
		Platform.runLater(() -> {
				pc.rollDice(joueur,typeDice,rolls, null);
		});
		
		this.waitPlateau();
	}
	
	public Joueur choisirJoueur(Joueur joueur, List<Joueur> joueurs, Contexte contexte) {
		
		Platform.runLater(() -> {
			try {	
				pc.afficherChoisirJoueur(joueur,joueurs, contexte);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	
		this.waitPlateau();
	
		final FutureTask<Joueur> query = new FutureTask<Joueur>(new Callable<Joueur>() {
		    @Override
		    public Joueur call() throws Exception {
		    	return pc.getChoixJoueur(joueur);
		    }
		});
		
		Platform.runLater(query);
		
		try {
			return query.get();
		} catch (InterruptedException | ExecutionException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}
	public void waitPlateau() {
		Thread t = Thread.currentThread();
		threads.add(t);
		synchronized(t) {
			try {
				t.wait();
			} catch (InterruptedException e) {
				
			}
		}
	}

	public static void notifyPlateau() {
		Thread t = threads.pop();
		synchronized(t) {	
			t.notify();
		}
	}
	
    public Type choisirCarte(Joueur joueur) {
		
		Platform.runLater(() -> {
			try {	
				pc.afficherPiocher(joueur);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	
		this.waitPlateau();
	
		final FutureTask<Type> query = new FutureTask<Type>(new Callable<Type>() {
		    @Override
		    public Type call() throws Exception {
		    	return pc.getChoixCarte(joueur);
		    }
		});
		
		Platform.runLater(query);
		
		try {
			return query.get();
		} catch (InterruptedException | ExecutionException e) {
		
			e.printStackTrace();
		}
		
		return null;
	}

	
	public void setConfiguration(Configuration c) {
	
		Map<Integer, Joueur> mapJoueurs = convertConfiguration(c);
		this.mapJoueurs = mapJoueurs;
		
		List<Joueur> joueurs = new ArrayList<Joueur>();
		
		for(Joueur j : mapJoueurs.values()) {
			joueurs.add(j);
		}
		//plateau = new Plateau(joueurs);
		plateau = new Plateau(joueurs,ressourceLoader.getCartes());
		
	}

	public Map<Integer, Joueur> convertConfiguration(Configuration c) {
		
		return c.toJoueurs();
	}

	public Map<Integer, Joueur> getMapJoueurs() {
		return this.mapJoueurs;
	}

	public void setPlateauController(PlateauController pc2) {
		pc = pc2;
		
	}

	public static void endGame() {
		plateau.stop();
	}

	public void setRessourceLoader(RessourceLoader rl) {
		this.ressourceLoader = rl;
	}

	public List<CarteLieu> getCartesLieux() {
		return plateau.getLieux();
	}

	public RessourceLoader getRessourceLoader() {
		return this.ressourceLoader;
	}

	public void ajouterEquipement(Joueur joueur, CarteEquipement e) {
		Platform.runLater(() -> {
			pc.ajouterEquipement(joueur,e);
		});	
	}

	public void retirerEquipement(Joueur joueur, CarteEquipement e) {
		Platform.runLater(() -> {
			pc.retirerEquipement(joueur,e);
		});	
	}

	public void piocher(Joueur j, CartePiochable cartePiochable) {
		Platform.runLater(() -> {
			try {
				if(cartePiochable.getType() == Type.VISION) {
					pc.afficherVision(j, cartePiochable);
				}else {
					pc.afficherLT(j, cartePiochable);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		waitPlateau();
	}

	
}
