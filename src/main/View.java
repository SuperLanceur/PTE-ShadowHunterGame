package main;

import java.util.List;

public class View{
	
	private static View view;
	
	private View() {}
	
	
	static {
		try {
			view = new View();
		}catch(Exception e) {
			throw new RuntimeException("View Singleton");
		}
	}
	
	public static View getView() {
		return view;
	}
	
	
	public static void initPartie(List<Joueur> joueurs) {
				
	}
	
	public static void lancerPartie() {
			
	}

	public static void menu() throws Exception {
		
	}
	
	public void applyConfiguration(GestionnaireJeu gj,Configuration c) {
		
	}
	
	public List<Joueur> getJoueurs() {
		return null;
	}
}
