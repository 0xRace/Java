/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * This program is able to find the divisors of a given number and return a statement showing the given number and its divisors
 */

import static java.lang.System.*;

public class Divisors
{
    // Just one instance variable is needed.  Do not add any others.
    private int number;

    // add no-arg constructor
    /**
     * Divisors Constructor creates a new instance of Divisors and sets int number to 0
     *
     */
    public Divisors()
    {
        number=0;
    }

    // add constructor
    /**
     * Divisors Constructor creates a new instance of Divisors and sets number
     *
     * @param num is an integer which sets number
     */
    public Divisors(int num)
    {
        number=num;
    }

    // add mutator method called setNum
    /**
     * Method setNum sets integer number to a given number
     *
     * @param num is an integer which sets number
     */
    public void setNum(int num)
    {
        number=num;        
    }
    // complete this method
    /**
     * Method getDivisors finds and returns the divisors of a number
     * 
     * @returns a string containing a the divisors for a given number
     */
    public String getDivisors()
    {
        String divisors="";
        int x=1;
        while(x<number)
        {
            if(number%x==0)
            {
                divisors= divisors+x+" ";
            }
            x++;
        }

        return divisors; 
    }

    // add toString method
    /**
     * Method toString returns a string stating a given number and its divisors
     *
     * @return a string stating the number and its divisors
     */
    public String toString()
    {
        return number+" has divisors "+getDivisors();   
    }
}