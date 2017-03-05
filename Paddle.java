//Implements paddle class
import java.awt.*;
import java.awt.geom.*;

public class Paddle extends ColorShape{
	
    // location and size variables
    private static int speed;
    private static int xPos;
    private static final int yPos = 450;
    private static final int width = 90;
    private static final int height = 20;
    private static final Rectangle2D.Double shape = new Rectangle2D.Double(0,yPos,width,height);
    
    public Paddle() {
		super(shape);
		// set paddle color
		setFillColor(Color.BLACK);
		setBorderColor(Color.BLACK);
		// set paddle position and speed
		speed=0;
		xPos=300;
    }
    
	// move paddle
    public void move() {
		xPos+=speed;
		// stop the paddle from moving at the edges
		if(xPos<0){
		    speed=0;
		    xPos=0;
		}
		if(xPos>510){
		    speed=0;
		    xPos=510;
		}
		// update shape
		shape.setRect(xPos, yPos, width, height);
    }
    
    //set speed
    public void setSpeed(int newSpeed) {
    	speed = newSpeed;
    }
    
    //get paddle width
    public int getWidth() {
    	return width;
    }
    
    //get paddle height
    public int getHeight() {
    	return height;
    }
    
    //get paddle x pos
    public int getX() {
    	return xPos;
    }
    
    //get paddle shape
    public Rectangle2D.Double getShape() {
    	return shape;
    } 
}
