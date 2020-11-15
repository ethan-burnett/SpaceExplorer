package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CrewNumberScreen {

	private JFrame window;
	private int sliderValue = 3;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public CrewNumberScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeCrewNumberScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Crew Number Screen\r\n");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel enterAmountOfLabel = new JLabel("Select amount of crew (between 2-4):");
		enterAmountOfLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterAmountOfLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		enterAmountOfLabel.setForeground(Color.YELLOW);
		enterAmountOfLabel.setBounds(28, 56, 467, 37);
		window.getContentPane().add(enterAmountOfLabel);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sliderValue = slider.getValue();
			}
		});
		slider.setSnapToTicks(true);
		slider.setFont(new Font("Dialog", Font.BOLD, 20));
		slider.setForeground(Color.YELLOW);
		slider.setBackground(Color.RED);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setValue(3);
		slider.setMinimum(2);
		slider.setMaximum(4);
		slider.setPaintTicks(true);
		slider.setBounds(95, 122, 319, 52);
		window.getContentPane().add(slider);
		
		JButton nextButton = new JButton("NEXT");
		nextButton.setBackground(Color.RED);
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setCrewNum(sliderValue);
				finishedWindow();
			}
		});
		nextButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		nextButton.setBounds(169, 233, 174, 43);
		window.getContentPane().add(nextButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(CrewNumberScreen.class.getResource("/Images/space_back.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}
