import static java.lang.System.*; 

public class BoxRunner
{
   public static void main( String args[] )
   {
		Box test = new Box(3);
		out.println(test);

		test.setSize(4);
		out.println(test);

		test.setSize(5);
		out.println(test);

		test.setSize(2);
		out.println(test);

		test.setSize(1);
		out.println(test);
	}
}