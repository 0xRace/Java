package test;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;


public class Light_Sabre {

	public static void main (final String [] args){
		//Declaration & Initializing Finch
		Finch myFinch = new Finch();
		//Declaration for 3 accelerometer variables
		double x,y,z;
		//Endless Loop
		while(true){
			//Imports Accelerometer data from finch
			x = myFinch.getXAcceleration()*50;
			y = myFinch.getYAcceleration()*50;
			z = myFinch.getZAcceleration()*50;
			
			//Tests, and compensates  if exceeds bounds (0-255) for RGB scale
			if(x<0) x=-x;
			if(x>255) x=255;
			if(y<0) y=-y;
			if(y>255) y=255;
			if(z<0) z=-z;
			if(z>255) z=255;
			
			//Changes LED and makes finch buzz on frequency depending on swing
			myFinch.setLED((int)x, (int)y, (int)z);
			myFinch.buzz((int) (500+x+y+z), 1000);
			myFinch.sleep(20);
		}
	}
}