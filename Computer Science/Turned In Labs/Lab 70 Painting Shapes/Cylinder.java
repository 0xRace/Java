//**********************************************************
//  Cylinder.java
//
//  Represents a cylinder.
//**********************************************************

public class Cylinder extends Shape
{
    //----------------------------------------------------
    //instance variables: 
    //radius in feet of the cylinder
    //height in feet
    //----------------------------------------------------
    private double radius, height;
    
    
    //----------------------------------------------------
    // Constructor: Sets up the cylinder with the given
    // radius and height.
    //----------------------------------------------------
    
    public Cylinder(double r, double h)
    {
        super("Cylinder");
        radius=r;
        height=h;
    }
    
    
    //---------------------------------------------------
    // area method
    // Returns the surface area of the cylinder.
    //---------------------------------------------------
    public double area()
    {
        return 2*Math.PI*radius*height+ 2*Math.PI*Math.pow(radius,2);
    }
    
    
    
    //---------------------------------------------------
    // toString method
    // Returns a string representation of the cylinder.
    //---------------------------------------------------
    public String toString()
   {
       return super.toString() + " of radius " + radius+" and height "+height;
   }
    
    
    
}
