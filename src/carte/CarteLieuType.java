package carte;

import java.awt.Point;

import main.Joueur;
import main.Pioche;
import main.Type;

public class CarteLieuType<T extends Type> extends CarteLieu{
	
	private Pioche<T> pioche;
	
	
	public CarteLieuType(String name, String description ,Point coordinates,Pioche<T> pioche) {
		super(name , description , coordinates);
		this.pioche = pioche;
	}

	public void utiliser(Joueur j) {
		
		CartePiochable<?> carte = pioche.piocher();
		carte.utiliser(j);
	}
	

}
