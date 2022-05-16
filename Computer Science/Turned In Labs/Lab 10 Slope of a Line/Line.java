/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

public class Line
{
    // instance variables
    private int xOne,yOne, xTwo, yTwo;
    private double slope;

    // constructor
    // a constructor is used to initialize the instance variables
    // the constructor is called when an instance of a class is created
    public Line(int x1, int y1, int x2, int y2)
    {
        xOne=x1;
        yOne=y1;
        xTwo=x2;
        yTwo=y2;

    }
    
    // mutator method
    // used to change the values of the instance variables
    public void setCoordinates(int x1, int y1, int x2, int y2)
    {
        xOne=x1;
        yOne=y1;
        xTwo=x2;
        yTwo=y2;
    }

    // calculate the slope of the line with coordinates (xOne, yOne) and (xTwo, yTwo)
    public void calculateSlope( )
    {
        slope=((double)yTwo-yOne)/(xTwo-xOne);

    }

    //  print the slope of the line to match the sample output
    public void print( )
    {
        System.out.printf("The slope of is %.2f \n",slope);   



    }
}