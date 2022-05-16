import java.lang.System;
import java.lang.Math;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * This program can perform operations on a given array. Determine if the values in an array are going down or up.
 * It can also reterun the number of values in an array bigger than a given value
 */
public class ArrayFunHouseTwo
{

    /**
     * Method goingUp
     * 
     * goingUp() will return true if all numbers
     * in numArray are in increasing order
     * [1,2,6,9,23] returns true
     * [9, 11, 13, 8]  returns false
     * 
     * @param numArray
     * @return true if the numbers are in increasing order, false otherwise
     */
    public static boolean goingUp(int[] numArray)
    {

        for(int x=1; x<numArray.length; x++)
        {
            if(numArray[x]>numArray[x-1]){}
            else{return false;}
        }
        return true;
    }

    /**
     * Method goingDown
     *
     * goingDown() will return true if all numbers
     * in numArray are in decreasing order
     * [31,12,6,2,1] returns true
     * [31, 20, 10, 15, 9] returns false
     * 
     * @param numArray
     * @return true if the numbers are in decreasing order, false otherwise
     */
    public static boolean goingDown(int[] numArray)
    {
        for(int x=1; x<numArray.length; x++)
        {
            if(numArray[x]<numArray[x-1]){}
            else{return false;}
        }
        return true;

    }

    /**
     * Method getCountValuesBiggerThanX
     * 
     * getValuesBiggerThanX will return an array that contains
     * count number of values that are larger than parameter x
     * [1,2,3,4,5,6,7,8,9,10,11,6],3,5  would return [6,7,8]
     * 
     * @param numArray 
     * @param count the number of values larger than x
     * @param x the target value
     * @return an array of size count that contains values larger than x
     */
    public static int[] getCountValuesBiggerThanX(int[] numArray, int count, int x)
    {
        int[] array= new int[count];
        int a=0;
        for(int num:numArray)
        {
            if(num>x)
            {
                if(a<count)
                {
                    array[a]=num;
                    a++;
                }
            }
        }
        return array;
    }

    /**
     * Method toString
     *
     * This method is complete.
     *
     * @param numArray 
     * @return the contents of numArray
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