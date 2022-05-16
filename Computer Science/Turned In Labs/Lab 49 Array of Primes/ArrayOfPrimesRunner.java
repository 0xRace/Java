import static java.lang.System.*;
import java.lang.Math;
import java.util.Arrays;

// You don't need to add anything to this class.
// Note that it imports the java.util.Arrays class, which is not in the AP Java subset.
// This class contains lots of useful methods for arrays. Its toString method is used here to print out the elements of an array.

public class ArrayOfPrimesRunner
{
	public static void main( String args[] )
	{
	   out.println("The 1st 5 primes starting from 2 are :: \n"+Arrays.toString(ArrayOfPrimes.getPrimeList(5)));   
	   
	   out.println("\nThe 1st 5 primes starting from 10 are :: \n"+Arrays.toString(ArrayOfPrimes.getPrimeList(5, 10)));   	   

	   out.println("\nThe 1st 10 primes starting from 100 are :: \n"+Arrays.toString(ArrayOfPrimes.getPrimeList(10, 100)));  
	   
	}
}