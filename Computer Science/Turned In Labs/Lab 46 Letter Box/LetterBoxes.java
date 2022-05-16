import java.util.Scanner;
import static java.lang.System.*;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * the purpose of this program is to contruct boxes of a given letter whose size is determined by  given integer
 */

public class LetterBoxes
{
    //instance variables and constructors could be present, but are not necessary

    /**
     * Method printBox prints a box
     *
     * @param letter is a char which determines what the box will be constructed out of
     * @param size is an integer which sets the size of the box 
     */
    public static void printBox(char letter, int size)
    {

        for(int i=0;i<size;i++)
        {
            for(int y=0;y<size;y++)
            {
                System.out.print(letter);
            }
            System.out.println();
        }

    }
}