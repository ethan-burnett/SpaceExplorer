package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class StartScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public StartScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeStartScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Start screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("SPACE EXPLORER");
		titleLabel.setForeground(Color.YELLOW);
		titleLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 35));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setToolTipText("");
		titleLabel.setBounds(0, 17, 525, 79);
		window.getContentPane().add(titleLabel);
		
		JButton startGameButton = new JButton("START GAME");
		startGameButton.setBackground(Color.YELLOW);
		startGameButton.setForeground(Color.BLACK);
		startGameButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		startGameButton.setBounds(169, 233, 174, 43);
		window.getContentPane().add(startGameButton);
		
		JLabel storyLabel = new JLabel("<html><div style='text-align: center;'>Your crew's ship has been critically attacked by space pirates,<br> causing several important parts of the ship to scatter across the solar system.<br> In order to survive and return home your crew must find all of these parts<br> within a certain amount of time before the space pirates come back to destroy your crew for good.<div><html>");
		storyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		storyLabel.setForeground(Color.YELLOW);
		storyLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		storyLabel.setBounds(10, 91, 509, 122);
		window.getContentPane().add(storyLabel);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(StartScreen.class.getResource("/Images/space_back.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}
