//Name -
//Please include the name of anyone who you worked with on this lab

import static java.lang.System.*;

public class RecursionFunThree
{
	/* luckySevens will return a count of the 7s in the number
	 *    unless the 7s are side by side in which case they are worth 14
	 *
	 * 1087171  would return 2 as there are 2 7s
	 * 1077171  would return 15 as 2 7s side by side count as 14 + 1 = 15
	 * 77077  would return 28 ( 14 + 14 )
	 * 97171771707797 would return 32 ( 1 + 1 + 14 + 1 + 14 + 1 )
	 * 1089651234 would return 0
	 *
	 * the solution to this problem must use recursion
	 */
	
	/*
	 * Algorithm help
	 * 
	 * if number is positive
	 * 
	 *    get last digit (use %)
	 *    get second to last digit (use / and %)
	 *    
	 *    if both digits are 7
	 *       return 14 + recursive call (number with last two digits removed - use /)
	 *       
	 *    else if last digit is 7
	 *       return 1 + recursive call (number with last digit removed - use /)
	 *       
	 *    else 
	 *       return 0 + recursive call (number with last digit removed - use /)
	 *       
	 *       
	 *  return 0
	 * 
	 */
	public static int luckySevens( long number )
	{
		if(number>0)
		{
		    int last=(int)(number%10);
		    int slast= (int)((number/10)%10);
		    if(last==7 && slast==7){return 14+luckySevens(number/100);}
		    else if(last==7){return 1+luckySevens(number/10);}
		    else{return 0+luckySevens(number/10);}
		  }
	    return 0;
	}
}