/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * program allows a user to play against a computer in rock paper scissors
 */

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
    // instance variables
    private String playChoice;
    private String compChoice;

    /**
     * RockPaperScissors Constructor
     * Set playChoice, compChoice to empty string
     */
    public RockPaperScissors()
    {
        playChoice= "";
        compChoice= "";
    }

    /**
     * RockPaperScissors Constructor
     * Call setPlayers
     * @param player is the player's choice ("R", "P", or "S")
     */
    public RockPaperScissors(String player)
    {
        setPlayers(player);

    }

    /**
     * Method setPlayers
     * 
     * assign person player
     * 
     * int num = random number 0, 1, or 2
     * 
     * if 0, assign compChoice "R"
     * else if 1, assign compChoice "P"
     * else assign compChoice "S"
     * 
     * @param player is the player's choice ("R", "P", or "S")
     */
    public void setPlayers(String player)
    {
        playChoice=player;
        int x =(int)(Math.random()*3);
        if (x==0){compChoice="R";}
        if (x==1){compChoice="P";}
        else{compChoice="S";}
    }

    /**
     * Method determineWinner
     * Determines the winner of the game, if any
     *
     * @return winner, a string that indicates the winner
     * winner should be one of the following:
     * 
     * "Draw game!"
     * "Player wins <<Paper Covers Rock>>!"
     * "Computer wins <<Rock Breaks Scissors>>!"
     * "Player wins << Scissors Cuts Paper>>!"
     * "Computer wins <<Paper Covers Rock>>!"
     * "Player wins <<Rock Breaks Scissors>>!"
     * "Computer wins <<Scissors Cuts Paper>>!"
     */
    public String determineWinner()
    {
        String winner="";
        if(playChoice.equals(compChoice)){winner="Draw Game!";}
        if(playChoice.equals("P") && compChoice.equals("R")){winner="Player wins <<Paper covers Rock!>>";}
        if(playChoice.equals("R") && compChoice.equals("P")){winner="Computer wins <<Paper covers Rock!>>";}
        if(playChoice.equals("R") && compChoice.equals("S")){winner="Player wins <<Rock breaks Scissors!>>";}
        if(playChoice.equals("S") && compChoice.equals("R")){winner="Computer wins <<Rock breaks Scissors!>>";}
        if(playChoice.equals("S") && compChoice.equals("P")){winner="Player wins <<Scissors cuts Paper!>>";}
        if(playChoice.equals("P") && compChoice.equals("S")){winner="Player wins <<Scissors cuts Paper!>>";}
        else{winner= "No Winner";}

        

        return winner;
    }

    /**
     * Method toString
     * Indicates the player's choice and the computer's choice
     * 
     * @return output is a string containing the player's choice
     * and the computer's choice
     */
    public String toString()
    {
        String output="Player had "+playChoice+"\nComputer had "+compChoice;

        return output;
    }
}