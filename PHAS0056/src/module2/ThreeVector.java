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
	
    public ThreeVector vectorProduct(ThreeVector v2) {
    	return vectorProduct(this, v2);
    
    }
    
    public double angle(ThreeVector v2) {
    	return angle(this, v2);
    }
    public ThreeVector addVector(ThreeVector v2) {
    	return addVector(this, v2);
    }
    
    public void TestThreeVector(ThreeVector v1, ThreeVector v2) {
    	System.out.println("Vector v1 is: " +v1);
    	System.out.println("Vector v1 is: " +v2);
    	System.out.println("The unit vector of vector v1 is: " +v1.unitVector());
    	System.out.println("The unit vector of vector v2 is: " +v2.unitVector());
    	System.out.println("The following lines use static methods:");
    	System.out.println("The scalar product of v1 and v2 is: " +scalarProduct(v1,v2));
    	System.out.println("The scalar product of v1 and v2 is: " +scalarProduct(v1,v2));
    	
    }
    
    
    
    
	public static void main(String[] args) {
		
		/*
		 * The following commented lines of code were for my testing only
		 * 
		ThreeVector tv1 = new ThreeVector(1, 2, 3);
		ThreeVector tv2 = new ThreeVector(4, 5, 6);	
		System.out.println("The magnitude of the (1,2,3) vector is: " +tv1.magnitude() );
		System.out.println("\n");
		System.out.println("The unit vector of the (1,2,3) vector is: " +tv1.unitVector() );
		System.out.println("\n");
	    System.out.println("(Using the static function) The scalar product of the vector (1,2,3) with (4,5,6) is: " +scalarProduct(tv1, tv2));
	    System.out.println("Testing static add function:" +addVector(tv1,tv2));
	    System.out.println("Testing static angle function :" +angle(tv1,tv2));
	    System.out.println("Testing static vectorProduct function: " +vectorProduct(tv1,tv2));
	    System.out.println("\n");
	    System.out.println("(Using the non-static function) The scalar product of the vector (1,2,3) with (4,5,6) is: " +tv1.scalarProduct(tv2));
	    System.out.println("(Using the non-static function) The vector product of the vector (1,2,3) with (4,5,6) is: " +tv1.vectorProduct(tv2));
	    System.out.println("(Using the non-static function) The angle between the vector (1,2,3) and (4,5,6) is: " +tv1.angle(tv2));
	    System.out.println("(Using the non-static function) Adding vector (1,2,3) to vector (4,5,6) gives: " +tv1.addVector(tv2));
	     * 
	     */
		
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		System.out.println("Vector v1 is: " +v1);
    	System.out.println("Vector v2 is: " +v2);
    	System.out.println("Vector v3 is: " +v3);
    	System.out.println("\n");
    	
    	System.out.println("The unit vector of vector v1 is: " +v1.unitVector());
    	System.out.println("The unit vector of vector v2 is: " +v2.unitVector());
    	System.out.println("The unit vector of vector v3 is: " +v3.unitVector());
    	System.out.println("\n");
    	
    	System.out.println("(STATIC) The scalar product of v1 and v2 is: " +scalarProduct(v1,v2));
    	System.out.println("(STATIC) The scalar product of v1 and v3 is: " +scalarProduct(v1,v3));
    	System.out.println("(STATIC) The vector product of v1 and v2 is: " +vectorProduct(v1,v2));
    	System.out.println("(STATIC) The vector product of v1 and v3 is: " +vectorProduct(v1,v3));
    	System.out.println("(STATIC) The angle between v1 and v2 is: " +angle(v1,v2));
     	System.out.println("(STATIC) The angle between v1 and v3 is: " +angle(v1,v3));
     	System.out.println("\n");
    	
    	System.out.println("(NON-STATIC) The scalar product of v1 and v2 is: " +v1.scalarProduct(v2));
    	System.out.println("(NON-STATIC) The scalar product of v1 and v3 is: " +v1.scalarProduct(v3));
    	System.out.println("(NON-STATIC) The vector product of v1 and v2 is: " +v1.vectorProduct(v2));
    	System.out.println("(NON-STATIC) The vector product of v1 and v3 is: " +v1.vectorProduct(v3));
    	System.out.println("(NON-STATIC) The angle between v1 and v2 is: " +v1.angle(v2));
     	System.out.println("(NON-STATIC) The angle between v1 and v3 is: " +v1.angle(v3));
    	System.out.println("\n");
    	
		System.out.println("If we comment out the toString method and then try and print vector v1 we get the output: ThreeVector@34c45dca");
		System.out.println("This is because java already has a definition of the toString function built into it, and unless we specify a different definition it will default to it's built in definition.");
		System.out.println("34c45dca is a hexidecimal number, probably refering to the memory address at which the v1 variable is stored in the stack.");
		System.out.println("Since java does not now how to print the format of number we have given it, it seems to instead default to printing the memory address at which the variable is stored");
	}
	

}
