/**
 * @author Pleae put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;

public class StarsAndStripes
{
    public StarsAndStripes()
    {
        out.println("StarsAndStripes");
        //print two blank lines
        printTwoBlankLines(); 
    }

    public void printTwentyStars()
    {
        //print twenty stars
        System.out.println("********************");
    }

    public void printTwentyDashes()
    {
        //print twenty dashes
        System.out.println("--------------------");
    }

    public void printTwoBlankLines()
    {
        //print two blank lines
        System.out.println("\n");
    }

    public void printASmallBox()
    {
        //print alternating dashes and stripes
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();
        printTwentyStars();
        printTwentyDashes();
        printTwentyStars();
    }

    public void printABigBox()
    { 
        //print two small boxes in a row to form a big box
        printASmallBox();
        printASmallBox();
    }   
    
    public void printMyShape()
    { 
        //print two small boxes in a row to form a big box
        printTwentyDashes();
        printTwentyDashes();
        printTwentyStars();
        printTwentyStars();
        printTwentyDashes();
        printTwentyStars();
    }  
}