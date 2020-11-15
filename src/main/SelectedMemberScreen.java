package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SelectedMemberScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public SelectedMemberScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeSelectedMemberScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.getContentPane().setBackground(Color.LIGHT_GRAY);
		window.setTitle("Selected Member Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel memberNameLabel = new JLabel("Name:");
		memberNameLabel.setBackground(Color.GRAY);
		memberNameLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberNameLabel.setBounds(16, 25, 70, 27);
		memberNameLabel.setOpaque(true);
		window.getContentPane().add(memberNameLabel);
		
		JLabel nameLabel = new JLabel(gameEnv.getSelectedMember().getName());
		nameLabel.setBackground(Color.GRAY);
		nameLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		nameLabel.setBounds(86, 25, 116, 27);
		nameLabel.setOpaque(true);
		window.getContentPane().add(nameLabel);
		
		JLabel memberTypeLabel = new JLabel("Type:");
		memberTypeLabel.setBackground(Color.GRAY);
		memberTypeLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberTypeLabel.setBounds(16, 64, 70, 27);
		memberTypeLabel.setOpaque(true);
		window.getContentPane().add(memberTypeLabel);
		
		JLabel typeLabel = new JLabel(gameEnv.getSelectedMember().getType());
		typeLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		typeLabel.setBounds(86, 64, 116, 27);
		typeLabel.setBackground(Color.GRAY);
		typeLabel.setOpaque(true);
		window.getContentPane().add(typeLabel);
		
		JLabel actionPtsLabel = new JLabel("ActionPts:");
		actionPtsLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		actionPtsLabel.setBounds(16, 105, 70, 27);
		actionPtsLabel.setBackground(Color.GRAY);
		actionPtsLabel.setOpaque(true);
		window.getContentPane().add(actionPtsLabel);
		
		JLabel actionNumLabel = new JLabel(gameEnv.getSelectedMember().getActionPt() + "");
		actionNumLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		actionNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actionNumLabel.setBounds(86, 105, 47, 27);
		actionNumLabel.setBackground(Color.GRAY);
		actionNumLabel.setOpaque(true);
		window.getContentPane().add(actionNumLabel);
		
		JLabel healthLabel = new JLabel("Health:");
		healthLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		healthLabel.setBounds(305, 25, 83, 27);
		healthLabel.setBackground(Color.GRAY);
		healthLabel.setOpaque(true);
		window.getContentPane().add(healthLabel);
		
		JLabel healthNowLabel = new JLabel(gameEnv.getSelectedMember().getHealth() + "%");
		healthNowLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		healthNowLabel.setBounds(388, 25, 64, 27);
		healthNowLabel.setBackground(Color.GRAY);
		healthNowLabel.setOpaque(true);
		window.getContentPane().add(healthNowLabel);
		
		JLabel hungerLabel = new JLabel("Hunger:");
		hungerLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		hungerLabel.setBounds(305, 69, 83, 27);
		hungerLabel.setBackground(Color.GRAY);
		hungerLabel.setOpaque(true);
		window.getContentPane().add(hungerLabel);
		
		JLabel hungerNowLabel = new JLabel(gameEnv.getSelectedMember().getHunger() + "%");
		hungerNowLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		hungerNowLabel.setBounds(388, 69, 64, 27);
		hungerNowLabel.setBackground(Color.GRAY);
		hungerNowLabel.setOpaque(true);
		window.getContentPane().add(hungerNowLabel);
		
		JLabel tirednessLabel = new JLabel("Tiredness:");
		tirednessLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		tirednessLabel.setBounds(305, 110, 83, 27);
		tirednessLabel.setBackground(Color.GRAY);
		tirednessLabel.setOpaque(true);
		window.getContentPane().add(tirednessLabel);
		
		JLabel tirednessNowLabel = new JLabel(gameEnv.getSelectedMember().getTiredness() + "%");
		tirednessNowLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		tirednessNowLabel.setBounds(388, 110, 64, 27);
		tirednessNowLabel.setBackground(Color.GRAY);
		tirednessNowLabel.setOpaque(true);
		window.getContentPane().add(tirednessNowLabel);
		
		JLabel plagueStatusLabel = new JLabel("Plague Status:");
		plagueStatusLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		plagueStatusLabel.setBounds(305, 149, 116, 27);
		plagueStatusLabel.setBackground(Color.GRAY);
		plagueStatusLabel.setOpaque(true);
		window.getContentPane().add(plagueStatusLabel);
		
		String plagueStr = "Uninfected";
		if (gameEnv.getSelectedMember().isInfected()) {
			plagueStr = "Infected";
		}
		JLabel isinfectedLabel = new JLabel(plagueStr);
		isinfectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		isinfectedLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		isinfectedLabel.setBounds(420, 149, 83, 27);
		isinfectedLabel.setBackground(Color.GRAY);
		isinfectedLabel.setOpaque(true);
		window.getContentPane().add(isinfectedLabel);
		
		JLabel selectActionLabel = new JLabel("Select Action from below:");
		selectActionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectActionLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectActionLabel.setBounds(16, 168, 178, 35);
		selectActionLabel.setBackground(Color.GRAY);
		selectActionLabel.setOpaque(true);
		window.getContentPane().add(selectActionLabel);
		
		JButton searchPlanetButton = new JButton("Search Planet");
		searchPlanetButton.setBackground(Color.LIGHT_GRAY);
		searchPlanetButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		searchPlanetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.selectAction("1");
				finishedWindow();
			}
		});
		searchPlanetButton.setBounds(16, 215, 155, 48);
		window.getContentPane().add(searchPlanetButton);
		
		JButton healButton = new JButton("Heal a Member");
		healButton.setBackground(Color.LIGHT_GRAY);
		healButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		healButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.selectAction("2");
				finishedWindow();
			}
		});
		healButton.setBounds(16, 265, 155, 48);
		window.getContentPane().add(healButton);
		
		JButton eatFoodButton = new JButton("Eat Food");
		eatFoodButton.setBackground(Color.LIGHT_GRAY);
		eatFoodButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		eatFoodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.selectAction("3");
				finishedWindow();
			}
		});
		eatFoodButton.setBounds(183, 215, 155, 48);
		window.getContentPane().add(eatFoodButton);
		
		JButton sleepButton = new JButton("Sleep");
		sleepButton.setBackground(Color.LIGHT_GRAY);
		sleepButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.selectAction("4");
				finishedWindow();
			}
		});
		sleepButton.setBounds(348, 215, 155, 48);
		window.getContentPane().add(sleepButton);
		
		JButton repairShipButton = new JButton("Repair Ship");
		repairShipButton.setBackground(Color.LIGHT_GRAY);
		repairShipButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		repairShipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.selectAction("5");
				finishedWindow();
			}
		});
		repairShipButton.setBounds(348, 265, 155, 48);
		window.getContentPane().add(repairShipButton);
		
		JButton backButton = new JButton("Back");
		backButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.selectAction("6");
				finishedWindow();
			}
		});
		backButton.setBounds(183, 265, 155, 48);
		window.getContentPane().add(backButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(SelectedMemberScreen.class.getResource("/Images/selectedMember.jpg")));
		backGroundLabel.setBounds(-132, 0, 657, 328);
		window.getContentPane().add(backGroundLabel);
		
	}
}
