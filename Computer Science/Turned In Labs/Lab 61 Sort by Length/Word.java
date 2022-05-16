import static java.lang.System.*;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */
public class Word implements Comparable<Word>
{
    private String word;

    // constructor
    public Word( String s )
    {
        word = new String(s);
    }

    // return 1 if the length of this word > length of other word
    // return -1 if the length of this word < length of other word
    // if the lengths are the same, return the result of the String class compareTo method
    public int compareTo( Word other )
    {		
        if(word.length()>other.word.length()){return 1;}
        if(word.length()<other.word.length()){return -1;}
        return word.compareTo(other.word);
    }

    // return word
    public String toString()
    {
        return word;
    }
}