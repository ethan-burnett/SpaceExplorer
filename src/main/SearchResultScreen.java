package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SearchResultScreen {

	private JFrame window;
	private String resultString;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 * @param incomingResults String
	 */
	public SearchResultScreen(GameEnvironment incomingGameEnv, String incomingResults) {
		resultString = incomingResults;
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
		gameEnv.closeSearchResultScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Search Result Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel searchResultsLabel = new JLabel("Search Results");
		searchResultsLabel.setBackground(Color.LIGHT_GRAY);
		searchResultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchResultsLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		searchResultsLabel.setBounds(164, 16, 180, 45);
		searchResultsLabel.setOpaque(true);
		window.getContentPane().add(searchResultsLabel);
		
		JLabel whoWhereLabel = new JLabel(gameEnv.getSelectedMember().getName() + " found the following on " + gameEnv.getPlanet().getName() + "!");
		whoWhereLabel.setBackground(Color.LIGHT_GRAY);
		whoWhereLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		whoWhereLabel.setHorizontalAlignment(SwingConstants.CENTER);
		whoWhereLabel.setBounds(69, 90, 394, 26);
		whoWhereLabel.setOpaque(true);
		window.getContentPane().add(whoWhereLabel);
		
		JLabel resultsLabel = new JLabel(resultString);
		resultsLabel.setBackground(Color.LIGHT_GRAY);
		resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultsLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		resultsLabel.setBounds(122, 143, 264, 80);
		resultsLabel.setOpaque(true);
		window.getContentPane().add(resultsLabel);
		
		JButton okButton = new JButton("Ok");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		okButton.setFont(new Font("Dialog", Font.PLAIN, 16));
		okButton.setBounds(207, 246, 102, 53);
		window.getContentPane().add(okButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(SearchResultScreen.class.getResource("/Images/metalPlate_1.jpg")));
		backGroundLabel.setBounds(-245, -216, 770, 544);
		window.getContentPane().add(backGroundLabel);
	}
}
