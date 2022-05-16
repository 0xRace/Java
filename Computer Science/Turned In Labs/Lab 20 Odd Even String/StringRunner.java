import static java.lang.System.*;
import java.util.Scanner;

public class StringRunner
{
	public static void main ( String[] args )
	{
	    Scanner keyboard = new Scanner(System.in);
		
	    // first word
		out.print("Enter a word :: ");
		String word = keyboard.next();
		StringOddOrEven demo = new StringOddOrEven(word);
		out.println(demo);   //cat
		
		// second word
		
		out.print("Enter a word :: ");
		word = keyboard.next();
		demo.setString(word);
		out.println(demo);  //boot
		
		// third word
		
		out.print("Enter a word :: ");
		word = keyboard.next();
		demo.setString(word);
		out.println(demo); 
		
		// fourth word
		
		out.print("Enter a word :: ");
		word = keyboard.next();
		demo.setString(word);
		out.println(demo); 
		
		// fifth word
		
		out.print("Enter a word :: ");
		word = keyboard.next();
		demo.setString(word);
		out.println(demo); 
		
		//add more test cases
	}
}