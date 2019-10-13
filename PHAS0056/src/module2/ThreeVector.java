package module2;

public class ThreeVector {
	
	double x;
	double y;
    double z;
    double a;
    double b;
    double c;
	
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
	
	public  static ThreeVector addVector(ThreeVector vector1, ThreeVector vector2) {
		ThreeVector newVector = new ThreeVector(vector1.x+vector2.x, vector1.y+vector2.y, vector1.z+vector2.z);
		return newVector;
	
    }
	
	public static double angle(ThreeVector vector1, ThreeVector vector2) {
		double angleOutput;
		angleOutput = Math.toDegrees(Math.acos(scalarProduct(vector1, vector2)/(vector1.magnitude()*vector2.magnitude())));
		return angleOutput;
	
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
	
    public static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2) {
    	double vectorOutputx = (vector1.y*vector2.z)-(vector1.z*vector2.y);
    	double vectorOutputy = (vector1.z*vector2.x)-(vector1.x*vector2.z);
    	double vectorOutputz = (vector1.x*vector2.y)-(vector1.y*vector2.x);
    	ThreeVector vectorOutput = new ThreeVector(vectorOutputx, vectorOutputy, vectorOutputz);
    	return vectorOutput;
    }
	
	public static void main(String[] args) {
		
		ThreeVector tv1 = new ThreeVector(1, 2, 3);
		ThreeVector tv2 = new ThreeVector(4, 5, 6);
			
		System.out.println("The magnitude of the (1,2,3) vector is: " +tv1.magnitude() );
		System.out.println("\n");
		
		System.out.println("The unit vector of the (1,2,3) vector is: " +tv1.unitVector() );
		System.out.println("\n");
	    
	    System.out.println("(Using the static function) The scalar product of the vector (1,2,3) with (4,5,6) is: " +scalarProduct(tv1, tv2));
	    System.out.println("(Using the non-static function) The scalar product of the vector (1,2,3) with (4,5,6) is: " +tv1.scalarProduct(tv2));
	    
	    System.out.println("Testing static add function:" +addVector(tv1,tv2));
	    System.out.println("Testing static angle function:" +angle(tv1,tv2));
	    System.out.println("Testing static vectorProduct function:" +vectorProduct(tv1,tv2));
	}

}
