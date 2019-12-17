package module9;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnimationGuiPanel extends JPanel implements ActionListener {
	 
	private AnimationPanel animPanel; // panel containing animation
	 private JButton startButton;
	 private JButton stopButton;
	 private JButton exitButton;
	 /** Create JPanel containing animation panel and buttons. */
	 public AnimationGuiPanel() {
	 super();
	 setPreferredSize(new Dimension(250,300));
	 setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	 animPanel = new AnimationPanel(200,200,10.0);
	 startButton = new JButton("Start");
	 stopButton = new JButton("Stop");
	 exitButton = new JButton("Exit");
	 startButton.addActionListener(this);
	 stopButton.addActionListener(this);
	 exitButton.addActionListener(this);
	 JPanel buttonPanel = new JPanel();
	 buttonPanel.setLayout(new BoxLayout(
	 buttonPanel,BoxLayout.X_AXIS));
	 buttonPanel.add(startButton);
	 buttonPanel.add(stopButton);
	 buttonPanel.add(exitButton);
	 add(animPanel);
	 add(buttonPanel);
	 }
	 /** Respond to button clicks */
	 public void actionPerformed(ActionEvent e) {
	 if (e.getSource()==startButton) start();
	 else if (e.getSource()==stopButton) stop();
	 else if (e.getSource()==exitButton) System.exit(0);
	 }
	 /** Start animation */
	 public void start() {animPanel.start();}
	 /** Stop animation */
	 public void stop() {animPanel.stop();}
	
	public static void main(String[] args) {
		 /** Create and display JFrame containing animation GUI panel */
		 SwingUtilities.invokeLater(new Runnable() {
		 public void run() {
		 JFrame frame = new JFrame("Animation demo");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(250,300);
		 JPanel panel = new AnimationGuiPanel();
		 frame.add(panel);
		 frame.setVisible(true);
		 }
		 });
		 }
		
	}


