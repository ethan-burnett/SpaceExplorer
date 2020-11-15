package main;

public class Ship {
	
	private String name;
	private double shieldHealth = 100;
	private boolean destroyed = false;
	private boolean ready = false;
	
	/**
	 * Initialize the Ship class.
	 * @param shipName String
	 */
	public Ship(String shipName) {
		name = shipName;
	}
	
	/**
	 * Gets the name of the ship.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the current shield health of the ship.
	 * @return shieldHealth
	 */
	public double getShieldHealth() {
		return shieldHealth;
	}
	
	/**
	 * If Ship is ready to move planet return true.
	 * @return ready
	 */
	public boolean isReady() {
		return ready;
	}
	
	/**
	 * If game should end return true. Checks destroyed variable.
	 * @return boolean
	 */
	public boolean isGameOver() {
		boolean result = false;
		if (destroyed) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Increases shieldHealth by given value * repairRate.
	 * @param value double
	 * @param member CrewMember
	 */
	public void repair(double value, CrewMember member) {
		double repairRate = 1;
		if (member.getType() == "Engineer") {
			repairRate = 1.5;
		}
		if (shieldHealth + (value * repairRate) > 100) {
			shieldHealth = 100;
		} else {
			shieldHealth += value * repairRate;
		}
	}
	
	/**
	 * Reduces shieldHealth by given value.
	 * @param value double
	 */
	public void damage(double value) {
		if (shieldHealth - value < 0) {
			shieldHealth = 0;
		} else {
			shieldHealth -= value;
		}
	}
	
	/**
	 * Changes destroyed variable to true if not already.
	 */
	public void destroy() {
		destroyed = true;
	}
	
	/**
	 * Changes ready to opposite boolean value.
	 */
	public void changeReadyStatus() {
		if (ready) {
			ready = false;
		} else {
			ready = true;
		}
	}

}
