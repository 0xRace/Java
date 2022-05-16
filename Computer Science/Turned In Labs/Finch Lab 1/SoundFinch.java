/** 
 * @student.info 
 *<BR> Name:         Race and Luigi
 *<BR> Date:          05-07-2012
 *<BR> Assignment:    SoundFinch
 *<BR> Description:   Sound Robot which tests all aspects of how Finch Robots can create / manage sound
 *<BR> Cite Sources:  FinchRobot.com API
 */
 
 //Phone Screen Tones:  http://en.wikipedia.org/wiki/Telephone_keypad
 //Songs with phone dialer:  http://www.sayyad.ca/phonesongs.html
 
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class SoundFinch 
{
    public static void main(String[] args) 
    {
        Finch MyFinch = new Finch();
        
        System.out.println("The finch will tell you its name");
        MyFinch.saySomething("Hello my name is Finch");
        MyFinch.sleep(6000);
        
        
        System.out.println("The finch will slowly count to ten");
        for(int i=1;i<=10;i++){MyFinch.saySomething(""+i);System.out.println(""+i);MyFinch.sleep(1500);}
        
        
        System.out.println("The finch will play a tone for two seconds");
        MyFinch.buzz(1000,3000);
        MyFinch.sleep(4000);
        
       
        System.out.println("The computer will play a different tone");
        MyFinch.playTone(1500,3000);
        MyFinch.sleep(4000);
        
    
        System.out.println("The computer will play a .wav file");
        MyFinch.playClip("thunder_clap.wav");
        MyFinch.sleep(6000);
        
		
		MyFinch.quit();
        System.exit(0);
		
	}
}	

/**
RUN OUTPUT:

Process started >>>
Connecting to Finch...this may take a few seconds...
Hello AP Java Students...
1
2
3
4
5
6
7
8
9
10
Use Finch built in buzzer...
Use computer speakers to play a tone...
Use computer speakers to play a WAV file...
DONE:  Shutting Down My Finch...
<<< Process finished.

*/	