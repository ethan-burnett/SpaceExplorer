package main;
	
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JButton;
	import java.awt.Font;
	import javax.swing.SwingConstants;
	import java.awt.Color;
	import javax.swing.ImageIcon;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	
	public class WinEndScreen {
	
		private JFrame window;
		private GameEnvironment gameEnv;
	
		/**
		 * Create the application.
		 * @param incomingGameEnv GameEnvironment
		 */
		public WinEndScreen(GameEnvironment incomingGameEnv) {
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
			gameEnv.closeWinEndScreen(this);
		}
	
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			window = new JFrame();
			window.setTitle("Win End Screen");
			window.setBounds(100, 100, 525, 350);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.getContentPane().setLayout(null);
	
			JButton quitButton = new JButton("Quit Game");
			quitButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					finishedWindow();
				}
			});
			quitButton.setFont(new Font("Dialog", Font.BOLD, 12));
			quitButton.setBounds(195, 249, 114, 40);
			window.getContentPane().add(quitButton);
	
			JLabel congratLabel = new JLabel("CONGRATULATIONS YOU WIN!");
			congratLabel.setForeground(new Color(0, 0, 0));
			congratLabel.setHorizontalAlignment(SwingConstants.CENTER);
			congratLabel.setFont(new Font("Dialog", Font.BOLD, 23));
			congratLabel.setBounds(6, 65, 513, 30);
			congratLabel.setOpaque(true);
			window.getContentPane().add(congratLabel);
	
			String shipNameStr = gameEnv.getCrew().getName();
			JLabel storyLabel = new JLabel("Your crew and the " + shipNameStr + " have made it back home to Earth safely!");
			storyLabel.setOpaque(true);
			storyLabel.setHorizontalAlignment(SwingConstants.CENTER);
			storyLabel.setForeground(Color.BLACK);
			storyLabel.setFont(new Font("Dialog", Font.BOLD, 12));
			storyLabel.setBounds(6, 217, 513, 21);
			window.getContentPane().add(storyLabel);
	
			JLabel backGroundLabel = new JLabel("");
			backGroundLabel.setIcon(new ImageIcon(WinEndScreen.class.getResource("/Images/earth_return.jpeg")));
			backGroundLabel.setBounds(-77, -11, 675, 377);
			window.getContentPane().add(backGroundLabel);
		}
	}