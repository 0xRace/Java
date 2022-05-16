/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * the purpose of this program is to print all numbers from 1000 to 10000 which contains the digit 3 three times
 */

public class ThreeThrees{
    /**
     * Method main 
     * when run it will prting all numbers from 1000 to 10000 that contain the digit 3 three times
     */
    public static void main(String[] args)
    {
        // insert a loop here
        // call hasThreeThrees from within loop
        for (int x = 1000; x<=10000;x++)
        {
            String xStr=""+x;
            if(hasThreeThrees(xStr)==true){System.out.println(x);}
        }
    }

    /**
     * Method hasThreeThrees tests if a given number contains the digit three three times
     *
     * @param number is a string
     * @return true if number has exactly three "3" digits, false otherwise
     */
    public static boolean hasThreeThrees(String number)
    {
        int x=0;
        for(int i=0; i<number.length();i++)
        {
            if(Integer.parseInt(number.substring(i,i+1))==3)
            {
                x=x+1;
            }
            if(x==3){return true;}
        }
        return false;
    }
}	