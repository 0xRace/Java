/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

public class LineRunner
{
    public static void main( String[] args )
    {
       Line line = new Line(1,9,14,2);
       line.calculateSlope();
       line.print();
        
       line.setCoordinates(1,7,18,3);
       line.calculateSlope();
       line.print();

       line.setCoordinates(6,4,2,2);
       line.calculateSlope();
       line.print();

       line.setCoordinates(4,4,5,3);
       line.calculateSlope();
       line.print();               
        
       line.setCoordinates(1,1,2,9);
       line.calculateSlope();
       line.print();    
    }
}