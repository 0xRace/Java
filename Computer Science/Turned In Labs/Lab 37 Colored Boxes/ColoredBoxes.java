import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Canvas;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * purpose of this program is to draw a colored square made of other squares    
 */

class ColoredBoxes extends Canvas
{
    public ColoredBoxes()
    {
        setBackground(Color.WHITE);
    }

    public void paint( Graphics window )
    {
        window.setColor(Color.RED);
        window.setFont(new Font("TAHOMA",Font.BOLD,12));
        window.drawString("Graphics Lab Lab11g ", 20, 40 );
        window.drawString("Drawing boxes with nested loops ", 20, 80 );

        drawBoxes(window);
    }

    /**
     * Method drawBoxes: draws a big square made up of smaller blue squares
     *
     * @param window Graphics object draws a big square made up of smaller blue squares
     */
    public void drawBoxes(Graphics window)
    {
        //nested loops to draw the pretty boxes
        
        // outer loop for rows
        //inner loop for columns
        window.setColor(Color.BLUE);
        for (int i=200; i<470;)
        {
            for(int b=20;b<290;b=b+30)
            {
                window.fillRect(b,i,20,20);
            }
            i=i+30;
        }

        
        
    }
}