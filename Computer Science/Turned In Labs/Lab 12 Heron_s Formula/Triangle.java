import java.util.Scanner;
import java.lang.Math.*; 

/**
 * These comments are an example of the types of comments that I will expect you to write for all labs 
 * henceforth.  You are required to write a Javadoc comment for all classes and for all methods, as well as 
 * comments that describe all parameter variables.  To add a method comment in Java, put your cursor inside
 * the method and select "Edit" and "Add method comment".
 * 
 * The triangle class contains methods which compute the perimeter and area of a triangle.
 *
 * It has two constructors.  These are examples of overloaded constructors (two or more constructors that 
 * take different parameters).  The appropriate constructor will be called based on what parameters
 * are provided by the client class.  I have asked you to instantiate a Triangle object using the no-args
 * constructor.
 * 
 * This class also contains a mutator (or setter) method.  The client class (TriangleRunner) will use this method to
 * set the side lengths.
 * 
 * I have provided all required methods.  Your job is to complete these methods with the appropriate 
 * code.
 * 
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

public class Triangle
{
    // instance variables
    private int sideA, sideB, sideC;
    private double perimeter;
    private double theArea;

    /**
     * Triangle Constructor.
     * This is a no-args constructor.
     * It initializes all int instance variables to 0 and all doubles to 0.0
     */
    public Triangle()
    {
        sideA=0;
        sideB=0;
        sideC=0;
        perimeter=0.0;
        theArea=0.0;
       
    }
    
    
    /**
     * Triangle Constructor.
     * It initializes sideA, sideB, and sideC to a, b, and c, respectively.
     * @param a side 1
     * @param b side 2
     * @param c side 3
     */
    public Triangle(int a, int b, int c)
    {
        sideA=a;
        sideB=b;
        sideC=c;
        perimeter=0.0;
        theArea=0.0;
              
    }
    
   
    /**
     * Method setSides.
     * This mutator method sets sideA, sideB, and sideC to a, b, and c, respectively.
     * @param a side 1
     * @param b side 2
     * @param c side 3
     */
    public void setSides(int a, int b, int c)
    {
        sideA=a;
        sideB=b;
        sideC=c;
        
    }

    /**
     * Method calcPerimeter
     * calculates the perimeter of the triangle
     */
    public void calcPerimeter( )
    {
        perimeter=sideA+sideB+sideC;
        
    }

    /**
     * Method calcArea
     * calculates the area of the triangle using Heron's Formula
     */
    public void calcArea( )
    {
        double s= perimeter/2.0;
        theArea=Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
        
        
    }

    /**
     * Method print
     * prints the perimeter and area of the triangle
     */
    public void print( )
    {
        System.out.println("\n"+sideA+" "+sideB+" "+sideC);
        System.out.printf("Area == %.5f\n",theArea);
        
    }
}