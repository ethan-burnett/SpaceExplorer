package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SelectMedScreen {

	private JFrame window;
	private String selectedMed = "Strepsils";
	private CrewMember other;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public SelectMedScreen(GameEnvironment incomingGameEnv) {
		gameEnv = incomingGameEnv;
		other = gameEnv.getMember(0);
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
		gameEnv.closeSelectMedScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Select Med Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel medBayLabel = new JLabel("Med Bay");
		medBayLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		medBayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medBayLabel.setBounds(166, 6, 161, 16);
		window.getContentPane().add(medBayLabel);
		
		CrewMember member = gameEnv.getSelectedMember();
		JLabel selectMemberLabel = new JLabel("Select a member from below for " + member.getName() + " to heal.");
		selectMemberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectMemberLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectMemberLabel.setBounds(27, 22, 460, 32);
		window.getContentPane().add(selectMemberLabel);
		
		JLabel selectMedicalItemLabel = new JLabel("Select a medical item from below to heal that selected member.");
		selectMedicalItemLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		selectMedicalItemLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectMedicalItemLabel.setBounds(27, 55, 460, 25);
		window.getContentPane().add(selectMedicalItemLabel);
		
		JLabel memberSelectionLabel = new JLabel("Member Selection:");
		memberSelectionLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberSelectionLabel.setBounds(16, 87, 124, 16);
		window.getContentPane().add(memberSelectionLabel);
		
		JLabel actionPtsLabel = new JLabel(member.getActionPt() + " Action Pts left");
		actionPtsLabel.setBackground(Color.LIGHT_GRAY);
		actionPtsLabel.setBounds(299, 255, 110, 16);
		actionPtsLabel.setOpaque(true);
		window.getContentPane().add(actionPtsLabel);
		
		String healthStr_0 = "";
		if (gameEnv.getNumCrew() >= 1) {
			healthStr_0 += gameEnv.getMember(0).getHealth();
		}
		JLabel healthLabel_0 = new JLabel(healthStr_0);
		healthLabel_0.setFont(new Font("Dialog", Font.PLAIN, 13));
		healthLabel_0.setBounds(179, 109, 83, 42);
		healthLabel_0.setOpaque(true);
		window.getContentPane().add(healthLabel_0);
		
		String healthStr_1 = "";
		if (gameEnv.getNumCrew() >= 2) {
			healthStr_1 += gameEnv.getMember(1).getHealth();
		}
		JLabel healthLabel_1 = new JLabel(healthStr_1);
		healthLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		healthLabel_1.setBounds(179, 149, 83, 42);
		healthLabel_1.setOpaque(true);
		window.getContentPane().add(healthLabel_1);
		
		String healthStr_2 = "";
		if (gameEnv.getNumCrew() >= 3) {
			healthStr_2 += gameEnv.getMember(2).getHealth();
		}
		JLabel healthLabel_2 = new JLabel(healthStr_2);
		healthLabel_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		healthLabel_2.setBounds(179, 190, 83, 42);
		healthLabel_2.setOpaque(true);
		window.getContentPane().add(healthLabel_2);
		
		String healthStr_3 = "";
		if (gameEnv.getNumCrew() >= 4) {
			healthStr_3 += gameEnv.getMember(3).getHealth();
		}
		JLabel healthLabel_3 = new JLabel(healthStr_3);
		healthLabel_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		healthLabel_3.setBounds(179, 232, 83, 42);
		healthLabel_3.setOpaque(true);
		window.getContentPane().add(healthLabel_3);
		
		JLabel medicalSelectionLabel = new JLabel("Medical Item Selection:");
		medicalSelectionLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		medicalSelectionLabel.setBounds(299, 87, 154, 16);
		window.getContentPane().add(medicalSelectionLabel);
		
		JLabel currentStuffLabel = new JLabel("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
		currentStuffLabel.setBackground(Color.WHITE);
		currentStuffLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		currentStuffLabel.setBounds(16, 277, 241, 45);
		currentStuffLabel.setOpaque(true);
		window.getContentPane().add(currentStuffLabel);
		
		String memberStr_0 = "";
		if (gameEnv.getNumCrew() >= 1) {
			memberStr_0 = gameEnv.getMember(0).getName();
		}
		JButton memberButton_0 = new JButton(memberStr_0);
		memberButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 1) {
					other = gameEnv.getMember(0);
					currentStuffLabel.setText("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
				}
			}
		});
		memberButton_0.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberButton_0.setBounds(6, 110, 161, 42);
		window.getContentPane().add(memberButton_0);
		
		String memberStr_1 = "";
		if (gameEnv.getNumCrew() >= 2) {
			memberStr_1 = gameEnv.getMember(1).getName();
		}
		JButton memberButton_1 = new JButton(memberStr_1);
		memberButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 2) {
					other = gameEnv.getMember(1);
					currentStuffLabel.setText("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
				}
			}
		});
		memberButton_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberButton_1.setBounds(6, 150, 161, 42);
		window.getContentPane().add(memberButton_1);
		
		String memberStr_2 = "";
		if (gameEnv.getNumCrew() >= 3) {
			memberStr_2 = gameEnv.getMember(2).getName();
		}
		JButton memberButton_2 = new JButton(memberStr_2);
		memberButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 3) {
					other = gameEnv.getMember(2);
					currentStuffLabel.setText("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
				}
			}
		});
		memberButton_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberButton_2.setBounds(6, 191, 161, 42);
		window.getContentPane().add(memberButton_2);
		
		String memberStr_3 = "";
		if (gameEnv.getNumCrew() >= 4) {
			memberStr_3 = gameEnv.getMember(3).getName();
		}
		JButton memberButton_3 = new JButton(memberStr_3);
		memberButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 4) {
					other = gameEnv.getMember(3);
					currentStuffLabel.setText("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
				}
			}
		});
		memberButton_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		memberButton_3.setBounds(6, 233, 161, 42);
		window.getContentPane().add(memberButton_3);
		
		JLabel currentHealthLabel = new JLabel("Current Health (%):");
		currentHealthLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		currentHealthLabel.setBounds(152, 87, 154, 16);
		window.getContentPane().add(currentHealthLabel);
		
		JButton strepButton = new JButton("Strepsils (heal 25%)");
		strepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMed = "Strepsils";
				currentStuffLabel.setText("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
			}
		});
		strepButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		strepButton.setBounds(268, 110, 211, 42);
		window.getContentPane().add(strepButton);
		
		JButton medkitButton = new JButton("Medkit (heal 50%)");
		medkitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMed = "Medkit";
				currentStuffLabel.setText("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
			}
		});
		medkitButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		medkitButton.setBounds(268, 157, 211, 42);
		window.getContentPane().add(medkitButton);
		
		JButton plagueCureButton = new JButton("Plague Cure (Cures Plague)");
		plagueCureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedMed = "Plague Cure";
				currentStuffLabel.setText("<html>Current member to heal: " + other.getName() + "<br>Current item to heal with: " + selectedMed + "<html>");
			}
		});
		plagueCureButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		plagueCureButton.setBounds(268, 204, 211, 42);
		window.getContentPane().add(plagueCureButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		backButton.setBounds(415, 261, 104, 42);
		window.getContentPane().add(backButton);
		
		JLabel strepCountLabel = new JLabel(gameEnv.getCrew().findMed("Strepsils").getCount() + "");
		strepCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strepCountLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		strepCountLabel.setBounds(475, 110, 44, 42);
		strepCountLabel.setOpaque(true);
		window.getContentPane().add(strepCountLabel);
		
		JLabel medkitCountLabel = new JLabel(gameEnv.getCrew().findMed("Medkit").getCount() + "");
		medkitCountLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		medkitCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medkitCountLabel.setBounds(475, 157, 44, 42);
		medkitCountLabel.setOpaque(true);
		window.getContentPane().add(medkitCountLabel);
		
		JLabel cureCountLabel = new JLabel(gameEnv.getCrew().findMed("Plague Cure").getCount() + "");
		cureCountLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		cureCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cureCountLabel.setBounds(475, 204, 44, 42);
		cureCountLabel.setOpaque(true);
		window.getContentPane().add(cureCountLabel);
		
		JButton healButton = new JButton("Heal");
		healButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.selectMed(selectedMed, other);
				strepCountLabel.setText(gameEnv.getCrew().findMed("Strepsils").getCount() + "");
				medkitCountLabel.setText(gameEnv.getCrew().findMed("Medkit").getCount() + "");
				cureCountLabel.setText(gameEnv.getCrew().findMed("Plague Cure").getCount() + "");
				actionPtsLabel.setText(member.getActionPt() + " Action Pts left");
				String health_0 = "";
				if (gameEnv.getNumCrew() >= 1) {
					health_0 += gameEnv.getMember(0).getHealth();
				}
				healthLabel_0.setText(health_0);
				String health_1 = "";
				if (gameEnv.getNumCrew() >= 2) {
					health_1 += gameEnv.getMember(1).getHealth();
				}
				healthLabel_1.setText(health_1);
				String health_2 = "";
				if (gameEnv.getNumCrew() >= 3) {
					health_2 += gameEnv.getMember(2).getHealth();
				}
				healthLabel_2.setText(health_2);
				String health_3 = "";
				if (gameEnv.getNumCrew() >= 4) {
					health_3 += gameEnv.getMember(3).getHealth();
				}
				healthLabel_3.setText(health_3);
			}
		});
		healButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		healButton.setBounds(320, 277, 83, 38);
		window.getContentPane().add(healButton);
		
		JLabel countLabel = new JLabel("Count:");
		countLabel.setBounds(465, 87, 54, 16);
		window.getContentPane().add(countLabel);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setOpaque(true);
		backGroundLabel.setBackground(Color.WHITE);
		backGroundLabel.setBounds(0, 107, 525, 221);
		window.getContentPane().add(backGroundLabel);
		
		JLabel backGroundLabel2 = new JLabel("");
		backGroundLabel2.setOpaque(true);
		backGroundLabel2.setBackground(Color.RED);
		backGroundLabel2.setBounds(0, 0, 525, 106);
		window.getContentPane().add(backGroundLabel2);
	}
}
