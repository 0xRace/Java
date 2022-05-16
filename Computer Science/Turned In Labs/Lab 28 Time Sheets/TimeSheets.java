import java.util.Scanner;

public class TimeSheets
{
   public static void main (String[] args)
   {
    /* Use Scanner for keyboard input.  Each time the program runs,
    the user will five lines of data containing eight values.
    
    
    Each line will contain the employee information for 2 work days.  
    The data will represent in order the location, the day number, 
    the start time and the end time for each day.
    
        SAMPLE INPUT:                           SAMPLE OUTPUT:
        1.  125, 2, 1, 7, 125, 3, 5, H          1.  $95.00
        2.  214, 4, 1, H, 314, 5, 5, H          2.  $133.00
        3.  318, 1, 1, H, 319, 3, 3, D          3.  $126.50
        4.  423, 1, 1, 7, 500, 2, 5, H          4.  $88.50
        5.  529, 6, 1, G, 100, 4, 2, G          5.  $146.00

    */
   Scanner keyboard=new Scanner(System.in);
   System.out.println("Please enter 5 lines of data. Each line should");
   System.out.println("contain the employee information for 2 work days");
   System.out.println("the data for each day should be ordered as");
   System.out.println("location, day #, start time, end time");
   System.out.println("Press enter after each line of data");
   System.out.print("\n1. ");
   String one= keyboard.nextLine();
   System.out.print("\n2. ");
   String two= keyboard.nextLine();
   System.out.print("\n3. ");
   String three= keyboard.nextLine();
   System.out.print("\n4. ");
   String four= keyboard.nextLine();
   System.out.print("\n5. ");
   String five= keyboard.nextLine();
   
}
}
