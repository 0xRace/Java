/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * this program takes a given number in base 10 and a desired base and converts the number to that base
 */

import static java.lang.System.*;

public class TenToAny
{
    private int base10;
    private int newBase;

    //add constructors
    /**
     * TenToAny Constructor creates a new instance of TenToAny and sets all variables equal to 0
     *
     */
    public TenToAny()
    {
        base10=0;
        newBase=0;
    }

    /**
     * TenToAny Constructor creates a new instance of TenToAny and sets variables base10 and newBase
     *
     * @param num sets int base10
     * @param base sets int newBase
     */
    public TenToAny(int num, int base)
    {
        base10=num;
        newBase=base;   
    }

    //add a set method
    /**
     * Method setTen sets variables base10 and newBase
     *
     * @param num sets int base10
     * @param base sets int newBase
     */
    public void setTen(int num, int base)
    {
        base10=num;
        newBase=base;  
    }

    /**
     * Method getNewNum converts a given number to a desired base and returns the value
     *
     * @return the number which has been converted to a new base
     */
    public String getNewNum()
    {
        String newNum="";
        int x=base10;
        while(x>0)
        {
            if(x%newBase<10){newNum= x%newBase +newNum;}
            else{newNum=(char)(55+x%newBase)+newNum;}
            x=x/newBase;
        }
        return newNum;
    }

    //add a toString method 
    /**
     * Method toString returns a string stating the original number and its value in a new base 
     *
     * @return a string stating the original number and its value in a new base 
     */
    public String toString()
    {
        return base10+" base 10 is "+getNewNum()+" base "+newBase;

    }


}