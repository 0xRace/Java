import java.util.Scanner;
import static java.lang.System.*; 

public class MonsterRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		int size;
		String name;
		out.print("Enter 1st monster's name : ");
		name = keyboard.next();
		out.print("Enter 1st monster's size : ");	
		size=keyboard.nextInt();	
		Monster mOne = new Monster(name, size);

		out.print("Enter 2nd monster's name : ");
		name = keyboard.next();
		out.print("Enter 2nd monster's size : ");	
		size=keyboard.nextInt();	
		Monster mTwo = new Monster(name, size);	
		
		System.out.println("\nMonster 1- "+mOne.toString());
		System.out.println("Monster 2- "+mTwo.toString()+"\n");
		
		if(mOne.isBigger(mTwo)==true)
		{
			out.println("Monster one is bigger than Monster two.");
		}
		if(mOne.isSmaller(mTwo)==true)
		{
			out.println("Monster one is smaller than Monster two.");
		}
		if(mOne.namesTheSame(mTwo)==true)
		{
			out.println("Monster one has the same name as Monster two.");
		}
		else{out.println("Monster one does not have the same name as Monster two.");}
	}
}