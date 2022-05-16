/**
 * @author Pleae put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;

public class StarsRunner
{
    public static void main(String args[])
    {
        //instantiate a StarsAndStripes object
        StarsAndStripes mysas = new StarsAndStripes();
        // Small box test
        mysas.printASmallBox();
        //print two blank lines
        mysas.printTwoBlankLines();
        // large box test
        mysas.printABigBox();
        //print two blank lines
        mysas.printTwoBlankLines();
        //my cutsom shape test
        mysas.printMyShape();
        //call the methods needed to make the patterns on the lab directions
    }
}