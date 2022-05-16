import java.util.Arrays;
/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * Race Saunders
 * the purpose of this lab is to perform functions with the Doggies class
 */
public class Doggies
{
    private Dog[] pups;

    /**
     * Doggies Constructor
     *
     * @param size sets the size of the pups array
     */
    public Doggies(int size)
    {
        //point pups at a new arry of Dog
        pups=new Dog[size];

    }

    /**
     * Method add
     *
     * @param spot sets where the dog to be added will be in the array
     * @param age is the age of the new dog
     * @param name is the name of the new dog 
     */
    public void add(int spot, int age, String name)
    {
        //add a new Dog to the array at spot 
        //make sure spot is in bounds
        Dog newPup= new Dog(age,name);
        if(spot<pups.length){pups[spot]=newPup;}

    }

    /**
     * Method getNameOfOldest
     *
     * @return the name of the oldest dog
     */
    public String getNameOfOldest()
    {
        int spot=0;
        for(int i=0;i<pups.length;i++)
        {
            if(pups[i].getAge()>=pups[spot].getAge()){spot=i;}
        }
        return pups[spot].getName();
    }

    /**
     * Method getNameOfYoungest
     *
     * @return the name of the youngest dog
     */
    public String getNameOfYoungest()
    {
        int spot=0;
        for(int i=0;i<pups.length;i++)
        {
            if(pups[i].getAge()<=pups[spot].getAge()){spot=i;}
        }
        return pups[spot].getName();
    }

    /**
     * Method toString
     *
     * @return the pups array
     */
    public String toString()
    {
        return ""+Arrays.toString(pups);
    }
}