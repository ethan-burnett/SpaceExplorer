package main;

public class FoodItem extends Item {
	
	private double hungerGain;
	
	/**
	 * Initialize FoodItem class.
	 * @param foodName String
	 * @param hungerValue double
	 * @param foodCost integer
	 */
	public FoodItem(String foodName, double hungerValue, int foodCost) {
		super(foodName, foodCost);
		hungerGain = hungerValue;
	}
	
	/**
	 * Get the double for hungerGain.
	 * @return hungerGain
	 */
	public double getHunger() {
		return hungerGain;
	}

}
