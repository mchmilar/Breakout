import java.awt.Graphics2D;

public class Ball {

	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	private Breakout game;
	
	public Ball(Breakout game) {
		this.game = game;
	}
	
	public void move() {
		if (x + xa < 0) {
			xa *= -1;
		}
		if ((x + WIDTH) + xa > game.getWidth()) {
			xa *= -1;
		}
		if (y + ya < 0) {
			ya *= -1;
		}
		if ((y + HEIGHT) + ya > game.getHeight()) {
			ya *= -1;
		}
		
		x += xa;
		y += ya;
	}
	
	public void paint(Graphics2D g) {
		g.fillOval(x, y, WIDTH, HEIGHT);
	}
	
}
