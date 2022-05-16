import static java.lang.System.*;

public class FactorialRunner
{
	public static void main ( String[] args )
	{
	    Factorial test = new Factorial(5);
		out.println(test);

		test.setNum(4);
		out.println(test);

		test.setNum(8);
		out.println(test);

		test.setNum(15);
		out.println(test);

		test.setNum(6);
		out.println(test);

		test.setNum(9);
		out.println(test);

		test.setNum(3);
		out.println(test);
	}
}