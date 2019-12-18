package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

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
	

	
	public SolarSystem (int width, int height) {
		
		setPreferredSize(new Dimension(width,height));
		//timer = new Timer();
		timer.start();
		
		radiusSun = 10;
		
		
		
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
