//*********************************************************
//  Rectangle.java
//
//  Represents a rectangle.
//*********************************************************

public class Rectangle extends Shape
{
    // instance variables:
    // length and width in feet
    private double length,width;
    

    //------------------------------------------------
    //  Constructor:  Sets up the rectangle with the
    //  given length and width.
    //------------------------------------------------
    public Rectangle(double l, double w)
    {
        super("Rectangle");
        length=l;
        width=w;
    }

    //----------------------------------------------------
    // area method 
    // Returns the area of the rectangle.
    //----------------------------------------------------
    public double area()
    {
        return length*width;
    }


    //----------------------------------------------------
    // toString method 
    // Returns a string representation of the rectangle.
    //----------------------------------------------------
     public String toString()
   {
       return super.toString() + " of length " + length+" and width "+width;
   }
    
}
