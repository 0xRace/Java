/** 
 * @author give your name and the name of anyone who you worked with on this lab
 */

import edu.cmu.ri.createlab.terk.robot.finch.Finch;
 
public class DefaultFinch
{
    public static void main(String args[])  
    {
 		Finch MyFinch = new Finch();

		MyFinch.setLED(255, 0, 0);
		MyFinch.sleep(5000);
		MyFinch.quit();
    } 
}
