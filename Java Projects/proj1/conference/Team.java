/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to create the Team object, which 
 *  will have a name, number of games, and roster of players associated 
 *  to it. It will be able to add goals to those players, and return how
 *  many goals they have scored. It will also be able to create new players, and 
 *  maintains a record of the number of games a team has played. 
 */
package conference;

import java.util.ArrayList;

public class Team {

	private ArrayList<Player> roster;
	private String name;
	private int games;

	public Team(String n) {
		name = n;
		roster = new ArrayList<Player>();
		games = 1;
	}

	public void addPlayer(String p) {
		roster.add(new Player(p));
	}

	//Adds aa goal to the correct player on the roster, if possible. 	
	public boolean addGoal(String p) {
		// For/Each loop to locate the correct player on the roster.
		for (Player player : roster) {
			// if possible the player is given an additional goal and the
			//method returns true. Otherwise it returns false
			if (player.getName().equals(p)) {
				player.addGoal();
				return true;
			}
		}
		//otherwise returns false
		return false;
	}

	//Returns the integer value with the number of goals a player has scored	
	public int getPlayerGoals(String p) {
		//For/Each loop to locate the correct player
		for (Player player : roster) {
			//If found, the players number of goals is returned
			//Otherwise 0 is returned
			if (player.getName().equals(p)) {
				return player.getGoals();

			}
		}
		return 0;

	}

	public String getName() {
		return name;
	}

	public void addGame() {
		games++;
	}

	public int getGames() {
		return games;
	}

}
