/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * this program perfomrs functions with primes
 */
public class ArrayOfPrimes
{
    //instance variables and constructors could be present, but are not necessary

    /**
     * Method getPrimeList
     *
     * returns an array containing the first numPrimes starting at 2
     * @param numPrimes sets the number of primes which will be found and displayed
     * @return an array full of primes
     */
    public static int[] getPrimeList(int numPrimes)
    {

        return getPrimeList(numPrimes,2);  //just call a method here
    }

    //getPrimeList(int numPrimes, int primeStart) will return an array 
    //containing the first numPrimes primes starting at primeStart
    /**
     * Method getPrimeList gets a list of primes with numPrimes primes and starting at primeStart
     *
     * returns an array containing the first numPrimes primes starting at primeStart
     * 
     * @param numPrimes is the number of primes that will be found
     * @param primeStart is where the search for primes will begin
     * @return an array full of primes starting at primestart
     */
    public static int[] getPrimeList(int numPrimes, int primeStart)
    {
        int[] primes= new int[numPrimes];
        int ptest=primeStart;
        int x=0;
        while(x<numPrimes)
        { 
            if(isPrime(ptest)==true){primes[x]=ptest;x++;}
            ptest++;
        }
        return primes;
    }

    /**
     * Method isPrime determines if a number is prime
     *
     * returns true if num is prime
     * a prime number is any number only divisible by 1 and itself
     * 
     * @param num is a number whose primeness will be determined
     * @return true of the given number is primes
     */
    private static boolean isPrime(int num)
    {
        for(int i=2; i <num;i++)
        {
            if(num%i==0){return false;}
        }        
        return true;
    }
}