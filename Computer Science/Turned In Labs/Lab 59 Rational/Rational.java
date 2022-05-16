import static java.lang.System.*; 

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * this purpose of this lab is to create a rational class to store fractions
   */
class Rational implements Comparable<Rational>
{
    //add two int instance variables for numerator and denominator
    private int numerator, denominator;

    //write two constructors, one with no parameters 
    public Rational()
    {
        numerator=1;
        denominator=1;
    }
    //(which can set numerator and denominator both to 1)
    //and one that takes an int numerator and int denominator
    public Rational(int num, int den)
    {
        numerator=num;
        denominator=den;
    }

    //write a setRational method that sets both a numerator and a denominator
    public void setRational(int num, int den)
    {
        numerator=num;
        denominator=den;
    }

    //write set methods for both the numerator and the denominator
    public void setNumerator(int num){numerator=num;}
    public void setDenominator(int den){denominator=den;}

    public void add(Rational other)
    {
        int num1=this.numerator;
        int den1=this.denominator;
        int num2=other.numerator;
        int den2=other.denominator;
               
        numerator = (num1 * den2 + num2 * den1);
        denominator = (den1 * den2);

        // note: num1 is this.numerator, num2 is other.numerator
        //       den1 is this.denominator, num2 is other.denominator

        reduce();
    }

    private void reduce()
    {
        //get the gcd of the numerator and denominator
        //set numerator to numerator/gcd
        //set denominator to denominator/gcd
        int gcd= gcd(numerator,denominator);
        numerator=(numerator/gcd);
        denominator=(denominator/gcd);

    }

    // returns the greatest common denominator for numOne and numTwo
    // this method is complete
    private int gcd(int numOne, int numTwo)
    {
        int min = Math.min(numOne,numTwo);
        for(int x = min; x>1; x--){
            if(numOne%x==0 && numTwo%x==0)
                return x;
        }
        return 1;
    }

    // this method is complete
    public Object clone ()
    {
        Rational r = new Rational(getNumerator(),getDenominator());
        return r;
    }

    //ACCESSORS
    //write get methods for numerator and denominator
    public int getNumerator(){return numerator;}
    public int getDenominator(){return denominator;}

    
    //returns true if this.numerator/this.denominator
    //is equal to other.numerator/other.denominator
    //and returns false otherwise
    //(but remember to cast the ints to doubles)
    public boolean equals(Object obj)
    {
        Rational other = (Rational) obj;
        if (((double)this.numerator/this.denominator) == ((double)other.numerator/other.denominator))
        {
            return true;
        }
        return false;
    }

    // returns 1 if this.numerator/this.denominator > 
    //              other.numerator/other.denominator
    // returns -1 if this.numerator/this.denominator <
    //              other.numerator/other.denominator
    // returns 0 otherwise
    public int compareTo(Rational other)
    {
        if (((double)this.numerator/this.denominator) > ((double)other.numerator/other.denominator))
        {
            return 1;
        }
        if (((double)this.numerator/this.denominator) <((double)other.numerator/other.denominator))
        {
            return -1;
        }
        return 0;
    }

    //write toString() method
    //to return a string representation of the fraction
    //e.g. "1/2" or "3/4"
    public String toString()
    {
        return ""+numerator+"/"+denominator;
    }

}