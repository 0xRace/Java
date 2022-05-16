/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * the program below takes in 4 doubles and finds the one which is largest
 */

import static java.lang.System.*;

public class BiggestDouble
{
    private double one,two,three,four;

    /**
     * BiggestDouble Constructor creates a new instance of Biggest Double and sets all values equal to 0
     * 
     */
    public BiggestDouble()
    {
        this(0,0,0,0); // "this" calls this class's constructor
    }

    /**
     * BiggestDouble Constructor creates a new instance of biggest double and sets all values to four given values
     *
     * @param a is an double which sets one
     * @param b is an double which sets two
     * @param c is an double which sets three
     * @param d is an double which sets four
     */
    public BiggestDouble(double a, double b, double c, double d)
    {
        one=a;
        two=b;
        three=c;
        four=d;
    }

    /**
     * Method setDoubles sets the value of one, two, three, four to four given values
     *
     * @param a is an double which sets one
     * @param b is an double which sets two
     * @param c is an double which sets three
     * @param d is an double which sets four
     */
    public void setDoubles(double a, double b, double c, double d)
    {
        one=a;
        two=b;
        three=c;
        four=d;
    }

    /**
     * Method getBiggest finds the biggest double of the 4 which have been given
     *
     * @return the value of the biggest double
     */
    public double getBiggest()
    {
         if (one>two && one>three && one>four){return one;}
         if (two>one && two>three && two>four){return two;}
         if (three>one && three>two &&three>four){return three;}
         return four;
    }

    /**
     * Method toString returns what the original four doubles were
     *
     * @return the value of the original four doubles
     */
    public String toString()
    {
        return one+" "+two+" "+three+" "+four;
    }
}