import static java.lang.System.*;

public class DivisorsRunner
{
	public static void main( String args[] )
	{
	    
		Divisors test = new Divisors(10);
		System.out.println(test);

		test.setNum(45);
		System.out.println(test);

		test.setNum(14);
		System.out.println(test);

		test.setNum(1024);
		System.out.println(test);

		test.setNum(1245);
		System.out.println(test);

		test.setNum(33);
		System.out.println(test);

		test.setNum(65535);
		System.out.println(test);
	}
}