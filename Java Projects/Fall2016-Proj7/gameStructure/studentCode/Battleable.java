package studentCode;

/**
 * Objects that implement this interface can be put into a BattleDeck.
 */
public interface Battleable {
	
	/**
	 * Getter for the skill level of the creature.
	 * @return skill level of the creature
	 */
	public int getLevel();
	
	
	
	/**
	 * Getter for the name of the creature.
	 * @return name of the creature
	 */
	public String getName();
	
	
	
	
	/**
	 * Getter for the strength of the creature.
	 * @return strength of the item
	 */
	public int getStrength();
	
	
	
	/**
	 * Setter for the strength of the creature.
	 * @param newStrength the new strength value for the creature
	 */
	public void setStrength(int newStrength);
	
	
	
	/**
	 * Method to create an independent copy of the creature.
	 * @return independent copy of the creature
	 */
	public Battleable returnDuplicate();
	
	
	
	/**
	 * Method that takes the outcome of a battle and increments the level
	 *   if the number of victories has passed the threshold.
	 * @param outcome the outcome of the battle in which this creature was 
	 *   involved
	 * @return true if the outcome conveyed caused a level-up
	 */
	public boolean inform(Universe.Outcomes outcome);
	
	
	
	/**
	 * String generator for the creature.
	 * @return String representing the creature
	 */
	public String toString();
	
	

}
