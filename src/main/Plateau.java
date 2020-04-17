package main;

import java.util.HashMap;
import java.util.Map;

public class Plateau {
	
	private Map<String, Integer> stats = new HashMap<>();
	
	public int rollDices6() {
		return roll6() + roll6();
	}
	
	public int roll6() {
		
		return 0;
	}

	public int rollDices4() {
		return 0;
	}
	
}
