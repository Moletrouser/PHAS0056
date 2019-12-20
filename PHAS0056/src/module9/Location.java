package module9;

public class Location {
	
	// initialises the x and y coordinate variables
	public int x;
	public int y;
	
	// defines the constructor that takes x and y arguments
	Location(int x, int y){
		
		this.x = x;
		this.y = y;
		
	}
	
	// getter method for x coordinate
	public int getX() {
		return this.x;
	}
	
	 // getter method for y coordinate
	public int getY() {
		return this.y;
	}
	// setter method for x coordinate
	public void setX(int x) {
		this.x = x;
		return;
	}
	// setter method for y coordinate
	public void setY(int y) {
		this.y = y;
		return;
	}
	
	
}
