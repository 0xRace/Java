/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * Class Grade finds the letter grade that correlates to a given number grade
 */

import static java.lang.System.*; 

public class Grade
{
    private int numGrade;

    /**
     * Grade Constructor
     * creates a new instance of Grade with int numGrade set to 0
     *
     */
    public Grade()
    {
        numGrade=0;
    }

    /**
     * Grade Constructor
     * creates a new instance of Grade with int numGrade set to grade
     * @param grade is an integer which sets numGrade
     */
    public Grade(int grade)
    {
        numGrade=grade;
    }

    /**
     * Method setGrade sets the value of numGrade
     *
     * @param grade is an integer which sets numGrade
     */
    public void setGrade(int grade)
    {
        numGrade=grade;
    }

    /**
     * Method getLetterGrade finds the letter grade that correlates to each number grade
     *
     * @return the letter grade which has been calculated from a given number grade
     */
    public String getLetterGrade( )
    {
        String letGrade="";
        if(numGrade>=90){letGrade="A";}
        if(numGrade>=80 && numGrade<90){letGrade="B";}
        if(numGrade>=75 && numGrade<80){letGrade="C";}
        if(numGrade>=70 && numGrade<75){letGrade="D";}
        if(numGrade<70){letGrade="F";}       
        return letGrade;
    }

    /**
     * Method toString returns the letter grade correlating to the number grade
     *
     * @return a string stating that a given number grade is equal to a certain letter grade
     */
    public String toString()
    {
        return numGrade + " is a " + getLetterGrade() + "\n";
    }
}