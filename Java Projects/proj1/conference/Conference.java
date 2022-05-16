/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 *  The purpose of this class is to provide a Conference object, which may be used to create and score games between teams, as well as to 
 *  keep record of the number of games each team has played and the number of goals scored by the players of each team. 
 */
package conference;

import java.util.ArrayList;

public class Conference {
	private ArrayList<Game> games;
	private ArrayList<Team> teams;

	//initializes an ArrayList of Teams and Games. 
	public Conference() {
		games = new ArrayList<Game>();
		teams = new ArrayList<Team>();
	}

	//Adds a game, if possible, and adds the teams to the ArrayList,
	//if not previously on it. 
	public boolean addGame(String team1, String team2) {
		
		//if a game between these teams exists, this will cause the method to return false
		for (Game g : games) {
			if (g.getT1().equals(team1) && g.getT2().equals(team2)
					|| g.getT1().equals(team2) && g.getT2().equals(team1)) {
				return false;
			}
		}
		
		//if the teams do not have different names, the method will return false. 
		if (team1.equals(team2)) {
			return false;
		}

		//a new game between the two teams will be added to the ArrayList of games. 
		games.add(new Game(team1, team2));
		
		int count1 = 0;
		int count2 = 0;

		//for loop to check if either team has already been added to the ArrayList.
		for (Team t : teams) {
			if (t.getName().equals(team1)) {
				count1 = 1;
			}
			if (t.getName().equals(team2)) {
				count2 = 1;
			}
		}
		//If either team has not been added, it is. If either team 
		//already exists, a game is added to its record. 
		if (count1 == 0) {
			teams.add(new Team(team1));
		} else {
			for (Team t : teams) {
				if (t.getName().equals(team1)) {
					t.addGame();
				}
			}

		}
		if (count2 == 0) {
			teams.add(new Team(team2));
		} else {
			for (Team t : teams) {
				if (t.getName().equals(team2)) {
					t.addGame();
				}
			}

		}

		return true;
	}

	public int numGames() {
		return games.size();
	}

	//for loop to locate the correct team, if it exists
	//returns the number of games for the team, otherwise
	//returns 0
	public int numGames(String team) {
		for (Team t : teams) {
			if (t.getName().equals(team)) {
				return t.getGames();
			}
		}
		return 0;

	}

	//This method changes the score of the game object associated with these two teams
	//and also creates the player on the roster of the correct team, if possible. 
	public boolean scoreGoal(String team1, String team2, String whichTeam, String player) {
		//if whichTeam is not either of the other teams the method returns false. 
		if (!(whichTeam.equals(team1) || whichTeam.equals(team2))) {
			return false;
		}
		
		//if it exists, finds the correct game and adds a score for the correct team
		//increments count, because the method will return false if no game exists.
		int count = 0;
		for (Game g : games) {
			if ((g.getT1().equals(team1) && g.getT2().equals(team2))
					|| (g.getT1().equals(team2) && g.getT2().equals(team1))) {
				g.addScore(whichTeam);
				count++;
				break;
			}

		}
		if (count == 0) {
			return false;
		}

		//locates the correct team, and adds a goal for the correct player
		//if the correct player does not exist, the player is created instead. 
		for (Team t : teams) {
			if (t.getName().equals(whichTeam)) {
				if (t.addGoal(player) == false) {
					t.addPlayer(player);
				}
			}
		}
		return true;
	}

	//if possible, the method returns the score of the team in the game object containing 
	//both teams. if impossible, the method returns -1. 
	public int getScore(String team1, String team2, String whichTeam) {
		//if whichTeam does not equal either team, -1 is returned. 
		if (!(whichTeam.equals(team1) || whichTeam.equals(team2))) {
			return -1;
		}
		//returns the score of the team if the game exists, otherwise returns -1.
		for (Game g : games) {
			if (g.getT1().equals(team1) && g.getT2().equals(team2)
					|| g.getT1().equals(team2) && g.getT2().equals(team1)) {
				return g.getScore(whichTeam);
			}
		}
		return -1;

	}

	// returns the number of goals a player of a specific team has scored, if possible. 
	public int numGoals(String whichTeam, String player) {
		//if the team and player exist, the method will return the number of goals for the player. 
		for (Team t : teams) {
			if (t.getName().equals(whichTeam)) {
				return t.getPlayerGoals(player);
			}
		}
		return 0;

	}
	//returns the winner based on the current score of the game object between the two teams
	//if it exists. if it does not, the method returns null
	public String winner(String team1, String team2) {

		//for loop to find the correct game, and get the winner, if it exists
		for (Game g : games) {
			if (g.getT1().equals(team1) && g.getT2().equals(team2)
					|| g.getT1().equals(team2) && g.getT2().equals(team1)) {

				return g.getWinner();
			}
		}

		return null;
	}

	//returns the number of games won based on the current scores in 
	// all games that the team is a part of. 
	public int gamesWon(String whichTeam) {
		int count = 0;
		//counts the number of times the team has a winning score
		for (Game g : games) {
			if (g.getT1().equals(whichTeam) || g.getT2().equals(whichTeam)) {
				if (g.getWinner().equals(whichTeam)) {
					count++;
				}
			}
		}
		return count;
	}

}
