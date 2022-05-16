import edu.cmu.ri.createlab.terk.robot.finch.Finch;
 
public class DancingFinch   
{
    private static Finch DancingFinch;
    
    public static void main(String args[])  
    {
        DancingFinch = new Finch();
        
        //MUST use program "decomposition" into private static methods in main
        //OR create a class file.
        //Random colors rapidly changing
        //play music loops constantly (avoid extreme overlap)
        //Random comment selected from 4 or more choices
        //Random dance move selected from 4 or more (time consistent) choices
        //Each dance move must have its own method
        //make 10 "time steps" through the dance

        for(int rave = 1; rave <= 10; rave++) // 10 time steps through the dance
        {
            //Feel free to change the order
            raveBeat();
            randomLED();
            randomLED();
            randomComment();
            randomDance();
            randomLED();
            randomLED();
            
            //let beat catch up before starting another beat,
            //don't overlap your beats!
            DancingFinch.sleep(700);
        }
        
        DancingFinch.saySomething("DONE:  Dance over, time to head home...");
        DancingFinch.quit();
    }
    
    //Sample method to play rave beat.  Make your own methods with other music loops
    private static void raveBeat()
    {
        DancingFinch.playClip("rave_beat.wav");
    }

    //randomly set an LED color
    private static void randomLED()
    {
        int red, blue, green;
        
        //fix this to randomly set red, green, and blue to values from 0-255, inclusive
        red=(int)(Math.random()*256);
        blue=(int)(Math.random()*256);
        green=(int)(Math.random()*256);
        
        DancingFinch.setLED(red, green, blue, 250); //You can change the 500.  
                                                    //Look at the Finch API to see what it does 
    }
    
    //randomly select a comment
    private static void randomComment()
    {
        int comment =(int)(Math.random()*4) ; // Fix this line to generate a random int from 1 to 4 (or more), inclusive
        
        if (comment == 1)
        {
            DancingFinch.saySomething("Do you have any extra light sticks?");
        }
        else if (comment == 2)
        {
            DancingFinch.saySomething("No thanks, I'm Straight Edge.");
        }
        else if (comment == 3)
        {
            DancingFinch.saySomething("Deadmau5 is my favorite...");
        }
        else
        {
            DancingFinch.saySomething("The bathroom is over there!");
        }
    }
    
    //randomly select a dance move
    private static void randomDance()
    {
        int move = (int)(Math.random()*4); // Fix this line to generate a random int from 1 to 4 (or more), inclusiv
        
        if (move == 1)
        {
            move1();
        }
        else if (move == 2)
        {
            move2();
        }
        else if (move == 3)
        {
            move3();
        }
        else
        {
            move4();
        }
    }
    
    //dance moves should be the same time so they will work randomly
    private static void move1()
    {
        DancingFinch.setWheelVelocities(100, 100, 500); // Here's a sample move.
        //Look at the Finch API to see what the three parameters mean
    }
    
    private static void move2()
    {
        DancingFinch.setWheelVelocities(-25, 100, 500); 
        // Put in another move
    }
    
    private static void move3()
    {
        DancingFinch.setWheelVelocities(100, -25, 500); 
        // Put in another move
    }
    
    private static void move4()
    {
        DancingFinch.setWheelVelocities(-100, -100, 500); 
        // Put in another move
    }
}
