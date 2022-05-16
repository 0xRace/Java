import static java.lang.System.*;

public class TenToAnyRunner
{
	public static void main( String args[] )
	{
		TenToAny test = new TenToAny(234,9);
		System.out.println(test);

		test.setTen(100,2);
		System.out.println(test);

		test.setTen(10,2);
		System.out.println(test);

		test.setTen(15,2);
		System.out.println(test);

		test.setTen(256,2);
		System.out.println(test);

		test.setTen(100,8);
		System.out.println(test);

		test.setTen(250,16);
		System.out.println(test);

		test.setTen(56,11);
		System.out.println(test);

		test.setTen(89,5);
		System.out.println(test);

		test.setTen(23,3);
		System.out.println(test);

		test.setTen(50,4);
		System.out.println(test);

		test.setTen(55,6);
		System.out.println(test);

		test.setTen(2500,16);
		System.out.println(test);

		test.setTen(2500,13);
		System.out.println(test);
	}
}