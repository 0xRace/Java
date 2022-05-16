import static java.lang.System.*;
import java.util.ArrayList;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * class Algorithmic has methods to analyze the contents of an array
 */
public class Algorithmic  
{
   
   /** @param array list of positive integer values
    *  @param post 1st location to process
    *  		Precondition : array.length>=2 and pos>0 and pos<array.length
    *  @return the sum of positions pos and pos+1
    */
	public static int getPairValue(int[] array, int pos)
	{
	    return array[pos]+array[pos+1];
		
	}
	
   /** @param num is a positive non-decimal value
    *  @param post 1st location to process
    *  		Precondition : num >= 0
    *  @return true if num is odd or false if num is even
    */
   public static boolean isOdd(int num)
	{  
	    if(num%2==0){return false;}
	    return true;
	}
	
 
    /** @param array list of positive integer values
    *  		Precondition : array.length>0
    *   @return the count of all odd pair sums
    */
	public static int getOddPairCount(int[] array)
	{
	    int count=0;
	    for(int i=0; i<array.length - 1; i++)
	    {
	        if(isOdd(getPairValue(array,i))){count++;}	        
	    }
	   return count;
	}	

    /** @param array list of positive integer values
    *  		Precondition : array.length>0
    *   @return an array containing all of the odd pair sums
    */
	public static int[] getOddPairArray(int[] array)
	{
		int count= getOddPairCount(array);
		int[] narray= new int[count];
		int index=0;
		for(int i=0; i<array.length-1;i++)
		{
		    if(isOdd(getPairValue(array,i)))
		    {
		        narray[index]=getPairValue(array,i);
		        index++;
		    }	
		}
		return narray;
	}
}