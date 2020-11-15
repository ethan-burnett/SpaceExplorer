package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberTypeScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public MemberTypeScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeMemberTypeScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Member Type Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel selectTypeLabel = new JLabel("Select member's type:");
		selectTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectTypeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		selectTypeLabel.setForeground(Color.YELLOW);
		selectTypeLabel.setBounds(136, 50, 237, 37);
		window.getContentPane().add(selectTypeLabel);
		
		JButton navigatorButton = new JButton("Navigator");
		navigatorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setMemberType("5");
				finishedWindow();
			}
		});
		navigatorButton.setBackground(Color.RED);
		navigatorButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		navigatorButton.setBounds(26, 105, 117, 29);
		window.getContentPane().add(navigatorButton);
		
		JButton engineerButton = new JButton("Engineer");
		engineerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setMemberType("6");
				finishedWindow();
			}
		});
		engineerButton.setBackground(Color.RED);
		engineerButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		engineerButton.setBounds(184, 105, 117, 29);
		window.getContentPane().add(engineerButton);
		
		JButton scavengerButton = new JButton("Scavenger");
		scavengerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setMemberType("4");
				finishedWindow();
			}
		});
		scavengerButton.setBackground(Color.RED);
		scavengerButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		scavengerButton.setBounds(355, 105, 117, 29);
		window.getContentPane().add(scavengerButton);
		
		JButton pilotButton = new JButton("Pilot");
		pilotButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setMemberType("1");
				finishedWindow();
			}
		});
		pilotButton.setBackground(Color.RED);
		pilotButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		pilotButton.setBounds(26, 231, 117, 29);
		window.getContentPane().add(pilotButton);
		
		JLabel naviLabel = new JLabel("<html>Uses less<br>actionPts when<br>plotting courses.<html>");
		naviLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		naviLabel.setForeground(Color.YELLOW);
		naviLabel.setBounds(30, 133, 117, 53);
		window.getContentPane().add(naviLabel);
		
		JLabel enginLabel = new JLabel("<html>Increased health.<br>Increased hunger.<br>Reduced tiredness.<br>Better at repairing<br>ship shields.<html>");
		enginLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		enginLabel.setForeground(Color.YELLOW);
		enginLabel.setBounds(190, 133, 118, 96);
		window.getContentPane().add(enginLabel);
		
		JLabel scavLabel = new JLabel("<html>Increased health.<br>Increased tiredness.<br>Searches planets<br>twice per actionPt.<html>");
		scavLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		scavLabel.setForeground(Color.YELLOW);
		scavLabel.setBounds(360, 133, 118, 86);
		window.getContentPane().add(scavLabel);
		
		JLabel pilotLabel = new JLabel("<html>Uses less<br>actionPts when<br>flying the ship.<html>");
		pilotLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		pilotLabel.setForeground(Color.YELLOW);
		pilotLabel.setBounds(30, 259, 118, 63);
		window.getContentPane().add(pilotLabel);
		
		JButton cyborgButton = new JButton("Cyborg");
		cyborgButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setMemberType("3");
				finishedWindow();
			}
		});
		cyborgButton.setBackground(Color.RED);
		cyborgButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		cyborgButton.setBounds(184, 231, 117, 29);
		window.getContentPane().add(cyborgButton);
		
		JLabel cyborgLabel = new JLabel("<html>Increased health.<br>Reduced hunger.<br>Reduced tiredness.<html>");
		cyborgLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		cyborgLabel.setForeground(Color.YELLOW);
		cyborgLabel.setBounds(190, 259, 118, 63);
		window.getContentPane().add(cyborgLabel);
		
		JButton medicButton = new JButton("Medic");
		medicButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setMemberType("2");
				finishedWindow();
			}
		});
		medicButton.setBackground(Color.RED);
		medicButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		medicButton.setBounds(355, 231, 117, 29);
		window.getContentPane().add(medicButton);
		
		JLabel medicLabel = new JLabel("<html>Reduced health.<br>Better at healing<br>crew members.<html>");
		medicLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		medicLabel.setForeground(Color.YELLOW);
		medicLabel.setBounds(360, 259, 117, 63);
		window.getContentPane().add(medicLabel);
		
		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setIcon(new ImageIcon(MemberTypeScreen.class.getResource("/Images/space_back.jpg")));
		backgroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backgroundLabel);
	}
}
