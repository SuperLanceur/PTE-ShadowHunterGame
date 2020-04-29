package ihm;

/**
 * @author https://www.programcreek.com/java-api-examples/?code=AlmasB%2FFXTutorials%2FFXTutorials-master%2Fsrc%2Fcom%2Falmasb%2Ftutorial5%2FDice.java
 * 
 */

import javafx.animation.RotateTransition;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Dice extends StackPane {

    public static int MAX_VALUE = 6;
    public static final int MIN_VALUE = 1;

    public final SimpleIntegerProperty valueProperty = new SimpleIntegerProperty();

    int i = 0;
    
    public Dice(int valeurMax) {
    	
    	MAX_VALUE = valeurMax;
        Rectangle rect = new Rectangle(50, 50);

        Text text = new Text();
        text.setFill(Color.WHITE);
        text.textProperty().bind(valueProperty.asString());

        this.setAlignment(Pos.CENTER);
        getChildren().addAll(rect, text);

        this.setOnMouseClicked(event -> roll());
    }

    public void roll() {
        RotateTransition rt = new RotateTransition(Duration.seconds(0.5), this);
        rt.setFromAngle(0);
        rt.setToAngle(360);
        int cycles = 2000;
       
        rt.setOnFinished(event -> {
       
        	valueProperty.set((int)(Math.random() * (MAX_VALUE - MIN_VALUE + 1)) + MIN_VALUE);

        	if(cycles < i) {
        		
        		rt.play();
        		i++;
        	}
        	
        });
        rt.play();
    }
}