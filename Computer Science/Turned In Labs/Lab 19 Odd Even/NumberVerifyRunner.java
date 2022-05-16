import static java.lang.System.*;
import java.util.Scanner;

public class NumberVerifyRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		//test one
		out.print("Enter a whole number :: ");
		int num = keyboard.nextInt();
		out.println(num + " is odd :: " + NumberVerify.isOdd(num));  //111
		out.println(num + " is even :: " + NumberVerify.isEven(num));  //111
		//test two
		out.print("Enter a whole number :: ");
		num = keyboard.nextInt();
		out.println(num + " is odd :: " + NumberVerify.isOdd(num));  //111
		out.println(num + " is even :: " + NumberVerify.isEven(num));  
		//test three
		out.print("Enter a whole number :: ");
		num = keyboard.nextInt();
		out.println(num + " is odd :: " + NumberVerify.isOdd(num));  //111
		out.println(num + " is even :: " + NumberVerify.isEven(num)); 
		//test four
		out.print("Enter a whole number :: ");
		num = keyboard.nextInt();
		out.println(num + " is odd :: " + NumberVerify.isOdd(num));  //111
		out.println(num + " is even :: " + NumberVerify.isEven(num));  
		
	}
}