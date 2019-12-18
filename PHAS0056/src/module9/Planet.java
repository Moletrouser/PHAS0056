package module9;

import java.awt.Color;

public class Planet {

	String name;
	double period;
	Color colour;
	int diameter;
	int orbitRad;
	double angularV;
	double startAngle = 0;
	public Location pos;
	public Location centreOfRotation;
	
	public Planet(String name, int orbitRad, double period, Color colour, int diameter) {
		
		this.orbitRad = orbitRad;
		this.name = name;
		this.period = period;
		this.angularV = 2*(Math.PI/this.period);
		this.colour = colour;
		this.pos = new Location(centreOfRotation.x,centreOfRotation.y);
		
	}
}
