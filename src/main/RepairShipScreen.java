package main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RepairShipScreen {

	private JFrame window;
	private GameEnvironment gameEnv;
	private double sliderValue = 3;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public RepairShipScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeRepairShipScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Repair Ship Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		CrewMember member = gameEnv.getSelectedMember();
		Ship ship = gameEnv.getCrew().getShip();
		JLabel repairShipLabel = new JLabel("Repair Ship");
		repairShipLabel.setBackground(Color.LIGHT_GRAY);
		repairShipLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		repairShipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repairShipLabel.setBounds(165, 24, 181, 44);
		repairShipLabel.setOpaque(true);
		window.getContentPane().add(repairShipLabel);
		
		JLabel selectLabel = new JLabel("Select how many action points " + member.getName() + " will use to repair the " + ship.getName());
		selectLabel.setBackground(Color.LIGHT_GRAY);
		selectLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectLabel.setBounds(11, 80, 502, 29);
		selectLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectLabel.setOpaque(true);
		window.getContentPane().add(selectLabel);
		
		JLabel actionPtsLabel = new JLabel(member.getName() + "'s Action Points: " + member.getActionPt());
		actionPtsLabel.setBackground(Color.LIGHT_GRAY);
		actionPtsLabel.setBounds(21, 131, 191, 29);
		actionPtsLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		actionPtsLabel.setOpaque(true);
		window.getContentPane().add(actionPtsLabel);
		
		JLabel shieldLabel = new JLabel(ship.getName() + " Shields at " + ship.getShieldHealth() + "%");
		shieldLabel.setBackground(Color.LIGHT_GRAY);
		shieldLabel.setBounds(288, 131, 191, 29);
		shieldLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		shieldLabel.setOpaque(true);
		window.getContentPane().add(shieldLabel);
		
		JLabel everyActionLabel = new JLabel("Every 1 action point = 10% increased shield health");
		everyActionLabel.setBackground(Color.LIGHT_GRAY);
		everyActionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		everyActionLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		everyActionLabel.setBounds(58, 251, 383, 29);
		everyActionLabel.setOpaque(true);
		window.getContentPane().add(everyActionLabel);
		
		JButton repairButton = new JButton("Repair");
		repairButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.repairShip(sliderValue);
				actionPtsLabel.setText(member.getName() + "'s Action Points: " + member.getActionPt());
				shieldLabel.setText(ship.getName() + " Shields at " + ship.getShieldHealth() + "%");
			}
		});
		repairButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		repairButton.setBounds(197, 221, 117, 29);
		window.getContentPane().add(repairButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		backButton.setBounds(197, 292, 117, 29);
		window.getContentPane().add(backButton);
		
		JSlider slider = new JSlider();
		slider.setForeground(Color.BLACK);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				sliderValue = (double) slider.getValue();
			}
		});
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setValue(3);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setOpaque(true);
		slider.setBounds(87, 165, 328, 44);
		window.getContentPane().add(slider);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(RepairShipScreen.class.getResource("/Images/metalPlate_2.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
		
	}
}
