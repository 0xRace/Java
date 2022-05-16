import java.util.Scanner;

public class QuineMcCluskey
{
    public static void main (String [] args)
    {

        Scanner kb = new Scanner(System.in);

        // Line 1
        System.out.println("Enter line 1 of input");
        String [] input = kb.nextLine().split(",");

        int count=0;

        while (Integer.parseInt(input[count])!=-1)
        {
            count++;
        }

        // POSSIBLY INSERT CODE HERE, BUT NOT NECESSARY
        
        // Lines 2 and 3
        for (int l=2; l<=3; l++)
        {
            System.out.println("Enter line " + l + " of input");
            input = kb.nextLine().split(",");

            //INSERT CODE HERE TO DETERMINE OUTPUT LINES 1 and 2
        }
        
        // Lines 4, 5, and 6
        for (int l=4; l<=6; l++)
        {
            System.out.println("Enter line " + l + " of input");
            input = kb.nextLine().split(",");

            //INSERT CODE HERE TO DETERMINE OUTPUT LINES 3, 4, and 5
        }
    }

    // Converts base ten int to 4-bit binary string
    // e.g. if ten = 5, returns "0101"
    public static String tenToBinary(int ten)
    {   
        return "";
    }
}
