package main;

import java.util.Collections;
import java.util.List;

public class Pioche<Carte> {
	private List<CartePiochable> cartesPiochables;
	
	public CartePiochable piocher() {
		Collections.shuffle(cartesPiochables);
		return cartesPiochables.get(0);
	}
}
