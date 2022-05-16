//Name -
//Please include the name of anyone who you worked with on this lab
import static java.lang.System.*;

public class AtCounter
{
   private String[][] atMat;

	public AtCounter(int rows, int cols)
	{
		//size the matrix atMat
		//use nested loops to randomly load the matrix with either @ or - in each bucket
		//you will need to use Math.random()
		atMat=new String[rows][cols];
		for(int r=0;r<rows;r++)
		{
		    for(int c=0;c<cols;c++)
		    {
		        int x=(int)(Math.random()*2);
		        if(x==1){atMat[r][c]="@";}
		        else atMat[r][c]= "-";
		    }		    
		}
	}

	public int countAts(int r, int c)
	{
	    /* 
	     * check if r is within the top/bottom bounds of the matrix and if c is
	     * within the left/right bounds of the matrix and if the current spot is @
	     *    mark spot as visited ("-")
	     *    return 1 + four recursive calls using elements below, above, to left, and to right
	     * 
	     * return 0
		 */
		if(r<atMat.length &&r>=0)
		{
		    if(c<atMat[r].length && c>=0)
		    {
		        if(atMat[r][c]=="@"){ atMat[r][c]="-";
		            return 1+countAts(r,c-1)+countAts(r,c+1)+countAts(r-1,c)+countAts(r+1,c);}
		      }
		  }
	
		return 0;
	}

	/*
	 *this method will return all values in the matrix
	 *this method returns a view of the matrix
	 *that looks like a matrix
	 */
	public String toString()
	{
		String output="";
		for( String[] row : atMat)
		{
			for( String val : row )
			{
				output += val + " ";
			}
			output += "\n";
		}
		return output;
	}
}