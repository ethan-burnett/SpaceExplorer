package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DayNumberScreen {

	private JFrame window;
	private int sliderValue = 6;
	private GameEnvironment gameEnv;
	
	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public DayNumberScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeDayNumberScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Number of Days Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel selectNumberLabel = new JLabel("Select number of days:");
		selectNumberLabel.setForeground(Color.YELLOW);
		selectNumberLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		selectNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectNumberLabel.setBounds(136, 56, 245, 37);
		window.getContentPane().add(selectNumberLabel);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				sliderValue = slider.getValue();
			}
		});
		slider.setFont(new Font("Dialog", Font.BOLD, 20));
		slider.setMajorTickSpacing(1);
		slider.setValue(6);
		slider.setToolTipText("");
		slider.setSnapToTicks(true);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMinimum(3);
		slider.setMaximum(10);
		slider.setForeground(Color.YELLOW);
		slider.setBackground(Color.RED);
		slider.setBounds(95, 122, 319, 52);
		window.getContentPane().add(slider);
		
		JButton nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setDayAndParts(sliderValue);
				finishedWindow();
			}
		});
		nextButton.setBackground(Color.RED);
		nextButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		nextButton.setBounds(169, 233, 174, 43);
		window.getContentPane().add(nextButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(DayNumberScreen.class.getResource("/Images/space_back.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}
