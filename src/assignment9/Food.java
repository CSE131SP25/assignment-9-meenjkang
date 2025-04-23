package assignment9;

import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		Random r = new Random();
		x = r.nextDouble() * (1 - FOOD_SIZE);
		y = r.nextDouble() * (1 - FOOD_SIZE);
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
