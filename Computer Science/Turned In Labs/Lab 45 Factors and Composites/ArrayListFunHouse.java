import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

/**
 * Race
 * The first purpose of this program is to determine the factors of a given number
 * The second purpose of this program is to remove all non-composite numbers from an array
 * @author Please put your name and the name of anyone who you worked with on this lab
 */
public class ArrayListFunHouse
{
    /**
     * Method getListOfFactors gets the list of factors for a certain number
     *
     * @param number is the number for which we will find factors
     * @return the array factors which contains all of the factors for the given nuber
     */
    public static ArrayList<Integer> getListOfFactors(int number)
    {
        ArrayList<Integer> factors= new ArrayList<Integer>();
        for(int i=2; i<number;i++)
        {
            if(number%i==0){factors.add(i);}
        }
        return factors;
    }

    /**
     * Method keepOnlyCompositeNumbers keeps only the composite numbers in a given array
     *
     * @param nums is the array for which we will remove all non-composite numbers
     */
    public static void keepOnlyCompositeNumbers( List<Integer> nums )
    {
        for(int i=0;i<nums.size();i++)
        {
            if(getListOfFactors(nums.get(i)).size()==0)
            {
                nums.remove(i);
                i--;
            }   
        }
    }
}