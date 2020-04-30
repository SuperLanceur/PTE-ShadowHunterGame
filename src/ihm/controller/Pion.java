package ihm.controller;

import java.awt.Point;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pion extends Circle{

	private static final double RADIUS = 8.0;
	private static final double RED= 0.0;
	private Point position;

	public Pion(Color color) {
		
		this.position = new Point(0,0);
		this.setRadius(RADIUS);
		this.setFill(color);
		this.setStroke(new Color(0,0,0,1));
		this.setStrokeWidth(1);
	}
	
	public void setPosition(int x, int y) {
		this.position = new Point(x,y);
	}
	
	public Point getPosition() {
		return this.position;
	}
	
}
