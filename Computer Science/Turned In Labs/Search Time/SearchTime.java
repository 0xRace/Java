import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class SearchTime
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<String> l = new ArrayList<String>();
        StopWatch timer = new StopWatch();
        Scanner inFile;
        Scanner keyboard;
        keyboard=new Scanner(System.in);
        
        inFile = new Scanner(new File("words.txt"));

        while(inFile.hasNextLine())
        {
            l.add(inFile.nextLine());
        }

        //YOUR CODE HERE

        //Ask the user to input a word
        System.out.println("Please input a word");
        String w=keyboard.nextLine();
        
        //Add code here to calculate how much faster a binary search is that a sequential
        //search for this particular dictionary for the user's word

        //Note: The lapsed time class is a rather crude stopwatch.  It returns results
        //to the nearest second.  You will want to time events that are much longer than
        //1 second (for example, 10 seconds or greater).  To do this, call each search 
        //method thousands of times.
        int i=0;
        timer.reset();
        timer.start();
        while(i<50000){sequentialSearch(l,w); System.out.println(i);i++;}
        timer.stop();
        double s1=timer.getTime();
        
        i=0;
        timer.reset();
        timer.start();
        while(i<50000){binarySearch(l,w);System.out.println(i);i++;}
        timer.stop();
        double s2=timer.getTime();
        
        System.out.println("Binary search is "+(s1/s2)+" times faster than sequatial search for the word "+w);

    }
    //Sequential search - start at the front and look in every bucket
    //Works for sorted or unsorted lists!!
    //returns the index of item or -1 if not found
    public static int sequentialSearch(ArrayList<String> l, String word)
    {
        //YOUR CODE HERE
        for(String i: l){
            if( i.equals(word))
            {
                return 1;
            }
        }
        return -1;
    }

    //Binary search - check the middle bucket and throw away half of the list if not found
    //Only works for a SORTED list
    //returns the index of item or -1 if not found
    public static int binarySearch(ArrayList<String> l, String word)
    {
        int b = 0;
        int t = l.size() - 1;
        while (b <= t){
            int m = (b + t) / 2;
            if (l.get(m).equals(word)){
                return m;
            }
            
            else if(word.compareTo(l.get(m)) < 0){
                t = m - 1;
            }
            else{
                b = m + 1;
            }
        }
        
        return -1;
    }
    
}