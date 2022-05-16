// This runner class is completely written.  You don't need to add anything.
public class ArrayFunHouseRunner
{
	public static void main( String args[] )
	{
		int[] one = {7, 4, 10, 0, 1, 7, 6, 5, 3, 2, 9, 7};

		System.out.println(ArrayFunHouse.toString(one));
		System.out.println("sum of spots 3-6  =  " + ArrayFunHouse.getSum(one,3,6));
		System.out.println("sum of spots 2-9  =  " + ArrayFunHouse.getSum(one,2,9));
		System.out.println("# of 4s  =  " + ArrayFunHouse.getCount(one,4));
		System.out.println("# of 9s  =  " + ArrayFunHouse.getCount(one,9));
		System.out.println("# of 7s  =  " + ArrayFunHouse.getCount(one,7));		
		one = ArrayFunHouse.removeVals(one,7);
		System.out.println("new array with all 7s removed" + ArrayFunHouse.toString(one));
		System.out.println("# of 7s  =  " + ArrayFunHouse.getCount(one,7));

		System.out.print("\n\n");
		
		int[] two = {7, 4, 2, 7, 3, 4, 6, 7, 8, 9, 7, 0, 10, 7, 0, 1, 7, 6, 5, 7, 3, 2, 7, 9, 9, 8, 7};

		System.out.println(ArrayFunHouse.toString(two));
		System.out.println("sum of spots 3-16  =  " + ArrayFunHouse.getSum(two,3,16));
		System.out.println("sum of spots 2-9  =  " + ArrayFunHouse.getSum(two,2,9));
		System.out.println("# of 0s  =  " + ArrayFunHouse.getCount(two,0));
		System.out.println("# of 3s  =  " + ArrayFunHouse.getCount(two,3));
		System.out.println("# of 7s  =  " + ArrayFunHouse.getCount(two,7));		
		two = ArrayFunHouse.removeVals(two,7);
		System.out.println("new array with all 7s removed" + ArrayFunHouse.toString(two));
		System.out.println("# of 7s  =  " + ArrayFunHouse.getCount(two,7));
	}
}