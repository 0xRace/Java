import java.util.Scanner;
import static java.lang.System.*;
/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */
public class MagicSquare1
{
    private int[][] mat;

    /**
     * MagicSquare1 Constructor
     *
     * size the matrix and load in the numbers into the matrix
     * @param size A parameter
     * @param numbers A parameter
     */
    public MagicSquare1(int size, String numbers)
    {
        mat = new int[size][size];
        String[] s = numbers.split(" " );
        int k = 0;
        for( int i = 0; i < size; i++)
        {
            for( int j = 0; j < size; j++)
            {
                mat[i][j] = Integer.parseInt(s[k++]);
            }
        }
    }

    /**
     * Method isMagicSquare
     *
     * @return true if mat is a Magic Square
     *         false if mat is not a Magic Square
     * 
     *  A square matrix is a Magic Square if the sum of the elements in each row, each columns,
     *  and each of the two diagonals are the same number.
     */
    public boolean isMagicSquare()
    {
        // Here is an algorithm:
        // 1) Find the sum of row 0.  Store this sum in a local variable (e.g., s)
        int s=sumRow(1);
        // 2) Loop through all rows of mat and find each row sum.  If any row sum is not equal to
        //    s, you can return false right away.
        for(int r=0;r<mat.length;r++)
        {
            if(sumRow(r)!=s){return false;}
        }
        // 3) Loop through all columns of mat and find each column sum.  If any column sum is not
        //    equal to s, you can return false right away
        for(int c=0;c<mat.length;c++)
        {
            if(sumCol(c)!=s){return false;}
        }
        // 4) Find the sum of a diagonal.  If it is not equal to s, return false.
        if(sumUpDiag()!=s){return false;}
        
        // 5) Find the sum of the other diagonal.  If it is not equal to s, return false.
        if(sumDownDiag()!=s){return false;}
        // If you made it this far, all possibilities have been exhausted.  
        // All row, column, and diagonal sums must be the same.  You know
        // that mat must be magic.  Return true.
        return true;
    }

    /**
     * Method sumRow
     *
     * @param r row index
     * @return the sum of all elements in row r of mat
     */
    public int sumRow( int r )
    {
        int sum=0;
        for(int i=0;i<mat[r].length;i++)
        {
            sum+=mat[r][i];
        }
        return sum;
    }

    /**
     * Method sumCol
     *
     * @param c column index
     * @return the sum of all elements in column c of mat
     */
    public int sumCol( int c )
    {
        int sum=0;
        for(int i=0;i<mat.length;i++)
        {
            sum+=mat[i][c];
        }
        return sum;
    }

    /**
     * Method sumDownDiag
     *
     * @return the sum of the elements in the top-left/bottom-right diagonal of mat
     */
    public int sumDownDiag()
    {
        int sum=0;
        for(int r=0;r<mat.length;r++)
        {
              
            sum+=mat[r][r];
        
        }
        
        return sum;
    }

    /**
     * Method sumUpDiag
     *
     * @return the sum of the elements in the bottom-left/top-right diagonal of mat
     */
    public int sumUpDiag()
    {
        int sum=0;
        for(int r=0;r<mat.length;r++)
        {
              
            sum+=mat[r][mat[r].length-1-r];
        
        }
        
        return sum;
    }

    /**
     * Method toString
     *
     * @return a String reprsentation of mat
     */
    public String toString()
    {
        String output="";
        for( int[] row : mat )
        {
            for( int val : row)
            {
                output += val + " ";
            }
            output += "\n";
        }
        return output.trim();
    }
}