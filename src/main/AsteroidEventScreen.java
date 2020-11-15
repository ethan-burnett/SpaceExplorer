package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AsteroidEventScreen {

	private JFrame window;
	private GameEnvironment gameEnv;
	
	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public AsteroidEventScreen(GameEnvironment incomingGameEnv) {
		gameEnv = incomingGameEnv;
		initialize();
		window.setVisible(true);
	}
	
	/**
	 * Called from gameEnv so window can "dispose" itself.
	 */
	public void closeWindow() {
		window.dispose();
	}
	
	/**
	 * Call to gameEnv to close this window.
	 */
	public void finishedWindow() {
		gameEnv.closeAsteroidEventScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Asteroid Event Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("ASTEROID COLLISION!!!");
		titleLabel.setForeground(Color.RED);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		titleLabel.setBounds(53, 11, 401, 71);
		window.getContentPane().add(titleLabel);
		
		JLabel yourShipHasLabel = new JLabel("Your ship has gone through an asteroid field!");
		yourShipHasLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		yourShipHasLabel.setHorizontalAlignment(SwingConstants.CENTER);
		yourShipHasLabel.setBounds(63, 74, 373, 31);
		yourShipHasLabel.setOpaque(true);
		window.getContentPane().add(yourShipHasLabel);
		
		JLabel itHasLostLabel = new JLabel("It's shields have taken a lot of damage!");
		itHasLostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itHasLostLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		itHasLostLabel.setBounds(98, 211, 308, 31);
		itHasLostLabel.setOpaque(true);
		window.getContentPane().add(itHasLostLabel);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		okButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		okButton.setBounds(210, 260, 89, 31);
		window.getContentPane().add(okButton);
		
		JLabel itHasBeenLabel = new JLabel("It has been struck by an asteroid!");
		itHasBeenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		itHasBeenLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		itHasBeenLabel.setBounds(98, 139, 308, 31);
		itHasBeenLabel.setOpaque(true);
		window.getContentPane().add(itHasBeenLabel);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(AsteroidEventScreen.class.getResource("/Images/asteroid_belt.jpg")));
		backgroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backgroundLabel);
	}
}