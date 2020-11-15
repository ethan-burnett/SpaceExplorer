package main;

public class Item {
	
	private String name;
	private int cost;
	private int count = 0;
	
	/**
	 * Initialize the Item class.
	 * @param itemName String
	 * @param itemCost integer
	 */
	public Item(String itemName, int itemCost) {
		name = itemName;
		cost = itemCost;
	}
	
	/**
	 * Overwrites the equals method to check Item name.
	 * @param item Item
	 * @return boolean
	 */
	public boolean equals(Item item) {
		boolean result = false;
		if (item.getName() == name) {
			result = true;
		}
		return result;
	}
	
	/**
	 * Gets the name of Item.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the integer cost of item.
	 * @return cost
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * gets the current count of Item.
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Adds 1 to count.
	 */
	public void addCount() {
		count += 1;
	}
	
	/**
	 * Removes 1 from count.
	 */
	public void removeCount() {
		if (count > 0) {
			count -= 1;
		}
	}

}
