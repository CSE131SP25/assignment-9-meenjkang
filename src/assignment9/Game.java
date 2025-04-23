package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {

	private Snake snake;
	private Food food;
	private int score;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		StdDraw.setScale(0, 1);
		snake = new Snake();
		food = new Food();
		score = 0;
	}
	
	public void play() {
		while (snake.isInbounds()) { 
			int dir = getKeypress();
			if (dir != -1) snake.changeDirection(dir);

			snake.move();

			if (snake.eatFood(food)) {
				food = new Food();
				score++;
			}
			
			updateDrawing();
			StdDraw.pause(80);
		}
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.5, "GAME OVER. Final Score: " + score);
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.9, 0.95, "Score: " + score);
		StdDraw.show();

	}
	
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
