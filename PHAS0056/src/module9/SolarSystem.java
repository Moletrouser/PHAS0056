package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class SolarSystem extends JPanel /*implements ActionListener */ {
	
	public static final int delay = 1;
	public Timer timer;
	
	public SolarSystem (int width, int height) {
		
		setPreferredSize(new Dimension(width,height));
		//timer = new Timer();
		timer.start();
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
