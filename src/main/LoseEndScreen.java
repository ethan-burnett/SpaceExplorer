package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LoseEndScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public LoseEndScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeLoseEndScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Lose End Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel gameOverLabel = new JLabel("<html>GameOver!<br>You Lose!<html>");
		gameOverLabel.setForeground(Color.RED);
		gameOverLabel.setBackground(Color.BLACK);
		gameOverLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gameOverLabel.setBounds(151, 0, 229, 88);
		window.getContentPane().add(gameOverLabel);
		
		JLabel loseTypeLabel = new JLabel(gameEnv.getEndType());
		loseTypeLabel.setBackground(Color.BLACK);
		loseTypeLabel.setForeground(Color.RED);
		loseTypeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loseTypeLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		loseTypeLabel.setBounds(34, 95, 449, 52);
		window.getContentPane().add(loseTypeLabel);
		
		JButton quitGameLabel = new JButton("Quit Game");
		quitGameLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		quitGameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		quitGameLabel.setBounds(179, 255, 173, 52);
		window.getContentPane().add(quitGameLabel);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(LoseEndScreen.class.getResource("/Images/new_lose_screen.jpg")));
		backGroundLabel.setBounds(-79, -33, 657, 385);
		window.getContentPane().add(backGroundLabel);
	}
}
