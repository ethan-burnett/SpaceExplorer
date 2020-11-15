package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeathScreen {

	private JFrame window;
	private ArrayList<CrewMember> DeathList;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 * @param incomingDeathList ArrayList CrewMember
	 */
	public DeathScreen(GameEnvironment incomingGameEnv, ArrayList<CrewMember> incomingDeathList) {
		gameEnv = incomingGameEnv;
		DeathList = incomingDeathList;
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
		gameEnv.closeDeathScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Death Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel memberDiedLabel = new JLabel("Death List!");
		memberDiedLabel.setForeground(Color.RED);
		memberDiedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberDiedLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		memberDiedLabel.setBounds(6, 11, 245, 39);
		window.getContentPane().add(memberDiedLabel);
		
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		okButton.setFont(new Font("Dialog", Font.BOLD, 11));
		okButton.setBounds(411, 225, 84, 39);
		window.getContentPane().add(okButton);
		
		JLabel youCanNoLabel = new JLabel("You can no longer use this member(s) for the rest of the game!");
		youCanNoLabel.setBackground(Color.LIGHT_GRAY);
		youCanNoLabel.setOpaque(true);
		youCanNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		youCanNoLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		youCanNoLabel.setBounds(11, 277, 495, 23);
		window.getContentPane().add(youCanNoLabel);
		
		String memberNameString = gameEnv.getDeathString(DeathList);
		JLabel memberNamesLabel = new JLabel(memberNameString);
		memberNamesLabel.setForeground(Color.RED);
		memberNamesLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		memberNamesLabel.setBounds(16, 62, 284, 152);
		window.getContentPane().add(memberNamesLabel);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(DeathScreen.class.getResource("/Images/space_death.jpg")));
		backGroundLabel.setBounds(-219, 0, 744, 328);
		window.getContentPane().add(backGroundLabel);
	
	}
}