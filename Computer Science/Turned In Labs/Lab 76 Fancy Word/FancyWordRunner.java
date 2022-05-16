import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

// This class is complete.
public class FancyWordRunner
{
    public static void main( String args[] ) throws IOException
    {
        Scanner file = new Scanner( new File("mofancyword.dat") );
        int zz = file.nextInt();
        file.nextLine();
        for( int xx = 0; xx < zz; xx++)
        {
            String line = file.nextLine();
            FancyWord one = new FancyWord(line);
            System.out.println( one );
        }

    }
}