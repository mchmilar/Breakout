import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Breakout extends JPanel implements MouseMotionListener{

	private static final int NB_ROWS = 6;
	private static final int NB_COLS = 10;
	private static final int BRICK_GAP = 3;
	private static final int BRICK_WIDTH = 30;
	private static final int BRICK_HEIGHT = 10;
	private static final int BOARD_WIDTH = (NB_COLS * BRICK_WIDTH) + ((NB_COLS + 1) * BRICK_GAP);
	private static final int BOARD_HEIGHT = 400;
	private static final Dimension d = new Dimension(BOARD_WIDTH, BOARD_HEIGHT);
	
	Ball ball;
	Paddle paddle;
	Brick[][] bricks;
	
	public Breakout() {
		super();
		setSize(d);
		ball = new Ball(this);
		paddle = new Paddle(this);
		bricks = new Brick[NB_ROWS][NB_COLS];
		addMouseMotionListener(this);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Breakout");
		Breakout game = new Breakout();	
		game.layBricks();
		frame.add(game);
		
		frame.getContentPane().setPreferredSize(d);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
	
	public Paddle getPaddle() {
		return paddle;
	}
	
	private void layBricks() {
		
		for (int i = 0; i < bricks.length; i++ ){
			for (int j = 0; j < bricks[i].length; j++) {
				int x = BRICK_GAP + (BRICK_GAP + BRICK_WIDTH) * j;
				int y = BRICK_GAP + (BRICK_GAP + BRICK_HEIGHT) * i;
				bricks[i][j] = new Brick(x, y, BRICK_WIDTH, BRICK_HEIGHT);
			}
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ball.paint(g2d);
		paddle.paint(g2d);
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[i].length;j++){
				bricks[i][j].paint(g2d);
			}
		}
		
		
	}
	
	private void move() {
		ball.move();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		paddle.mouseDragged(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		paddle.mouseMoved(e);
		
	}
	
	
}
