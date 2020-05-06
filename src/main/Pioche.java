package main;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import carte.CartePiochable;

public class Pioche {
	
	private Stack<CartePiochable> cartesPiochables;
	private CartePiochable.Type type;
	
	public Pioche(List<CartePiochable> cartesPiochables) {
		
	}

	public Pioche(CartePiochable.Type type, List<CartePiochable> list1) {
		super();
		this.type = type;
		this.cartesPiochables = new Stack<CartePiochable>();
		this.cartesPiochables.addAll(cartesPiochables);
		melanger();
	}

	public void melanger()
	{
		Collections.shuffle(cartesPiochables);
	}
	
	public CartePiochable piocher() {	
		return cartesPiochables.pop();
	}
}
