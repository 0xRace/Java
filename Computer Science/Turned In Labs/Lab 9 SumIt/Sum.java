/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

public class Sum
{
    //instance variables
    private double one, two, sum;

    // mutator method
    public void setNums(double num1, double num2)
    {
        one=num1;
        two=num2;
    }

    // find the sum of one and two
    public void sum( )
    {
        sum=one+two;
    }

    // print the value of one, two, and sum
    public void print( )
    {
        System.out.println(one+" + "+two+" == "+sum);
    }
}