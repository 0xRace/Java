//Name -
//Please include the name of anyone who you worked with on this lab

import static java.lang.System.*;

public class RecursionFunOne
{
	public static int countOddDigits(int num)
	{
	    /*
	     * Algorithm help
	     *    if (num is greater than zero)
	     *       if the digit is odd
	     *          return 1 plus a call with remaining digits
	     *       else
	     *          return 0 plus a call with remaining digits
	     * 
	     *    return 0
	     *    
	     *    Your solution must use recursion.  
	     *    Solutions that do not use recursion will 
	     *    not receive any credit.
	     */    
	    int temp=num;
	    
	    if(temp>0)
	    {
	        
	        if(temp%2==1){temp=temp/10;return 1+ countOddDigits(temp);}
	        else{ temp=temp/10; return countOddDigits(temp);}
	        
	    }


		return 0;
	}
}