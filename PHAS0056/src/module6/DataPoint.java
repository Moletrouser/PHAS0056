package module6;

public class DataPoint {

	double x;
	double y;
	double ey;
	
	public DataPoint(double x, double y, double ey) {
	x = this.x;
	y = this.ey;
	ey = this.ey;
	}
	
	// gets the x value
	public double getX() {
		return x;
	}
	// gets the y value
	public double getY() {
		return y;
	}
	// gets the error on the y value
	public double getEY() {
		return ey;
	}
	
	public String toString() {
		return "x = "+x+" y = "+y+" ey = "+ey;
	}
}