import java.awt.Graphics2D;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class Paddle {

	private int x;
	private int y;
	private int width;
	private int height;
	private Breakout game;
	private Rectangle2D.Double paddle;
	
	// Takes the calling Breakout class as a parameter to detect the edge of the frame
	public Paddle(Breakout game) {
		this.game = game;
		width = 40;
		height = 10;
		x = (game.getWidth() / 2) - (width / 2);
		y = game.getHeight() - 40;
		paddle = new Rectangle2D.Double(x, y, width, height);
	}
	
	public Rectangle2D.Double getBounds() {
		return new Rectangle2D.Double(x, y, width, height);
	}
	
	public void paint(Graphics2D g) {
		g.draw(paddle);
		g.fill(paddle);
	}
	
	public void move (int x) {
		this.x = x;
		if (x <= 0)
			paddle.setRect(0, y, width, height);
		else if (x >= game.getWidth() - width)
			paddle.setRect(game.getWidth() - width, y, width, height);
		else 
			paddle.setRect(x, y, width, height);
			
	}
	
	public void mouseDragged(MouseEvent e) {
	}
	
	public void mouseMoved(MouseEvent e) {
		x = e.getX() - (width /2);	
		move(x);
	}
}
