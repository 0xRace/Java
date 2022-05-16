import java.lang.System;
import java.lang.Math;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * This program has several array manipulation methods. One sums the value of a section of a provided array.
 * One will coun the uses of a given value in an array
 * One will remove all values from an array. 
 */

public class ArrayFunHouse
{
    // instance variables and constructors could be used, but are not really needed in this lab
    // so you don't need to write that code this time

    /**
     * Method getSum
     *
     * getSum() will return the sum of the numbers from start to stop, not including stop
     * @param numArray 
     * @param start
     * @param stop
     * @return sum of the values in numArray from index start to index stop, not including stop
     */
    public static int getSum(int[] numArray, int start, int stop)
    {
        int sum=0;
        for (int x=start; x<stop; x++){sum=sum+numArray[x];}
        return sum;
    }

    /**
     * Method getCount
     * 
     * getCount() will return number of times val is present
     * @param numArray 
     * @param val 
     * @return the number of times that val is present
     */
    public static int getCount(int[] numArray, int val)
    {
        int count=0;
        for(int num:numArray)
        {
            if(num==val){count++;}
        }
        
        return count;
    }

    /**
     * Method removeVals
     * removeVals() will remove all values of val from the array numArray
     * it must return a smaller, resized array
     * 
     * @param numArray 
     * @param val the value to be removed from numArray
     * @return the smaller, resized array
     */
    public static int[] removeVals(int[] numArray, int val)
    {
        int count=getCount(numArray,val);
        int[] array= new int[numArray.length-count];
        int i=0;
        for(int x=0; x<numArray.length;x++)
        {
            if(numArray[x] != val)
            {
                array[i]=numArray[x];
                i++;
            }
           
        }
        return array;
    }

    /**
     * Method toString
     *
     * This method is complete.  You do not need to change it.
     * 
     * @param numArray
     * @return String containing the contents of numArray
     */
    public static String toString(int[] numArray)
    {
        String output="[";
        for (int i=0; i<numArray.length; i++)
        {
            if (i<numArray.length-1) output=output + numArray[i]+", ";
            else output = output + numArray[i];
        }
        output=output + "]";
        return output;
    }
}