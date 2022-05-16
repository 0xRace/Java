/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * This program takes in a given word and outputs the first letter, last letter, and the word backwards
 */

import static java.lang.System.*;

public class Word
{
    private String word;

    /**
     * Word Constructor creates a new instance of Word with String word=""
     *
     */
    public Word()
    {
        word="";
    }

    /**
     * Word Constructor creates a new instance of Word and sets String word= to s
     *
     * @param s is a string which sets word
     */
    public Word(String s)
    {
        word=s;
    }

    /**
     * Method setString sets String word = to s
     *
     * @param s is a string which sets word
     */
    public void setString(String s)
    {
        word=s;
    }

    /**
     * Method getFirstChar returns the first character of a word
     *
     * @return the first character of a word
     */
    public char getFirstChar()
    {
        return word.charAt(0);
    }

    /**
     * Method getLastChar returns the last character of a word
     *
     * @return the last character of a word
     */
    public char getLastChar()
    {
        return word.charAt(word.length()-1);
    }

    /**
     * Method getBackWards returns the word backwards
     *
     * @return a given word backwards
     */
    public String getBackWards()
    {
        String back="";
        for(int x=word.length()-1; x>=0;x--)
        {
            back=back+word.charAt(x);
        }
        return back;
    }

    /**
     * Method toString returns the value of word
     *
     * @return word
     */
    public String toString()
    {
        return word;
    }
}