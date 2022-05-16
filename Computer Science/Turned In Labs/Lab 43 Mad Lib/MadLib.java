//Name - Race Saunders
//Date - 10-4
//Class -
//Lab  - 43

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;


//class simulates the creation of a Mad Lib
public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	// complete the no-arg constructor
	public MadLib()
	{
	    verbs= new ArrayList<String>();
	    nouns= new ArrayList<String>();
	    adjectives= new ArrayList<String>();
		
	}
    
	// Constructor
	public MadLib(String fileName)
	{
		// Initialize the instance data here, just as in the no-arg constructor
		verbs= new ArrayList<String>();
	    nouns= new ArrayList<String>();
	    adjectives= new ArrayList<String>();
	    
		loadNouns();
		loadVerbs();
		loadAdjectives();
		
		try{
			Scanner file = new Scanner(new File(fileName));
			while(file.hasNext())
			{
				String symbol = file.next();
				
				// If the symbol in the file is a "#" call getRandomNoun and print the noun
				if(symbol.equals("#")){System.out.println(getRandomNoun());}
				// If the symbol in the file is a "@" call getRandomVerb and print the verb
				else if(symbol.equals("@")){System.out.println(getRandomVerb());}
				// If the symbol in the file is a "&" call getRandomAdjective and print the adjective
				else if(symbol.equals("&")){System.out.println(getRandomAdjective());}
				// If the symbol is an actual word, print the word
				else{System.out.println(symbol);}
				
			}
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}
		
	}

	// This method is complete
	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File("nouns.dat"));
			while(file.hasNext())
			{
				nouns.add(file.next());
			}
		}
		catch(Exception e)
		{
		}	
		
	}
	
	// This method is complete
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File("verbs.dat"));
			while(file.hasNext())
			{
				verbs.add(file.next());
			}
		}
		catch(Exception e)
		{
		}
	}

	// This method is complete
	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File("adjectives.dat"));
			while(file.hasNext())
			{
				adjectives.add(file.next());
			}
		}
		catch(Exception e)
		{
		}
	}

	// Complete this method
	public String getRandomVerb()
	{
	    
	    return verbs.get((int)(Math.random()*(verbs.size())));
		
	}
	
	// Complete this method
	public String getRandomNoun()
	{
	    return nouns.get((int)(Math.random()*(nouns.size())));
		
	}
	
	// Complete this method
	public String getRandomAdjective()
	{
	    return adjectives.get((int)(Math.random()*(adjectives.size())));
		
	}		

	// This method is complete
	public String toString()
	{
	   return "\n\n\n";
	}
}