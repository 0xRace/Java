import static java.lang.System.*;
import java.util.Arrays;

public class AlgorithmicRunner
{
   public static void main( String args[] ) throws Exception  
   {
		System.out.println(Algorithmic.getOddPairCount(new int[]{1,2,3,4,5,6,7}));					
		System.out.println(Arrays.toString(Algorithmic.getOddPairArray(new int[]{1,2,3,4,5,6,7})));		
		
		System.out.println(Algorithmic.getOddPairCount(new int[]{4,2,0,4,5,2,7,9}));
		System.out.println(Arrays.toString(Algorithmic.getOddPairArray(new int[]{4,2,0,4,5,2,7,9})));
		
			
		System.out.println(Algorithmic.getOddPairCount(new int[]{4}));	
		System.out.println(Algorithmic.getOddPairCount(new int[]{4,4}));
		System.out.println(Algorithmic.getOddPairCount(new int[]{1,2}));
		System.out.println(Arrays.toString(Algorithmic.getOddPairArray(new int[]{2,2,3,4,5})));
				
		System.out.println(Algorithmic.getOddPairCount(new int[]{1,5,1,3}));																
		System.out.println(Arrays.toString(Algorithmic.getOddPairArray(new int[]{1,5,1,3})));
   }
}