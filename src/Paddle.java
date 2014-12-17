import java.awt.Graphics2D;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class Paddle {

	private int x;
	private int y;
	private int width;
	private int height;
	private Breakout game;
	
	// Takes the calling Breakout class as a parameter to detect the edge of the frame
	public Paddle(Breakout game) {
		this.game = game;
		width = 40;
		height = 10;
		x = (game.getWidth() / 2) - (width / 2);
		y = game.getHeight() - 40;
		
	}
	
	public void paint(Graphics2D g) {
		g.fillRect(x, y, width, height);
	}
	
	public void mouseDragged(MouseEvent e) {
	}
	
	public void mouseMoved(MouseEvent e) {
		x = e.getX() - (width /2);		
	}
}
