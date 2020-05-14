package tmpmeth;
import java.lang.Math;

public class Dice {

	private int max;

	public Dice() {
		this(0);
	}
	
	public Dice(int m) {
		this.max = m;
	}
	
	public int roll() {
		return (int)((max)*Math.random())+1;
	}
	
	public int getMax() {
		return this.max;
	}
	
}
