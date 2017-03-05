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
    public void move() {
	// move ball
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
    public void setXspeed(int newSpeed) {
	xSpeed = newSpeed;
    }
    public void setYspeed(int newSpeed) {
	ySpeed = newSpeed;
    }
    public int getX() {
	return xPos;
    }
    public int getY() {
	return yPos;
    }
    public int getWidth() {
	return width;
    }
    public int getHeight() {
	return height;
    }
    public int getxSpeed(){
	return xSpeed;
    }
    public int getySpeed(){
	return ySpeed;
    }
    public Ellipse2D.Double getShape() {
	return shape;
    }
}
