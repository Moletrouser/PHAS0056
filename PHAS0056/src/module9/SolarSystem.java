package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Color;

public class SolarSystem extends JPanel implements ActionListener  {

	// initialises the planet radii
	public int sunRad;
	public int earthRad;
	public int marsRad;
	public int jupiterRad;
	public int venusRad;
	public int mercuryRad;
	public int saturnRad;
	
	// initialises the orbital radii
	public int earthOrbRad;
	public int marsOrbRad;
	public int jupiterOrbRad;
	public int venusOrbRad;
	public int mercuryOrbRad;
	public int saturnOrbRad;
	public Location centreOfRotation;
	
	// initialises the planetary periods
	public double earthPeriod;
	public double marsPeriod;
	public double jupiterPeriod;
	public double venusPeriod;
	public double mercuryPeriod;
	public double saturnPeriod;
	
	// initialises the planet names as character arrays
	char[] earthNameArr;
	char[] marsNameArr;
	char[] jupiterNameArr;
	char[] venusNameArr;
	char[] mercuryNameArr;
	char[] saturnNameArr;
	int orbitCount;
	
	// defimes the fonts that will be printed to the screen
	Font courier1 = new Font("Courier", Font.BOLD, 22);
	Font courier2 = new Font("Courier", Font.BOLD, 28);
	
	// initialises comet and planet arrays
	ArrayList<Planet> planets;
	ArrayList<Comet> comets;

	// defines the delay between frames
	public static final int delay = 20;
	public Timer timer;
	
	// defines the position of the sun
	Location centreOfOrbit = new Location(500,500);
	
	public SolarSystem (int width, int height) {
		
		setPreferredSize(new Dimension(width,height));
		timer = new Timer(delay, this);
		timer.start();
		
		//initialising all the constants that will be used
		
		earthPeriod = 10; 
		marsPeriod = 19; // jupiter has a period of almost 2 earth years
		jupiterPeriod = 120; // jupiter has a period of 12 earth years
		venusPeriod = 6; // venus has a period of just over half one earth year
		mercuryPeriod = 2.5; // mercury has a period of around 1/4 of earths
		saturnPeriod = 290; // saturn has a period of around 29 of earths
		
		// planets are in order in the animation however orbital radii have been shortened to allow
		// them all to fit onto the screen
		sunRad = 30;
		earthOrbRad = 140;
		marsOrbRad = 70;
		jupiterOrbRad = 250;
		venusOrbRad = 100;
		mercuryOrbRad = 55;
		saturnOrbRad = 400;
		
		// planetary radii are roughly to scale with each other
		// however they are not to scale with the sun so that they can
		// remain large enough to see clearly
		earthRad = 10;
		marsRad = 8;
		jupiterRad = 25;
		venusRad = 10;
		mercuryRad = 6;
		saturnRad = 20;
		
		// defines the centre that the planets will orbit
		// for the comets this point will act as a focus of the eliptical orbit
		centreOfOrbit = new Location(500,500);
		
		// creates the various planetary objects
		Planet earth = new Planet("Earth", earthOrbRad, earthPeriod, Color.blue, earthRad, centreOfOrbit);
		Planet mars = new Planet("Mars", marsOrbRad, marsPeriod, Color.red, marsRad, centreOfOrbit);
		Planet jupiter = new Planet("Jupiter", jupiterOrbRad, jupiterPeriod, Color.gray, jupiterRad, centreOfOrbit);
		Planet venus = new Planet("Venus", venusOrbRad, venusPeriod, Color.cyan, venusRad, centreOfOrbit);
		Planet mercury = new Planet("Mercury", mercuryOrbRad, mercuryPeriod, Color.magenta, mercuryRad, centreOfOrbit);
		Planet saturn = new Planet("Saturn", saturnOrbRad, saturnPeriod, Color.orange, saturnRad, centreOfOrbit);
	
		
		
		// 
		Comet halleys = new Comet("Halley's Comet", 0.9, 300, Color.red, 7, centreOfOrbit, 90);
		Comet haleBopp = new Comet("Hale-Bopp", 0.8, 450, Color.green, 6, centreOfOrbit, 130);
		
		// In reality, halleys comet has a period of 70ish years, and hale-bopp a period of 2500ish years. 
		// these have been shortened greatly for the purposes of the animation
				
		
		planets = new ArrayList<Planet>();
		comets = new ArrayList<Comet>();
		
		// adding all planets to the arraylist
		planets.add(earth);
		planets.add(mars);
		planets.add(jupiter);
		planets.add(venus);
		planets.add(mercury);
		planets.add(saturn);
		
		// adding all comets to the arraylist
		comets.add(halleys);
		comets.add(haleBopp);
	}
		
		public void start() {
			timer.start();
		}
	
		public void stop() {
			timer.stop();
		}
		
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
		
		// defines where are how the objects should be painted
		protected void paintComponent(Graphics g) {
			
			// defines earth as the first member of the planets array list
			Planet earth = planets.get(0);
			super.paintComponent(g);
			g.setColor(Color.black); // paints space black
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.yellow); // paints the sun yellow
			g.fillOval(centreOfOrbit.getX()-sunRad,centreOfOrbit.getY()-sunRad, sunRad*2, sunRad*2);
		
			for (Planet i: planets) { // paints each planet and its name and orbit in sequence
				g.setColor(i.getColour());
				g.fillOval(i.getLocation().getX(), i.getLocation().getY(), i.getRad(), i.getRad());
				g.setColor(Color.lightGray);
				g.drawOval(centreOfOrbit.getX()-i.getOrbitRad()+i.getRad()/2, centreOfOrbit.getY()-i.getOrbitRad()+i.getRad()/2,2*i.getOrbitRad()+i.getRad()/8,2*i.getOrbitRad()+i.getRad()-i.getRad());
				g.setColor(Color.magenta);
				g.drawChars(i.getName().toCharArray(),0,i.getName().length(),i.getLocation().getX()-20, i.getLocation().getY()-15);
				
			}
			
			for (Comet j: comets) { // paints each comet and their names
				g.setColor(j.getColour());
				g.fillOval(j.getLocation().getX(), j.getLocation().getY(), j.getSize(), j.getSize());
				g.setColor(Color.magenta);
				g.drawChars(j.getName().toCharArray(),0,j.getName().length(),j.getLocation().getX()-20, j.getLocation().getY()-15);
			}
			
			g.setFont(courier1); // sets the font
			g.setColor(Color.magenta);
			g.drawString("The time elapsed in earth years is: ", 270, 80); // prints the earth years passed
			g.drawString(Integer.toString(earth.getOrbitCount()), 735, 80); // to the screen
			g.drawString(Integer.toString(earth.getOrbitCount()), 145,950);
			g.drawString("year(s) closer to the inevitable heat death of the universe.", 170,950); // extra marks for whimsy please
			g.setColor(Color.green);
			g.setFont(courier2);
			g.drawString("WELCOME TO THE MILKY WAY!", 290, 50); // a warm welcome
			
		}
		
	
	
	
	public static void main(String[] args) {
		
		 
		SwingUtilities.invokeLater(new Runnable() {
	
			public void run() {
				
				// instantiates a new JFrame and starts the animation 
				JFrame frame = new JFrame("Solar System");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1200,1200);
				JPanel panel = new SolarSystem(1500,1000);

				frame.add(panel);
				frame.setVisible(true);
			}
	 
		});
	
	}	
	
}
