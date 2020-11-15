package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class OverViewScreen {

	private JFrame window;
	private GameEnvironment gameEnv;
	
	/**
	 * Create the application.
	 * @param incomingGameEnv GameEnvironment
	 */
	public OverViewScreen(GameEnvironment incomingGameEnv) {
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
		gameEnv.closeOverViewScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setTitle("Overview Screen");
		window.setBounds(100, 100, 525, 350);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JButton cargoButton = new JButton("View Cargo");
		cargoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.overViewOptions("2");
				finishedWindow();
			}
		});
		cargoButton.setFont(new Font("Dialog", Font.BOLD, 13));
		cargoButton.setBounds(10, 22, 122, 50);
		window.getContentPane().add(cargoButton);
		
		JButton outpostButton = new JButton("Outpost");
		outpostButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getPlanet().hasOutpost()) {
					gameEnv.overViewOptions("3");
					finishedWindow();
				}
			}
		});
		outpostButton.setFont(new Font("Dialog", Font.BOLD, 13));
		outpostButton.setBounds(10, 84, 122, 50);
		window.getContentPane().add(outpostButton);
		
		JButton plotCourseButton = new JButton("Plot Course");
		plotCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!gameEnv.getCrew().getShip().isReady()) {
					gameEnv.overViewOptions("4");
					finishedWindow();
				}
			}
		});
		plotCourseButton.setFont(new Font("Dialog", Font.BOLD, 13));
		plotCourseButton.setBounds(10, 146, 122, 50);
		window.getContentPane().add(plotCourseButton);
		
		JButton pilotShipButton = new JButton("Pilot Ship");
		pilotShipButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getCrew().getShip().isReady()) {
					gameEnv.overViewOptions("5");
					finishedWindow();
				}
			}
		});
		pilotShipButton.setFont(new Font("Dialog", Font.BOLD, 13));
		pilotShipButton.setBounds(10, 207, 122, 50);
		window.getContentPane().add(pilotShipButton);
		
		JButton nextDayButton = new JButton("Next Day");
		nextDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameEnv.overViewOptions("6");
				finishedWindow();
			}
		});
		nextDayButton.setFont(new Font("Dialog", Font.BOLD, 13));
		nextDayButton.setBounds(10, 269, 122, 50);
		window.getContentPane().add(nextDayButton);
		
		String strMoney = "Credits: " + gameEnv.getCrew().getMoney();
		JLabel moneyLabel = new JLabel(strMoney);
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moneyLabel.setBackground(Color.LIGHT_GRAY);
		moneyLabel.setForeground(Color.BLACK);
		moneyLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		moneyLabel.setBounds(190, 88, 133, 23);
		moneyLabel.setOpaque(true);
		window.getContentPane().add(moneyLabel);
		
		String strDays = "Day Number: " + gameEnv.getDaysString();
		JLabel dayNumberLabel = new JLabel(strDays);
		dayNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dayNumberLabel.setBackground(Color.LIGHT_GRAY);
		dayNumberLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		dayNumberLabel.setBounds(190, 282, 133, 23);
		dayNumberLabel.setOpaque(true);
		window.getContentPane().add(dayNumberLabel);
		
		String strShield = "Shields: " + gameEnv.getShieldString();
		JLabel shipShieldsLabel = new JLabel(strShield);
		shipShieldsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shipShieldsLabel.setForeground(Color.BLACK);
		shipShieldsLabel.setBackground(Color.LIGHT_GRAY);
		shipShieldsLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		shipShieldsLabel.setBounds(190, 57, 133, 23);
		shipShieldsLabel.setOpaque(true);
		window.getContentPane().add(shipShieldsLabel);
		
		String strPart = "Parts Found: " + gameEnv.getPartString();
		JLabel partsFoundLabel = new JLabel(strPart);
		partsFoundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partsFoundLabel.setBackground(Color.LIGHT_GRAY);
		partsFoundLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		partsFoundLabel.setBounds(190, 247, 133, 23);
		partsFoundLabel.setOpaque(true);
		window.getContentPane().add(partsFoundLabel);
		
		JLabel crewMembersLabel = new JLabel("Crew Members:");
		crewMembersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		crewMembersLabel.setBackground(Color.LIGHT_GRAY);
		crewMembersLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		crewMembersLabel.setBounds(370, 32, 140, 29);
		crewMembersLabel.setOpaque(true);
		window.getContentPane().add(crewMembersLabel);
		
		String strMemeber_0 = "";
		if (gameEnv.getNumCrew() >= 1) {
			CrewMember member_0 = gameEnv.getMember(0);
			strMemeber_0 = "<html>" + member_0.getName() + "<br>" + member_0.getType() + "<br> ActionPts(" + member_0.getActionPt() + ")</html>";
		}
		JButton memberButton_0 = new JButton(strMemeber_0);
		memberButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 1) {
					gameEnv.setSelectedMember("1");
					gameEnv.overViewOptions("1");
					finishedWindow();
				}
			}
		});
		memberButton_0.setFont(new Font("Dialog", Font.BOLD, 11));
		memberButton_0.setBounds(383, 84, 111, 50);
		window.getContentPane().add(memberButton_0);
		
		String strMemeber_1 = "";
		if (gameEnv.getNumCrew() >= 2) {
			CrewMember member_1 = gameEnv.getMember(1);
			strMemeber_1 = "<html>" + member_1.getName() + "<br>" + member_1.getType() + "<br> ActionPts(" + member_1.getActionPt() + ")</html>";
		}
		JButton memberButton_1 = new JButton(strMemeber_1);
		memberButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 2) {
					gameEnv.setSelectedMember("2");
					gameEnv.overViewOptions("1");
					finishedWindow();
				}
			}
		});
		memberButton_1.setFont(new Font("Dialog", Font.BOLD, 11));
		memberButton_1.setBounds(383, 146, 111, 50);
		window.getContentPane().add(memberButton_1);
		
		String strMemeber_2 = "";
		if (gameEnv.getNumCrew() >= 3) {
			CrewMember member_2 = gameEnv.getMember(2);
			strMemeber_2 = "<html>" + member_2.getName() + "<br>" + member_2.getType() + "<br> ActionPts(" + member_2.getActionPt() + ")</html>";
		}
		JButton memberButton_2 = new JButton(strMemeber_2);
		memberButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 3) {
					gameEnv.setSelectedMember("3");
					gameEnv.overViewOptions("1");
					finishedWindow();
				}
			}
		});
		memberButton_2.setFont(new Font("Dialog", Font.BOLD, 11));
		memberButton_2.setBounds(383, 207, 111, 50);
		window.getContentPane().add(memberButton_2);
		
		String strMemeber_3 = "";
		if (gameEnv.getNumCrew() >= 4) {
			CrewMember member_3 = gameEnv.getMember(3);
			strMemeber_3 = "<html>" + member_3.getName() + "<br>" + member_3.getType() + "<br> ActionPts(" + member_3.getActionPt() + ")</html>";
		}
		JButton memberButton_3 = new JButton(strMemeber_3);
		memberButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (gameEnv.getNumCrew() >= 4) {
					gameEnv.setSelectedMember("4");
					gameEnv.overViewOptions("1");
					finishedWindow();
				}
			}
		});
		memberButton_3.setFont(new Font("Dialog", Font.BOLD, 11));
		memberButton_3.setBounds(383, 269, 111, 50);
		window.getContentPane().add(memberButton_3);
		
		String planetNameStr = "Planet Name: " + gameEnv.getPlanet().getName();
		JLabel planetNameLabel = new JLabel(planetNameStr);
		planetNameLabel.setBackground(Color.LIGHT_GRAY);
		planetNameLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		planetNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		planetNameLabel.setOpaque(true);
		planetNameLabel.setBounds(171, 173, 170, 23);
		window.getContentPane().add(planetNameLabel);
		
		String shipNameStr = gameEnv.getCrew().getName();
		JLabel shipNameLabel = new JLabel(shipNameStr);
		shipNameLabel.setForeground(Color.RED);
		shipNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shipNameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		shipNameLabel.setBackground(Color.LIGHT_GRAY);
		shipNameLabel.setBounds(157, 6, 201, 39);
		window.getContentPane().add(shipNameLabel);
		
		String partFoundStr = "Part detected on planet";
		if (gameEnv.getPlanet().isPartFound()) {
			partFoundStr = "No Part on planet";
		}
		JLabel partFoundLabel = new JLabel(partFoundStr);
		partFoundLabel.setHorizontalAlignment(SwingConstants.CENTER);
		partFoundLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		partFoundLabel.setBackground(Color.LIGHT_GRAY);
		partFoundLabel.setOpaque(true);
		partFoundLabel.setBounds(171, 212, 170, 23);
		window.getContentPane().add(partFoundLabel);
		
		String outpostStr = "Outpost near: No";
		if (gameEnv.getPlanet().hasOutpost()) {
			outpostStr = "Outpost near: Yes";
		}
		JLabel outpostNearbyLabel = new JLabel(outpostStr);
		outpostNearbyLabel.setBackground(Color.LIGHT_GRAY);
		outpostNearbyLabel.setOpaque(true);
		outpostNearbyLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		outpostNearbyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outpostNearbyLabel.setBounds(171, 130, 170, 23);
		window.getContentPane().add(outpostNearbyLabel);
		
		JLabel backGroundLabel = new JLabel("");
		backGroundLabel.setIcon(new ImageIcon(OverViewScreen.class.getResource("/Images/space_back.jpg")));
		backGroundLabel.setBounds(0, 0, 525, 328);
		window.getContentPane().add(backGroundLabel);
	}
}