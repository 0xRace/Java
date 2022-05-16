//Name -
//Please include the name of anyone who you worked with on this lab

import static java.lang.System.*;

public class RecursionFunTwo
{
	public static int countChickens(String word)
	{
	    /*
	     * Algorithm help (Your solution must use recursion):
	     * 
	     if (length of word > 0)
	     * 
	     *   use indexOf to determine if "chicken" is in word and if so, its position
	     *   
	     *   if "chicken" is, in fact, present somewhere in word
	     *      return 1 + countChickens(a string with "chicken" removed) - use two substring calls
	     *                                                                  to generate this string
	     *   
	     *  return 0
	     * 
	     * 
	     * 
	     */
	    if(word.length()>0)
	    {
	        if(word.indexOf("chicken")!=-1){
	            
	            return 1+countChickens(word.substring(0,word.indexOf("chicken"))+word.substring(word.indexOf("chicken")+7,word.length()));}
	       }


		return 0;
	}
}