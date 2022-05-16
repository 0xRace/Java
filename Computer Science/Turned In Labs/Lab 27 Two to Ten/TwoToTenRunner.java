import static java.lang.System.*;

public class TwoToTenRunner
{
	public static void main ( String[] args )
	{
		TwoToTen test = new TwoToTen("1010");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("1100");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("1110");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("1111");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("11111");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("111111");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("1110101");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("10101010101");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("1010101010110");
		out.println(test + " == " + test.getBaseTen()+"\n");

		test.setTwo("111111111111111111");
		out.println(test + " == " + test.getBaseTen()+"\n");
	}
}