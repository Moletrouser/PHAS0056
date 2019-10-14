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
	
	public static Complex add(Complex c1, Complex c2) {
		Complex newc = new Complex(c1.real + c2.real, c1.imag + c2.imag);
		return newc;
		
	}
	
	public static Complex subtract(Complex c1, Complex c2) {
		Complex newc = new Complex(c1.real - c2.real, c1.imag - c2.imag);
		return newc;
	}
	
	public static Complex multiply(Complex c1, Complex c2) {
		double newreal = (c1.real*c2.real) - (c1.imag*c2.imag);
		double newimag = (c1.real*c2.imag) + (c2.real*c1.imag);
		Complex newcomplex = new Complex(newreal, newimag);
		return newcomplex;
	}
	
	// c1 divided by c2
	public static Complex divide(Complex c1, Complex c2) {
		double realnumerator = c1.real*c2.real + c1.imag*c2.imag;
		double imagnumerator = c2.real*c1.imag - c1.real*c2.imag;
		double denominator = c2.real*c2.real + c2.imag*c2.imag;
		Complex newcomplex = new Complex(realnumerator/denominator, imagnumerator/denominator);
		return newcomplex;
	}
	
	
	
	
	public String toString() {
		String realString = Double.toString(real);
		String imagString = Double.toString(imag);
		String stringComplex = "(" + realString + ", " + imagString + "i" +")";
		return stringComplex;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		
		
		Complex ONE = new Complex(1,0);
		Complex ZERO = new Complex(0,0);
		Complex I = new Complex(0,1);
		Complex c1 = new Complex(1,-2);
		Complex c2 = new Complex(-2,1);
		
		
		
		/* 
		 * The following commented out code is for my testing only
		 * 
		Complex i1 = new Complex(1,2);
		Complex i2 = new Complex(3,4);
		System.out.println(i1.argument());
		System.out.println(i1.equals(i2));
		System.out.println(setFromModulusAngle(3, 45));
		System.out.println("1,2 plus 3,4 is: " +add(i1,i2));
		System.out.println("1,2 minus 3,4 is: " +subtract(i1,i2));
		System.out.println("1,2 multiplied by 3,4 is: " +multiply(i1,i2));
		System.out.println("1,2 divided by 3,4 is: " +divide(i1,i2));
		*/
		
		System.out.println("The product of c1 and c2 is: " +multiply(c1,c2));
		System.out.println("The ratio of c1 to c2 is: " +divide(c1,c2));
		System.out.println("The  product of c1 and I: " +multiply(c1,I));
		System.out.println("The ratio of c1 to zero is: " +divide(c1,ZERO));
		System.out.println("The product of c1 with its conjugate is: " +multiply(c1,c1.conjugate()));
		System.out.println("The product of c2 with its conjugate is: " +multiply(c2,c2.conjugate()));
		
		
		
		
		
	}

}
