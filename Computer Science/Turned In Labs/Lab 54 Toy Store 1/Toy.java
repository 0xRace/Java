import static java.lang.System.*;
/**Race Saunders
 * @author Please put your name and the name of anyone who you worked with on this lab
 * The purpose of this program is to create a toy class that stores a toy name and a count for how many of that toy extists in a store
 */
public class Toy
{
    private String name;
    private int count;

    /**
     * Toy Constructor creates a new instance of Toy with no name and count of 1
     *
     */
    public Toy()
    {
        count=1;
        name="";
    }

    /**
     * Toy Constructor creates a new instance of Toy with a name and count of one
     *
     * @param nm is a string which sets name
     */
    public Toy( String nm )
    {
        name=nm;
        count=1;
    }

    /**
     * Method getCount 
     *
     * @return the value of count
     */
    public int getCount()
    {
        return count;
    }

    /**
     * Method setCount
     *
     * @param cnt sets count
     */
    public void setCount( int cnt )
    {
        count=cnt;
    }

    /**
     * Method getName
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Method setName
     *
     * @param nm sets name
     */
    public void setName( String nm )
    {
        name=nm;
    }

    /**
     * Method toString
     *
     * @return the name and count of a Toy
      */
    public String toString()
    {
        return name+" "+ count;
    }
}