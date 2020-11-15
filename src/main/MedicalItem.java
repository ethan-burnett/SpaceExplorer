package main;

public class MedicalItem extends Item {
	
	private double healthGain;
	private boolean curePlague;
	
	/**
	 * Initialize the MedicalItem class.
	 * @param medName String
	 * @param healthValue double
	 * @param isCure boolean
	 * @param medCost integer
	 */
	public MedicalItem(String medName, double healthValue, boolean isCure, int medCost) {
		super(medName, medCost);
		healthGain = healthValue;
		curePlague = isCure;
	}
	
	/**
	 * Get the healthGain double.
	 * @return healthGain
	 */
	public double getHealth() {
		return healthGain;
	}
	
	/**
	 * Gets boolean for curing the plague or not.
	 * @return curePlague
	 */
	public boolean isCure() {
		return curePlague;
	}

}