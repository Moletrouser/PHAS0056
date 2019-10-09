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

	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2) {
		double scalarOutput;
		scalarOutput = vector1.x*vector2.x + vector1.y*vector2.y + vector1.z*vector2.z;
		return scalarOutput;
	
	}
	
	public double scalarProduct(ThreeVector v2) {
	
		return scalarProduct(this,v2);
	}
	
  //  public ThreeVector vectorProduct(ThreeVector vector2) {
  //  double vectorOutputx = (y*c)-(z*b);
  //  double vectorOutputy = (z*a)-(x*c);
  //  double vectorOutputz = (x*b)-(y*a);
  // ThreeVector vectorOutput = new ThreeVector(vectorOutputx, vectorOutputy, vectorOutputz);
  //  return vectorOutput;
  // }
	
	public static void main(String[] args) {
		
		ThreeVector tv1 = new ThreeVector(1, 2, 3);
		ThreeVector tv2 = new ThreeVector(4, 5, 6);
		double answer = tv1.scalarProduct(tv2);
	
		System.out.println("The magnitude of the (1,2,3) vector is: " +tv1.magnitude() );
		System.out.println("\n");
		
		System.out.println("The unit vector of the (1,2,3) vector is: " +tv1.unitVector() );
		System.out.println("\n");
		
		System.out.println("The original vector is: " +tv1 );
	    System.out.println("\n");
	    
	  //  System.out.println(tv.vectorProduct(1,2,3,4,5,6));
	    
	    double x = 1;
	    double y = 2;
	    double z = 3;
	    double a = 4;
	    double b = 5;
	    double c = 6;
	    
	 //   System.out.println("(Using the static function) The scalar product of the vector (1,2,3) is: " +tv1.scalarProduct());
	 
	}

}
