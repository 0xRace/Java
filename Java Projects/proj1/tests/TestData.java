package tests;

// (c) Larry Herman, 2017.  You are allowed to use this code yourself, but
// not to provide it to anyone else.

import conference.Conference;

/* This class contains utility methods that create and return example
 * Conference objecs that the public (and secret) tests can use, to reduce
 * the amout of code needed in different tests to create objects to test the
 * methods with.  You can use these methods in your student tests as well.
 */

public class TestData {

  public static Conference bigEast() {
    Conference conf= new Conference();

    conf.addGame("Connecticut", "Georgetown");

    conf.scoreGoal("Connecticut", "Georgetown", "Connecticut", "Brooke");
    conf.scoreGoal("Connecticut", "Georgetown", "Connecticut", "Kiera");
    conf.scoreGoal("Connecticut", "Georgetown", "Georgetown", "Natalie");

    return conf;
  }

  public static Conference acc() {
    Conference conf= new Conference();

    conf.addGame("Virginia", "North Carolina");
    conf.addGame("Duke", "Louisville");

    conf.scoreGoal("Virginia", "North Carolina", "Virginia", "Lilly");
    conf.scoreGoal("Virginia", "North Carolina", "Virginia", "Maggie");
    conf.scoreGoal("Virginia", "North Carolina", "North Carolina", "Marie");
    conf.scoreGoal("Virginia", "North Carolina", "North Carolina", "Carly");
    conf.scoreGoal("Virginia", "North Carolina", "North Carolina", "Sophie");

    conf.scoreGoal("Duke", "Louisville", "Duke", "Casey");
    conf.scoreGoal("Duke", "Louisville", "Louisville", "Anne");
    conf.scoreGoal("Duke", "Louisville", "Louisville", "Blair");

    return conf;
  }

  public static Conference big10() {
    Conference conf= new Conference();

    conf.addGame("Maryland", "Ohio State");
    conf.addGame("Rutgers", "Northwestern");
    conf.addGame("Ohio State", "Michigan");
    conf.addGame("Maryland", "Rutgers");
    conf.addGame("Penn State", "Ohio State");
    conf.addGame("Penn State", "Michigan");
    conf.addGame("Ohio State", "Rutgers");
    conf.addGame("Northwestern", "Maryland");
    conf.addGame("Penn State", "Maryland");

    conf.scoreGoal("Northwestern", "Maryland", "Maryland", "Alex");
    conf.scoreGoal("Maryland", "Ohio State", "Maryland", "Alex");
    conf.scoreGoal("Maryland", "Ohio State", "Maryland", "Caroline");
    conf.scoreGoal("Northwestern", "Maryland", "Maryland", "Alex");
    conf.scoreGoal("Penn State", "Michigan", "Michigan", "Kim");
    conf.scoreGoal("Ohio State", "Rutgers", "Ohio State", "Erin");
    conf.scoreGoal("Rutgers", "Northwestern", "Northwestern", "Sheila");
    conf.scoreGoal("Penn State", "Michigan", "Michigan", "Molly");
    conf.scoreGoal("Maryland", "Ohio State", "Maryland", "Alex");
    conf.scoreGoal("Northwestern", "Maryland", "Maryland", "Deb");
    conf.scoreGoal("Penn State", "Michigan", "Penn State", "Hayley");
    conf.scoreGoal("Maryland", "Ohio State", "Ohio State", "Sarah");
    conf.scoreGoal("Northwestern", "Maryland", "Northwestern", "Selena");
    conf.scoreGoal("Ohio State", "Rutgers", "Ohio State", "Caroline");
    conf.scoreGoal("Ohio State", "Rutgers", "Rutgers", "Abbey");
    conf.scoreGoal("Northwestern", "Maryland", "Northwestern", "Danita");
    conf.scoreGoal("Northwestern", "Maryland", "Maryland", "Julia");
    conf.scoreGoal("Rutgers", "Northwestern", "Rutgers", "Nicole");
    conf.scoreGoal("Ohio State", "Michigan", "Ohio State", "Sarah");
    conf.scoreGoal("Northwestern", "Maryland", "Maryland", "Julia");
    conf.scoreGoal("Penn State", "Michigan", "Penn State", "Allie");
    conf.scoreGoal("Rutgers", "Northwestern", "Rutgers", "Jordan");
    conf.scoreGoal("Ohio State", "Michigan", "Ohio State", "Morgan");
    conf.scoreGoal("Ohio State", "Michigan", "Michigan", "Kim");
    conf.scoreGoal("Ohio State", "Michigan", "Ohio State", "Ali");
    conf.scoreGoal("Northwestern", "Maryland", "Maryland", "Kelsey");
    conf.scoreGoal("Maryland", "Rutgers", "Maryland", "Nikki");
    conf.scoreGoal("Maryland", "Rutgers", "Maryland", "Marissa");

    conf.scoreGoal("Penn State", "Maryland", "Maryland", "Emily");

    return conf;
  }
  
 

}
