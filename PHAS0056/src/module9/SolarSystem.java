package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Color;

public class SolarSystem extends JPanel /*implements ActionListener */ {
	
	public static final int delay = 1;
	public Timer timer;
	
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
	
	ArrayList<Planet> planets;
	
	public SolarSystem (int width, int height) {
		
		setPreferredSize(new Dimension(width,height));
		//timer = new Timer();
		timer.start();
		
		sunRad = 10;
		
		earthPeriod = 10;
		marsPeriod = 19;
		jupiterPeriod = 12;
		venusPeriod = 6;
		mercuryPeriod = 2.5;
		saturnPeriod = 29;
		
		earthOrbRad = 140;
		marsOrbRad = 59;
		jupiterOrbRad = 450;
		venusOrbRad = 100;
		mercuryOrbRad = 55;
		saturnOrbRad = 1300;
		
		earthRad = 10;
		marsRad = 6;
		jupiterRad = 110;
		venusRad = 10;
		mercuryRad = 4;
		saturnRad = 90;
		
		Planet earth = new Planet("Earth", earthOrbRad, earthPeriod, Color.blue, earthRad);
		Planet mars = new Planet("Mars", marsOrbRad, marsPeriod, Color.red, marsRad);
		Planet jupiter = new Planet("Jupiter", jupiterOrbRad, jupiterPeriod, Color.gray, jupiterRad);
		Planet venus = new Planet("Venus", venusOrbRad, venusPeriod, Color.cyan, venusRad);
		Planet mercury = new Planet("Mercury", mercuryOrbRad, mercuryPeriod, Color.darkGray, mercuryRad);
		Planet saturn = new Planet("Saturn", saturnOrbRad, saturnPeriod, Color.orange, saturnRad);
	
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
	
			public void run() {
				
				JFrame frame = new JFrame("Solar System");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000,1000);
				JPanel panel = new SolarSystem(1000,1000);
				frame.add(panel);
				frame.setVisible(true);
			}
	 
		});
	
	}	
	
}
