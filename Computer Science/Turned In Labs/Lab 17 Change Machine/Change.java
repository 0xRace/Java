import java.io.*;
import java.util.Scanner;
class Change
{
    public static void main(String [] args)
    {
        //Declare Scanner and variables:
        Scanner keyboard=new Scanner(System.in);
        double cost,paid,change;
        int quarters,dimes,nickels,pennies;
             
        
        //Get input and calculate change:
        System.out.println("\nPlease enter the cost of the item\n");
        cost=keyboard.nextDouble();
        System.out.println("\nPlease enter the amount paid\n");
        paid=keyboard.nextDouble();
        //Calculate amount of each coin, using modular division
        //or division-subtraction:
        change=paid-cost+.001;
        
        quarters=(int)(change/.25);
        dimes=(int)(((change-(quarters*.25))/.1));
        nickels=(int)(((change-(quarters*.25+dimes*.1))/.05));
        pennies=(int)(((change-(quarters*.25+dimes*.1+nickels*.05))/.01));
        //Print output:
        System.out.printf("Change owed: %.2f\n",change);
        System.out.println("Quarters: "+quarters);
        System.out.println("Dimes: "+dimes);
        System.out.println("Nickels: "+nickels);
        System.out.println("Pennies: "+pennies);
        
        
    }
}