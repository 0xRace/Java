import static java.lang.System.*;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */
public class Word implements Comparable<Word>
{
    private String word;

    // constructor
    public Word( String s)
    {
        word=s;

    }

    // returns the number of vowels in word
    private int numVowels()
    {
        String vowels = "AEIOUaeiou";
        int vowelCount=0;
        for(int i=0;i<word.length();i++)
        {
            for(int x=0;x<vowels.length();x++)
            {
                if(word.charAt(i)==vowels.charAt(x)){vowelCount++;}
            }
        }


        return vowelCount;
    }

    // returns 1 if the number of vowels in this word > number of vowels in other word
    // returns -1 if the number of vowels in this word < number of vowels in other word
    // if the number of vowels are equal, returns whatever is returned by the 
    // String class compareTo method
    public int compareTo(Word other)
    {
        if(this.numVowels()>other.numVowels()){return 1;}
        else if(this.numVowels()<other.numVowels()){return -1;}
        else{return this.word.compareTo(other.word);}
    }

    public String toString()
    {
        return word;
    }
}