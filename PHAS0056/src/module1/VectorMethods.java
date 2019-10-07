package module1;
import java.lang.Math.*;  

// defines the vectorMethods class
public class VectorMethods {
	public VectorMethods() { }
	
	// defines the dot product function, taking inputs as doubles in the 
	 // form of two 3D vectors and outputting a single number of type double
	public double dotProduct(double x, double y, double z, double a, double b, double c) {
		double dotOutput;
		dotOutput = (x*a)+(y*b)+(z*c);
		return dotOutput;
	}
	
	// defines the magnitude function, taking as an input one 3D vector 
	// and outputting a single number of type double 
	public double magnitude(double x, double y, double z) {
	double magnitudeOutput;
	magnitudeOutput = Math.sqrt((x*x)+(y*y)+(z*z));
	return magnitudeOutput;
	}
	
	// defines the angle function, taking as inputs two 3D vectors
	// and outputting the smaller of the two angles (<180) between them in degrees
	public double angle(double x, double y, double z, double a, double b, double c) {
	double angleOutput;
	angleOutput = Math.toDegrees(Math.acos((dotProduct(x,y,z,a,b,c)/(magnitude(x,y,z)*magnitude(a,b,c)))));
	return angleOutput;
	
		
	}


	
	public static void main(String[] args) {
	
	// defines a new object of the vectormethods class with the prefix vm
	VectorMethods vm = new VectorMethods();
	
	// tests the dot product function on two vectors
	System.out.println("The dot product of the vectors (1,2,3) and (4,5,6) is: " +vm.dotProduct(1,2,3,4,5,6));
	System.out.println("\n");	
	
	// tests the magnitude function on two vectors
	System.out.println("The magnitude of the vector (1,2,3) is: " +vm.magnitude(1, 2, 3));
	System.out.println("\n");	
	
	// tests the angle function on two vectors
	System.out.println("The angle between the vectors (4,3,2) and (1,5,4) in degrees is: " +vm.angle(4,3,2,1,5,4));
	System.out.println("The angle between the vectors (4,3,2) and (0,0,0) in degrees is: " +vm.angle(4,3,2,0,0,0));
	System.out.println("The angle is given as 'NaN' since (0,0,0) is the zero vector, since it has no length or direction the angle between it and any other vector cannot be defined");
	System.out.println("\n");
	}

}
