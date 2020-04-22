package main;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import carte.CartePiochable;

public class Pioche<T extends Type> {
	
	private Stack<CartePiochable<T>> cartesPiochables;
	
	public Pioche(List<CartePiochable<T>> cartesPiochables) {
		super();
		this.cartesPiochables = new Stack<CartePiochable<T>>();
		this.cartesPiochables.addAll(cartesPiochables);
		melanger();
	}

	public void melanger()
	{
		Collections.shuffle(cartesPiochables);
	}
	
	public CartePiochable<?> piocher() {	
		return cartesPiochables.pop();
	}
}
