/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 * The purpose of this class is to create the player object, which has both a name and number of goals associated to it. 
 * An ArrayList of players will populate each Team.  
 */
package conference;

public class Player {
	private String name;
	private int goals;

	public Player(String n) {
		name = n;
		goals = 1;
	}

	public void addGoal() {
		goals++;
	}

	public int getGoals() {
		return goals;
	}

	public String getName() {
		return name;
	}

}
