package main;

public class Planet {
	
	private String name;
	private boolean hasOutpost;
	private boolean partFound = false;
	
	/**
	 * Initialize Planet class.
	 * @param newName String
	 * @param newOutpost boolean
	 */
	public Planet(String newName, boolean newOutpost) {
		name = newName;
		hasOutpost = newOutpost;
	}
	
	/**
	 * Gets the name of the planet.
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * If part has been found on planet return true.
	 * @return partFound
	 */
	public boolean isPartFound() {
		return partFound;
	}
	
	/**
	 * Changes partFound to true.
	 */
	public void foundPart() {
		partFound = true;
	}
	
	/**
	 * Gets hasOutpost boolean.
	 * @return hasOutpost
	 */
	public boolean hasOutpost() {
		return hasOutpost;
	}

}