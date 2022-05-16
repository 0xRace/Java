//*******************************************************
//  Shape.java
//
//  Represents a generic shape.
//*******************************************************

abstract public class Shape
{
    //------------------------------------------------- 
    // instance variable
    //-------------------------------------------------
    private String shapeName;

    //-------------------------------------------------
    // Constructor:  Sets up the shape by assigning it
    //               the given name.
    //-------------------------------------------------
    public Shape(String name)
    {
        shapeName=name;
    }

    //--------------------------------------------------
    // area method
    // Derived classes must define an area method to
    // compute the area of the particular type of shape.
    //--------------------------------------------------
    abstract double area();
    

    //-------------------------------------------------
    // toString method
    // Returns a string with the name of the shape.
    //-------------------------------------------------
    public String toString()
    {
        return shapeName;
    }

}
