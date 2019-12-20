package module9;

import java.awt.Color;

public class Planet {
	
	// initialises the variables to be used later 
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
	public double delay = 10;
	double orbitAngle;
	int radius;
	Location centreOfOrbit = new Location(500,500);
	int orbitCount;
	
	// defines the arguments the Planet object type will take
	public Planet(String name, int orbitRad, double period, Color colour, int radius, Location centreOfOrbit) {
		
		this.orbitRad = orbitRad;
		this.name = name;
		this.period = period;
		this.angularV = 2*(Math.PI/this.period);
		this.colour = colour;
		this.pos = new Location(centreOfOrbit.getX(),centreOfOrbit.getY()+this.orbitRad);
		this.radius = radius;
		this.centreOfOrbit = centreOfOrbit;
		this.delta = 2*Math.PI*this.delay/(this.period*800);
		
	}
	
	// gets the planet name
	public String getName() {
		return this.name;
	}
	
	// gets the number of completed orbits 
	public int getOrbitCount() {
		return this.orbitCount;
	}
	
	// gets the orbital radius
	public int getOrbitRad() {
		return this.orbitRad;
	}
	
	// gets the planet's colour
	public Color getColour() {
		return this.colour;
	}
	
	// gets the radius of the planet
	public int getRad() {
		return this.radius;
	}
	
	// defines how the planets location should be updated each frame
	public void changeLocation() {
		
		this.orbitAngle = orbitAngle + delta;
		this.pos.setX((int)((Math.cos(this.orbitAngle)*this.orbitRad)+this.centreOfOrbit.getX()));
		this.pos.setY((int)((Math.sin(this.orbitAngle)*this.orbitRad)+this.centreOfOrbit.getY()));
		
		if(this.orbitAngle>2*Math.PI) { // keeps track of the number of orbits each planet makes
			this.orbitAngle = this.orbitAngle%(2*Math.PI);
			orbitCount = orbitCount + 1;
		}
	}
	
	// getting method for planet location
	public Location getLocation() {
		changeLocation();
		return this.pos;
	}

}



