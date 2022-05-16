/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * the purpopse f this program is to draw a box using nested for loops
   */

import static java.lang.System.*;

public class Box
{
    private int size;

    /**
     * Box Constructor creates a new instance of Box and sets size equal to 0
     *
     */
    public Box()
    {
        size=0;
    }

    /**
     * Box Constructor creates a new instance of Box and sets size
     *
     * @param count is an integer which sets size
     */
    public Box(int count)
    {
        size=count;
    }

    /**
     * Method setSize
     *
     * @param count is an integer which sets size
     */
    public void setSize(int count)
    {
        size=count;
    }

    /**
     * Method getSize
     *
     * @return the value of int size
     */
    public int getSize()
    {
        return size;
    }

    /**
     * Method toString
     *
     * @return a box made of * and # which has been drawn through nested for loops 
     * and whose size is determined by int size
     */
    public String toString()
    {
        String output="";
        for (int sizetemp=size;sizetemp>0;sizetemp--)
        {
            for(int i=sizetemp; i>0;i--)
            {
                output=output+"*";
            }
            for(int y=sizetemp; y<=size;y++)
            {
                output=output+"#";
            }
            output=output+"\n";
        }
        return output;
    }
}