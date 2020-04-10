package tmpmeth;

public class DamageCalculator {
        
    public static int calculDamage(Dice d6, Dice d4) {
        int r = d6.roll() - d4.roll();
        if(r < 0) {
        	r = 0;
        }
        return r;
    }
}

