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

public class PirateEventScreen {

	private JFrame window;
	private GameEnvironment gameEnv;
	private String stolenItem;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 * @param stolenThing String
	 */
	public PirateEventScreen(GameEnvironment incomingGameEnv, String stolenThing) {
		gameEnv = incomingGameEnv;
		stolenItem = stolenThing;
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
		gameEnv.closePirateEventScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Pirate event screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel theLocalPiratesLabel = new JLabel("The local pirates have attacked!");
		theLocalPiratesLabel.setBounds(69, 62, 395, 44);
		theLocalPiratesLabel.setForeground(Color.RED);
		theLocalPiratesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		theLocalPiratesLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		window.getContentPane().add(theLocalPiratesLabel);
		
		JLabel theyRaidedLabel = new JLabel("They raided your ship and took one:");
		theyRaidedLabel.setBounds(69, 126, 395, 44);
		theyRaidedLabel.setForeground(Color.RED);
		theyRaidedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		theyRaidedLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		window.getContentPane().add(theyRaidedLabel);
		
		JLabel itemLabel = new JLabel(stolenItem);
		itemLabel.setBounds(69, 195, 395, 44);
		itemLabel.setForeground(Color.RED);
		itemLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		itemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		window.getContentPane().add(itemLabel);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		okButton.setForeground(Color.BLACK);
		okButton.setBackground(Color.RED);
		okButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		okButton.setBounds(220, 251, 87, 49);
		window.getContentPane().add(okButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(PirateEventScreen.class.getResource("/Images/aliens.jpg")));
		backGroundLabel.setBounds(-76, -48, 616, 433);
		window.getContentPane().add(backGroundLabel);
	}
}