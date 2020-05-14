package tmpmeth;

public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Dice d4 = new Dice(4);
	    Dice d6 = new Dice(6);
	    
	    System.out.println(DamageCalculator.calculDamage(d6, d4));

	}
}
