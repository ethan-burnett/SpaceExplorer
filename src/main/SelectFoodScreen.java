package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectFoodScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public SelectFoodScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeSelectFoodScreen(this);
	}
	
	private void initialize() {
		window = new JFrame();
		window.setTitle("Select Food screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		CrewMember member = gameEnv.getSelectedMember();
		JLabel selectFoodLabel = new JLabel("Select a food for " + member.getName() + " to eat");
		selectFoodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		selectFoodLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		selectFoodLabel.setBounds(104, 12, 299, 21);
		selectFoodLabel.setOpaque(true);
		window.getContentPane().add(selectFoodLabel);
		
		JLabel eatingTakesLabel = new JLabel("Eating any item of food costs 1 action point");
		eatingTakesLabel.setOpaque(true);
		eatingTakesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eatingTakesLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		eatingTakesLabel.setBounds(104, 32, 299, 21);
		window.getContentPane().add(eatingTakesLabel);
		
		JLabel availableActionPtsLabel = new JLabel(member.getName() + "'s available Action Points: " + member.getActionPt());
		availableActionPtsLabel.setOpaque(true);
		availableActionPtsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableActionPtsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		availableActionPtsLabel.setBounds(104, 52, 299, 21);
		window.getContentPane().add(availableActionPtsLabel);
		
		JLabel hungerLabel = new JLabel(member.getName() + "'s hunger: " + member.getHunger() + "%");
		hungerLabel.setOpaque(true);
		hungerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hungerLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		hungerLabel.setBounds(104, 72, 299, 21);
		window.getContentPane().add(hungerLabel);
		
		JLabel riceCountLabel = new JLabel("Rice (5% hunger) :       " + gameEnv.getCrew().findFood("Rice").getCount());
		riceCountLabel.setOpaque(true);
		riceCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		riceCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		riceCountLabel.setBounds(10, 116, 176, 21);
		window.getContentPane().add(riceCountLabel);
		
		JButton riceButton = new JButton("Eat Rice");
		riceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.selectFood("Rice");
				availableActionPtsLabel.setText(member.getName() + "'s available Action Points: " + member.getActionPt());
				riceCountLabel.setText("Rice (5% hunger) :       " + gameEnv.getCrew().findFood("Rice").getCount());
				hungerLabel.setText(member.getName() + "'s hunger: " + member.getHunger() + "%");
			}
		});
		riceButton.setFont(new Font("Dialog", Font.BOLD, 11));
		riceButton.setBounds(10, 136, 176, 23);
		window.getContentPane().add(riceButton);
		
		JLabel chipsCountLabel = new JLabel("Chips (10% hunger) :   " + gameEnv.getCrew().findFood("Chips").getCount());
		chipsCountLabel.setOpaque(true);
		chipsCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		chipsCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		chipsCountLabel.setBounds(10, 172, 176, 21);
		window.getContentPane().add(chipsCountLabel);
		
		JButton chipsButton = new JButton("Eat Chips");
		chipsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.selectFood("Chips");
				availableActionPtsLabel.setText(member.getName() + "'s available Action Points: " + member.getActionPt());
				chipsCountLabel.setText("Chips (10% hunger) :   " + gameEnv.getCrew().findFood("Chips").getCount());
				hungerLabel.setText(member.getName() + "'s hunger: " + member.getHunger() + "%");
			}
		});
		chipsButton.setFont(new Font("Dialog", Font.BOLD, 11));
		chipsButton.setBounds(10, 192, 176, 23);
		window.getContentPane().add(chipsButton);
		
		JLabel greenGoopCountLabel = new JLabel("Green Goop (25% hunger) :   " + gameEnv.getCrew().findFood("Green Goop").getCount());
		greenGoopCountLabel.setOpaque(true);
		greenGoopCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		greenGoopCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		greenGoopCountLabel.setBounds(277, 116, 227, 21);
		window.getContentPane().add(greenGoopCountLabel);
		
		JButton greenGoopButton = new JButton("Eat Green Goop");
		greenGoopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.selectFood("Green Goop");
				availableActionPtsLabel.setText(member.getName() + "'s available Action Points: " + member.getActionPt());
				greenGoopCountLabel.setText("Green Goop (25% hunger) :   " + gameEnv.getCrew().findFood("Green Goop").getCount());
				hungerLabel.setText(member.getName() + "'s hunger: " + member.getHunger() + "%");
			}
		});
		greenGoopButton.setFont(new Font("Dialog", Font.BOLD, 11));
		greenGoopButton.setBounds(277, 137, 227, 23);
		window.getContentPane().add(greenGoopButton);
		
		JLabel pizzaCountLabel = new JLabel("Pizza (50% hunger) :    " + gameEnv.getCrew().findFood("Pizza").getCount());
		pizzaCountLabel.setOpaque(true);
		pizzaCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		pizzaCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pizzaCountLabel.setBounds(10, 231, 176, 21);
		window.getContentPane().add(pizzaCountLabel);
		
		JButton pizzaButton = new JButton("Eat Pizza");
		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.selectFood("Pizza");
				availableActionPtsLabel.setText(member.getName() + "'s available Action Points: " + member.getActionPt());
				pizzaCountLabel.setText("Pizza (50% hunger) :    " + gameEnv.getCrew().findFood("Pizza").getCount());
				hungerLabel.setText(member.getName() + "'s hunger: " + member.getHunger() + "%");
			}
		});
		pizzaButton.setFont(new Font("Dialog", Font.BOLD, 11));
		pizzaButton.setBounds(10, 249, 176, 23);
		window.getContentPane().add(pizzaButton);
		
		JLabel ewokSteakCountLabel = new JLabel("Ewok Steak (75% hunger) :   " + gameEnv.getCrew().findFood("Ewok Steak").getCount());
		ewokSteakCountLabel.setOpaque(true);
		ewokSteakCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		ewokSteakCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		ewokSteakCountLabel.setBounds(277, 172, 227, 21);
		window.getContentPane().add(ewokSteakCountLabel);
		
		JButton ewokSteakButton = new JButton("Eat Ewok Steak");
		ewokSteakButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.selectFood("Pizza");
				availableActionPtsLabel.setText(member.getName() + "'s available Action Points: " + member.getActionPt());
				ewokSteakCountLabel.setText("Ewok Steak (75% hunger) :   " + gameEnv.getCrew().findFood("Ewok Steak").getCount());
				hungerLabel.setText(member.getName() + "'s hunger: " + member.getHunger() + "%");
			}
		});
		ewokSteakButton.setFont(new Font("Dialog", Font.BOLD, 11));
		ewokSteakButton.setBounds(277, 192, 227, 23);
		window.getContentPane().add(ewokSteakButton);
		
		JLabel calamariCountLabel = new JLabel("Ctuhlu Calamari (100% hunger) : " + gameEnv.getCrew().findFood("Ctuhlu Calamari").getCount());
		calamariCountLabel.setOpaque(true);
		calamariCountLabel.setHorizontalAlignment(SwingConstants.LEFT);
		calamariCountLabel.setFont(new Font("Dialog", Font.BOLD, 10));
		calamariCountLabel.setBounds(277, 231, 227, 21);
		window.getContentPane().add(calamariCountLabel);
		
		JButton calamariButton = new JButton("Eat Ctuhlu Calamari");
		calamariButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.selectFood("Pizza");
				availableActionPtsLabel.setText(member.getName() + "'s available Action Points: " + member.getActionPt());
				calamariCountLabel.setText("Cthulhu Calamari (100% hunger) : " + gameEnv.getCrew().findFood("Ctuhlu Calamari").getCount());
				hungerLabel.setText(member.getName() + "'s hunger: " + member.getHunger() + "%");
			}
		});
		calamariButton.setFont(new Font("Dialog", Font.BOLD, 11));
		calamariButton.setBounds(277, 249, 227, 23);
		window.getContentPane().add(calamariButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Dialog", Font.BOLD, 11));
		backButton.setBounds(173, 281, 120, 38);
		window.getContentPane().add(backButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(SelectFoodScreen.class.getResource("/Images/space_kitchen.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}