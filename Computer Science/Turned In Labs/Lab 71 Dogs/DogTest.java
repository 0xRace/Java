// ****************************************************************
// DogTest.java
//
// A simple test class that creates a Dog and makes it speak.
//          
// ****************************************************************

public class DogTest
{
    public static void main(String[] args)
    {
        Labrador lab= new Labrador("Lab","Blue");
        System.out.println(lab.getName() + " says " + lab.speak());
        Yorkshire york= new Yorkshire("Yorky");
        System.out.println(york.getName() + " says " + york.speak());
        System.out.println("Lab average breed weight is " +lab.avgBreedWeight());
        System.out.println("Yorkshire average breed weight is " +york.avgBreedWeight());
    }
}