import static java.lang.System.*; 
import java.util.Scanner;

public class GradeCheck
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter a number grade :: ");
		int grade = keyboard.nextInt(); 
		Grade theGrade = new Grade(grade);
		out.println(theGrade);  //78

		out.print("Enter a number grade :: ");
		grade = keyboard.nextInt(); 
		theGrade.setGrade(grade);
		out.println(theGrade);  //92
		
		out.print("Enter a number grade :: ");
		grade = keyboard.nextInt(); 
		theGrade.setGrade(grade);
		out.println(theGrade); 
		
		out.print("Enter a number grade :: ");
		grade = keyboard.nextInt(); 
		theGrade.setGrade(grade);
		out.println(theGrade); 
		
		out.print("Enter a number grade :: ");
		grade = keyboard.nextInt(); 
		theGrade.setGrade(grade);
		out.println(theGrade); 
		
		out.print("Enter a number grade :: ");
		grade = keyboard.nextInt(); 
		theGrade.setGrade(grade);
		out.println(theGrade); 
		
		out.print("Enter a number grade :: ");
		grade = keyboard.nextInt(); 
		theGrade.setGrade(grade);
		out.println(theGrade); 
		
		out.print("Enter a number grade :: ");
		grade = keyboard.nextInt(); 
		theGrade.setGrade(grade);
		out.println(theGrade); 
		
		// Add six more test cases where you call the setGrade and toString methods on theGrade,
		// as above.
	}
}