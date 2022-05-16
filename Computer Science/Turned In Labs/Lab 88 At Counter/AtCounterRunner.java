//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class AtCounterRunner
{
	public static void main( String args[] )
	{
		AtCounter test = new AtCounter(10, 10);
		System.out.println(test);
		out.println("0 0 has "+test.countAts(0,0) + "\n\n");

		test = new AtCounter(10, 10);
		System.out.println(test);
		out.println("5 5 has "+test.countAts(5,5) + "\n\n");
	}
}