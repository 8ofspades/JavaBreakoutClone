//Implements Breakout Game
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Breakout {
    public static void main(String[] args) {
	//Initializes the JFrame and calls the game panel
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(600,500);
        frame.setTitle("Breakout");
        frame.setResizable(false);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
    
    //GamePanel Class
    private static class GamePanel extends JPanel {
		private static final long serialVersionUID = 1L;
		Ball ball;
		Paddle paddle;
		BrickConfiguration bconfig;
		Timer timer;
		public GamePanel() {
		    super();
		    // call initializeGameObjects()
		    initializeGameObjects();
		    // add PaddleMover as a keyListener
		    addKeyListener(new PaddleMover());
		    setFocusable(true);		
		}
		
	    // instantiate ball, paddle, and brick configuration
		public void initializeGameObjects() {
		    ball=new Ball();
		    paddle=new Paddle();
		    bconfig=new BrickConfiguration();
		    // set up timer to run GameMotion() every 10ms
		    timer = new Timer(10, new GameMotion());
		    timer.start();
		}
		
		//Override java.swing paintComponent
		@Override
		public void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    Graphics2D g2 = (Graphics2D)g;
		    // paint ball, paddle, and brick configuration
		    paddle.paint(g2);
		    ball.paint(g2);
		    bconfig.paint(g2);
		}
		
		//Keep track of Paddle and Ball movements
		private class GameMotion implements ActionListener {
		    public GameMotion(){}
		    public void actionPerformed(ActionEvent evt) {
			//move ball automatically
			ball.move();
			//move paddle according to key press
			paddle.move();
			//check if the ball hits the paddle or a brick
			checkForHit();
			//call repaint
			repaint();
		    }
		}
		
		//Move paddle when arrow keys are pressed
		private class PaddleMover implements KeyListener{
		    public void keyPressed(KeyEvent evt){
				int key=evt.getKeyCode();
				//reverses the speed of the paddle depending on which key is pressed
				if(key==KeyEvent.VK_LEFT){
				    paddle.setSpeed(-4);
				}
				if(key==KeyEvent.VK_RIGHT){
				    paddle.setSpeed(4);
				}
		    }
		    
		    //stops the paddle when the key is released
		    public void keyReleased(KeyEvent evt){
		    	paddle.setSpeed(0);
		    }
		    public void keyTyped(KeyEvent evt){}
		}
		
		//Check collisions
		public void checkForHit() {
		    
		    // change ball speed when ball hits paddle
		    if (ball.getShape().intersects(paddle.getShape())) {
				int leftSide = paddle.getX();
				int middleLeft = paddle.getX() + (int)(paddle.getWidth()/3);
				int middleRight = paddle.getX() + (int)(2*paddle.getWidth()/3);
				int rightSide = paddle.getX() + paddle.getWidth();
		
				if ((ball.getX() >= leftSide) && (ball.getX() < middleLeft)) {
				    // Bounces the ball to the left if it hits the left side of the paddle
				    ball.setXspeed(-2);
				    ball.setYspeed(-2);
				}
				if ((ball.getX() >= middleLeft) && (ball.getX() <= middleRight)) {
				    // Bounces the ball upwards if it hits the center of the paddle
				    ball.setXspeed(0);
				    ball.setYspeed(-2);
				}
				if ((ball.getX() > middleRight) && (ball.getX() <= rightSide)) {
				    // Bounces the ball to the right if it hits the right side of the paddle
				    ball.setXspeed(2);
				    ball.setYspeed(-2);
				}
		    }
		    
		    // change ball speed when ball hits brick
		    for (int i = 0; i < bconfig.getRows(); i++) {
				for (int j = 0; j < bconfig.getCols(); j++) {
				    if (bconfig.exists(i,j)) {
						if (ball.getShape().intersects(bconfig.getBrick(i,j).getShape())) {
							
						    //create 4 points on the edge of the circle 
						    Point ballLeft = new Point((int)ball.getShape().getX(), (int)(ball.getShape().getY() + ball.getShape().getHeight()/2));
						    Point ballRight = new Point((int)(ball.getShape().getX() + ball.getShape().getWidth()), (int)(ball.getShape().getY() + ball.getShape().getHeight()/2));
						    Point ballTop = new Point((int)(ball.getShape().getX() + ball.getShape().getWidth()/2), (int)ball.getShape().getY());
						    Point ballBottom = new Point((int)(ball.getShape().getX() + ball.getShape().getWidth()/2), (int)(ball.getShape().getY() + ball.getShape().getHeight()));
						   
						    //bounces the ball to the right
						    if (bconfig.getBrick(i,j).getShape().contains(ballLeft)) {
						    	ball.setXspeed(2);
						    }
						    
						    //bounces the ball to the left
						    if (bconfig.getBrick(i,j).getShape().contains(ballRight)) {
						    	ball.setXspeed(-2);
						    }
						    
						    //bounces the ball downwards
						    if (bconfig.getBrick(i,j).getShape().contains(ballTop)) {
								ball.setXspeed(ball.getxSpeed());
								ball.setYspeed(2);
						    }
						    
						    //bounces the ball upwards
						    if (bconfig.getBrick(i,j).getShape().contains(ballBottom)) {
								ball.setXspeed(-ball.getxSpeed());
								ball.setYspeed(2);
						    }
						    
						    // remove brick
						    bconfig.removeBrick(j,i);
						}
				    }
				}
		    }
		}
    }
}
