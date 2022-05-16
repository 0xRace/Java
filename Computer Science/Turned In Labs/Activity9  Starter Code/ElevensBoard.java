import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
	    // INSERT CODE HERE
	    // Three possibilities, so use if - else if - else
	    // 1. if the number of Cards in the selectedCards ArrayList is 2 (size of List is 2), return true if that list containsPairSum11
	    // 2. else if the number of Cards in the selectedCards ArrayList is 3 (size of List is 3), return true if that list containsJQK
	    // 3. else return false 
	    if(selectedCards.size()==2&& containsPairSum11(selectedCards)==true){return true;}
	    else if(selectedCards.size()==3 && containsJQK(selectedCards)==true){return true;}
	    else return false;
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		// INSERT CODE HERE
		// CardIndexes() returns a list of the indexes of actual (non-null) cards on the board.  
		// You will need to call that method and use the list that is returned from it twice from here (1 & 2 below).
		//  1. Pass in that return List as a parameter to containsPairSum11
		//  2. Pass in that same return List as a parameter to containsJQK
		//  3. Return true if either containsPairSum11 or containsJQK returns true
		//  This method can be written in one line.
		return containsPairSum11(super.cardIndexes()) || containsJQK(super.cardIndexes());
		
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pair; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		// INSERT CODE HERE
		//
		// We need to check the combined point values of all possible pairs of cards on the board. To do this, a nested
		// loop will do the job.  We need to sum the point value of each card with the point value of every other card 
		// (except itself).  For example, card 0's point value will be summed with the point values of 
		// cards 1,2,3,4,5,6,7,8,9, and 10.  Then card 1's point value will be summed with the point values of cards 2-10 
		// but notice that we don't have to sum with card 0, since we did that already, or with card 1 (itself).  
		// Then card 2's point value will summed with the point values of cards 3-10 (but again we do not backtrack to cards 0 or 1
		// since we already did those pair sums).  This process continues to the end of the list. 
		//
		// Outer loop: regular for loop through all items in the parameter List selectedCards (loop control variable i)
		//    Get the value (call it k1) that is in bucket i of selectedCards - e.g., int k1 = selectedCards.get(i); 
		//    k1 happens to be an index of the cards array 
		//    (cards is the array of Cards on the board).
		//
		//    Inner loop: regular for loop through all items in the parameter List selectedCards after index i
		//       (we can call the inner loop control variable j).
		//       Get the value (call it k2) that is in bucket j of selectedCards. k2 happens to be an index of the cards array, too.
		//       Get the point values of the cards with indexes k1 and k2 of the cards array - to get the card use the accessor method 
		//       cardAt.  cardAt(k1) will get the Card at index k1, and cardAt(k2) will get the Card at index k2
		//       Note that cards[k1] or cards[k2] will not work, since the instance variable array cards has private access in the Board superclass.
		//       To get the point value of each card use pointValue.
		//       (e.g., cardAt(k1).pointValue() or cardAt(k2).pointValue()).
		//       If the sum of these point values is 11 return true, otherwise return false.
		for(int i=0;i<selectedCards.size();i++)
		{
		    int k1=selectedCards.get(i);
		    for(int j=i+1;j<selectedCards.size();j++)
		    {
		       int k2=selectedCards.get(j);
		       if(cardAt(k1).pointValue()+cardAt(k2).pointValue()==11){return true;}
		    }
		}
		//
		return false;
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		// INSERT CODE HERE
		// Declare 3 local boolean variables that indicate whether a Jack, a Queen, or King has been found.
		// Initialize all these variable to false.
		boolean j=false;
		boolean q=false;
		boolean k=false;
		// 
		// Regular for loop through all items in selectedCards (loop control variable i) - a for-each loop would work too
		// Check if rank is a jack (e.g. cardAt(selectedCards.get(i)).rank().equals("jack") if you were using a regular for loop).  
		// If so, set that boolean variable to true.
		// Do the same for queen and king.
		for(int i=0;i<selectedCards.size();i++)
		{
		    if(cardAt(selectedCards.get(i)).rank().equals("jack")){j=true;}
		    if(cardAt(selectedCards.get(i)).rank().equals("queen")){q=true;}
		    if(cardAt(selectedCards.get(i)).rank().equals("king")){k=true;}
		}
		
		// After the loop, return true if ALL three (jack, queen, king) have been found
		// Make sure your logic in this method is correct.  The most common error is to return true if either a jack or a queen or a king is found
		if(j==q==k==true){return true;}
		return false;
	}
}
