/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * The purpose of this program is to print all numbers containing the digit 3 from 1000 to 2000
 */

public class AnyThrees{

    /**
     * Method main
     *when run, will print all numbers from 1000 to 2000 that contain the digit 3
     * 
     */
    public static void main(String[] args)
    {
        // insert your code here
        // you will need a loop
        // inside the loop, you will need to call hasThree
        for(int x=1000; x<=2000; x++)
        {
            if(hasThree(x)==true){System.out.println(x);}
        }
    }

    /**
     * Method hasThree determines if a number contains the digit 3
     *
     * @param number is a integer between 1000 and 2000
     * @return true if the string contains any "3"s, false otherwise
     */
    public static boolean hasThree(int number)
    {
        String numstr=""+number;
        if(numstr.indexOf("3")!=-1){return true;}
        
        return false;
    }
}	