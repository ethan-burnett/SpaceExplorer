package main;

public class CrewMember {
	
	private double health = 100;
	private double healthRate = 1;
	
	private double hunger = 0;
	private double hungerRate = 1;
	
	private double tiredness = 0;
	private double tirednessRate = 1;
	
	private int actionPt = 5;
	
	private String name;
	private String type;
	private boolean hasPlague = false;
	private boolean alive = true;
	
	/**
	 * Initialize CrewMember class.
	 * @param crewName String
	 * @param crewType String
	 */
	public CrewMember(String crewName, String crewType) {
		name = crewName;
		switch (crewType) {
			case "1":
				type = "Pilot";
				break;
			case "2":
				type = "Medic";
				healthRate = 1.5;
				break;
			case "3":
				type = "Cyborg";
				healthRate = 0.5;
				hungerRate = 0.5;
				tirednessRate = 0.5;
				break;
			case "4":
				type = "Scavenger";
				hungerRate = 0.5;
				tirednessRate = 0.5;
				break;
			case "5":
				type = "Navigator";
				break;
			case "6":
				type = "Engineer";
				healthRate = 0.5;
				hungerRate = 1.5;
				tirednessRate = 0.5;
				break;
			default:
				type = "Unknown";
				break;
		}
	}
	
	/**
	 * Reduces the health of the member by given value * healthRate.
	 * @param value double
	 */
	public void damage(double value) {
		if (health - (value * healthRate) < 0) {
			health = 0;
			alive = false;
		} else {
			health = health - (value * healthRate);
		}
	}
	
	/**
	 * Heals the member via other (selectedMember), increasing their health.
	 * @param item MedicalItem
	 * @param member CrewMember
	 */
	public void heal(MedicalItem item, CrewMember member) {
		double healRate = 1;
		if (item.isCure()) {
			hasPlague = false;
		} 
		if (member.getType() == "Medic") {
			healRate = 1.5;
		} 
		if ((health + (item.getHealth() * healRate)) > 100) {
			health = 100;
		} else {
			health = health + (item.getHealth() * healRate);
		}
	}
	
	/**
	 * Change hasPlague to true if not already.
	 */
	public void infect() {
		hasPlague = true;
	}
	
	/**
	 * Gets and returns hasPlague boolean.
	 * @return boolean 
	 */
	public boolean isInfected() {
		return hasPlague;
	}
	
	/**
	 * Gets the current health.
	 * @return health
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Increases the hunger by 50 * hungerRate.
	 */
	public void increaseHunger() {
		if (hunger + (50 * hungerRate) > 100) {
			hunger = 100;
		} else {
			hunger = hunger + (50 * hungerRate);
		}
	}
	
	/**
	 * Reduced hunger via FoodItem.getHunger() value.
	 * @param food FoodItem
	 */
	public void feed(FoodItem food) {
		if ((hunger - food.getHunger()) < 0) {
			hunger = 0;
		} else {
			hunger = hunger - food.getHunger();
		}
	}
	
	/**
	 * Get the current hunger.
	 * @return hunger
	 */
	public double getHunger() {
		return hunger;
	}
	
	/**
	 * Reduces tiredness by the given value.
	 * @param value double
	 */
	public void sleep(double value) {
		if ((tiredness - value) < 0) {
			tiredness = 0;
		} else {
			tiredness = tiredness - value;
		}
	}
	
	/**
	 * Increases tiredness by 50 * tirednessRate.
	 */
	public void increaseTiredness() {
		if ((tiredness + (50 * tirednessRate)) > 100) {
			tiredness = 100;
		} else {
			tiredness = tiredness + (50 * tirednessRate);
		}
	}
	
	/**
	 * Gets the current tiredness.
	 * @return tiredness
	 */
	public double getTiredness() {
		return tiredness;
	}
	
	/**
	 * Remove current actionPt by given value.
	 * @param value integer
	 */
	public void removeActionPt(int value) {
		if (actionPt - value >= 0) {
			actionPt = actionPt - value;
		}
	}
	
	/**
	 * Changes actionPt to maxActionPt = 5.
	 */
	public void resetActionPt() {
		actionPt = 5;
	}
	
	/**
	 * Gets the current actionPt.
	 * @return actionPt
	 */
	public int getActionPt() {
		return actionPt;
	}
	
	/**
	 * Gets the name of the member.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the type of the member.
	 * @return type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Gets the boolean for alive.
	 * @return alive
	 */
	public boolean isAlive() {
		return alive;
	}
	
}