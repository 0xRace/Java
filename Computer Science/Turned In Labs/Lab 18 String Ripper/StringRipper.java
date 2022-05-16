/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;

public class StringRipper
{
    private String word;

    /**
     * StringRipper Constructor
     * creates new instance of string ripper
     */
    public StringRipper()
    {
        word="";
    }

    /**
     * StringRipper Constructor
     * creates new instance of string ripper and sets word equal to a given string s
     * @param s A string
     */
    public StringRipper(String s)
    {
        word=s;
    }

    /**
     * Method setString
     * sets word equal to a given string s
     * @param s A string
     */
    public void setString(String s)
    {
        word=s;   
    }	

    /**
     * Method ripString
     *
     * @param x A integer
     * @param y A integer
     * @return the substring from x to y
     */
    public String ripString(int x, int y)
    {
        return word.substring(x,y);
    }

    /**
     * Method toString
     *
     * @return The value of word
     */
    public String toString()
    {
        return word+"\n";
    }
}