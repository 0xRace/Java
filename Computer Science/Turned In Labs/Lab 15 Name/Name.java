/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import static java.lang.System.*;

public class Name
{
    private String name;

    /**
     * Name Constructor
     * instantiates instance of Name
     */
    public Name()
    {
        name="";
    }

    /**
     * Name Constructor
     * sets String name equal to string s and creates instance of Name
     * @param s is a name
     */
    public Name(String s)
    {
        name=s;
    }

    /**
     * Method setName
     * sets name equal to string s
     * @param s is a name
     */
    public void setName(String s)
    {
        name=s;
    }

    /**
     * Method getFirst
     * returns the first name of the person
     * @return The return value
     */
    public String getFirst()
    {
        return name.substring(0,name.indexOf(" "));
    }

    /**
     * Method getLast
     * returns the last name of the person
     * @return The return value
     */
    public String getLast()
    {
        return name.substring(name.indexOf(" ")+1,name.length());
    }

    /**
     * Method toString
     * returns the full name of the person
     * @return The return value
     */
    public String toString()
    {
        return name+"\n";
    }
}