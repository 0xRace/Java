/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * The QuadraticRunner class is complete.
 */

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class QuadraticRunner
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner( System.in );
        out.print("Enter a :: ");
        int quadA = keyboard.nextInt();
        out.print("Enter b :: ");
        int quadB = keyboard.nextInt();
        out.print("Enter c :: ");
        int quadC = keyboard.nextInt();


        Quadratic test = new Quadratic();
        test.setEquation(quadA,quadB,quadC);
        test.calcRoots( );
        test.print();
    }
}