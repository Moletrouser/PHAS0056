package module1;
import java.lang.Math.*;

public class VectorMethods {
	public VectorMethods() { }
	
	public double dotProduct(double x, double y, double z, double a, double b, double c) {
	double dotOutput;
	dotOutput = (x*a)+(y*b)+(z*c);
	return dotOutput;
	
	}
	
	public static void main(String[] args) {
	
	VectorMethods vm = new VectorMethods();
	System.out.println("The dot product of the vectors (1,2,3) and (4,5,6) is:" +vm.dotProduct(1,2,3,4,5,6));
	System.out.println("\n");	
	
		
		
		
	}

}
