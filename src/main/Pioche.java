package main;

import java.util.Collections;
import java.util.Stack;

import carte.CartePiochable;

public class Pioche<T extends Type> {
	
	private Stack<CartePiochable<T>> cartesPiochables;
	
	
	public void melanger()
	{
		Collections.shuffle(cartesPiochables);
	}
	
	public CartePiochable<?> piocher() {
		
		return cartesPiochables.pop();
	}
}
