import java.util.Scanner;
import static java.lang.System.*;

// this class is complete

public class RPSRunner
{
    public static void main(String args[])
    {
        Scanner keyboard = new Scanner(System.in);
        char response;
        
        // This is a do-while loop.  This type of loop is not in the AP Java subset.
        // A do-while loop will always run at least once, since the boolean condition is not
        // evaluated until the bottom of the loop.
        
        do{

            System.out.print("Rock-Paper-Scissors - pick your weapon[R,P,S]:: ");
            RockPaperScissors test = new RockPaperScissors(keyboard.next());
            System.out.println(test);
            System.out.println(test.determineWinner()+"\n");

            System.out.print("Do you want to play again? ");
            response = keyboard.next().charAt(0);
        }while(response=='Y'||response=='y');

    }
}


