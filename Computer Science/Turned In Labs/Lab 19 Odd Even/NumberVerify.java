/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;

public class NumberVerify
{
    /**
     * Method isOdd tells if a given number is odd
     *
     * @param num is a given integer
     * @return true if num is odd, or false if num is even
     */
    public static boolean isOdd( int num )
    {
        if(num%2==0){return false;}
        else{return true;}
    }

    /**
     * Method isEven tells if a given number is even
     *
     * @param num is a given integer
     * @return true if num is even, or false if num is odd
     */
    public static boolean isEven( int num )
    {
        if(num%2==0){ return true;}
        else{return false;}
    }   
}