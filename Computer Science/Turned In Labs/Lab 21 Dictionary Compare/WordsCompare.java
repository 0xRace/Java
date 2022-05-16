/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 *Class WordCompare determines if words should be placed in front of or behind eachother in a dictionary
 */

import static java.lang.System.*;

public class WordsCompare
{
    private String wordOne, wordTwo;
    private int compare;

    /**
     * WordsCompare Constructor
     * creates a new instance of WordsCompare
     * sets int compare to 0 and wordOne and wordTwo to ""
     *
     */
    public WordsCompare()
    {
        wordOne="";
        wordTwo="";
        compare=0;
    }

    /**
     * WordsCompare Constructor
     * creates a new intsance of WordsCompare
     * @param one is a string which sets wordOne
     * @param two is a string gwhich sets wordTwo
     * int compare is set to 0
     */
    public WordsCompare(String one, String two)
    {
        wordOne=one;
        wordTwo=two;
        compare=0;
    }

    
    /**
     * Method setWords sets the string variables to two given strings
     * @param one is a string which sets wordOne
     * @param two is a string which sets wordTwo
     */
    public void setWords(String one, String two)
    {
        wordOne=one;
        wordTwo=two;

    }

    /**
     * Method compare compares the two given words so that they may later be evaluated for placement in a dictionary
     *
     */
    public void compare()
    {
        compare=wordOne.compareTo(wordTwo);
    }

    /**
     * Method toString evaluates where the words should be placed based on the value of compare
     *
     * @return a string stating where which word should be placed
     */
    public String toString()
    {
        if(compare<0)
        {
            return wordOne + " should be placed before " + wordTwo + "\n";
        }
        else
        {
            return wordOne + " should be placed after " + wordTwo + "\n";
        }
    }
}