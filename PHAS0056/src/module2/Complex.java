package module2;

public class Complex {

	double real;
	double imag;
	
	
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
		
	}
	
	public double real() {
		return real;
	}
	
	public double imag() {
		return imag;
	}
	
	public double modulus() {
		double modulusOutput = Math.sqrt(real*real + imag*imag);
		return modulusOutput;
	}
	
	// gives the argument of a complex number in degrees
	public double argument() {
		double angle = Math.toDegrees(Math.acos(real/imag));
		return angle;
	}
	
	public Complex conjugate() {
		Complex conj = new Complex(real, -imag);
		return conj;
	}
	
	public Complex normalised() {
		Complex norm = new Complex(real/modulus(), imag/modulus());
		return norm;
	}
	
	public boolean equals(Complex c) {
		if (c.real == this.real && c.imag == this.imag) {  
		return true;
	}
		return false;
    }
	
	// ang is given in degrees
	public static Complex setFromModulusAngle(double mag, double ang) {
		double real = Math.cos(Math.toRadians(ang))*mag;
		double imag = Math.sin(Math.toRadians(ang))*mag;
		Complex complex1 = new Complex(real,imag);
		return complex1;
	}
	
	public String toString() {
		String realString = Double.toString(real);
		String imagString = Double.toString(imag);
		String stringComplex = "(" + realString + ", " + imagString + ")";
		return stringComplex;
	}
	
	public static void main(String[] args) {
		
		Complex i1 = new Complex(1,2);
		Complex i2 = new Complex(1,2);
		
		// testing
		System.out.println(i1.argument());
		System.out.println(i1.equals(i2));
		System.out.println(setFromModulusAngle(3, 45));
	}

}
