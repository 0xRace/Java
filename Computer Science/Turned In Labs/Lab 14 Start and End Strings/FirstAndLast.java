/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;

public class FirstAndLast
{
    private String word="";

    /**
     * FirstAndLast Constructor
     * Sets word to a given string
     * @param s is set equal to word
     */
    public FirstAndLast(String s)
    {
        word=s;
    }

    /**
     * Method setString
     * Sets word to a given string
     * @param s is set equal to word
     */
    public void setString(String s)
    {
        word=s;
    }

    /**
     * Method getFirst
     * Returns the first letter of the string word
     * @return The first letter
     */
    public String getFirst()
    {
        return word.charAt(0)+"";
    }

    /**
     * Method getLast
     * Returns the last letter of the string word
     * @return The last letter
     */
    public String getLast()
    {
        int howLong=  word.length()-1;
        return word.charAt(howLong)+"";
    }

    /**
     * Method toString
     * Returns the value of word
     * @return The word value
     */
    public String toString()
    {
        String output=word;
        return output;
    }
}