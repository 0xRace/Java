/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 * 
 * The purpose of this class is to create the Game object, which associates two teams to two scores. 
 * the scores may be returned and added to, and a winner may be calculated based on the current scores.
 * This method can also return the names of the teams, and the score of a team. 
 *  
 */
package conference;

public class Game {
	private int t1score, t2score;
	private String t1name, t2name;

	public Game(String name1, String name2) {
		t1name = name1;
		t2name = name2;
		t1score = 0;
		t2score = 0;
	}

	//Adds a point to the correct team if possible
	public void addScore(String team) {
		// If the passed in value is equal to either
		// of the teams names, then a point is given
		// to that team. 
		if (team.equals(t1name)) {
			t1score++;
		}
		if (team.equals(t2name)) {
			t2score++;
		}
	}

	//Returns a string with the winner's name, or "tie"
	public String getWinner() {
		// Returns the name of the team which
		// currently has greater points, or tie
		// if they are equal
		if (t1score == t2score) {
			return "tie";
		} else if (t1score > t2score) {
			return t1name;
		} else if (t1score < t2score) {
			return t2name;
		}
		//otherwise returns null
		return null;

	}

	public String getT1() {
		return t1name;

	}

	public String getT2() {
		return t2name;

	}

	//Returns the integer value for the score of the team, if possible. 
	public int getScore(String team) {
		// If the passed in value matches the name
		// of either team, then the score of that
		// team is returned.
		if (team.equals(t1name)) {
			return t1score;
		}
		if (team.equals(t2name)) {
			return t2score;
		}
		//Otherwise, 0 is returned. 
		return 0;
	}

}
