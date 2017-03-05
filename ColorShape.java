//Basic abstract class for Ball, Paddle & Brick classes
import java.awt.*;
import java.awt.geom.*;

//Color shape class
public abstract class ColorShape{
    protected RectangularShape shape;
    private Color fillColor;
    private Color borderColor;
    
    //Defines object shape
    public ColorShape(RectangularShape s) {
    	shape = s;
    }
    
    //Set current location
    public void setLocation(double x, double y) {
    	shape.setFrame(x, y, shape.getWidth(), shape.getHeight());
    }
    
    //set Shape size
    public void setSize(double w, double h) {
    	shape.setFrame(shape.getX(), shape.getY(), w, h);
    }
    
    //Set interior color
    public void setFillColor(Color color) {
    	fillColor = color;
    }
    
    //get interior color
    public Color getFillColor() {
    	return fillColor;
    }
    
    //set border color
    public void setBorderColor(Color color) {
    	borderColor = color;
    }
    
    //get border color
    public Color getBorderColor() {
    	return borderColor;
    }
    
    //draw object to screen
    public void paint(Graphics2D brush) {
		brush.setColor(borderColor);
		brush.draw(shape);
		brush.setColor(fillColor);
		brush.fill(shape);
    }
}
