package module9;

import java.awt.Color;

public class Comet {
	
	public double eccentricity;
	public String name;
	public int majorAx;
	public Color colour;
	public int radius;
	public double period;
	public Location centreOfOrbit;
	public double t;
	
	public Comet (String name, double eccentricity, int majorAx, Color colour, int radius, Location centreOfOrbit, double period ) {
		
		this.name = name;
		this.radius = radius;
		this.centreOfOrbit = centreOfOrbit;
		this.eccentricity = eccentricity;
		this.majorAx = majorAx;
		
		
	}


	
	public String getName() {
		return this.name;
	}
	
	public Color getColour() {
		return this.colour;
	}
	
	public int getRad() {
		return this.radius;
	}
	
	public double getE() {
		return this.eccentricity;
	}
}