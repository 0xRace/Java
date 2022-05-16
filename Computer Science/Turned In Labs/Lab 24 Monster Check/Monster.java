/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * Class Monster creates and defines "Monsters" with a string name and size howBig. It can compare size and names. 
 */

import static java.lang.System.*; 

public class Monster
{
    private String name;
    private int howBig; 

    /**
     * Monster Constructor creates a new instance of the Monster class
     * sets name equal to "" and howBig equal to 0
     *
     */
    public Monster()
    {
        name="";
        howBig=0;

    }
    /**
     * Monster Constructor creates a new instance of the Monster class
     *
     * @param n is a string which sets name
     * @param size is a int which sets howBig
     */
    public Monster(String n, int size)
    {
        name=n;
        howBig=size;

    }
    /**
     * Method getName returns the name of the monster
     *
     * @return the name of the monster
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Method getHowBig returns the size of the monster
     *
     * @return the size of the monster;
     */
    public int getHowBig()
    {
        return howBig;
    }

    /**
     * Method isBigger compares two monsters
     *
     * @param other is a monster which will be compared by size
     * @return true if the monster is bigger than the one being compared to, or false if it is smaller than the one being compared to
     */
    public boolean isBigger(Monster other)
    {
        if(howBig>other.getHowBig()){return true;}
        else{return false;}
    }

    /**
     * Method isSmaller compares two monsters
     *
     * @param other is a monster which will be compared by size
     * @return true if the monster is smaller than the one being compared to, or true if it is smaller than the one being compared to
     */
    public boolean isSmaller(Monster other)
    {
        if(howBig>other.getHowBig()){return false;}
        else{return true;}
       
    }

    /**
     * Method namesTheSame compares the names of two monsters
     *
     * @param other is a monster which will be compared by name
     * @return true if the name of the two monsters are the same, or false otherwise
     */
    public boolean namesTheSame(Monster other)
    {
        if(name.compareTo(other.getName())==0){return true;}
        else{return false;}
    }

    /**
     * Method toString returns the name of the monster and its size
     *
     * @return the name of the monster and its size
     */
    public String toString()
    {
        return name+" "+howBig;
    }
}