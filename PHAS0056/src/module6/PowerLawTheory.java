package module6;

public class PowerLawTheory implements Theory {
	
	double nn;
	
	public PowerLawTheory (double n) {
		nn = n; 
	}
	
	// creating a method which will calculate the theoretical Y value for Quadratic theory
	public double y(double x) {
		double y = Math.pow(x, nn);
		return y;
	}

	// creating a method which will return the name of the theory along with the equation used
	public String Name() {
		String theoryName = "PowerLawTheory : ";
		String n = Double.toString(nn);;
		String fullLabel = theoryName +"y = +x^" +n;
		return fullLabel;
	}

}

