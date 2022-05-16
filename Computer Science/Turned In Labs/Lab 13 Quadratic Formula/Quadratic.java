/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class Quadratic
{
    private int a, b, c;
    private double rootOne;
    private double rootTwo;
    
    /**
    * Quadratic Constructor
    *
    */
    public Quadratic()
    {
        a=0;
        b=0;
        c=0;
        rootOne=0;
        rootTwo=0;


    }

    /**
     * Quadratic Constructor
     *
     * @param quadA A parameter
     * @param quadB A parameter
     * @param quadC A parameter
     */
    public Quadratic(int quadA, int quadB, int quadC)
    {
        a=quadA;
        b=quadB;
        c=quadC;
        rootOne=0;
        rootTwo=0;


    }

    /**
     * Method setEquation
     *
     * @param quadA A parameter
     * @param quadB A parameter
     * @param quadC A parameter
     */
    public void setEquation(int quadA, int quadB, int quadC)
    {
        a=quadA;
        b=quadB;
        c=quadC;
    }

    /**
     * Method calcRoots
     *
     */
    public void calcRoots( )
    {
        rootOne=((-b)+Math.sqrt(b*b-4*a*c))/(2*a);
        rootTwo=((-b)-Math.sqrt(b*b-4*a*c))/(2*a);


    }

    /**
     * Method print
     *
     */
    public void print( )
    {
        System.out.printf("\n\nrootone :: %.2f\n",rootOne);
        System.out.printf("roottwo :: %.2f\n",rootTwo);


    }
}