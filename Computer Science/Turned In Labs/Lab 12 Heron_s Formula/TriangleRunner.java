/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import java.util.Scanner;
import java.lang.Math.*; 

public class TriangleRunner  //this class is used to test Triangle
{
    public static void main( String[] args )
    {
        // instantiate a new Scanner object
        Scanner keyboard = new Scanner(System.in);

        
        // Ask for the user to input the values of the three sides
        // I have done this for side a.  You will need to add code to do this for sides b and c. 
        System.out.print("Enter side A ::  ");
        int a = keyboard.nextInt();
        System.out.print("Enter side B ::  ");
        int b = keyboard.nextInt();
        System.out.print("Enter side C ::  ");
        int c = keyboard.nextInt();

        
        // Instantiate a new Triangle object with default instance variable values (all sides 0).
        // Note that the no-args constructor will be called when the object is instantiated.
        // Insert your code below.
        Triangle tri= new Triangle();      
        
        // Call the appropriate methods to set side length values, calculate the perimeter,
        // and calculate the area of the user's triangle.
        // Then call a method to print the result
        // Insert your code below
        tri.setSides(a,b,c);
        tri.calcPerimeter();
        tri.calcArea();
        tri.print();
        
        
        
    }
}