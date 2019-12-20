package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Color;

public class SolarSystem extends JPanel implements ActionListener  {

	public int sunRad;
	public int earthRad;
	public int marsRad;
	public int jupiterRad;
	public int venusRad;
	public int mercuryRad;
	public int saturnRad;
	
	public int earthOrbRad;
	public int marsOrbRad;
	public int jupiterOrbRad;
	public int venusOrbRad;
	public int mercuryOrbRad;
	public int saturnOrbRad;
	public Location centreOfRotation;
	
	public double earthPeriod;
	public double marsPeriod;
	public double jupiterPeriod;
	public double venusPeriod;
	public double mercuryPeriod;
	public double saturnPeriod;
		
	char[] earthNameArr;
	char[] marsNameArr;
	char[] jupiterNameArr;
	char[] venusNameArr;
	char[] mercuryNameArr;
	char[] saturnNameArr;
	int orbitCount;
	
	Font courier = new Font("Courier", Font.BOLD, 22);
	
	ArrayList<Planet> planets;
	ArrayList<Comet> comets;
	public Planet earth;
	
	public static final int delay = 50;
	public Timer timer;
	
	Location centreOfOrbit = new Location(500,500);
	
	public SolarSystem (int width, int height) {
		
		setPreferredSize(new Dimension(width,height));
		timer = new Timer(delay, this);
		timer.start();
		
		earthPeriod = 10;
		marsPeriod = 19;
		jupiterPeriod = 12;
		venusPeriod = 6;
		mercuryPeriod = 4;
		saturnPeriod = 29;
		
		sunRad = 30;
		earthOrbRad = 140;
		marsOrbRad = 70;
		jupiterOrbRad = 250;
		venusOrbRad = 100;
		mercuryOrbRad = 55;
		saturnOrbRad = 400;
		
		earthRad = 10;
		marsRad = 6;
		jupiterRad = 25;
		venusRad = 10;
		mercuryRad = 4;
		saturnRad = 20;
		
		char[] earthNameArr = {'E','a','r','t','h'};
		char[] marsNameArr = {'M','a','r','s'};
		char[] jupiterNameArr = {'J','u','p','i','t','e','r'};
		char[] venusNameArr = {'V','e','n','u','s'};
		char[] mercuryNameArr = {'M','e','r','c','u','r','y'};
		char[] saturnNameArr = {'S','a','t','u','r','n'};
		
		centreOfOrbit = new Location(500,500);
		
		Planet earth = new Planet("Earth", earthOrbRad, earthPeriod, Color.blue, earthRad, centreOfOrbit);
		Planet mars = new Planet("Mars", marsOrbRad, marsPeriod, Color.red, marsRad, centreOfOrbit);
		Planet jupiter = new Planet("Jupiter", jupiterOrbRad, jupiterPeriod, Color.gray, jupiterRad, centreOfOrbit);
		Planet venus = new Planet("Venus", venusOrbRad, venusPeriod, Color.cyan, venusRad, centreOfOrbit);
		Planet mercury = new Planet("Mercury", mercuryOrbRad, mercuryPeriod, Color.magenta, mercuryRad, centreOfOrbit);
		Planet saturn = new Planet("Saturn", saturnOrbRad, saturnPeriod, Color.orange, saturnRad, centreOfOrbit);
	
		Comet halleys = new Comet("Halley's Comet", 0.7, 300, Color.red, 10, centreOfOrbit, 30);
		Comet haleBopp = new Comet("Hale-Bopp", 0.9, 450, Color.green, 5, centreOfOrbit, 20);
		
		planets = new ArrayList<Planet>();
		comets = new ArrayList<Comet>();
		
		planets.add(earth);
		planets.add(mars);
		planets.add(jupiter);
		planets.add(venus);
		planets.add(mercury);
		planets.add(saturn);
		
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

		protected void paintComponent(Graphics g) {
			
			Planet earth = planets.get(0);
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.yellow);
			g.fillOval(centreOfOrbit.getX()-sunRad,centreOfOrbit.getY()-sunRad, sunRad*2, sunRad*2);
		
			for (Planet i: planets) {
				g.setColor(i.getColour());
				g.fillOval(i.getLocation().getX(), i.getLocation().getY(), i.getRad(), i.getRad());
				g.setColor(Color.lightGray);
				g.drawOval(centreOfOrbit.getX()-i.getOrbitRad()+i.getRad()/2, centreOfOrbit.getY()-i.getOrbitRad()+i.getRad()/2,2*i.getOrbitRad()+i.getRad()/8,2*i.getOrbitRad()+i.getRad()-i.getRad());
				g.setColor(Color.magenta);
				g.drawChars(i.getName().toCharArray(),0,i.getName().length(),i.getLocation().getX()-20, i.getLocation().getY()-15);
				
			}
			
			for (Comet j: comets) {
				g.setColor(j.getColour());
				g.fillOval(j.getLocation().getX(), j.getLocation().getY(), j.getSize(), j.getSize());
			//	g.setColor(Color.lightGray);
			//	g.drawOval(centreOfOrbit.getX()-j.getOrbitRad()+j.getRad()/2, centreOfOrbit.getY()-j.getOrbitRad()+i.getRad()/2,2*j.getOrbitRad()+j.getRad()/8,2*j.getRad()+j.getRad()-j.getRad());
			//	g.setColor(Color.magenta);
			//	g.drawChars(j.getName().toCharArray(),0,j.getName().length(),j.getLocation().getX()-20, j.getLocation().getY()-15);
			}
			
			g.setFont(courier);
			g.setColor(Color.magenta);
			g.drawString("The time elapsed in earth years is: ", 290, 70);
			g.drawString(Integer.toString(earth.getOrbitCount()), 760, 70);
			g.drawString(Integer.toString(earth.getOrbitCount()), 145,950);
			g.drawString("year(s) closer to the inevitable heat death of the universe.", 170,950);
			
			
		}
		
	
	
	
	public static void main(String[] args) {
		
		 
		SwingUtilities.invokeLater(new Runnable() {
	
			public void run() {
				
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
