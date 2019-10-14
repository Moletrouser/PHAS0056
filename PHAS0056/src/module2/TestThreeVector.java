package module2;

public class TestThreeVector {
	
	// calculates the scalar product of the two three vectors passed to it (static version)
	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2) {
		double scalarOutput;
		scalarOutput = vector1.x*vector2.x + vector1.y*vector2.y + vector1.z*vector2.z;
		return scalarOutput;
	
	}
	 // calculates the vector product of the two three vectors passed to it (static version)
	 public static ThreeVector vectorProduct(ThreeVector vector1, ThreeVector vector2) {
	    	double vectorOutputx = (vector1.y*vector2.z)-(vector1.z*vector2.y);
	    	double vectorOutputy = (vector1.z*vector2.x)-(vector1.x*vector2.z);
	    	double vectorOutputz = (vector1.x*vector2.y)-(vector1.y*vector2.x);
	    	ThreeVector vectorOutput = new ThreeVector(vectorOutputx, vectorOutputy, vectorOutputz);
	    	return vectorOutput;
	    	
	}
	 
	// calculates the angle between two three vectors (static version)
	public static double angle(ThreeVector vector1, ThreeVector vector2) {
		double angleOutput;
		angleOutput = Math.toDegrees(Math.acos(scalarProduct(vector1, vector2)/(vector1.magnitude()*vector2.magnitude())));
		return angleOutput;
	
	}
	

	public static void main(String[] args) {
		
		
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


