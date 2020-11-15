package main;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PilotShipScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public PilotShipScreen(GameEnvironment incomingGameEnv) {
		gameEnv = incomingGameEnv;
		gameEnv.setSelectedMember("1");
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
		gameEnv.closePilotShipScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Pilot Ship Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		String memberNameStr = gameEnv.getSelectedMember().getName();
		JLabel memberNameLabel = new JLabel(memberNameStr);
		memberNameLabel.setBackground(Color.LIGHT_GRAY);
		memberNameLabel.setForeground(Color.BLACK);
		memberNameLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		memberNameLabel.setBounds(209, 53, 129, 30);
		memberNameLabel.setOpaque(true);
		window.getContentPane().add(memberNameLabel);
		
		String memeberStr_0 = "";
		if (gameEnv.getNumCrew() >= 1) {
			CrewMember member_0 = gameEnv.getMember(0);
			memeberStr_0 = "<html>" + member_0.getName() + "<br>" + member_0.getType() + "<br> ActionPts(" + member_0.getActionPt() + ")</html>";
		}
		JButton memberButton_0 = new JButton(memeberStr_0);
		memberButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 1) {
					gameEnv.setSelectedMember("1");
					memberNameLabel.setText(gameEnv.getSelectedMember().getName());
				}
			}
		});
		memberButton_0.setBackground(Color.LIGHT_GRAY);
		memberButton_0.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberButton_0.setBounds(22, 158, 146, 68);
		window.getContentPane().add(memberButton_0);
		
		String memeberStr_1 = "";
		if (gameEnv.getNumCrew() >= 2) {
			CrewMember member_1 = gameEnv.getMember(1);
			memeberStr_1 = "<html>" + member_1.getName() + "<br>" + member_1.getType() + "<br> ActionPts(" + member_1.getActionPt() + ")</html>";
		}
		JButton memberButton_1 = new JButton(memeberStr_1);
		memberButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 2) {
					gameEnv.setSelectedMember("2");
					memberNameLabel.setText(gameEnv.getSelectedMember().getName());
				}
			}
		});
		memberButton_1.setBackground(Color.LIGHT_GRAY);
		memberButton_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberButton_1.setBounds(192, 158, 146, 68);
		window.getContentPane().add(memberButton_1);
		
		String memeberStr_2 = "";
		if (gameEnv.getNumCrew() >= 3) {
			CrewMember member_2 = gameEnv.getMember(2);
			memeberStr_2 = "<html>" + member_2.getName() + "<br>" + member_2.getType() + "<br> ActionPts(" + member_2.getActionPt() + ")</html>";
		}
		JButton memberButton_2 = new JButton(memeberStr_2);
		memberButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 3) {
					gameEnv.setSelectedMember("3");
					memberNameLabel.setText(gameEnv.getSelectedMember().getName());
				}
			}
		});
		memberButton_2.setBackground(Color.LIGHT_GRAY);
		memberButton_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberButton_2.setBounds(22, 238, 146, 68);
		window.getContentPane().add(memberButton_2);
		
		String memeberStr_3 = "";
		if (gameEnv.getNumCrew() >= 4) {
			CrewMember member_3 = gameEnv.getMember(3);
			memeberStr_3 = "<html>" + member_3.getName() + "<br>" + member_3.getType() + "<br> ActionPts(" + member_3.getActionPt() + ")</html>";
		}
		JButton memberbutton_3 = new JButton(memeberStr_3);
		memberbutton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 4) {
					gameEnv.setSelectedMember("4");
					memberNameLabel.setText(gameEnv.getSelectedMember().getName());
				}
			}
		});
		memberbutton_3.setBackground(Color.LIGHT_GRAY);
		memberbutton_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberbutton_3.setBounds(192, 238, 146, 68);
		window.getContentPane().add(memberbutton_3);
		
		JLabel selectMemberLabel = new JLabel("Select crew member to pilot ship:");
		selectMemberLabel.setBackground(Color.LIGHT_GRAY);
		selectMemberLabel.setForeground(Color.BLACK);
		selectMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectMemberLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		selectMemberLabel.setBounds(22, 94, 271, 40);
		selectMemberLabel.setOpaque(true);
		window.getContentPane().add(selectMemberLabel);
		
		JLabel selectedLabel = new JLabel("Currently Selected: ");
		selectedLabel.setBackground(Color.LIGHT_GRAY);
		selectedLabel.setForeground(Color.BLACK);
		selectedLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		selectedLabel.setBounds(22, 53, 187, 30);
		selectedLabel.setOpaque(true);
		window.getContentPane().add(selectedLabel);
		
		JButton goButton = new JButton("Go");
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.pilotShip();
				finishedWindow();
			}
		});
		goButton.setFont(new Font("Dialog", Font.PLAIN, 25));
		goButton.setBounds(383, 55, 88, 136);
		window.getContentPane().add(goButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.launchOverViewScreen();
				finishedWindow();
			}
		});
		cancelButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		cancelButton.setBounds(372, 247, 116, 51);
		window.getContentPane().add(cancelButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(PilotShipScreen.class.getResource("/Images/new_pilot_ship.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}
