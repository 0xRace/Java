//************************************************************
//  PaintThings.java
//
//  Computes the amount of paint needed to paint various
//  things. Uses the amount method of the paint class which
//  takes any Shape as a parameter.
//***********************************************************

import java.text.DecimalFormat;

public class PaintThings
{
    //-----------------------------------------
    // Creates some shapes and a Paint object
    // and prints the amount of paint needed
    // to paint each shape.
    //-----------------------------------------
   public static void main (String[] args)
   {
      final double COVERAGE = 350;
      Paint paint = new Paint(COVERAGE);

      // Instantiate 3 shape objects:
      // deck: 20 ft by 35 ft Rectangle
      Shape deck= new Rectangle(20,35);
      // bigBall: Sphere of radius 15
      Shape bigBall= new Sphere(15);
      // tank: Cylinder for radius 10 and height 30
      Shape tank= new Cylinder(10,30);
      
      double deckAmt, ballAmt, tankAmt;

      // Compute the amount of paint needed for each shape.
      // Make the appropriate method calls to complete the
      // three lines below.
      
      deckAmt = paint.amount(deck);
      ballAmt = paint.amount(bigBall);
      tankAmt = paint.amount(tank);

      // Print the amount of paint for each.
      DecimalFormat fmt = new DecimalFormat("0.#");
      System.out.println ("\nNumber of gallons of paint needed...");
      System.out.println ("Deck " + fmt.format(deckAmt));
      System.out.println ("Big Ball " + fmt.format(ballAmt));
      System.out.println ("Tank " + fmt.format(tankAmt));
   }
}
