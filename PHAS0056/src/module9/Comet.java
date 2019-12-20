package module9;

import java.awt.Color;

public class Comet {
	
	// initialises the variables to be used later on
	public double eccentricity;
	public String name;
	public int majorAx;
	public int minorAx;
	public Color colour;
	public double period;
	public Location centreOfOrbit;
	public double t = 0;
	double pericenter;
	double avgRateOfSweep;
	double timeAtPericenter;
	double meanAnomaly;
	int size;
	int maxIter = 8; // this was an arbitrary choice, it was a trade off between time to calculate
	// and accuracy/smoothness of the comet orbit
	public Location pos;
	
	// defines the constructor and the arguments it takes
	// takes the comet name, orbit eccentricity, major Axis, comet colour, comet radius and orbit focus as arguments
	public Comet (String name, double eccentricity, int majorAx, Color colour, int size, Location centreOfOrbit, double period) {
		
		this.name = name;
		this.size = size;
		this.centreOfOrbit = centreOfOrbit;
		this.eccentricity = eccentricity;
		this.majorAx = majorAx;
		//this.meanAnomaly = this.avgRateOfSweep*(this.t - this.timeAtPericenter);
		this.period = period;
		this.colour = colour;
		
	}
	
	// defines how the comets location should be updated each frame
	public Location getLocation() {
		// calculates the three anomaly variables needed to calculate the comets movement
		double meanAnomaly = 2*t*Math.PI/this.period;
		double eccentricAnomaly = getEccentricAnomaly(meanAnomaly, eccentricity, maxIter);
		double trueAnomaly = Math.atan((Math.sqrt((1 + eccentricity)/(1 - eccentricity)))*Math.tan(eccentricAnomaly/2))*2;
		double radius = (majorAx * (1-Math.pow(eccentricity, 2)))/(1 + eccentricity*Math.cos(trueAnomaly));
		t = t + 0.05; // advances the time step each time the getter function is called
		return new Location(centreOfOrbit.getX()-(int)(radius*Math.cos(trueAnomaly)), centreOfOrbit.getY() - (int)(radius*Math.sin(trueAnomaly)));
	}	// returns the comets new location
	
	// getter method for meanAnomaly
	public double getMeanAnomaly() {
		return this.meanAnomaly;
	}
	
	// getter method that performs a root finding method to find the eccentric anomaly from which
	// the true anomaly can be calculated
	public double getEccentricAnomaly(double meanAnomaly, double e, int maxIter) {
		int i = 0;
		double x = meanAnomaly;
		while(i<maxIter) {
			x = (meanAnomaly + (Math.sin(x)*e)-(e*x*Math.cos(x)))/(1-e*Math.cos(x));
			i = i + 1;
		}
		return x;
	}
	
	// a simple getter method that returns the radius of the comet
	public int getSize() {
		return this.size;
	}
	
	// a simple getter method that returns the name of the comet
	public String getName() {
		return this.name;
	}
	// a simple getter method that returns the colour of the comet
	public Color getColour() {
		return this.colour;
	}
	// a getter method that returns the eccentricity of the comets orbit
	public double getE() {
		return this.eccentricity;
	}
}