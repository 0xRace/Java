// Please insert your name and the name of any people who you worked with on this lab.
// Name:
// People who you worked with:

import twitter4j.*;       //set the classpath to lib\twitter4j-core-4.0.2.jar
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Twitter_BMS
{
    private static PrintStream consolePrint;

    public static void main (String []args) throws TwitterException, IOException
    {
        consolePrint = System.out; 

        // PART 1
        // set up classpath and properties file

        BMSTwitter bigBird = new BMSTwitter(consolePrint);

        // create message to tweet, then call the tweetOut method
        bigBird.tweetOut("Just testing my Twitter app.");

        // PART 2
        // Choose a public Twitter user's handle 

        Scanner scan = new Scanner(System.in);
        consolePrint.print("Please enter a Twitter handle, do not include the @symbol --> ");
        String twitter_handle = scan.next();

        while (!twitter_handle.equals("done"))
        {
            // Print the most popular word they tweet
            bigBird.makeSortedListOfWordsFromTweets(twitter_handle);
            consolePrint.println("The most common word from @" + twitter_handle + " is: " + bigBird.mostPopularWord());
            consolePrint.println();
            consolePrint.print("Please enter a Twitter handle, do not include the @ symbol --> ");
            twitter_handle = scan.next();
        }

        // PART 3
        bigBird.investigate();

    }//end main        
}//end driver        
class BMSTwitter 
{
    private Twitter twitter;
    private PrintStream consolePrint;
    private List<Status> statuses;
    private List<String> sortedTerms;

    public BMSTwitter(PrintStream console)
    {
        // Make an instance of Twitter - this is re-useable and thread safe.
        twitter = TwitterFactory.getSingleton(); //connects to Twitter and performs authorizations
        consolePrint = console;
        statuses = new ArrayList<Status>();
        sortedTerms = new ArrayList<String>();   
    }

    /******************  Part 1 *******************/
    public void tweetOut(String message) throws TwitterException, IOException
    {
        //twitter.updateStatus(message);
    }

    @SuppressWarnings("unchecked")
    public void makeSortedListOfWordsFromTweets(String handle) throws TwitterException, IOException
    {
        statuses.clear();
        sortedTerms.clear();
        PrintStream fileout = new PrintStream(new FileOutputStream("tweets.txt")); // Creates file for dedebugging purposes
        Paging page = new Paging (1,200);
        int p = 1;
        while (p <= 10)
        {
            page.setPage(p);
            statuses.addAll(twitter.getUserTimeline(handle,page)); 
            p++;        
        }
        int numberTweets = statuses.size();
        fileout.println("Number of tweets = " + numberTweets);

        fileout = new PrintStream(new FileOutputStream("garbageOutput.txt"));

        int count=1;
        for (Status j: statuses)
        {
            fileout.println(count+".  "+j.getText());
            count++;
        }       

        //Make a list of words from user timeline
        for (Status status : statuses)
        {           
            String[]array = status.getText().split(" ");
            for (String word : array)
            {  //System.out.println(word);
                sortedTerms.add(removePunctuation(word).toLowerCase());
            }
        }   

        // Remove common English words, which are stored in commonWords.txt                        
        sortedTerms = removeCommonEnglishWords(sortedTerms);
        sortAndRemoveEmpties();

    }
    // Sort words in alpha order. You should use your old code from the Sort/Search unit.
    // Remove all empty strings ""
    @SuppressWarnings("unchecked")
    private void sortAndRemoveEmpties()
    {
        Sorter.sort(sortedTerms); //uses code from sorting widgets

        for (int i=0; i<sortedTerms.size();i++)
        {
            if (sortedTerms.get(i).equals(""))
            {
                sortedTerms.remove(i);
                i--;            
            }
        }
    }

    // Removes common English words from list
    // Remove all words found in commonWords.txt  from the argument list.
    @SuppressWarnings("unchecked")
    private List removeCommonEnglishWords (List<String> list)
    {   
        int count=0;
        try {
            Scanner infile = new Scanner (new File("words.dat"));
            while (infile.hasNext())
            {
                count++;
                infile.next();
            }   
            //consolePrint.println(count);  
            infile.close();
        }
        catch (FileNotFoundException e) {
            return list;
        }

        try {
            Scanner infile2 = new Scanner (new File("words.dat"));
            String [] boringWords = new String [count];
            int i=0;
            while (infile2.hasNext())
            {               
                boringWords[i]=infile2.next();
                i++;
            }   
            for (int j=0; j<list.size(); j++)
            {
                for (int k=0;k<boringWords.length;k++)
                {
                    if (list.get(j).equalsIgnoreCase(boringWords[k]))
                    {
                        list.remove(j);
                        j--;
                        k=boringWords.length;
                    }
                }   
            }
            infile2.close();
            for (int z=0;z<list.size();z++)
            {
                if (list.get(z).length()>=1 && list.get(z).charAt(0)=='@')
                {
                    list.remove(z);
                    z--;
                }
            }       
            return list;
        }
        catch (FileNotFoundException e) {
            return list;
        }
    }

    //Remove punctuation
    //YOU NEED TO COMPLETE THIS METHOD
    private String removePunctuation( String s )
    { 
        String punct = ".,'?!:;\"(){}^{}<>-";
        String scrubbed = "";

        //INSERT CODE HERE
        //Loop through each character of s.  If a character is found in not found punct (use indexOf),
        //then concatenate that character to scrubbed.  Otherwise, you don't want it, so do nothing.
        for(int i=0;i<s.length();i++)
        {
            if(punct.indexOf(s.charAt(i))!=-1){}
            else{scrubbed=scrubbed+s.charAt(i);}
        }

        //return s; // when you are done, comment this line and uncomment the next
        return scrubbed;
    }

    //Return the most common word from sortedTerms.
    //YOU NEED TO COMPLETE THIS METHOD
    @SuppressWarnings("unchecked")
    public String mostPopularWord()
    {
        String mostPopular=sortedTerms.get(0);
        int mostPopularWordCount = 1;
        int thisWordCount = 1;

        // INSERT CODE HERE
        //
        // You need to insert a loop that goes through the elements of the ArrayList sortedTerms
        //      The loop control variable will be the index in the list.
        //      Start its value at 1, since you will be comparing each String to the String before it in the list
        //
        //      If a String is the same as the one before it, increment thisWordCount by 1
        //      Remember, use the equals method of the String class to compare Strings, not ==
        //
        //      If thisWordCount is greater than mostPopularWordCount
        //          mostPopular is now the present most popular String in the list
        //          mostPopularWordCount now is equal to thisWordCount
        //
        //      If an element is not the same as the one before it, set thisWordCount back to 1

        for(int i=1; i<sortedTerms.size();i++)
        {
            if(sortedTerms.get(i).equals(sortedTerms.get(i-1))){thisWordCount++;}
            else if(thisWordCount>mostPopularWordCount){mostPopularWordCount=thisWordCount;mostPopular=sortedTerms.get(i-1);thisWordCount=1;}
            else{thisWordCount=1;}

        }

        consolePrint.println("Count = " + mostPopularWordCount + " out of the last "+statuses.size()+" tweets.");    
        return mostPopular;
    }

    /******************  Part 3 *******************/

    public void investigate ()
    {
        // A sample query to determine how many people in Baltimore tweet about the Orioles
        Query query = new Query("flu");
        query.setCount(100);
        query.setGeoCode(new GeoLocation(39.446597,-76.647058), 15, Query.MILES);
        query.setSince("2016-03-1");
        try {
            QueryResult result = twitter.search(query);
            consolePrint.println("Count : " + result.getTweets().size()) ;
            for (Status tweet : result.getTweets()) {
                consolePrint.println("@"+tweet.getUser().getName()+ ": " + tweet.getText());  
            }
        } 
        catch (TwitterException e) {
            e.printStackTrace();
        } 
        consolePrint.println(); 
    }  

}  

class Sorter
{
    // Sorts list lexicographically
    public static void sort(List<String> list){
        // Copy the selection sort code from the code that was distributed in class and paste it here.
        // Now just modify this code to work with an Array list of Strings, not an array of ints.
        // Remember, to compare Strings lexicographically, use the compareTo method in the String class.
        // Do not use any other sorting method.  For example, if you are familiar with
        // Collections.sort(), do not use it.
        //
        // INSERT CODE HERE
        for (int i = 0; i < list.size()- 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < list.size(); j++){
                if (list.get(j).compareTo(list.get(index))<0)
                {index = j;}

                String temp = list.get(index); 
                list.set(index,list.get(i));
                list.set(i,temp);

            }
        }
    }
}    

