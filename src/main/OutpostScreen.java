package main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class OutpostScreen {

	private JFrame window;
	private GameEnvironment gameEnv;

	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public OutpostScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeOutpostScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Outpost screen");
		window.setBounds(100, 100, 525, 376);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel outpostLabel = new JLabel("Outpost");
		outpostLabel.setBounds(175, 0, 163, 39);
		outpostLabel.setOpaque(true);
		outpostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outpostLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		outpostLabel.setBackground(Color.LIGHT_GRAY);
		window.getContentPane().add(outpostLabel);
		
		JLabel moneyCountLabel = new JLabel(gameEnv.getCrew().getMoney() + "   ");
		moneyCountLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		moneyCountLabel.setOpaque(true);
		moneyCountLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		moneyCountLabel.setBackground(Color.LIGHT_GRAY);
		moneyCountLabel.setBounds(418, 47, 50, 31);
		window.getContentPane().add(moneyCountLabel);
		
		JLabel medicalLabel = new JLabel("Medical Items");
		medicalLabel.setBounds(16, 17, 140, 39);
		medicalLabel.setBackground(Color.LIGHT_GRAY);
		medicalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medicalLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		medicalLabel.setOpaque(true);
		window.getContentPane().add(medicalLabel);
		
		JLabel foodLabel = new JLabel("Food Items");
		foodLabel.setBounds(289, 119, 140, 39);
		foodLabel.setBackground(Color.LIGHT_GRAY);
		foodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		foodLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		foodLabel.setOpaque(true);
		window.getContentPane().add(foodLabel);
		
		JLabel strepsilsLabel = new JLabel("<html>Strepsils<br>(Heals 25):<html>");
		strepsilsLabel.setBounds(16, 68, 84, 42);
		strepsilsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strepsilsLabel.setBackground(Color.LIGHT_GRAY);
		strepsilsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		strepsilsLabel.setOpaque(true);
		window.getContentPane().add(strepsilsLabel);
		
		JLabel strepCountLabel = new JLabel("" + gameEnv.getCrew().findMed("Strepsils").getCount());
		strepCountLabel.setBounds(99, 68, 57, 42);
		strepCountLabel.setOpaque(true);
		strepCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strepCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		strepCountLabel.setBackground(Color.LIGHT_GRAY);
		window.getContentPane().add(strepCountLabel);
		
		JButton strepsilsButton = new JButton("Buy for 5 Credits");
		strepsilsButton.setBounds(16, 105, 140, 31);
		strepsilsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.outpostShop("7");
				strepCountLabel.setText("" + gameEnv.getCrew().findMed("Strepsils").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		strepsilsButton.setFont(new Font("Dialog", Font.BOLD, 10));
		window.getContentPane().add(strepsilsButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setBounds(206, 61, 102, 46);
		backButton.setFont(new Font("Dialog", Font.BOLD, 12));
		window.getContentPane().add(backButton);
		
		JLabel medkitLabel = new JLabel("<html>MedKit:<br>(Heals 50)<html>");
		medkitLabel.setBounds(16, 153, 84, 39);
		medkitLabel.setOpaque(true);
		medkitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medkitLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		medkitLabel.setBackground(Color.LIGHT_GRAY);
		window.getContentPane().add(medkitLabel);
		
		JLabel medKitCountLabel = new JLabel("" + gameEnv.getCrew().findMed("Medkit").getCount());
		medKitCountLabel.setBounds(99, 153, 57, 39);
		medKitCountLabel.setOpaque(true);
		medKitCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medKitCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		medKitCountLabel.setBackground(Color.LIGHT_GRAY);
		window.getContentPane().add(medKitCountLabel);
		
		JButton medKitButton = new JButton("Buy for 10 Credits");
		medKitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.outpostShop("8");
				medKitCountLabel.setText("" + gameEnv.getCrew().findMed("Medkit").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		medKitButton.setFont(new Font("Dialog", Font.BOLD, 10));
		medKitButton.setBounds(16, 188, 140, 31);
		window.getContentPane().add(medKitButton);
		
		JLabel plagueCureLabel = new JLabel("Plague Cure:");
		plagueCureLabel.setOpaque(true);
		plagueCureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		plagueCureLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		plagueCureLabel.setBackground(Color.LIGHT_GRAY);
		plagueCureLabel.setBounds(16, 230, 102, 39);
		window.getContentPane().add(plagueCureLabel);
		
		JLabel plagueCountLabel = new JLabel("" + gameEnv.getCrew().findMed("Plague Cure").getCount());
		plagueCountLabel.setOpaque(true);
		plagueCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		plagueCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		plagueCountLabel.setBackground(Color.LIGHT_GRAY);
		plagueCountLabel.setBounds(106, 231, 50, 38);
		window.getContentPane().add(plagueCountLabel);
		
		JButton cureButton = new JButton("Buy for 20 Credits");
		cureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.outpostShop("9");
				plagueCountLabel.setText("" + gameEnv.getCrew().findMed("Plague Cure").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		cureButton.setFont(new Font("Dialog", Font.BOLD, 10));
		cureButton.setBounds(16, 268, 140, 31);
		window.getContentPane().add(cureButton);
		
		JLabel riceLabel = new JLabel("<html>Rice:<br>(Hunger 5)<html>");
		riceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riceLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		riceLabel.setBackground(Color.LIGHT_GRAY);
		riceLabel.setBounds(215, 170, 93, 42);
		riceLabel.setOpaque(true);
		window.getContentPane().add(riceLabel);
		
		JLabel riceCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Rice").getCount());
		riceCountLabel.setBackground(Color.LIGHT_GRAY);
		riceCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riceCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		riceCountLabel.setBounds(285, 170, 70, 42);
		riceCountLabel.setOpaque(true);
		window.getContentPane().add(riceCountLabel);
		
		JButton riceButton = new JButton("Buy for 1 Credit");
		riceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.outpostShop("1");
				riceCountLabel.setText("" + gameEnv.getCrew().findFood("Rice").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		riceButton.setFont(new Font("Dialog", Font.BOLD, 10));
		riceButton.setBounds(215, 212, 140, 19);
		window.getContentPane().add(riceButton);
		
		JLabel chipsLabel = new JLabel("<html>Chips:<br>(Hunger 10)<html>");
		chipsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chipsLabel.setOpaque(true);
		chipsLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		chipsLabel.setBackground(Color.LIGHT_GRAY);
		chipsLabel.setBounds(359, 170, 70, 42);
		window.getContentPane().add(chipsLabel);
		
		JLabel chipsCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Chips").getCount());
		chipsCountLabel.setOpaque(true);
		chipsCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chipsCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		chipsCountLabel.setBackground(Color.LIGHT_GRAY);
		chipsCountLabel.setBounds(429, 170, 70, 42);
		window.getContentPane().add(chipsCountLabel);
		
		JButton chipsButton = new JButton("Buy for 2 Credits");
		chipsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.outpostShop("2");
				chipsCountLabel.setText("" + gameEnv.getCrew().findFood("Chips").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		chipsButton.setFont(new Font("Dialog", Font.BOLD, 10));
		chipsButton.setBounds(359, 212, 140, 19);
		window.getContentPane().add(chipsButton);
		
		JLabel greenGoopLabel = new JLabel("<html>Green Goop:<br>(Hunger 25)<html>");
		greenGoopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greenGoopLabel.setOpaque(true);
		greenGoopLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		greenGoopLabel.setBackground(Color.LIGHT_GRAY);
		greenGoopLabel.setBounds(215, 233, 93, 42);
		window.getContentPane().add(greenGoopLabel);
		
		JLabel greenGoopCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Green Goop").getCount());
		greenGoopCountLabel.setOpaque(true);
		greenGoopCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greenGoopCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		greenGoopCountLabel.setBackground(Color.LIGHT_GRAY);
		greenGoopCountLabel.setBounds(285, 233, 70, 42);
		window.getContentPane().add(greenGoopCountLabel);
		
		JButton greenGoopButton = new JButton("Buy for 5 Credits");
		greenGoopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gameEnv.outpostShop("3");
				greenGoopCountLabel.setText("" + gameEnv.getCrew().findFood("Green Goop").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		greenGoopButton.setFont(new Font("Dialog", Font.BOLD, 10));
		greenGoopButton.setBounds(215, 274, 140, 19);
		window.getContentPane().add(greenGoopButton);
		
		JLabel pizzaLabel = new JLabel("<html>Pizza:<br>(Hunger 50)<html>");
		pizzaLabel.setOpaque(true);
		pizzaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		pizzaLabel.setBackground(Color.LIGHT_GRAY);
		pizzaLabel.setBounds(359, 233, 92, 42);
		window.getContentPane().add(pizzaLabel);
		
		JLabel pizzaCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Pizza").getCount());
		pizzaCountLabel.setOpaque(true);
		pizzaCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pizzaCountLabel.setBackground(Color.LIGHT_GRAY);
		pizzaCountLabel.setBounds(429, 233, 70, 42);
		window.getContentPane().add(pizzaCountLabel);
		
		JButton pizzaButton = new JButton("Buy for 10 Credits");
		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.outpostShop("4");
				pizzaCountLabel.setText("" + gameEnv.getCrew().findFood("Pizza").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		pizzaButton.setFont(new Font("Dialog", Font.BOLD, 10));
		pizzaButton.setBounds(359, 274, 140, 19);
		window.getContentPane().add(pizzaButton);
		
		JLabel ewokSteakLabel = new JLabel("<html>Ewok Steak:<br>(Hunger 75)<html>");
		ewokSteakLabel.setOpaque(true);
		ewokSteakLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ewokSteakLabel.setFont(new Font("Dialog", Font.BOLD, 11));
		ewokSteakLabel.setBackground(Color.LIGHT_GRAY);
		ewokSteakLabel.setBounds(215, 295, 92, 34);
		window.getContentPane().add(ewokSteakLabel);
		
		JLabel ewokSteakCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Ework Steak").getCount());
		ewokSteakCountLabel.setOpaque(true);
		ewokSteakCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ewokSteakCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		ewokSteakCountLabel.setBackground(Color.LIGHT_GRAY);
		ewokSteakCountLabel.setBounds(285, 295, 70, 34);
		window.getContentPane().add(ewokSteakCountLabel);
		
		JButton ewokSteakButton = new JButton("Buy for 15 Credits");
		ewokSteakButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.outpostShop("5");
				ewokSteakCountLabel.setText("" + gameEnv.getCrew().findFood("Ework Steak").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		ewokSteakButton.setFont(new Font("Dialog", Font.BOLD, 10));
		ewokSteakButton.setBounds(215, 329, 140, 19);
		window.getContentPane().add(ewokSteakButton);
		
		JLabel cthulhuCalamariLabel = new JLabel("<html>Cthulhu Calamari:<br>(Hunger100)<html>");
		cthulhuCalamariLabel.setOpaque(true);
		cthulhuCalamariLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cthulhuCalamariLabel.setFont(new Font("Dialog", Font.BOLD, 8));
		cthulhuCalamariLabel.setBackground(Color.LIGHT_GRAY);
		cthulhuCalamariLabel.setBounds(359, 295, 84, 35);
		window.getContentPane().add(cthulhuCalamariLabel);
		
		JLabel cthulhuCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Cthulhu Calamari").getCount());
		cthulhuCountLabel.setOpaque(true);
		cthulhuCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cthulhuCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		cthulhuCountLabel.setBackground(Color.LIGHT_GRAY);
		cthulhuCountLabel.setBounds(429, 295, 70, 35);
		window.getContentPane().add(cthulhuCountLabel);
		
		JButton cthulhuCalamariButton = new JButton("Buy for 20 Credits");
		cthulhuCalamariButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.outpostShop("6");
				cthulhuCountLabel.setText("" + gameEnv.getCrew().findFood("Cthulhu Calamari").getCount());
				moneyCountLabel.setText(gameEnv.getCrew().getMoney() + "   ");
			}
		});
		cthulhuCalamariButton.setFont(new Font("Dialog", Font.BOLD, 10));
		cthulhuCalamariButton.setBounds(359, 329, 140, 19);
		window.getContentPane().add(cthulhuCalamariButton);
		
		JLabel moneyLabel = new JLabel("Money: ");
		moneyLabel.setOpaque(true);
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		moneyLabel.setBackground(Color.LIGHT_GRAY);
		moneyLabel.setBounds(353, 47, 76, 31);
		window.getContentPane().add(moneyLabel);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(OutpostScreen.class.getResource("/Images/metalPlate_1.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 354);
		window.getContentPane().add(backGroundLabel);

	}
}