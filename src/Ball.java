import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

	private int x = 0;
	private int y = 0;
	private int xa = 1;
	private int ya = 1;
	private static final int WIDTH = 10;
	private static final int HEIGHT = 10;
	private Ellipse2D.Double ball;
	private Breakout game;
	
	public Ball(Breakout game) {
		this.game = game;
		ball = new Ellipse2D.Double(x, y, WIDTH, HEIGHT);
	}
	
	public void move() {
		if (x + xa < 0) {
			xa *= -1;
			x += xa;
		}else if ((x + WIDTH) + xa > game.getWidth()) {
			xa *= -1;
		}
		
		if (y + ya < 0) {
			ya *= -1;
		} else if ((y + HEIGHT) + ya > game.getHeight()) {
			ya *= -1;
		}
		if (isCollision()) {
			ya *= -1;
		}
		x += xa;
		y += ya;
		ball.setFrame(x, y, WIDTH, HEIGHT);
	}
	
	public Rectangle2D.Double getBounds() {
		return new Rectangle2D.Double(x, y, WIDTH, HEIGHT);
	}
	
	public boolean isCollision() {
		return game.paddle.getBounds().intersects(getBounds());
	}
	
	public void paint(Graphics2D g) {
		g.draw(ball);
		g.fill(ball);
	}
	
}
