package carte;

import java.awt.Point;

import main.Joueur;
import main.Pioche;
import main.Type;

public class CarteLieuType<T extends Type> extends CarteLieu{
	
	private Pioche<T> pioche;
	
	
	public CarteLieuType(Point coordinates,Pioche<T> pioche) {
		super(coordinates);
		this.pioche = pioche;
	}

	public void utiliser(Joueur j) {
		
		CartePiochable<?> carte = pioche.piocher();
		carte.utiliser(j);
	}
	

}
