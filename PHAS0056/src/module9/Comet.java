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
	public double t = 0;
	double pericenter;
	double avgRateOfSweep;
	double timeAtPericenter;
	double meanAnomaly;
	int size;
	int maxIter = 2;
	public Location pos;
	
			
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

	public Location getLocation() {
		double meanAnomaly = 2*t*Math.PI/this.period;
		double eccentricAnomaly = getEccentricAnomaly(meanAnomaly, eccentricity, maxIter);
		double trueAnomaly = Math.atan((Math.sqrt((1 + eccentricity)/(1 - eccentricity)))*Math.tan(eccentricAnomaly/2))*2;
		double radius = (majorAx * (1-Math.pow(eccentricity, 2)))/(1 + eccentricity*Math.cos(trueAnomaly));
		t = t + 0.1;
		return new Location(centreOfOrbit.getX()-(int)(radius*Math.cos(trueAnomaly)), centreOfOrbit.getY() - (int)(radius*Math.sin(trueAnomaly)));
	}
	
	public double getMeanAnomaly() {
		return this.meanAnomaly;
	}
	
	
	public double getEccentricAnomaly(double meanAnomaly, double e, int maxIter) {
		int i = 0;
		double x = meanAnomaly;
		while(i<maxIter) {
			x = (meanAnomaly + (Math.sin(x)*e)-(e*x*Math.cos(x)))/(1-e*Math.cos(x));
			i = i + 1;
		}
		return x;
	}
	
	
	
	
	
	
	
	public int getSize() {
		return this.size;
	}
	
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