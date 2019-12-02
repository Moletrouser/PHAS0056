package module6;

public class LabelledDataPoint extends DataPoint {

	String label;
	
	public LabelledDataPoint(double x, double y, double ey, String label) {
		super(x, y, ey);
	}
	
	public String getLabel() {
		return label;
	}
	
	
	public String toString() {
		return "x = "+x+" y = "+y+" ey = "+ey+" label = "+label;
	}
}