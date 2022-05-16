/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;
import java.util.Scanner;

public class StringOddOrEven
{
    private String word;

    /**
     * StringOddOrEven Constructor
     * creates a new instance of StringOddOrEven
     */
    public StringOddOrEven()
    {
        word="";
    }

    /**
     * StringOddOrEven Constructor
     * creates a new instance of StringOddOrEven
     * @param s is a given string whose value is set to word
     */
    public StringOddOrEven(String s)
    {
        word=s;
    }

    /**
     * Method setString
     *
     * @param s is a given string whose value is set to word
     */
    public void setString(String s)
    {
        word=s;
    }

    /**
     * Method isEven
     *
     * @return true if the number of letters in word is even, or false if not
     */
    public boolean isEven()
    {
        return (word.length()%2)==0;
    }

    /**
     * Method toString
     *
     * @return the value of word and tell if the number of characters in the string is even or not
     */
    public String toString()
    {
        String output="";

        if(isEven())
        {
            output=word + " is even.\n";
        }
        else{output=word + " is odd.\n";}

        // add code here to handle the situation where the String is odd

        return output;
    }
}