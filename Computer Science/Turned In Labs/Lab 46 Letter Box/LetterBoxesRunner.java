//Name -
//Date -
//Class -  
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class LetterBoxesRunner
{
    public static void main( String args[] )
    {
        // Leave this method alone.  No changes are needed.
        
        Scanner keyboard = new Scanner(System.in);
        String choice="Y";
        
        while (choice.equals("Y")||choice.equals("y"))
        {
            out.print("\nEnter the letter for the box :: ");
            char letter = keyboard.next().charAt(0);
    
            out.print("Enter the size of the box :: ");
            int size = keyboard.nextInt();
    
            LetterBoxes test = new LetterBoxes();
            test.printBox(letter,size);     
            
            System.out.print("\nDo you want to enter more sample input? ");
            choice=keyboard.next();         
        }               
    }
}