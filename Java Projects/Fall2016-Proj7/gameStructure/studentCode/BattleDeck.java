package studentCode;

import java.util.ArrayList;


/** 
 * A data structure class that stores deep copies of any creatures 
 * that are sent to do battle.  By having deep copies, the player's
 * character does not get permanently damaged in their personal 
 * library, only in this playing of the game.
 * <br><br>
 * A BattleDeck object has a list of Battleable creatures held in 
 * an ArrayList object.  It cannot be used to hold anything that
 * doesn't implement the Battleable interface.
 */
public class BattleDeck<T extends Battleable> {
	private ArrayList<Battleable> arr;
	
	//You might end up adding more instance fields...


	/**
	 * Standard constructor.  It needs to initialize the ArrayList object 
	 * and do any other setup that you deem necessary for this class object.
	 */
	public BattleDeck() {
		throw new RuntimeException("You must implement this!");
	}

	
	
	/**
	 * Adds an item to the BattleDeck in a very special way.  
	 * The structure is double-ended; this means that the "side" to which
	 * objects are added alternates with every other item added.  If things
	 * are added in the order 1,2,3,4,5 then the BattleDeck would grow as
	 * the following:<br>
	 * &nbsp;&nbsp;&nbsp;1<br>
	 * &nbsp;&nbsp;&nbsp;1,2<br>
	 * &nbsp;&nbsp;&nbsp;3,1,2<br>
	 * &nbsp;&nbsp;&nbsp;3,1,2,4<br>
	 * &nbsp;&nbsp;&nbsp;5,3,1,2,4<br>
	 * It is your job to determine a good way to ensure this alternation.
	 * 
	 * @param newItem refers to a creature to be added to this BattleDeck
	 */
	public void add(T newItem) {
		throw new RuntimeException("You must implement this!");
	}

	
	
	/**
	 * Goes through each item in the BattleDeck and deducts the specified 
	 * loss value from every creature it contains.
	 * 
	 * @param lossValue the value to deduct from the strength level
	 */
	public void weakenCreatures(int lossValue) {
		throw new RuntimeException("You must implement this!");
	}
	
	
	/**
	 * Removes any creature currently in the battle deck who have
	 * no more strength left.
	 */
	public void sweepDeck() {
		throw new RuntimeException("You must implement this!");
	}
	
	
	
	/**
	 * Shuffles the contents of the deck in the way described here. 
	 * The deck will be divided into two "packets" (we will call them 
	 * the top half and the bottom half).  The shuffled BattleDeck of 
	 * cards will consist of the first card from the top packet, 
	 * followed by the first card from the bottom packet, followed by 
	 * the second card from the top packet, followed by the second card 
	 * from the bottom packet, etc. 
	 * 
	 * Important: If there are an odd number of cards, the top packet 
	 * should have one more card than the bottom packet. 
	 * 
	 * Remember that the top of the deck is considered to be the front 
	 * of the ArrayList. 
	 * 
	 */
	public void shuffle() {
		throw new RuntimeException("You must implement this!");
	}
	
	
	
	/**
	 * The method is meant to allow the next two creatures to fight and
	 * for the winner to be returned.
	 * <br><br>
	 * If there are no creatures in the structure, returns null.<br>
	 * If there is only one creature in the structure, it is removed
	 * and declared the winner<br>
	 * Otherwise, there is a series of events that takes place.
	 * The following presents the events and the order in which 
	 * the events must take place:<br>
	 * 1. One creature is removed from each end of the structure
	 *       and they will later do battle.<br>
	 * 2. All creatures remaining in the BattleDeck are weakened by
	 *       one strength point.<br>
	 * 3. The BattleDeck is cleared of any creatures who no longer
	 *       have any strength.<br>
	 * 4. The winner in solitaire fights are determined in by two-step process; 
	 *       (a) if they have different skill levels, the one with the higher 
	 *           skill level wins but if they have the same skill level then 
	 *       (b) the one with the higher strength value wins.  If they have the
	 *           same skill level and the same strength level, then whichever 
	 *           of the two creatures came from the front of the deck wins.
	 * <br><br>
	 * NOTE: The @SuppressWarnings("unchecked") indicator is to inform
	 * the compiler that even though we don't test to make sure the cast
	 * to T is valid, we are sure of our logic.  This is also a bit of a
	 * hint to you that there will need to be some casting done.  For example,
	 * if you had code similar to:
	 *    Battleable frontFighter = arr.remove(0);
	 *    if (frontFighter.getClass() != backFighter.getClass()) {
	 *       return frontFighter;
	 *    }
	 * that won't work because the type of frontFighter is Battleable and even
	 * though *we* know that's what we're going to send back in THIS PROJECT, 
	 * this class can be used for many different types and is generic, so the 
	 * return statement would need to be:
	 *       return (T)frontFighter;
	 * 
	 * NOTE: The above code is just example syntax, not example logic for this
	 * project's requirements.
	 * 
	 * @return reference to the winning creature
	 */
	@SuppressWarnings("unchecked")
	public T solitaireFight() {
		throw new RuntimeException("You must implement this!");
	}
	
	
	
	
	/**
	 * The method will return a ragged 2D structure using the Java array.
	 * It will have references to copies of the creatures currently stored 
	 * in the battle deck.  
	 * 
	 * The 2D structure will have one row for each valid skill level 
	 * (0 through 9).  Within each row the order will be based on the 
	 * "front to back" order of them in the deck's single-dimensional
	 * structure.
	 * 
	 * NOTE: To build the ragged 2D structure, you'll need to read
	 * through the list of creatures once to determine how big each 
	 * row will need to be and then another time to populate the 
	 * ragged structure with the references to the copies of the 
	 * creatures.
	 * 
	 * @return reference to a ragged 2D structure using the java array
	 */
	public Battleable[][] export2Darray() {
		//returns a two-dimensional ragged array where each row 
		//  contains a deep copy of all of the Battleable objects
		//  in the BattleStack with the corresponding Level value
		Battleable[][] retVal = new Battleable[10][];
		
		//YOUR CODE GOES HERE

		return retVal;
	}

	
	
	/**
	 * The method will return a ragged 2D structure using the ArrayList
	 * data type - it will have references to copies of the creatures 
	 * currently stored in the battle deck.  
	 * 
	 * The 2D structure will have one row for each valid skill level 
	 * (0 through 9).  Within each row the order will be based on the 
	 * "front to back" order of them in the deck's single-dimensional
	 * structure.
	 * 
	 * NOTE: To build this ragged 2D structure, you should only need
	 * to go through the deck once!
	 * 
	 * @return reference to a ragged 2D structure using ArrayLists
	 */
	public ArrayList<ArrayList<Battleable>> export2Darraylist() {
		ArrayList<ArrayList<Battleable>> retVal =
				new ArrayList<ArrayList<Battleable>>();
		
		//YOUR CODE GOES HERE

		return retVal;
	}
	
	
	
	
	
	
	
	/**
	 * The method will return a String object containing a representation
	 * of the creatures currently held in the BattleDeck, shown in order 
	 * from "front to back" of the ArrayList holding the references.
	 * 
	 * @return String representing the BattleDeck
	 */
	@Override
	public String toString() {
		StringBuffer retVal = new StringBuffer("Contents: ");
		retVal.append("[ ");
		for (Battleable val : arr) {
			retVal.append(val + ", ");
		}
		if (retVal.lastIndexOf(", ") == retVal.length()-2) {
			retVal.delete(retVal.length()-2, retVal.length());
		}
		retVal.append(" ]");

		return new String(retVal);
	}







}
