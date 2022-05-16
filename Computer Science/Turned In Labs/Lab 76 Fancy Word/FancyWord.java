// Please list the names of anyone who you worked with on this lab.
//

import java.util.Scanner;
import static java.lang.System.*;

public class FancyWord
{
    private String[][] mat;

    public FancyWord()
    {
        mat=new String[0][0];
    }

    public FancyWord(String s)
    {
        //Size and instantiate the matrix mat 
        //(the matrix is square, so give it s.length rows and s.length columns)
        
        mat=new String[s.length()][s.length()];
        //System.out.println(s.length());
        //Make a nested loop to fill in the matrix with spaces (" ")
        for(int r=0;r<mat.length;r++)
        {
            for(int c=0;c<mat[r].length;c++)
            {
                mat[r][c]=" ";
            }
        }
        //use the for loop below to load in the letters into the matrix 

        for (int i = 0; i < s.length(); i++)
        {
            mat[0][i] = s.substring(i, i+1);
            mat[i][i] = s.substring(i, i+1);
            mat[i][s.length()-1-i] = s.substring(s.length()-1-i,s.length()-i);
            mat[s.length()-1][i]=s.substring(i, i+1);
            //3 more statements like the one I gave you on the line directly above
        }

    }

    public String toString()
    {
        String output="";
        for (int r=0; r<mat.length; r++)
        {
            for (int c=0; c<mat[r].length; c++)
            {
                output+=mat[r][c];
            }
            output+="\n";
        }
        return output;
    }
}