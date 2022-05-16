/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * Race Saunders
 * the purpose of this lab is to perform functions with the dog class
 */
public class Dog 
{
    private int age;
    private String name;

    /**
     * Dog Constructor creates a new instance of Dog
     *
     * @param a is an integer which sets age
     * @param n is a string which sets name
     */
    public Dog(int a, String n) 
    {
        // complete the constructor
        age=a;
        name=n;
    } 

    /**
     * Method getName
     *
     * @return the name of the dog
     */
    public String getName()
    {
        // complete the accessor method
        return name;
    }

    /**
     * Method getAge
     *
     * @return the age of the dog
     */
    public int getAge()
    {
        // complete the accessor method
        return age;
    }

    /**
     * Method toString
     *
     * @return the age and name of a dog
     */
    public String toString()
    {
        return "" + age + " " + name;
    }  
}