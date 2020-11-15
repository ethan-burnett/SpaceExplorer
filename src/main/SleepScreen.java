package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SleepScreen {

	private JFrame window;
	private GameEnvironment gameEnv;
	private double sliderValue = 3;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public SleepScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeSleepScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel sleepLabel = new JLabel("Sleep");
		sleepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sleepLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		sleepLabel.setBounds(160, 11, 174, 23);
		sleepLabel.setOpaque(true);
		window.getContentPane().add(sleepLabel);
		
		String memberStr = gameEnv.getSelectedMember().getName();
		JLabel selectHowManyLabel = new JLabel("Select how many Action Points of sleep you want " + memberStr + " to sleep for :");
		selectHowManyLabel.setOpaque(true);
		selectHowManyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectHowManyLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		selectHowManyLabel.setBounds(10, 44, 487, 16);
		window.getContentPane().add(selectHowManyLabel);
		
		JLabel actionPtLabel = new JLabel("1 Action Point = 10% of " + memberStr + "'s tiredness reduced");
		actionPtLabel.setOpaque(true);
		actionPtLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actionPtLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		actionPtLabel.setBounds(65, 254, 378, 16);
		window.getContentPane().add(actionPtLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Dialog", Font.BOLD, 11));
		backButton.setBounds(204, 280, 89, 23);
		window.getContentPane().add(backButton);
		
		JLabel availableActionLabel = new JLabel(memberStr + "'s Action Points : " + gameEnv.getSelectedMember().getActionPt());
		availableActionLabel.setOpaque(true);
		availableActionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableActionLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		availableActionLabel.setBounds(10, 69, 210, 23);
		window.getContentPane().add(availableActionLabel);
		
		JLabel tirednessLabel = new JLabel(memberStr + "'s tiredness : " + gameEnv.getSelectedMember().getTiredness() + "%");
		tirednessLabel.setOpaque(true);
		tirednessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tirednessLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		tirednessLabel.setBounds(287, 69, 210, 23);
		window.getContentPane().add(tirednessLabel);
		
		JSlider slider = new JSlider();
		slider.setForeground(Color.BLACK);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				sliderValue = (double) slider.getValue();
			}
		});
		slider.setBackground(Color.WHITE);
		slider.setBounds(84, 171, 333, 37);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setValue(3);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setOpaque(true);
		window.getContentPane().add(slider);
		
		JButton sleepButton = new JButton("Sleep");
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.selectSleepDuration(sliderValue);
				availableActionLabel.setText(memberStr + "'s Action Points : " + gameEnv.getSelectedMember().getActionPt());
				tirednessLabel.setText(memberStr + "'s tiredness : " + gameEnv.getSelectedMember().getTiredness() + "%");
			}
		});
		sleepButton.setFont(new Font("Dialog", Font.BOLD, 11));
		sleepButton.setBounds(204, 220, 89, 23);
		window.getContentPane().add(sleepButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(SleepScreen.class.getResource("/Images/new_sleep.jpg")));
		backGroundLabel.setBackground(Color.WHITE);
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}