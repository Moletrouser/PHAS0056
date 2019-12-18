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
	double delta;
	double orbitAngle;
	int radius;
	
	public Planet(String name, int orbitRad, double period, Color colour, int radius, Location centreOfOrbit) {
		
		this.orbitRad = orbitRad;
		this.name = name;
		this.period = period;
		this.angularV = 2*(Math.PI/this.period);
		this.colour = colour;
		this.pos = new Location(centreOfOrbit.x,centreOfOrbit.y);
		this.radius = radius;
		
		
	}

	private void changeLocation() {
		this.orbitAngle = orbitAngle + delta;
	}

	public Location getLocation() {
		changeLocation();
		return this.pos;
	}

}