//Implements Ball Class
import java.awt.geom.*;
import java.awt.*;

public class Ball extends ColorShape {	
    // location and size variables
    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;
    private static final int height = 10;
    private static final int width = 10;
    private static final Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width, height);
    
    // constructor
    public Ball() {
		super(shape);
		// set ball color
		super.setFillColor(Color.RED);
		super.setBorderColor(Color.RED);
		// set initial values for x and y position and speed
		xPos=300;
		yPos=450;
		xSpeed=0;
		ySpeed=2;
    }
    
    //move ball
    public void move() {
		xPos+=xSpeed;
		yPos+=ySpeed;
		// detect if ball should bounce off an edge
		if(xPos==0||xPos==600){
		    setXspeed(-xSpeed);
		}
		if(yPos<0){
		    setYspeed(-ySpeed);
		}
		// update shape to new values
		shape.setFrame(xPos, yPos, width, height);
    }
    
    //Set xSpeed
    public void setXspeed(int newSpeed) {
    	xSpeed = newSpeed;
    }
    
    //Set ySpeed
    public void setYspeed(int newSpeed) {
    	ySpeed = newSpeed;
    }
    
    //get x position
    public int getX() {
    	return xPos;
    }
    
    //get y position
    public int getY() {
    	return yPos;
    }
    
    //get ball width
    public int getWidth() {
    	return width;
    }
    
    //get ball height
    public int getHeight() {
    	return height;
    }
    
    //get xSpeed
    public int getxSpeed(){
    	return xSpeed;
    }
    
    //get ySpeed
    public int getySpeed(){
    	return ySpeed;
    }
    
    //get Shape type
    public Ellipse2D.Double getShape() {
    	return shape;
    }
}
