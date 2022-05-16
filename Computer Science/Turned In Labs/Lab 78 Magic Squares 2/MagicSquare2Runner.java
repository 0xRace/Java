import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class MagicSquare2Runner
{
    public static void main( String args[] ) throws IOException
    {
        MagicSquare2 one = new MagicSquare2(5);
        one.createMagic();
        System.out.println(one);

        one.setSize(1);
        one.createMagic();
        System.out.println(one);

        one.setSize(7);
        one.createMagic();
        System.out.println(one);

        one.setSize(3);
        one.createMagic();
        System.out.println(one);
    }
}