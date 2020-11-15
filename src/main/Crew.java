package main;

import java.util.*;

public class Crew {
	
	private ArrayList<CrewMember> crewMemberList = new ArrayList<CrewMember>();
	private String crewName;
	private Ship crewShip;
	private int crewMoney = 10;
	private ArrayList<FoodItem> foodList = new ArrayList<FoodItem>();
	private ArrayList<MedicalItem> medicalList = new ArrayList<MedicalItem>();
	
	/**
	 * Initialize the Crew class.
	 * @param name String
	 */
	public Crew(String name) {
		crewName = name;
		crewShip = new Ship(name);
		addFood(new FoodItem("Rice", 5, 1));
		addFood(new FoodItem("Chips", 10, 2));
		addFood(new FoodItem("Green Goop", 25, 5));
		addFood(new FoodItem("Pizza", 50, 10));
		addFood(new FoodItem("Ewok Steak", 75, 15));
		addFood(new FoodItem("Cthulhu Calamari", 100, 20));
		addMedical(new MedicalItem("Strepsils", 25, false, 5));
		addMedical(new MedicalItem("Medkit", 50, false, 10));
		addMedical(new MedicalItem("Plague Cure", 0, true, 20));
	}
	
	/**
	 * Returns true if game should end.<br>
	 * Uses ship.isGameOver and crewMemberList.size.
	 * @return boolean
	 */
	public boolean isGameOver() {
		boolean result = false;
		if (crewShip.isGameOver() || (getCrewMemberList().size() == 0)) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Gets current crewMemberList.
	 * @return crewMemberList
	 */
	public ArrayList<CrewMember> getCrewMemberList() {
		return crewMemberList;
	}
	
	/**
	 * Adds a CrewMember to crewMemberList.
	 * @param member CrewMember
	 */
	public void addCrewMember(CrewMember member) {
		crewMemberList.add(member);
	}
	
	/**
	 * Removes a CrewMember from crewMemberList.
	 * @param member CrewMember
	 */
	public void removeCrewMember(CrewMember member) {
		crewMemberList.remove(member);
	}
	
	/**
	 * Gets crew/ship name.
	 * @return crewName
	 */
	public String getName() {
		return crewName;
	}
	
	/**
	 * Gets the crews ship.
	 * @return crewShip
	 */
	public Ship getShip() {
		return crewShip;
	}
	
	/**
	 * Gets current amount of money.
	 * @return crewMoney
	 */
	public int getMoney() {
		return crewMoney;
	}
	
	/**
	 * Changes the crewMoney by adding or removing value.
	 * @param value integer
	 */
	public void changeMoney(int value) {
		if (crewMoney + value >= 0) {
			crewMoney += value;
		}
	}
	
	/**
	 * If possible removes one item at random from the crew. <br>
	 * If all item counts equal zero do nothing.
	 * @param gameEnv GameEnvironment
	 */
	public void stealItem(GameEnvironment gameEnv) {
		Random rand = new Random();
		ArrayList<Integer> indexFoodList = new ArrayList<Integer>();
		ArrayList<Integer> indexMedicalList = new ArrayList<Integer>();
		int foodIndex = 0;
		int medIndex = 0;
		for (FoodItem food: foodList) {
			if (food.getCount() > 0) {
				indexFoodList.add(foodIndex);
			}
			foodIndex += 1;
		}
		for (MedicalItem med: medicalList) {
			if (med.getCount() > 0) {
				indexMedicalList.add(medIndex);
			}
			medIndex += 1;
		}
		String stealFrom = "Something";
		if (indexMedicalList.size() == 0 && indexFoodList.size() == 0) {
			stealFrom = "Nothing";
		}
		if (stealFrom == "Something") {
			if (indexMedicalList.size() == 0) {
				stealFrom = "Food";
			} else if (indexFoodList.size() == 0) {
				stealFrom = "Medical";
			} else {
				int randomNum = rand.nextInt(2);
				if (randomNum == 0) {
					stealFrom = "Medical";
				} else {
					stealFrom = "Food";
				}
			}
			String itemStolen;
			if (stealFrom == "Medical") {
				int indexMed = rand.nextInt(indexMedicalList.size());
				MedicalItem med = getMedicalList().get(indexMedicalList.get(indexMed));
				med.removeCount();
				itemStolen = med.getName();
			} else {
				int indexFood = rand.nextInt(indexFoodList.size());
				FoodItem food = getFoodList().get(indexFoodList.get(indexFood));
				food.removeCount();
				itemStolen = food.getName();
			}
			gameEnv.launchPirateEventScreen(itemStolen);
		} else {
			gameEnv.plagueEvent();
		}
	}
	
	/**
	 * Finds the food with the given name.
	 * @param foodName String
	 * @return selectedFood 
	 */
	public FoodItem findFood(String foodName) {
		FoodItem selectedFood = foodList.get(0);
		for (FoodItem food: foodList) {
			if (food.getName() == foodName) {
				selectedFood = food;
			}
		}
		return selectedFood;
	}
	
	/**
	 * Gets the list of FoodItems
	 * @return foodList
	 */
	public ArrayList<FoodItem> getFoodList(){
		return foodList;
	}
	
	/**
	 * Adds the FoodItem to the foodList or increases its count.
	 * @param item FoodItem
	 */
	public void addFood(FoodItem item) {
		boolean found = false;
		int index = 0;
		while (!found) {
			if (index >= foodList.size()) {
				found = true;
				foodList.add(item);
			} else if (foodList.get(index) == item) {
				found = true;
				foodList.get(index).addCount();
			} else {
				index += 1;
			}
		}
	}
	
	/**
	 * Finds the medicalItem with the given name.
	 * @param medName String
	 * @return selectedMed
	 */
	public MedicalItem findMed(String medName) {
		MedicalItem selectedMed = medicalList.get(0);
		for (MedicalItem med: medicalList) {
			if (med.getName() == medName) {
				selectedMed = med;
			}
		}
		return selectedMed;
	}
	
	/**
	 * Gets current medicalList.
	 * @return medicalList
	 */
	public ArrayList<MedicalItem> getMedicalList(){
		return medicalList;
	}
	
	/**
	 * Add the MedicalItem to meicalList.
	 * @param item MedicalItem
	 */
	public void addMedical(MedicalItem item) {
		boolean found = false;
		int index = 0;
		while (!found) {
			if (index >= medicalList.size()) {
				found = true;
				medicalList.add(item);
			} else if (medicalList.get(index) == item) {
				found = true;
				medicalList.get(index).addCount();
			} else {
				index += 1;
			}
		}
	}
	
}