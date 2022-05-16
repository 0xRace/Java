public class Time
{
    public static void main(String[] args)
    {
        //declare variables
        byte hours= 9;
        byte minutes= 43;
        byte seconds= 25;
        
        //print statements with the calculations within them
        System.out.println("Number of seconds since midnight:");
        System.out.println(hours*3600+minutes*60+seconds);
        System.out.println("Number of seconds until midnight:");
        System.out.println((24*3600)-(hours*3600+minutes*60+seconds));
        System.out.println("Percentage of the day that has passed:");
        System.out.println(((double)hours*3600+(double)minutes*60+(double)seconds)/(24*3600));
        

    }
}
