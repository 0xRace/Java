//Name -
//Please include the name of anyone who you worked with on this lab

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

public class Gasket extends Canvas implements Runnable
{
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;

	public Gasket()
	{
		setBackground(Color.WHITE);
	}

	public void paint( Graphics window )
	{
		window.setColor(Color.BLUE);
		window.setFont(new Font("ARIAL",Font.BOLD,24));
		window.drawString("Sierpinski's Gasket", 25, 50);

		gasket(window, (WIDTH-10)/2, 20, WIDTH-40, HEIGHT-20, 40, HEIGHT-20);
	}

	public void gasket(Graphics window, int x1, int y1, int x2, int y2, int x3, int y3)
	{
	    /*
	     *               (x1,y1)
	     *                  /\
	     *                 /  \
	     *                /    \ 
	     *               /      \ 
	     *         mid3 /        \ mid1 
	     *             /          \
	     *            /            \
	     *           /              \
	     *          /                \
	     *     (x3,y3)-----mid2-----(x2,y2)   
	     */
	    
		//base case goes here: if ( (y2 - y1) > 2 and (x2 - x3) > 2)
		if ( (y2 - y1) > 2 &&(x2 - x3) > 2)
		{
		    
		    Color col = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
		    //System.out.println(col.toString());
		    window.setColor(col);
		    window.drawLine(x1,y1,x2,y2);
		    window.drawLine(x2,y2,x3,y3);
		    window.drawLine(x3,y3,x1,y1);
		    
		    
		    int xMid1 = ((x1 + x2) / 2);
			int yMid1 = ((y1 + y2)/  2);
			
			int xMid2 = ((x2 + x3) / 2);
			int yMid2 = ((y2 + y3)/  2);
			
			int xMid3 = ((x3 + x1) / 2);
			int yMid3 = ((y3 + y1)/  2);
			
			gasket(window, x1, y1, xMid1, yMid1, xMid3, yMid3);
			gasket(window, xMid1, yMid1, x2, y2, xMid2, yMid2);
			gasket(window, xMid3, yMid3, xMid2, yMid2, x3, y3);
		  }
			//make a random color here with int variables r,g,b (random values from 0 to 255)
			
			// Color col = new Color(r,g,b);
			// window.setColor(col);
			
			//draw lines to make a triangle
			// hint: first line - window.drawLine(x1, y1, x2, y2);
			// and then draw two more lines
			
			// calculate x and y coordinates for 3 midpoints
			// hint: first pair of coordinates xMid1 = ((x1 + x2) / 2)
			//                                 yMid1 = ((y1 + y2)/  2)
			// you need two more pairs
			
			// make three recursive calls
			// hint: first call gasket(window, x1, y1, xMid1, yMid1, xMid3, yMid3);
			// make two more calls
			
			//run(); //uncomment to slow it down and see it in action
	}

	public void run()
	{
		try{
		  	Thread.currentThread().sleep(3);
		}
		catch(Exception e)
		{
		}
	}
}