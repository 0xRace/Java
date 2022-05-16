/** 
 * @author Race and Luigi
 */

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import java.awt.Color;

public class TemperatureFinch01   
{
    public static void main(String args[])  
    {

        Finch MyFinch = new Finch();

        double lastTemp=0;
        double celsius= MyFinch.getTemperature();
        double fahren= (celsius*1.8)+32;
        System.out.println("Temperate #1 is "+fahren+"°f and stable")	;	    
        MyFinch.sleep(6000);
        lastTemp=fahren;

        for(int i=0; i <19;i++)
        {
            String status="";
            celsius= MyFinch.getTemperature();
            fahren= (celsius*1.8)+32;
            double  change= fahren-lastTemp;
            if(change>.25){ status= "climbing";MyFinch.setLED(new Color(255,0,0));}
            else if(change<-.25){ status= "dropping";MyFinch.setLED(new Color(0,0,255));}
            else{ status= "stable";MyFinch.setLED(new Color(255,255,255));}

            System.out.println("Temperate #"+(i+2)+" is "+fahren+"°f and "+status)	;	    
            MyFinch.sleep(6000);
            lastTemp=fahren;
        }

    } 
}

/**
RUN OUTPUT:

Process started >>>
Connecting to Finch...this may take a few seconds...
Temperature #01 is 76.25°f and stable.
Temperature #02 is 76.25°f and stable.
Temperature #03 is 76.25°f and stable.
Temperature #04 is 80.75°f and climbing.
Temperature #05 is 82.25°f and climbing.
Temperature #06 is 83.0°f and climbing.
Temperature #07 is 83.75°f and climbing.
Temperature #08 is 81.5°f and dropping.
Temperature #09 is 81.5°f and stable.
Temperature #10 is 80.75°f and dropping.
Temperature #11 is 80.75°f and stable.
Temperature #12 is 80.0°f and dropping.
Temperature #13 is 80.0°f and stable.
Temperature #14 is 80.0°f and stable.
Temperature #15 is 79.25°f and dropping.
Temperature #16 is 79.25°f and stable.
Temperature #17 is 78.5°f and dropping.
Temperature #18 is 78.5°f and stable.
Temperature #19 is 78.5°f and stable.
Temperature #20 is 77.75°f and dropping.
DONE:  Shutting Down My Finch...
<<< Process finished.

 */