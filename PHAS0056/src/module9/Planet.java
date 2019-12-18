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
	Location centreOfOrbit = new Location(500,500);
	
	public Planet(String name, int orbitRad, double period, Color colour, int radius, Location centreOfOrbit) {
		
		this.orbitRad = orbitRad;
		this.name = name;
		this.period = period;
		this.angularV = 2*(Math.PI/this.period);
		this.colour = colour;
		this.pos = new Location(centreOfOrbit.getX(),centreOfOrbit.getY());
		this.radius = radius;
		
		
	}
	
	
	
	
	
	
	
	private void changeLocation() {
		
		this.orbitAngle = orbitAngle + delta;
		
		this.pos.setX((int)((Math.cos(this.orbitAngle)*this.orbitRad)+this.centreOfOrbit.getX()));
		this.pos.setY((int)((Math.sin(this.orbitAngle)*this.orbitRad)+this.centreOfOrbit.getY()));
	}

	public Location getLocation() {
		changeLocation();
		return this.pos;
	}

}