/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;

public class FirstRunner
{
    public static void main ( String[] args )
    {
        FirstAndLast demo = new FirstAndLast("Hardy");
        System.out.println( "word :: "+demo);
        System.out.println( "first letter :: " + demo.getFirst() );
        System.out.println( "last letter :: " + demo.getLast()+"\n" );

        demo.setString("Bryn Mawr");
        System.out.println( "word :: "+demo);
        System.out.println( "first :: " + demo.getFirst() );
        System.out.println( "last :: " + demo.getLast()+"\n" );
        //add three more test cases
        demo.setString("Hello");
        System.out.println( "word :: "+demo);
        System.out.println( "first :: " + demo.getFirst() );
        System.out.println( "last :: " + demo.getLast()+"\n" );

        demo.setString("World");
        System.out.println( "word :: "+demo);
        System.out.println( "first :: " + demo.getFirst() );
        System.out.println( "last :: " + demo.getLast()+"\n" );

        demo.setString("JukeBox");
        System.out.println( "word :: "+demo);
        System.out.println( "first :: " + demo.getFirst() );
        System.out.println( "last :: " + demo.getLast()+"\n" ); 
    }
}