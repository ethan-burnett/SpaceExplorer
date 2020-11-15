package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlagueEventScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public PlagueEventScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closePlagueEventScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Plague Event Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel oneOfYourLabel = new JLabel("Your crew has come in contact with the Space Plague!");
		oneOfYourLabel.setBackground(Color.GREEN);
		oneOfYourLabel.setForeground(Color.BLACK);
		oneOfYourLabel.setHorizontalAlignment(SwingConstants.CENTER);
		oneOfYourLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		oneOfYourLabel.setBounds(31, 11, 459, 26);
		oneOfYourLabel.setOpaque(true);
		window.getContentPane().add(oneOfYourLabel);
		
		String infectedStr = gameEnv.getInfectedString();
		JLabel isInfectedLabel = new JLabel(infectedStr);
		isInfectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		isInfectedLabel.setBackground(Color.GREEN);
		isInfectedLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		isInfectedLabel.setBounds(31, 36, 459, 104);
		isInfectedLabel.setOpaque(true);
		window.getContentPane().add(isInfectedLabel);
		
		JLabel youCanCureLabel = new JLabel("You can cure the infected with the plague cure!");
		youCanCureLabel.setBackground(Color.GREEN);
		youCanCureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		youCanCureLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		youCanCureLabel.setBounds(31, 193, 459, 26);
		youCanCureLabel.setOpaque(true);
		window.getContentPane().add(youCanCureLabel);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		okButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		okButton.setBounds(222, 241, 87, 49);
		window.getContentPane().add(okButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(PlagueEventScreen.class.getResource("/Images/new_space_plague.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}

}