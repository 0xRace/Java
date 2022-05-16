/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * This programs calculates the factorial of a given number
 */

import static java.lang.System.*;

public class Factorial
{
    private int number;

    /**
     * Factorial Constructor
     * creates a new instance of Factorial, and sets int number = to 0
     *
     */
    public Factorial()
    {
        number=0;
    }

    /**
     * Factorial Constructor
     * creates a new instance of Factorial
     * @param num is an integer which sets number
     */
    public Factorial(int num)
    {
        number=num;
    }

    /**
     * Method setNum allows the number to be set
     *
     * @param num is an integer which sets number
     */
    public void setNum(int num)
    {
        number=num;
    }

    /**
     * Method getNum
     *
     * @return the value of int number
     */
    public int getNum()
    {
        return number;
    }

    /**
     * Method getFactorial calculates the factorial of a given number and returns the answer
     *
     * @return the factorial of a given number
     */
    public long getFactorial( )
    {
        long total=1;
        for(int x=number;x>0;x--){
            total=total*x;
        }



        return total;
    }

    /**
     * Method toString tells what the factorial of a given number is
     *
     * @return a string stating what the factorial of a given number is
     */
    public String toString()
    {
        return "factorial of " + getNum() + " is "+ getFactorial()+"\n";
    }
}