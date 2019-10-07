package module2;

public class ThreeVector {
	
	double x;
	double y;
	double z;
	
	public ThreeVector(double x, double y, double z) {
		this.x = x; 
		this.y = y;
		this.z = z;
	}
	
	
	
	
		public double magnitude() {
		
			double magnitudeOutput;
			magnitudeOutput = Math.sqrt((x*x)+(y*y)+(z*z));
			return magnitudeOutput;
	
	}
		public ThreeVector unitVector() {
			ThreeVector unit = new ThreeVector(x/magnitude(), y/magnitude(), z/magnitude());
			return unit;
	}
		public String toString() {
			String xString = Double.toString(x);
			String yString = Double.toString(y);
			String zString = Double.toString(z);
			String stringVector = "(" + xString + ", " + yString + ", " + zString + ")";
			return stringVector;
	}

	
	
	public static void main(String[] args) {
		
		ThreeVector tv = new ThreeVector(1, 2, 3);
	
		System.out.println("The magnitude of the (1,2,3) vector is: " +tv.magnitude() );
		System.out.println("\n");
		
		System.out.println("The unit vector of the (1,2,3) vector is: " +tv.unitVector() );
		System.out.println("\n");
		
		System.out.println("The original vector is: " +tv );
	    System.out.println("\n");
	 
	}

}
