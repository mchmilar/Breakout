import java.awt.Graphics;

public class Brick{

	private int x;
	private int y;
	private int width;
	private int height;
	
	public Brick() {
		
	}
	
	public Brick(int x, int y, int width, int height) {
		setWidth(width);
		setHeight(height);
		setX(x);
		setY(y);
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, width, height);
	}
	
}
