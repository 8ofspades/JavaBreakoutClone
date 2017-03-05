//Implements Brick Layout
import java.awt.*;

public class BrickConfiguration {
    
    //location and size variables
    private static final int xStart = 5;
    private static final int yStart = 5;	
    private static final int numCols = 11;
    private static final int numRows = 7;
    private static final int brickHeight = 20;
    private static final int brickWidth = 49;
    
    // 2D array containing brick objects
    private static Brick[][] bricks = new Brick[numCols][numRows];
    
    // 2D array telling us whether the brick should be painted (has it been hit?)
    private static boolean[][] paintBricks = new boolean[numCols][numRows];
    
    // constructor
    public BrickConfiguration() {
		// create new bricks and store them in bricks array
		bricks=new Brick[numCols][numRows];
		int xpos=0;
		int ypos=0;
		for (int i = 0; i < numCols; i++) {
		    for (int j = 0; j < numRows; j++) {
			// initialize paintBricks[i][j]
			paintBricks[i][j]=true;
			// iterate the distance of the blocks and initialize bricks[i][j]
			xpos=xStart+i*(brickWidth+5);
			ypos=yStart+j*(brickHeight+5);
			bricks[i][j]=new Brick(xpos,ypos,brickWidth, brickHeight);
		    }
		}		
    }
    
    // paint the bricks array to the screen
    public void paint(Graphics2D brush) {
		for (int i = 0; i < numCols; i++) {
		    for (int j = 0; j < numRows; j++) {
				// determine if brick should be painted
				// if so, call paintBrick()
				if(paintBricks[i][j]==true){
				    paintBrick(bricks[i][j],brush);
				}
		    }
		}
    }
    
    // paint an individual brick
    public void paintBrick(Brick brick, Graphics2D brush) {
		// call brick's paint method
		brick.paint(brush);
    }
    
    // update paintBricks array for destroyed brick
    public void removeBrick(int row, int col) {
    	paintBricks[row][col]=false;
    }
    
    //Get brick @ row col position
    public Brick getBrick(int row, int col) {
    	return bricks[col][row];
    }
    
    //checks if the brick is to be displayed or not
    public boolean exists(int row, int col) {
    	return paintBricks[col][row];
    }
    
    //Get number of rows
    public int getRows() {
    	return numRows;
    }
    
    //get number of Columns
    public int getCols() {
    	return numCols;
    }
}
