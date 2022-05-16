/** 
 * @author Race and Luigi
 */

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;

public class RainbowFinch   
{
    public static void main(String args[])  
    {
        Finch MyFinch = new Finch();
        
        MyFinch.setLED(new Color(255,0,0),2000);
        MyFinch.setLED(new Color(255,127,0),2000);
        MyFinch.setLED(new Color(255,255,0),2000);
        MyFinch.setLED(new Color(0,255,0),2000);
        MyFinch.setLED(new Color(0,0,255),2000);
        MyFinch.setLED(new Color(75,0,130),2000);
        MyFinch.setLED(new Color(139,0,255),2000);

        MyFinch.quit();
        System.exit(0);

    } 
}

/**
RUN OUTPUT:

Process started >>>
Connecting to Finch...this may take a few seconds...
DONE:  Shutting Down My Finch...
<<< Process finished.

 */