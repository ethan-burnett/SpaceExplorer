package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CargoScreen {

	private JFrame window;
	private GameEnvironment gameEnv;
	
	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public CargoScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeCargoScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Cargo screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel medicalLabel = new JLabel("Medical Cargo");
		medicalLabel.setBackground(Color.LIGHT_GRAY);
		medicalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medicalLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		medicalLabel.setBounds(10, 11, 140, 72);
		medicalLabel.setOpaque(true);
		window.getContentPane().add(medicalLabel);
		
		JLabel foodLabel = new JLabel("Food Cargo\r\n");
		foodLabel.setBackground(Color.LIGHT_GRAY);
		foodLabel.setHorizontalAlignment(SwingConstants.CENTER);
		foodLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		foodLabel.setBounds(359, 11, 157, 64);
		foodLabel.setOpaque(true);
		window.getContentPane().add(foodLabel);
		
		JLabel strepsilsLabel = new JLabel("Strepsils");
		strepsilsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strepsilsLabel.setBackground(Color.LIGHT_GRAY);
		strepsilsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		strepsilsLabel.setBounds(10, 80, 75, 72);
		strepsilsLabel.setOpaque(true);
		window.getContentPane().add(strepsilsLabel);
		
		JLabel medkitLabel = new JLabel("MedKit");
		medkitLabel.setOpaque(true);
		medkitLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medkitLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		medkitLabel.setBackground(Color.LIGHT_GRAY);
		medkitLabel.setBounds(10, 147, 75, 72);
		window.getContentPane().add(medkitLabel);
		
		JLabel plagueCureLabel = new JLabel("Plague Cure");
		plagueCureLabel.setOpaque(true);
		plagueCureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		plagueCureLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		plagueCureLabel.setBackground(Color.LIGHT_GRAY);
		plagueCureLabel.setBounds(10, 207, 86, 72);
		window.getContentPane().add(plagueCureLabel);
		
		JLabel strepCountLabel = new JLabel("" + gameEnv.getCrew().findMed("Strepsils").getCount());
		strepCountLabel.setOpaque(true);
		strepCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		strepCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		strepCountLabel.setBackground(Color.LIGHT_GRAY);
		strepCountLabel.setBounds(82, 80, 68, 72);
		window.getContentPane().add(strepCountLabel);
		
		JLabel medKitCountLabel = new JLabel("" + gameEnv.getCrew().findMed("Medkit").getCount());
		medKitCountLabel.setOpaque(true);
		medKitCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		medKitCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		medKitCountLabel.setBackground(Color.LIGHT_GRAY);
		medKitCountLabel.setBounds(82, 147, 68, 72);
		window.getContentPane().add(medKitCountLabel);
		
		JLabel plagueCureCountLabel = new JLabel("" + gameEnv.getCrew().findMed("Plague Cure").getCount());
		plagueCureCountLabel.setOpaque(true);
		plagueCureCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		plagueCureCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		plagueCureCountLabel.setBackground(Color.LIGHT_GRAY);
		plagueCureCountLabel.setBounds(82, 207, 68, 72);
		window.getContentPane().add(plagueCureCountLabel);
		
		JLabel riceLabel = new JLabel("Rice");
		riceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riceLabel.setOpaque(true);
		riceLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		riceLabel.setBackground(Color.LIGHT_GRAY);
		riceLabel.setBounds(359, 72, 86, 35);
		window.getContentPane().add(riceLabel);
		
		JLabel riceCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Rice").getCount());
		riceCountLabel.setOpaque(true);
		riceCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		riceCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		riceCountLabel.setBackground(Color.LIGHT_GRAY);
		riceCountLabel.setBounds(441, 72, 75, 35);
		window.getContentPane().add(riceCountLabel);
		
		JLabel chipsLabel = new JLabel("Chips");
		chipsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chipsLabel.setOpaque(true);
		chipsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		chipsLabel.setBackground(Color.LIGHT_GRAY);
		chipsLabel.setBounds(359, 99, 86, 37);
		window.getContentPane().add(chipsLabel);
		
		JLabel chipsCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Chips").getCount());
		chipsCountLabel.setOpaque(true);
		chipsCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		chipsCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		chipsCountLabel.setBackground(Color.LIGHT_GRAY);
		chipsCountLabel.setBounds(441, 98, 75, 37);
		window.getContentPane().add(chipsCountLabel);
		
		JLabel greenGoopLabel = new JLabel("<html>Green<br>Goop<html>");
		greenGoopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greenGoopLabel.setOpaque(true);
		greenGoopLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		greenGoopLabel.setBackground(Color.LIGHT_GRAY);
		greenGoopLabel.setBounds(359, 134, 86, 37);
		window.getContentPane().add(greenGoopLabel);
		
		JLabel greenGoopCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Green Goop").getCount());
		greenGoopCountLabel.setOpaque(true);
		greenGoopCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		greenGoopCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		greenGoopCountLabel.setBackground(Color.LIGHT_GRAY);
		greenGoopCountLabel.setBounds(441, 134, 75, 37);
		window.getContentPane().add(greenGoopCountLabel);
		
		JLabel ewokSteakLabel = new JLabel("<html>Ewok<br>Steak<html>");
		ewokSteakLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ewokSteakLabel.setOpaque(true);
		ewokSteakLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		ewokSteakLabel.setBackground(Color.LIGHT_GRAY);
		ewokSteakLabel.setBounds(359, 200, 86, 40);
		window.getContentPane().add(ewokSteakLabel);
		
		JLabel ewokSteakCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Ework Steak").getCount());
		ewokSteakCountLabel.setOpaque(true);
		ewokSteakCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ewokSteakCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		ewokSteakCountLabel.setBackground(Color.LIGHT_GRAY);
		ewokSteakCountLabel.setBounds(441, 205, 75, 40);
		window.getContentPane().add(ewokSteakCountLabel);
		
		JLabel ctuhluCalamariLabel = new JLabel("<html>Cthulhu<br>Calamari<html>");
		ctuhluCalamariLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ctuhluCalamariLabel.setOpaque(true);
		ctuhluCalamariLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		ctuhluCalamariLabel.setBackground(Color.LIGHT_GRAY);
		ctuhluCalamariLabel.setBounds(359, 239, 86, 40);
		window.getContentPane().add(ctuhluCalamariLabel);
		
		JLabel calamariCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Cthulhu Calamari").getCount());
		calamariCountLabel.setOpaque(true);
		calamariCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		calamariCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		calamariCountLabel.setBackground(Color.LIGHT_GRAY);
		calamariCountLabel.setBounds(441, 244, 75, 35);
		window.getContentPane().add(calamariCountLabel);
		
		JLabel Cargo = new JLabel("Cargo");
		Cargo.setOpaque(true);
		Cargo.setHorizontalAlignment(SwingConstants.CENTER);
		Cargo.setFont(new Font("Dialog", Font.BOLD, 24));
		Cargo.setBackground(Color.LIGHT_GRAY);
		Cargo.setBounds(181, 11, 140, 72);
		window.getContentPane().add(Cargo);
		
		JLabel pizzaLabel = new JLabel("Pizza");
		pizzaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaLabel.setOpaque(true);
		pizzaLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pizzaLabel.setBackground(Color.LIGHT_GRAY);
		pizzaLabel.setBounds(359, 164, 86, 46);
		window.getContentPane().add(pizzaLabel);
		
		JLabel pizzaCountLabel = new JLabel("" + gameEnv.getCrew().findFood("Pizza").getCount());
		pizzaCountLabel.setOpaque(true);
		pizzaCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaCountLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		pizzaCountLabel.setBackground(Color.LIGHT_GRAY);
		pizzaCountLabel.setBounds(441, 164, 75, 46);
		window.getContentPane().add(pizzaCountLabel);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		backButton.setFont(new Font("Dialog", Font.BOLD, 12));
		backButton.setBounds(181, 233, 140, 46);
		window.getContentPane().add(backButton);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(CargoScreen.class.getResource("/Images/metalPlate_1.jpg")));
		backGroundLabel.setBounds(-64, -24, 621, 394);
		window.getContentPane().add(backGroundLabel);
	}
}