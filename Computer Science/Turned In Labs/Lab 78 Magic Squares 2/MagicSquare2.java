import java.util.Scanner;
import static java.lang.System.*;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

public class MagicSquare2
{
    private int[][] magicSquare;

    public MagicSquare2()
    {
        setSize(0);
    }

    public MagicSquare2(int size)
    {
        setSize(size);
    }

    public void setSize(int size)
    {
        magicSquare = new int[size][size];
    }

    /*
     * Creates a magic square in the array magicSquare
     * 
     * A magic square is a square in which each row, each column, and each
     * of the two diagonals sum to the same number.
     * 
     * Algorithm:
     * Start with the middle entry of the top row. Place a 1 there. 
     * Now move consecutively through the other squares and place the numbers 2, 3, 4, etc. 
     * After placing a number, just remember to always move:
     * 1. diagonally up and to the right when you can, 
     * 2. straight down if you cannot.
     */
    public void createMagic()
    {
        int num = 1; // start with a 1
        int end = magicSquare.length; // to make things easier, make a local variable for the
                                      // number of rows/columns in the matrix

        // place num (now 1) in the middle of the top row
        magicSquare[0][end/2]= num;
        
        // initialize row and col local variables to middle of the top row 
        int row = 0; // top row
        int col = end/2; // middle column
        

        // LOOP: Insert the rest of the numbers.  The loop will run end*end - 1 times
        // For example, for a 3x3 matrix    , we have 8 spots left to fill, so the loop will
        // run 3*3 - 1 = 8 times.
        
           // decrease row by 1
           // increase col by 1
           // increase num by 1
           for(int i=0;i<end*end-1;i++)
           {
               row--;
               col++;
               num++;
               if(row<0){row=end-1;}
               if(col>end-1){col=0;}
               if(magicSquare[row][col]!=0)
               {
                   row++;
                   col--;
                   if(row>end-1){row=0;}
                   if(col<0){col=end-1;}
                   row++;
                }
                magicSquare[row][col]=num;
           }
           
           // if row is no longer in bounds (row < 0), set row to last row
           // if col is no longer in bounds (col > end - 1), set col to first col
           
           // if current spot is not 0 (spot has already been filled)
              // increase row by 1
              // decrease col by 1 (that is, these two steps will go back to the prior spot)
              // if row is no longer in bounds (row > end - 1), set row to first row
              // if col is no longer in bounds (col < 0), set col to last column
              // increase row by 1
              
           // set spot to num
           
        // END OF LOOP
        
    }
    
    public String toString( )
    {
        String output="";
        int end = magicSquare.length;
        for(int r = 0; r < end; r ++)
        {
            for(int c = 0; c < end; c++)
            {
                output+=magicSquare[r][c]+"\t";
            }
            output+="\n";
        }
        out.println();
        return output;
    }
}