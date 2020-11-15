package main;

import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class GameEnvironment {
	
	private Crew crew;
	private int crewNum;
	private String memberName;
	private String memberType;
	private CrewMember selectedMember;
	private int numParts;
	private int currentPartNum = 0;
	private int endDay;
	private int currentDay = 1;
	private int planetIndex = 0;
	private ArrayList<Planet> planetList = new ArrayList<Planet>();
	
	/**
	 * Launch StartScreen.
	 */
	public void launchStartScreen() {
		StartScreen startWindow = new StartScreen(this);
	}
	
	/**
	 * Close StartScreen and launch NameShipScreen.
	 * @param startWindow StartScreen
	 */
	public void closeStartScreen(StartScreen startWindow) {
		startWindow.closeWindow();
		launchNameShipScreen();
	}
	
	/**
	 * Launch NameShipScreen.
	 */
	public void launchNameShipScreen() {
		NameShipScreen nameShipWindow = new NameShipScreen(this);
	}
	
	/**
	 * Close NameShipScreen and launch CrewNumberScreen.
	 * @param nameShipWindow NameShipScreen
	 */
	public void closeNameShipScreen(NameShipScreen nameShipWindow) {
		nameShipWindow.closeWindow();
		launchCrewNumberScreen();
	}
	
	/**
	 * Launch CrewNumberScreen.
	 */
	public void launchCrewNumberScreen() {
		CrewNumberScreen crewNumberWindow = new CrewNumberScreen(this);
	}
	
	/**
	 * Close CrewNumberScreen and launch MemberNameScreen.
	 * @param crewNumberWindow CrewNumberScreen
	 */
	public void closeCrewNumberScreen(CrewNumberScreen crewNumberWindow) {
		crewNumberWindow.closeWindow();
		launchMemberNameScreen();
	}
	
	/**
	 * Launch MemberNameScreen.
	 */
	public void launchMemberNameScreen() {
		MemberNameScreen memberNameWindow = new MemberNameScreen(this);
	}
	
	/**
	 * Close MemberNameScreen and launch MemberTypeScreen. 
	 * @param memberNameWindow MemberNameScreen
	 */
	public void closeMemberNameScreen(MemberNameScreen memberNameWindow) {
		memberNameWindow.closeWindow();
		launchMemberTypeScreen();
	}
	
	/**
	 * Launch MemberTypeScreen.
	 */
	public void launchMemberTypeScreen() {
		MemberTypeScreen memberTypeWindow = new MemberTypeScreen(this);
	}
	
	/**
	 * Close MemberTypeScreen. <br>
	 * Creates and adds new CrewMember to crew. <br>
	 * If all members created launch DayNumberScreen otherwise MemberNameScreen.
	 * @param memberTypeWindow MemberTypeScreen
	 */
	public void closeMemberTypeScreen(MemberTypeScreen memberTypeWindow) {
		memberTypeWindow.closeWindow();
		CrewMember member = new CrewMember(memberName, memberType);
		crew.addCrewMember(member);
		if (crewNum == crew.getCrewMemberList().size()) {
			launchDayNumberScreen();
		} else {
			launchMemberNameScreen();
		}
	}
	
	/**
	 * Launch DayNumberScreen.
	 */
	public void launchDayNumberScreen() {
		DayNumberScreen dayNumberWindow = new DayNumberScreen(this);
	}
	
	/**
	 * Close DayNumberScreen and launch OverViewScreen.
	 * @param dayNumberWindow DayNumberScreen
	 */
	public void closeDayNumberScreen(DayNumberScreen dayNumberWindow) {
		dayNumberWindow.closeWindow();
		launchOverViewScreen();
	}
	
	/**
	 * Launch OverViewScreen.
	 */
	public void launchOverViewScreen() {
		OverViewScreen overViewWindow = new OverViewScreen(this);
	}
	
	/**
	 * Close OverViewScreen.
	 * @param overViewWindow OverViewScreen
	 */
	public void closeOverViewScreen(OverViewScreen overViewWindow) {
		overViewWindow.closeWindow();
	}
	
	/**
	 * Launch CargoScreen.
	 */
	public void launchCargoScreen() {
		CargoScreen cargoWindow = new CargoScreen(this);
	}
	
	/**
	 * Close CargoScreen and launch OverViewScreen.
	 * @param cargoWindow CargoScreen
	 */
	public void closeCargoScreen(CargoScreen cargoWindow) {
		cargoWindow.closeWindow();
		launchOverViewScreen();
	}
	
	/**
	 * launch OutpostScreen.
	 */
	public void launchOutpostScreen() {
		OutpostScreen outpostWindow = new OutpostScreen(this);
	}
	
	/**
	 * Close OutpostScreen and launch OverViewScreen.
	 * @param outpostWindow OutpostScreen
	 */
	public void closeOutpostScreen(OutpostScreen outpostWindow) {
		outpostWindow.closeWindow();
		launchOverViewScreen();
	}
	
	/**
	 * Launch PlotCourseScreen.
	 */
	public void launchPlotCourseScreen() {
		PlotCourseScreen plotCourseWindow = new PlotCourseScreen(this);
	}
	
	/**
	 * Close PlotCourseScreen and launch OverViewScreen.
	 * @param plotCourseWindow PlotCourseScreen
	 */
	public void closePlotCourseScreen(PlotCourseScreen plotCourseWindow) {
		plotCourseWindow.closeWindow();
	}
	
	/**
	 * Launch PilotShipScreen.
	 */
	public void launchPilotShipScreen() {
		PilotShipScreen pilotShipWindow = new PilotShipScreen(this);
	}
	
	/**
	 * Close PilotShipScreen and launch OverViewScreen.
	 * @param pilotShipWindow PilotShipScreen
	 */
	public void closePilotShipScreen(PilotShipScreen pilotShipWindow) {
		pilotShipWindow.closeWindow();
	}
	
	/**
	 * Launch SelectedMemberScreen.
	 */
	public void launchSelectedMemberScreen() {
		SelectedMemberScreen selectedMemberWindow = new SelectedMemberScreen(this);
	}
	
	/**
	 * Close SelectedMemberScreen.
	 * @param selectedMemberWindow SelectedMemberScreen
	 */
	public void closeSelectedMemberScreen(SelectedMemberScreen selectedMemberWindow) {
		selectedMemberWindow.closeWindow();
	}
	
	/**
	 * Launch SearchResultScreen.
	 * @param resultString String
	 */
	public void launchSearchResultScreen(String resultString) {
		SearchResultScreen searchResultWindow = new SearchResultScreen(this, resultString);
	}
	
	/**
	 * Close SearchResultScreen and launch WinEndScreen if GameOver else launch SelectedMemberScreen.
	 * @param searchResultWindow SearchResultScreen
	 */
	public void closeSearchResultScreen(SearchResultScreen searchResultWindow) {
		searchResultWindow.closeWindow();
		if (isGameOver()) {
			launchWinEndScreen();
		} else {
			launchSelectedMemberScreen();
		}
	}
	
	/**
	 * Launch SelectMedScreen.
	 */
	public void launchSelectMedScreen() {
		SelectMedScreen selectMedWindow = new SelectMedScreen(this);
	}
	
	/**
	 * Close SelectMedScreen and launch SelectedMemberScreen.
	 * @param selectMedWindow SelectMedScreen
	 */
	public void closeSelectMedScreen(SelectMedScreen selectMedWindow) {
		selectMedWindow.closeWindow();
		launchSelectedMemberScreen();
	}
	
	/**
	 * Launch SelectFoodScreen.
	 */
	public void launchSelectFoodScreen() {
		SelectFoodScreen selectFoodWindow = new SelectFoodScreen(this);
	}
	
	/**
	 * Close SelectFoodScreen and launch SelectedMemberScreen.
	 * @param selectFoodWindow SelectFoodScreen
	 */
	public void closeSelectFoodScreen(SelectFoodScreen selectFoodWindow) {
		selectFoodWindow.closeWindow();
		launchSelectedMemberScreen();
	}
	
	/**
	 * launch SleepScreen.
	 */
	public void launchSleepScreen() {
		SleepScreen sleepWindow = new SleepScreen(this);
	}
	
	/**
	 * Close SleepScreen and launch SelectedMemberScreen.
	 * @param sleepWindow SleepScreen
	 */
	public void closeSleepScreen(SleepScreen sleepWindow) {
		sleepWindow.closeWindow();
		launchSelectedMemberScreen();
	}
	
	/**
	 * Launch RepairShipScreen.
	 */
	public void launchRepairShipScreen() {
		RepairShipScreen repairShipWindow = new RepairShipScreen(this);
	}
	
	/**
	 * Close RepairShipScreen and launch SelectedMemberScreen.
	 * @param repairShipWindow RepairShipScreen
	 */
	public void closeRepairShipScreen(RepairShipScreen repairShipWindow) {
		repairShipWindow.closeWindow();
		launchSelectedMemberScreen();
	}
	
	/**
	 * Launch AsteroidEventScreen.
	 */
	public void launchAsteroidEventScreen() {
		AsteroidEventScreen asteroidEventWindow = new AsteroidEventScreen(this);
	}
	
	/**
	 * Close AsteroidEventScreen and launch OverViewScreen.
	 * @param asteroidEventWindow AsteroidEventScreen
	 */
	public void closeAsteroidEventScreen(AsteroidEventScreen asteroidEventWindow) {
		asteroidEventWindow.closeWindow();
		launchOverViewScreen();
	}
	
	/**
	 * Launch PirateEventScreen.
	 * @param stolenItem String
	 */
	public void launchPirateEventScreen(String stolenItem) {
		PirateEventScreen pirateEventWindow = new PirateEventScreen(this, stolenItem);
	}
	
	/**
	 * Close PirateEventScreen.
	 * @param pirateEventWindow PirateEventScreen
	 */
	public void closePirateEventScreen(PirateEventScreen pirateEventWindow) {
		pirateEventWindow.closeWindow();
		plagueEvent();
	}
	
	/**
	 * Launch PlagueEventScreen.
	 */
	public void launchPlagueEventScreen() {
		PlagueEventScreen plagueEventWindow = new PlagueEventScreen(this);
	}
	
	/**
	 * Close PlagueEventScreen.
	 * @param plagueEventWindow PlagueEventScreen
	 */
	public void closePlagueEventScreen(PlagueEventScreen plagueEventWindow) {
		plagueEventWindow.closeWindow();
		launchOverViewScreen();
	}
	
	/**
	 * Launch DeathScreen.
	 * @param deathList ArrayList CrewMember
	 */
	public void launchDeathScreen(ArrayList<CrewMember> deathList) {
		DeathScreen deathWindow = new DeathScreen(this, deathList);
	}
	
	/**
	 * Close DeathScreen and call pirateEvent.
	 * @param deathWindow DeathScreen
	 */
	public void closeDeathScreen(DeathScreen deathWindow) {
		deathWindow.closeWindow();
		pirateEvent();
	}
	
	/**
	 * Launch WinEndScreen.
	 */
	public void launchWinEndScreen() {
		WinEndScreen winEndWindow = new WinEndScreen(this);
	}
	
	/**
	 * Close WinEndScreen and therefore end the game.
	 * @param winEndWindow WinEndScreen
	 */
	public void closeWinEndScreen(WinEndScreen winEndWindow) {
		winEndWindow.closeWindow();
	}
	
	/**
	 * Launch LoseEndScreen.
	 */
	public void launchLoseEndScreen() {
		LoseEndScreen loseEndWindow = new LoseEndScreen(this);
	}
	
	/**
	 * Close LoseEndScreen and therefore end the game.
	 * @param loseEndWindow LoseEndScreen
	 */
	public void closeLoseEndScreen(LoseEndScreen loseEndWindow) {
		loseEndWindow.closeWindow();
	}
	
	/**
	 * Returns the member selected to do actions.
	 * @return selectedMember
	 */
	public CrewMember getSelectedMember() {
		return selectedMember;
	}
	
	/**
	 * Sets the crew class with String name.
	 * @param name String
	 */
	public void setCrew(String name) {
		crew = new Crew(name);
	}
	
	/**
	 * Sets the original number of crew to number.
	 * @param number integer
	 */
	public void setCrewNum(int number) {
		crewNum = number;
	}
	
	/**
	 * Sets the next member name.
	 * @param name String
	 */
	public void setMemberName(String name) {
		memberName = name;
	}
	
	/**
	 * Sets the next member type.
	 * @param type String
	 */
	public void setMemberType(String type) {
		memberType = type;
	}
	
	/**
	 * Get the current size of crewMemberList.
	 * @return number of crew
	 */
	public int getNumCrew() {
		return crewNum;
	}
	
	/**
	 * Get the crew member at index.
	 * @param index integer
	 * @return CrewMember
	 */
	public CrewMember getMember(int index) {
		return crew.getCrewMemberList().get(index);
	}
	
	/**
	 * Get the current number of parts found and needed number of parts.
	 * @return String partString
	 */
	public String getPartString() {
		return currentPartNum + "/" + numParts;
	}
	
	/**
	 * Get the current shield %.
	 * @return String shieldString
	 */
	public String getShieldString() {
		return crew.getShip().getShieldHealth() + "%";
	}
	
	/**
	 * get the current day / endDay string.
	 * @return String daysString
	 */
	public String getDaysString() {
		return currentDay + "/" + endDay;
	}
	
	/**
	 * Makes a string from the deathList to be used by DeathScreen.
	 * @param deathList ArrayList CrewMember
	 * @return deathListStr
	 */
	public String getDeathString(ArrayList<CrewMember> deathList) {
		String deathListString = "<html>";
		for (CrewMember member: deathList) {
			deathListString += member.getName() + " has died!<br>";
		}
		return deathListString.substring(0, deathListString.length()-4) + "</html>";
	}
	
	/**
	 * Get the current planet at planetIndex within planetList.
	 * @return currentPlanet
	 */
	public Planet getPlanet() {
		return planetList.get(planetIndex);
	}
	
	/**
	 * Gets a string with all the infected members.
	 * @return String infectedString
	 */
	public String getInfectedString() {
		String str = "<html>";
		for (CrewMember member: crew.getCrewMemberList()) {
			if (member.isInfected()) {
				str += member.getName() + " is infected!<br>";
			}
		}
		return str.substring(0, str.length()-4) + "</html>";
	}
	
	/**
	 * Gets the current crew.
	 * @return crew
	 */
	public Crew getCrew() {
		return crew;
	}
	
	/**
	 * Makes a string for LoseEndScreen.
	 * @return end type
	 */
	public String getEndType() {
		String result;
		if (currentDay >= endDay+1) {
			result = "<html>The time to find the missing parts has run out.<br>Your crew of the " + getCrew().getName() + " have all failed.<html>";
		} else if (crewNum <= 0) {
			result = "<html>The last crew member of the " + getCrew().getName() + " has died.<br>Your crew have failed to find all missing parts.<html>";
		} else {
			result = "<html>An Asteroid has destroyed the " + getCrew().getName() + ".<br>The shields were too low. All the crew have perished.<html>";
		}
		return result;
	}
	
	/**
	 * Uses numDays to find the number of parts needed to win. <br>
	 * Sets the variables endDay and numParts. Also calls setPlanet.
	 * @param numDays integer
	 */
	public void setDayAndParts(int numDays) {
		endDay = numDays;
		if (3 == endDay || 4 == endDay) {
			numParts = 2;
		} else if (5 == endDay) {
			numParts = 3;
		} else if (6 == endDay || 7 == endDay) {
			numParts = 4;
		} else if (8 == endDay) {
			numParts = 5;
		} else if (9 == endDay || 10 == endDay){
			numParts = 6;
		} else {
			endDay = 3;
			numParts = 6;
		}
		setPlanets();
	}
	
	/**
	 * Constructs and adds the planets to the planetList. <br>
	 * Starting planet constructed and added first.
	 */
	public void setPlanets() {
		planetList.add(new Planet("Aiur", false));
		planetList.get(0).foundPart();
		planetList.add(new Planet("Veldin", true));
		planetList.add(new Planet("Rilgar", true));
		planetList.add(new Planet("Char", false));
		planetList.add(new Planet("Tatooine", true));
		planetList.add(new Planet("Titan", false));
		planetList.add(new Planet("Endor", true));
	}
	
	/**
	 * Changes the selectedMember to one of the crew members.
	 * @param ans String
	 */
	public void setSelectedMember(String ans) {
		switch (ans) {
			case "1":
				selectedMember = crew.getCrewMemberList().get(0);
				break;
			case "2":
				selectedMember = crew.getCrewMemberList().get(1);
				break;
			case "3":
				selectedMember = crew.getCrewMemberList().get(2);
				break;
			case "4":
				selectedMember = crew.getCrewMemberList().get(3);
				break;
		}
	}
	
	/**
	 * Member action that searches the planet for part, food, medical and money. <br>
	 * 1 out of 5 chance for each outcome. <br>
	 * If possible removes one of member's action points. <br>
	 * If member type is Scavenger two searches are performed with one action point. <br>
	 * Nothing can be found.
	 */
	public void searchPlanet() {
		int searchNum = 1;
		if (selectedMember.getType() == "Scavenger") {
			searchNum = 2;
		}
		if (selectedMember.getActionPt() >= 1) {
			selectedMember.removeActionPt(1);
			String resultString = "<html>";
			while (searchNum > 0) {
				Random rand = new Random();
				int randomNum = rand.nextInt(5);
				switch (randomNum) {
					case 0:
						if (!planetList.get(planetIndex).isPartFound()) {
							currentPartNum += 1;
							planetList.get(planetIndex).foundPart();
							resultString += "Found part";
						}
						break;
					case 1:
						int indexFood = rand.nextInt(6);
						FoodItem food = crew.getFoodList().get(indexFood);
						food.addCount();
						resultString += "Found " + food.getName();
						break;
					case 2:
						int indexMed = rand.nextInt(3);
						MedicalItem med = crew.getMedicalList().get(indexMed);
						med.addCount();
						resultString += "Found " + med.getName();
						break;
					case 3:
						int value = rand.nextInt(25) + 1;
						crew.changeMoney(value);
						resultString += "Found " + value + " Credits";
						break;
					default:
						break;
				}
				searchNum -= 1;
				if (searchNum > 0 && resultString != "<html>") {
					resultString += "<br>";
				}
			}
			if (resultString == "<html>") {
				resultString = "Nothing found";
			} else {
				resultString += "<html>";
			}
			launchSearchResultScreen(resultString);
		} else {
			launchSelectedMemberScreen();
		}
	}
	
	/**
	 * Member action which heals other member via the selectedMember with chosen MedicalItem.
	 * @param medName String
	 * @param other CrewMember
	 */
	public void selectMed(String medName, CrewMember other) {
		MedicalItem med = crew.findMed(medName);
		if (selectedMember.getActionPt() > 0 && other.getHealth() < 100 && med.getCount() > 0) {
			other.heal(med, selectedMember);
			selectedMember.removeActionPt(1);
			med.removeCount();
		}
	}
	/**
	 * Member action which feeds the selectedMember with chosen FoodItem.
	 * @param foodName String
	 */
	public void selectFood(String foodName) {
		FoodItem food = crew.findFood(foodName);
		if (selectedMember.getActionPt() > 0 && selectedMember.getHunger() > 0 && food.getCount() > 0) {
			selectedMember.feed(food);
			selectedMember.removeActionPt(1);
			food.removeCount();
		}
	}
	
	/**
	 * Member action which reduces Tiredness attribute for selectedMember. <br>
	 * The amount is inputed via player and used for CrewMember.sleep(value) method
	 * @param duration double
	 */
	public void selectSleepDuration(double duration) {
		if (selectedMember.getActionPt() > 0) {
			if (selectedMember.getActionPt() < duration) {
				duration = selectedMember.getActionPt();
			}
			selectedMember.sleep(duration * 10);
			selectedMember.removeActionPt((int) duration);
		}
	}
	
	/**
	 * Member action which repairs the ship by a given amount. <br>
	 * The amount is inputed via player and converted for Ship.repair(value, member) method.
	 * @param value double
	 */
	public void repairShip(double value) {
		if (selectedMember.getActionPt() > 0) {
			if (selectedMember.getActionPt() < value) {
				value = selectedMember.getActionPt();
			}
			crew.getShip().repair(value * 10, selectedMember);
			selectedMember.removeActionPt((int) value);
		}
	}
	
	/**
	 * Performs action from option inputed, launches screen if needed.
	 * @param ans String
	 */
	public void selectAction(String ans) {
			switch (ans) {
				case "1":
					searchPlanet();
					break;
				case "2":
					launchSelectMedScreen();
					break;
				case "3":
					launchSelectFoodScreen();
					break;
				case "4":
					launchSleepScreen();
					break;
				case "5":
					launchRepairShipScreen();
					break;
				case "6":
					launchOverViewScreen();
					break;
			}
	}
	
	/**
	 * FoodItems and medicalItems may be bought and increases count of that Item by one. <br>
     * If crewMoney is to low for chosen Item nothing happens.
     * @param ans String
	 */
	public void outpostShop(String ans) {
		switch (ans) {
			case "1":
				if (crew.getMoney() >= 1) {
					crew.findFood("Rice").addCount();
					crew.changeMoney(-1);
				}
				break;
			case "2":
				if (crew.getMoney() >= 2) {
					crew.findFood("Chips").addCount();
					crew.changeMoney(-2);
				}
				break;
			case "3":
				if (crew.getMoney() >= 5) {
					crew.findFood("Green Goop").addCount();
					crew.changeMoney(-5);
				}
				break;
			case "4":
				if (crew.getMoney() >= 10) {
					crew.findFood("Pizza").addCount();
					crew.changeMoney(-10);
				}
				break;
			case "5":
				if (crew.getMoney() >= 15) {
					crew.findFood("Ework Steak").addCount();
					crew.changeMoney(-15);
				}
				break;
			case "6":
				if (crew.getMoney() >= 20) {
					crew.findFood("Cthulhu Calamari").addCount();
					crew.changeMoney(-20);
				}
				break;
			case "7":
				if (crew.getMoney() >= 5) {
					crew.findMed("Strepsils").addCount();
					crew.changeMoney(-5);
				}
				break;
			case "8":
				if (crew.getMoney() >= 10) {
					crew.findMed("Medkit").addCount();
					crew.changeMoney(-10);
				}
				break;
			case "9":
				if (crew.getMoney() >= 20) {
					crew.findMed("Plague Cure").addCount();
					crew.changeMoney(-20);
				}
				break;
		}
	}
	
	/**
	 * If course not plotted and selected member has action points plot course.
	 */
	public void plotCourse() {
		int actionCost = 2;
		if (selectedMember.getType() == "Navigator") {
			actionCost = 1;
		}
		if (selectedMember.getActionPt() >= actionCost) {
			crew.getShip().changeReadyStatus();
			selectedMember.removeActionPt(actionCost);
			launchOverViewScreen();
		} else {
			launchPlotCourseScreen();
		}
	}
	
	/**
	 * Rolls the dice on traveling through an asteroid field. <br>
	 * 1 out of 4 chance of occurring. <br>
	 * If this occurs the ship shield health is reduced by half if greater than 15, else reduce by 15. <br>
	 * If the ship shield health is zero destroy the ship.
	 */
	public void asteroidEvent() {
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		if (randomNum == 0) {
			double value = 15;
			double currentShield = crew.getShip().getShieldHealth();
			if (currentShield <= 0) {
				crew.getShip().destroy();
			}
			if (currentShield > 15) {
				value = Math.round(currentShield / 2);
			}
			crew.getShip().damage(value);
			if (isGameOver()) {
				launchLoseEndScreen();
			} else {
				launchAsteroidEventScreen();
			}
		} else {
			launchOverViewScreen();
		}
	}
	
	/**
	 * Changes planetIndex to move to next planetList. <br>
	 * Then calls asteroidEvent.
	 */
	public void moveShip() {
		if (planetIndex + 1 == planetList.size()) {
			planetIndex = 1;
		} else {
			planetIndex += 1;
		}
		asteroidEvent();
	}
	
	/**
	 * If course is plotted a member is selected and that member uses action points <br>
	 * to move the ship via moveShip method.
	 */
	public void pilotShip() {
		int actionCost = 2;
		if (selectedMember.getType() == "Pilot") {
			actionCost = 1;
		}
		if (selectedMember.getActionPt() >= actionCost) {
			crew.getShip().changeReadyStatus();
			selectedMember.removeActionPt(actionCost);
			moveShip();
		} else {
			launchPilotShipScreen();
		}
	}
	
	/**
	 * Rolls the dice for getting the plague. <br>
	 * 1 out of 8 chance of becoming infected.
	 */
	public void plagueEvent() {
		boolean needPopUp = false;
		for (CrewMember member: crew.getCrewMemberList()) {
			Random rand = new Random();
			int randomNum = rand.nextInt(8);
			if (randomNum == 0) {
				member.infect();
			}
			if (member.isInfected()) {
				needPopUp = true;
			}
		}
		if (needPopUp) {
			launchPlagueEventScreen();
		} else {
			launchOverViewScreen();
		}
	}
	
	/**
	 * Rolls the dice for getting attacked by alien pirates. <br>
	 * 1 out of 4 chance of being boarded and having one item stolen. <br>
	 * If no items are in the cargo lists then no item is stolen.
	 */
	public void pirateEvent() {
		Random rand = new Random();
		int randomNum = rand.nextInt(4);
		if (randomNum == 0) {
			crew.stealItem(this);
		} else {
			plagueEvent();
		}
	}
	
	/**
	 * Updates the day number and each crew member. <br>
	 * Members are updated by checking if they need damage from low hunger, tiredness and plague. <br>
	 * The resetActionPt method is also used and if isAlive is false they are removed from the crew.
	 */
	public void nextDay() {
		currentDay += 1;
		ArrayList<CrewMember> deathList = new ArrayList<CrewMember>();
		for (CrewMember member: crew.getCrewMemberList()) {
			if (member.getHunger() >= 100) {
				member.damage(10);
			}
			if (member.getTiredness() >= 80) {
				member.damage(5);
			}
			if (member.isInfected()) {
				member.damage(50);
			}
			member.increaseHunger();
			member.increaseTiredness();
			member.resetActionPt();
			if (!member.isAlive()) {
				deathList.add(member);
			}
		}
		for (CrewMember deadMember: deathList) {
			crew.removeCrewMember(deadMember);
			crewNum -= 1;
		}
		if (!isGameOver() && deathList.size() > 0) {
			launchDeathScreen(deathList);
		} else if (!isGameOver()) {
			pirateEvent();
		} else {
			launchLoseEndScreen();
		}
	}
	
	
	/**
	 * Returns true if game should end. <br>
	 * Uses isGameOver method for crew and checks currentDay and currentPartNum.
	 * @return boolean
	 */
	public boolean isGameOver() {
		boolean result = false;
		if (crew.isGameOver() || currentDay >= endDay+1 || currentPartNum >= numParts) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Selects the correct option from below and performs its action.
	 * @param ans String
	 */
	public void overViewOptions(String ans) {
		switch (ans) {
		case "1":
			launchSelectedMemberScreen();
			break;
		case "2":
			launchCargoScreen();
			break;
		case "3":
			launchOutpostScreen();
			break;
		case "4":
			launchPlotCourseScreen();
			break;
		case "5":
			launchPilotShipScreen();
			break;
		case "6":
			nextDay();
			break;
		}
	}
	
	/**
	 * Launch the game.
	 * @param args arguments
	 */
	public static void main(String[] args) {
		GameEnvironment gameEnv = new GameEnvironment();
		
		gameEnv.launchStartScreen();
	}

}