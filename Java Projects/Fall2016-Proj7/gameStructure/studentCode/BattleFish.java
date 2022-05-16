package studentCode;



/** 
 * A mutable class that represents a BattleFish creature that might do battle
 * in our game.  As such, it implements the Battleable interface.
 * <br><br>
 * A BattleFish object has a name (String) and a strength (int) as well
 * as a number of level-ups (int) above its base and an internal counter
 * for how many victories it has had since its last level-up (int).
 */
public class BattleFish implements Battleable {
	
	private String name;
	private int strength;
	private int levelUps;
	private int victoriesSinceLevelUp;

	/**
	 * Standard constructor.  levelUps and victoriesSinceLevelUp start at 0.
	 * 
	 * @param nameIn desired name for this BattleFish
	 * @param strengthIn starting strength for this BattleFish
	 */
	public BattleFish(String nameIn, int strengthIn) {
		//throw new RuntimeException("You must implement this!");
		name=nameIn;
		strength=strengthIn;
		levelUps=0;
		victoriesSinceLevelUp=0;
	}

	
	/**
	 * Copy constructor.  
	 * 
	 * @param other reference to the existing object which is the basis of the new one
	 */
	public BattleFish(BattleFish other) {
		//throw new RuntimeException("You must implement this!");
		name=other.getName();
		strength=other.getStrength();
		levelUps=other.getLevel();
		victoriesSinceLevelUp=0;
	}
	
	
	/**
	 * Getter for skill level of the BattleFish, which is always 1 more than
	 * the number of levelUps they have.
	 * 
	 * @return skill level of the BattleFish
	 */
	public int getLevel() {
		//throw new RuntimeException("You must implement this!");
		return levelUps+1;
	}
	
	
	/**
	 * Getter for name of the BattleFish.
	 * 
	 * @return reference to the name of the BattleFish
	 */
	public String getName() {
		//throw new RuntimeException("You must implement this!");
		return name;
	}


	
	/**
	 * Getter for strength value of the BattleFish.
	 * 
	 * @return strength value of the BattleFish
	 */
	public int getStrength() {
		//throw new RuntimeException("You must implement this!");
		return strength;
	}

	
	/**
	 * Setter for the strength of the BattleFish.
	 * @param newStrength the new strength value for the BattleFish
	 */
	public void setStrength(int newStrength) {
		//throw new RuntimeException("You must implement this!");
		strength=newStrength;
	}

	
	
	/**
	 * Method that takes the outcome of a battle and increments the level
	 *   if the number of victories has passed the threshold.  We define 
	 *   "passed the threshold" as meaning the victories equals or exceeds 
	 *   the threshold.
	 * @param outcome the outcome of the battle in which this BattleFish was 
	 *   involved
	 * @return true if the outcome conveyed caused a level-up
	 */
	public boolean inform(Universe.Outcomes outcome) {
		//throw new RuntimeException("You must implement this!");
		switch(outcome)
		{
		
		case WIN:
			victoriesSinceLevelUp++;
			if(victoriesSinceLevelUp>=17)
			{
				levelUps++;
				return true;
			}
			
			return false;
			
		case LOSE:
			return false;
		
		
			
		case DRAW:
			return false;		
			
		
		}
		return false;
	}

	
	
	
	/**
	 * Method to create an independent copy of the BattleFish.
	 * @return independent copy of the BattleFish
	 */
	public Battleable returnDuplicate() {
		//throw new RuntimeException("You must implement this!");
		return new BattleFish(this);
	}
	
	
	
	
	
	
	
	/**
	 * The "usual suspect" toString method.
	 * @return a String describing the BattleFish
	 */
	
	public String toString() {
		return "BattleFish<Name: " + getName() + 
				"  Strength: " + getStrength() +
				"  Level: " + getLevel() +
				">";
	}
	
	/**
	 * The "usual suspect" equals method.
	 */
	
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		else if (this.getClass()!=other.getClass()) {
			return false;
		}
		else {
			BattleFish casted = (BattleFish)other;
			return 
					this.getName().equals(casted.getName()) 
					&& 
					this.getStrength() == casted.getStrength()
					&& 
					this.getLevel() == casted.getLevel();
		}
	}
	
}
