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
	public double delay = 50;
	double orbitAngle;
	int radius;
	Location centreOfOrbit = new Location(500,500);
	int orbitCount;
	
	public Planet(String name, int orbitRad, double period, Color colour, int radius, Location centreOfOrbit) {
		
		this.orbitRad = orbitRad;
		this.name = name;
		this.period = period;
		this.angularV = 2*(Math.PI/this.period);
		this.colour = colour;
		this.pos = new Location(centreOfOrbit.getX(),centreOfOrbit.getY()+this.orbitRad);
		this.radius = radius;
		this.centreOfOrbit = centreOfOrbit;
		this.delta = 2*Math.PI*this.delay/(this.period*1000);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getOrbitCount() {
		return this.orbitCount;
	}
	
	public int getOrbitRad() {
		return this.orbitRad;
	}
	
	public Color getColour() {
		return this.colour;
	}
	
	public int getRad() {
		return this.radius;
	}
	
	public void changeLocation() {
		
		this.orbitAngle = orbitAngle + delta;
		this.pos.setX((int)((Math.cos(this.orbitAngle)*this.orbitRad)+this.centreOfOrbit.getX()));
		this.pos.setY((int)((Math.sin(this.orbitAngle)*this.orbitRad)+this.centreOfOrbit.getY()));
		
		if(this.orbitAngle>2*Math.PI) {
			this.orbitAngle = this.orbitAngle%(2*Math.PI);
			orbitCount = orbitCount + 1;
		}
	}

	public Location getLocation() {
		changeLocation();
		return this.pos;
	}

}



