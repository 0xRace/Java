package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import conference.Conference;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  // Obviously all tests also call and therefore test the effects of
  // addGame() as well.

  // Tests numGames() with a conference that has just one game.
  @Test public void testPublic1() {
    assertEquals(1, TestData.bigEast().numGames());
  }

  // Tests numGames() with a conference that has more than one game.
  @Test public void testPublic2() {
    assertEquals(2, TestData.acc().numGames());
  }

  // Tests numGames(team) with a conference that has just one game.
  @Test public void testPublic3() {
    Conference conference= TestData.bigEast();

    assertEquals(1, conference.numGames("Connecticut"));
    assertEquals(1, conference.numGames("Georgetown"));
  }

  // Tests numGames(team) with a conference that has more than one game.
  @Test public void testPublic4() {
    Conference conference= TestData.acc();

    assertEquals(1, conference.numGames("Virginia"));
    assertEquals(1, conference.numGames("North Carolina"));

    assertEquals(1, conference.numGames("Duke"));
    assertEquals(1, conference.numGames("Louisville"));
  }

  // Tests calling scoreGoal() and getScore() with a conference that has
  // just one game.
  @Test public void testPublic5() {
    Conference conference= TestData.bigEast();

    assertEquals(2, conference.getScore("Connecticut", "Georgetown",
                                        "Connecticut"));
    assertEquals(1, conference.getScore("Connecticut", "Georgetown",
                                        "Georgetown"));
  }

  // Tests calling scoreGoal() and getScore() with a conference that has
  // more than one game.
  @Test public void testPublic6() {
    Conference conference= TestData.acc();

    assertEquals(2, conference.getScore("Virginia", "North Carolina",
                                        "Virginia"));
    assertEquals(3, conference.getScore("Virginia", "North Carolina",
                                        "North Carolina"));

    assertEquals(1, conference.getScore("Duke", "Louisville", "Duke"));
    assertEquals(2, conference.getScore("Duke", "Louisville", "Louisville"));
  }

  // Tests calling getScore() for nonexistent games.
  @Test public void testPublic7() {
    Conference conference= TestData.acc();

    assertEquals(-1, conference.getScore("Virginia", "Duke", "Virginia"));
    assertEquals(-1, conference.getScore("Virginia", "Duke", "Duke"));
    assertEquals(-1, conference.getScore("Virginia", "Louisville",
                                         "Virginia"));
    assertEquals(-1, conference.getScore("Virginia", "Louisville",
                                         "Louisville"));
    assertEquals(-1, conference.getScore("North Carolina", "Louisville",
                                         "North Carolina"));
    assertEquals(-1, conference.getScore("North Carolina", "Louisville",
                                         "Louisville"));  }

  // Tests calling numGoals() for players who scored some goals in a
  // conference.
  @Test public void testPublic8() {
    Conference conference= TestData.big10();

    assertEquals(2, conference.numGoals("Maryland", "Julia"));
    assertEquals(4, conference.numGoals("Maryland", "Alex"));
  }

  // Tests calling numGoals() for a player who didn't score any goals in a
  // conference.
  @Test public void testPublic9() {
    assertEquals(0, TestData.big10().numGoals("Maryland", "Emma"));
  }

  // Tests the basic operation of winner().
  @Test public void testPublic10() {
    Conference conference= TestData.big10();

    assertEquals("Maryland", conference.winner("Maryland", "Rutgers"));
    assertEquals("Maryland", conference.winner("Northwestern", "Maryland"));
    assertEquals("Ohio State", conference.winner("Ohio State", "Michigan"));
  }

  // Tests the basic operation of gamesWon().
  @Test public void testPublic11() {
    Conference conference= TestData.big10();

    assertEquals(4, conference.gamesWon("Maryland"));
    assertEquals(1, conference.gamesWon("Rutgers"));
    assertEquals(0, conference.gamesWon("Michigan"));
  }

  // Tests that addGame() does not add an already-existing duplicate game
  // (two games between the same pair of teams).
  @Test public void testPublic12() {
    Conference conference= TestData.bigEast();

    assertEquals(1, conference.numGames());

    conference.addGame("Connecticut", "Georgetown");
    assertEquals(1, conference.numGames());
  }

  // Tests the return value of addGame() for adding a new game, and trying
  // to add an already-existing duplicate game.
  @Test public void testPublic13() {
    Conference conference= new Conference();

    assertTrue(conference.addGame("Connecticut", "Georgetown"));
    assertFalse(conference.addGame("Connecticut", "Georgetown"));
  }

  // Tests that addGame() does not add a game with both team names being the
  // same.
  @Test public void testPublic14() {
    Conference conf= TestData.bigEast();

    assertFalse(conf.addGame("Florida", "Florida"));
    assertEquals(1, conf.numGames());
  }

  // Tests calling some of the methods on an empty Conference object, that
  // no games have been added to.
  @Test public void testPublic15() {
    Conference conference= new Conference();

    assertEquals(0, conference.numGames());
    assertFalse(conference.scoreGoal("Florida", "Marquette", "Marquette",
                                     "Riley"));
  }

}
