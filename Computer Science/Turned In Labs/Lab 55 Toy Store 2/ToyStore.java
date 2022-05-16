import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
    private ArrayList<Toy> toyList;

    // constructor
    public ToyStore()
    {
        toyList=new ArrayList<Toy>();

    }

    // This method is implemented completely, but here's what it does:
    // loops through toy names in String parameter toys
    // checks if a Toy t with a given name has been added to toyList already by calling getThatToy
    // if not, adds Toy t to the end of toyList
    // if so, increments that Toy t's instance variable count by 1
    // this method is similar to part b of the Music Downloads AP problem we did in class
    public void loadToys( String toys )
    {
        for( String name : toys.split( " " ) )
        {
            Toy t = getThatToy( name );
            if( t == null )
            {
                toyList.add( new Toy( name ) );
            }
            else
            {
                t.setCount( t.getCount() + 1 );
            }
        }
    }

    // determines if a Toy with name nm is present in toyList
    // use a for-each loop to loop through each Toy t in toyList
    // check if the name of t equals parameter nm
    // if so, return that Toy's reference (t)
    // if not, return null
    public Toy getThatToy( String nm )
    {
        for(int i=0;i<toyList.size();i++)
        {
            if(toyList.get(i).getName().equals(nm)){return toyList.get(i);}
        }
            
        return null;
    }

    // return the name of Toy t that has the largest value of instance variable count
    public String getMostFrequentToy()
    {
        int bcount=0;
        int spot=0;
        for(int i=0;i<toyList.size();i++)
        {
            if(toyList.get(i).getCount()>=bcount){bcount=toyList.get(i).getCount();spot=i;}
        }
        return toyList.get(spot).getName();
    }  

    // return toyList
    // don't forget to complete toString method
    public String toString()
    {
        return toyList.toString();
    }
}