/**
 * @author Pleae put your name and the name of anyone who you worked with on this lab
 */
//***************************************************************
//File: Paint.java
//
//Purpose: Determine how much paint is needed to paint the walls
//of a room given its length, width, and height
//***************************************************************
import java.util.Scanner;
public class Paint
{
    public static void main(String[] args)
    {
        final int COVERAGE = 350; //paint covers 350 sq ft/gal
        //declare integers length, width, and height;
        int length,width,height;
        //declare integers windows and doors;
        int windows,doors;
        //declare double totalSqFt;
        double totalSqFt;
        //declare double paintNeeded;
        double paintNeeded;
        //declare and initialize Scanner object
        Scanner keyboard = new Scanner(System.in);
        //Prompt for and read in the length of the room
        System.out.println("Please enter the length of the room:");
        length = keyboard.nextInt(); 
        //Prompt for and read in the width of the room
        System.out.println("Please enter the width of the room:");
        width = keyboard.nextInt(); 
        //Prompt for and read in the height of the room
        System.out.println("Please enter the height of the room:");
        height = keyboard.nextInt(); 
        //Prompt for and read in the number of doors and windows
        System.out.println("Please enter the number of windows");
        windows = keyboard.nextInt();
        System.out.println("Please enter the number of doors");
        doors = keyboard.nextInt();
        //Compute the total square feet to be painted--think
        //about the dimensions of each wall
        totalSqFt= 2*(length*height)+2*(width*height);
        //Subtract off the area of the windows and doors
        totalSqFt=totalSqFt-(windows*15+doors*20);
        //Compute the amount of paint needed
        paintNeeded=totalSqFt/COVERAGE;
        //Print the length, width, and height of the room and the
        //number of gallons of paint needed.
        System.out.println("You will need "+paintNeeded+" galons of paint to paint a room that is "+width+" feet wide by "+length+" feet long by "+height+" feet high with "+windows+" windows and "+doors+" doors.");
        
    }
}