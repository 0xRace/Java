import static java.lang.System.*;

// this class is complete
public class ToyRunner
{
	public static void main(String[] args)
	{
	    Toy t = new Toy( "sorry" );
		System.out.println( t );
		
		t = new Toy( "gi joe" );
		t.setCount( 5 );
		System.out.println( t );
	}
}