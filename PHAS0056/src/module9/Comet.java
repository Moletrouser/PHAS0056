package module9;

import java.awt.Color;

public class Comet {
	
	public double eccentricity;
	public String name;
	public int majorAx;
	public int minorAx;
	public Color colour;
	public double period;
	public Location centreOfOrbit;
	public double t;
	double pericenter;
	double avgRateOfSweep;
	double timeAtPericenter;
	double meanAnomaly;
	int maxIter;
	
			
	public Comet (String name, double eccentricity, int majorAx, Color colour, int radius, Location centreOfOrbit, double period, double avgRateOfSweep, double t, double timeAtPericenter) {
		
		this.name = name;
		this.radius = radius;
		this.centreOfOrbit = centreOfOrbit;
		this.eccentricity = eccentricity;
		this.majorAx = majorAx;
		this.meanAnomaly = this.avgRateOfSweep*(this.t - this.timeAtPericenter);
		
	}

	

	public double getMeanAnomaly() {
		return this.meanAnomaly;
	}
	
	
	public double getEccentricAnomaly(double meanAnomaly, double e, int maxIter) {
		int i = 0;
		double x = meanAnomaly;
		while(i<maxIter) {
			x = meanAnomaly + (Math.sin(x)*e)-(e*x*Math.acos(x))/(1-e*Math.acos(x));
		}
		return x;
	}
	
	double eccentricAnomaly = getEccentricAnomaly(meanAnomaly, eccentricity, 10);
	
	double trueAnomaly = Math.atan((Math.sqrt((1 + eccentricity)/(1 - eccentricity)))*Math.tan(eccentricAnomaly/2))*2;
	
	double radius = (majorAx * (1-Math.pow(eccentricity, 2)))/(1 + eccentricity*Math.acos(trueAnomaly));
	
	public String getName() {
		return this.name;
	}
	
	public Color getColour() {
		return this.colour;
	}
	
	public double getE() {
		return this.eccentricity;
	}
}