package module3;

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
	// calculates the magnitude of the 3 vector passed to it
	public double magnitude() {
		double magnitudeOutput;
		magnitudeOutput = Math.sqrt((x*x)+(y*y)+(z*z));
		return magnitudeOutput;
	
	}
	
	// calculates the unit vector of the three vector passed to it
	public ThreeVector unitVector() throws Exception {
		if (x == 0 && y == 0 && z == 0) {
			throw new Exception("The zero vector has no direction and it's modulus is zero, therefore it's unitvector cannot be determined");
		}
		ThreeVector unit = new ThreeVector(x/magnitude(), y/magnitude(), z/magnitude());
		return unit;
	}
	
	// calculates the sum of two vectors (static version)
	public  static ThreeVector addVector(ThreeVector vector1, ThreeVector vector2) {
		ThreeVector newVector = new ThreeVector(vector1.x+vector2.x, vector1.y+vector2.y, vector1.z+vector2.z);
		return newVector;
	
    }
	
	// calculates the angle between two three vectors (static version)
	public static double angle(ThreeVector vector1, ThreeVector vector2) throws Exception{
		if (vector2.x == 0 && vector2.y == 0 && vector2.z == 0) {
			throw new Exception("Cannot find the angle between two vectors if one is the zero vector (Change vector 2 to a non-zero vector)");
		}
		if (vector1.x == 0 && vector1.y == 0 && vector1.z == 0) {
			throw new Exception("Cannot find the angle between two vectors if one is the zero vector (Change vector 1 to a non-zero vector)");
		}
		double angleOutput;
		angleOutput = Math.toDegrees(Math.acos(scalarProduct(vector1, vector2)/(vector1.magnitude()*vector2.magnitude())));
		return angleOutput;
	
	}
	
	// overwrites the java toString function to tell it how to print vectors legibly 
	public String toString() {
		String xString = Double.toString(x);
		String yString = Double.toString(y);
		String zString = Double.toString(z);
		String stringVector = "(" + xString + ", " + yString + ", " + zString + ")";
		return stringVector;
	
	}
	
	// calculates the scalar product of the two three vectors passed to it (static version)
	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2) {
		double scalarOutput;
		scalarOutput = vector1.x*vector2.x + vector1.y*vector2.y + vector1.z*vector2.z;
		return scalarOutput;
	
	}
	
	// calculates the scalar product of the two three vectors passed to it (non-static version)
	public double scalarProduct(ThreeVector v2) {
		return scalarProduct(this,v2);
	}
	
	// calculates the vector product of the two three vectors passed to it (static version)
    public static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2) {
    	double vectorOutputx = (vector1.y*vector2.z)-(vector1.z*vector2.y);
    	double vectorOutputy = (vector1.z*vector2.x)-(vector1.x*vector2.z);
    	double vectorOutputz = (vector1.x*vector2.y)-(vector1.y*vector2.x);
    	ThreeVector vectorOutput = new ThreeVector(vectorOutputx, vectorOutputy, vectorOutputz);
    	return vectorOutput;
    	
    }
	
    // calculates the vector product of the two three vectors passed to it (non-static version)
    public ThreeVector vectorProduct(ThreeVector v2) {
    	return vectorProduct(this, v2);
    
    }
    // calculates the angle between the two three vectors passed to it (non-static version)
    public double angle(ThreeVector v2) throws Exception  {
    if (this.x == 0 && this.y == 0 && this.z == 0) {
		throw new Exception("Cannot find the angle between two vectors if one is the zero vector (Change vector 1 to a non-zero vector)");
	}
	if (v2.x == 0 && v2.y == 0 && v2.z == 0) {
		throw new Exception("Cannot find the angle between two vectors if one is the zero vector (Change vector 2 to a non-zero vector)");
	}	
	return angle(this, v2);
	}
    
    
    // calculates the sum of the two three vectors passed to it (non-static version)
    public ThreeVector addVector(ThreeVector v2) {
    	return addVector(this, v2);
    }
    	
  
    
    
    
    
	public static void main(String[] args) {
		
		
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		
		// testing how the static unitVector method responds to receiving the zero vector as the input
		System.out.println("Testing how the static unitVector method responds to a zero input");
		try {
			System.out.println(v3.unitVector());
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		
		// testing how the static angle method responds to receiving the zero vector as one of the inputs
		System.out.println("Testing how the static angle method responds to a zero input");
		try {
			System.out.println(angle(v3,v1));
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		
		// testing how the non-static angle method responds to receiving the zero vector as the input
		System.out.println("Testing how the non-static angle method responds to a zero input");
		try {
			System.out.println(v3.angle(v1));
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		
		
		
		/*
		
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
		*/
	
	}
	

}
