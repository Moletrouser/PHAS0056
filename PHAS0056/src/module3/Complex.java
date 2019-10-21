package module3;

public class Complex {

	double real;
	double imag;
	
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
		
	}
	
	// defines how java should return the real part of a complex number
	public double real() {
		return real;
	}
	
	// defines how java should return the imaginary part of a complex number
	public double imag() {
		return imag;
	}
	
	// returns the modulus of the complex number passed to it
	public double modulus() {
		double modulusOutput = Math.sqrt(real*real + imag*imag);
		return modulusOutput;
	}
	
	// gives the argument of a complex number in degrees
	public double argument() {
		double angle = Math.toDegrees(Math.acos(real/imag));
		return angle;
	}
	
	// returns the complex conjugate of the complex number passed to it
	public Complex conjugate() {
		Complex conj = new Complex(real, -imag);
		return conj;
	}
	
	// normalises the complex number passed to it
	public Complex normalised() throws Exception{
		if (modulus()==0) {
			throw new Exception("Cannot normalise a complex number with modulus zero");
		}
		Complex norm = new Complex(real/modulus(), imag/modulus());
		return norm;
	}
	
	// returns true or false depending on whether the two complex numbers passed to it match
	public boolean equals(Complex c) {
		if (c.real == this.real && c.imag == this.imag) {  
		return true;
	}
		return false;
    }
	
	
	// takes the modulus and argument and outputs the complex number they corespond to, ang is given in degrees
	public static Complex setFromModulusAngle(double mag, double ang) {
		double real = Math.cos(Math.toRadians(ang))*mag;
		double imag = Math.sin(Math.toRadians(ang))*mag;
		Complex complex1 = new Complex(real,imag);
		return complex1;
	}
	
	// adds the two complex numbers passed to it
	public static Complex add(Complex c1, Complex c2) {
		Complex newc = new Complex(c1.real + c2.real, c1.imag + c2.imag);
		return newc;
		
	}
	
	// subtracts the two complex numbers passed to it, subtracts c2 from c1
	public static Complex subtract(Complex c1, Complex c2) {
		Complex newc = new Complex(c1.real - c2.real, c1.imag - c2.imag);
		return newc;
	}
	
	// multiplies the two complex numbers passed to it
	public static Complex multiply(Complex c1, Complex c2) {
		double newreal = (c1.real*c2.real) - (c1.imag*c2.imag);
		double newimag = (c1.real*c2.imag) + (c2.real*c1.imag);
		Complex newcomplex = new Complex(newreal, newimag);
		return newcomplex;
	}
	
	// divides the complex number c1 by c2
	public static Complex divide(Complex c1, Complex c2) throws Exception {
		Complex ZERO = new Complex(0,0);
		if (c2.real == 0 && c2.imag == 0) { 
				throw new Exception("Cannot divide by zero");
		}
		
		double realnumerator = c1.real*c2.real + c1.imag*c2.imag;
		double imagnumerator = c2.real*c1.imag - c1.real*c2.imag;
		double denominator = c2.real*c2.real + c2.imag*c2.imag;
		Complex newcomplex = new Complex(realnumerator/denominator, imagnumerator/denominator);
		return newcomplex;
	}
	
	
	
	// tells java how to display complex numbers as strings
	public String toString() {
		String realString = Double.toString(real);
		String imagString = Double.toString(imag);
		String stringComplex = "(" + realString + ", " + imagString + "i" +")";
		return stringComplex;
	}
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		
		Complex ONE = new Complex(1,0);
		Complex ZERO = new Complex(0,0);
		Complex I = new Complex(0,1);
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(-2,1);
	
		// testing what happens if we divide by zero
		try {
			System.out.println(divide(c1,ZERO));
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		
		// testing what happens if we try to normalise the zero vector
		try {
			System.out.println(ZERO.normalised());
		}
		catch(Exception e) {
			System.out.println("Error: " +e.getMessage());
		}
		
		
		/*
		 * 
		System.out.println("The product of c1 and c2 is: " +multiply(c1,c2));
		System.out.println("The ratio of c1 to c2 is: " +divide(c1,c2));
		System.out.println("The  product of c1 and I: " +multiply(c1,I));
		System.out.println("The ratio of c1 to zero is: " +divide(c1,ZERO));
		System.out.println("The product of c1 with its conjugate is: " +multiply(c1,c1.conjugate()));
		System.out.println("The product of c2 with its conjugate is: " +multiply(c2,c2.conjugate()));
		
		*/
		
		
		
	}

}
