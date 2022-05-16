/*
 * Name - Race Saunders
 * Directory ID - rssaunde
 * University ID - 114803078
 * Section - 0108
 * "I pledge on my honor that I have not given or received any unauthorized assistance on this assignment."
 *  
 */
package tests;

import org.junit.*;

import static org.junit.Assert.*;
import conference.Conference;

public class StudentTests {
	
	// tests that a game cannot be created if the teams have the same name
	@Test
	public void testAdding1()
	{
		Conference conference = new Conference();
		assertFalse(conference.addGame("Same","Same"));
	}
	
	// tests that the same game cannot be added twice, and that order does not matter
	@Test
	public void testAdding2()
	{
		Conference conference = new Conference();
		conference.addGame("Same","NotSame");
		assertFalse(conference.addGame("Same","NotSame"));
		assertFalse(conference.addGame("NotSame","Same"));
	}
	
	//tests that the number of games for the conference is being kept track of
	// as well as the number of games for each team of the conference
	@Test
	public void testNumGames1()
	{
		Conference conference = new Conference();
		assertEquals(0,conference.numGames());
		conference.addGame("Same","NotSame");
		assertEquals(1,conference.numGames());
		assertEquals(0,conference.numGames("DNE"));
		assertEquals(1,conference.numGames("Same"));
		
	}
	
	//tests that scoreGoal() returns true and false under the correct conditions
	@Test
	public void testScoring()
	{
		Conference conference = new Conference();
		conference.addGame("Same","NotSame");
		assertTrue(conference.scoreGoal("Same", "NotSame", "Same", "Me"));
		assertFalse(conference.scoreGoal("Same", "Different", "Same", "Me"));
		assertFalse(conference.scoreGoal("Same", "Different", "Neither", "Me"));
		
	}
	
	// tests that scores are returned correctly, and that -1 is returned
	// if whichTeam is different or if the game does not exist
	@Test
	public void testGettingScores()
	{
		Conference conference = new Conference();
		conference.addGame("Same","NotSame");
		assertEquals(0,conference.getScore("Same", "NotSame", "Same"));
		conference.scoreGoal("Same", "NotSame", "Same", "Me");
		assertEquals(1,conference.getScore("Same", "NotSame", "Same"));
		assertEquals(-1,conference.getScore("Same", "Same", "Same"));
		assertEquals(-1,conference.getScore("Same", "NotSame", "Neither"));
	}
	
	//tests that players are added and their goals are kept track of correctly, and
	// that the method will return 0 if the player or team specified does not exist. 
	@Test
	public void testNumGoals()
	{
		Conference conference = new Conference();
		conference.addGame("Same","NotSame");
		assertEquals(0,conference.numGoals("Same","Me"));
		assertEquals(0,conference.numGoals("NotSame","Me"));
		assertEquals(0,conference.numGoals("Neither","Me"));
		conference.scoreGoal("Same", "NotSame", "Same", "Me");
		assertEquals(1,conference.numGoals("Same","Me"));
		conference.scoreGoal("Same", "NotSame", "Same", "Me");
		assertEquals(2,conference.numGoals("Same","Me"));
		
	}
	
	//tests whether the winner of a game returns null if there is no such game, 
	// and if there is a game, if it returns the correct winner based on goals
	// scored, or tie if the score is the same. 
	@Test
	public void testWinner()
	{
		Conference conference = new Conference();
		assertEquals(null,conference.winner("Same", "NotSame"));
		conference.addGame("Same","NotSame");
		conference.scoreGoal("Same", "NotSame", "Same", "Me");
		conference.scoreGoal("Same", "NotSame", "NotSame", "NotMe");
		assertEquals("tie", conference.winner("Same", "NotSame"));
		conference.scoreGoal("Same", "NotSame", "Same", "Me");
		assertEquals("Same", conference.winner("Same", "NotSame"));
		
	}
	
	//tests that gamesWon() returns the correct number of games when given a team.
	//including that it still tests correctly with ties. 
	@Test
	public void testGamesWon()
	{
		Conference conference = new Conference();
		assertEquals(0,conference.gamesWon("DNE"));
		conference.addGame("Same","NotSame");
		assertEquals(0,conference.gamesWon("Same"));
		conference.scoreGoal("Same", "NotSame", "Same", "Me");
		assertEquals(1,conference.gamesWon("Same"));
		
	}


}
