package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberNameScreen {

	private JFrame window;
	private JTextField textField;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public MemberNameScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeMemberNameScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Name Member Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel enterNameLabel = new JLabel("Enter member's name:");
		enterNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterNameLabel.setForeground(Color.YELLOW);
		enterNameLabel.setFont(new Font("Dialog", Font.PLAIN, 18));
		enterNameLabel.setBounds(136, 56, 237, 37);
		window.getContentPane().add(enterNameLabel);
		
		textField = new JTextField();
		textField.setText("");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setBackground(Color.RED);
		textField.setBounds(80, 125, 348, 43);
		window.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.setMemberName(textField.getText());
				finishedWindow();
			}
		});
		nextButton.setBackground(Color.RED);
		nextButton.setFont(new Font("Dialog", Font.PLAIN, 20));
		nextButton.setBounds(169, 233, 174, 43);
		window.getContentPane().add(nextButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(MemberNameScreen.class.getResource("/Images/space_back.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}
