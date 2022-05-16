/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * This program converts a given base two binary number to base 10
 */

import static java.lang.System.*;

public class TwoToTen
{
    private String binary;

    /**
     * TwoToTen Constructor constructs a new instance of TwoToTen and sets string binary to ""
     *
     */
    public TwoToTen()
    {
        binary="";
    }

    /**
     * TwoToTen Constructor constructs a new instance of TwoToTen and sets string binary to
     * a given string bin
     *
     * @param bin sets binary
     */
    public TwoToTen(String bin)
    {
        binary=bin;
    }

    /**
     * Method setTwo sets the value of binary
     *
     * @param bin sets binary
     */
    public void setTwo(String bin)
    {
        binary=bin;
    }

    /**
     * Method getBaseTen converts int binary to base ten and returns the answer
     *
     * @return the base ten value of int binary
     */
    public int getBaseTen( )
    {
        int ten=0;
        int slength=binary.length();
        for(int x=0; x<slength;x++)
        {
            int k=Integer.parseInt(binary.substring(x,x+1));
            double twopow=Math.pow(2,slength-x-1);
            ten=ten+(int)(k*twopow);
        }
        return ten;
    }

    /**
     * Method toString
     *
     * @return The return the value of int binary
     */
    public String toString()
    {
        return binary;
    }
}