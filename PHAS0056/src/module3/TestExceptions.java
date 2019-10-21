package module3;

import module3.Complex;


	
	
public class TestExceptions {

	// divides the complex number c1 by c2
	public static Complex divide(Complex c1, Complex c2) throws Exception {
		Complex ZERO = new Complex(0,0);
		if (c1.real == 0 && c1.imag == 0) {
			return ZERO;
		}
		if (c2.real == 0 && c2.imag == 0) {
			throw new Exception("Cannot divide a non zero number by zero");
		}
		double realnumerator = c1.real*c2.real + c1.imag*c2.imag;
		double imagnumerator = c2.real*c1.imag - c1.real*c2.imag;
		double denominator = c2.real*c2.real + c2.imag*c2.imag;
		Complex newcomplex = new Complex(realnumerator/denominator, imagnumerator/denominator);
		return newcomplex;
	}
	
	public static double scalarProduct(ThreeVector vector1, ThreeVector vector2) {
		double scalarOutput;
		scalarOutput = vector1.x*vector2.x + vector1.y*vector2.y + vector1.z*vector2.z;
		return scalarOutput;
	
	}
	
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
	
	
	
	
	
	
	public static void main(String[] args) {

		Complex ZERO = new Complex(0,0);
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(-2,1);
		
		ThreeVector v1 = new ThreeVector(4,5,3);
		ThreeVector v2 = new ThreeVector(1,4,2);
		ThreeVector v3 = new ThreeVector(0,0,0);
		
		System.out.println("Testing how the complex divide method responds to dividing by zero");
		try {
			System.out.println("(1 - 2i) divided by (0 + 0i) equals:" +divide(c1,ZERO));
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		System.out.println("Testing how the complex divide method responds to dividing zero by a non-zero number");
		try {
			System.out.println("(0 + 0i) divided by (1 - 2i) equals: " +divide(ZERO,c1));
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		
		System.out.println("Testing how normalised method responds to a request to normalise the complex number (0 + 0i)");
		try {
			System.out.println(ZERO.normalised());
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		
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
		
		System.out.println("Testing how particle drop method responds to a negative mass particle");
		try {
			double m = -2;
			double d = 3;
			double h = 2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(0.001);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		System.out.println("Testing how particle drop method responds to a negative drag");
		try {
			double m = 2;
			double d = -3;
			double h = 2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(0.001);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		System.out.println("Testing how particle drop method responds to a negative particle height");
		try {
			double m = 2;
			double d = 3;
			double h = -2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(0.002);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		System.out.println("\n");
		
		System.out.println("Testing how particle drop method responds to a negative time step");
		try {
			double m = 2;
			double d = 3;
			double h = 2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(-0.001);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		System.out.println("Testing how particle drop method responds to multiple unphysical values");
		try {
			double m = 2;
			double d = 3;
			double h = 2;
			FallingParticle newparticle = new FallingParticle (m,d, h);
			newparticle.drop(-0.001);
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
	}
}
