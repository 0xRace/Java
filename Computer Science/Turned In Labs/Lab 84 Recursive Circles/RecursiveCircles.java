//Name -
//Please include the name of anyone who you worked with on this lab 

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class RecursiveCircles extends JPanel
{
    public RecursiveCircles()
    {
        setSize(640,480);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public void paintComponent( Graphics window )
    {
        super.paintComponent(window);
        window.setColor(Color.ORANGE);
        window.setFont(new Font("TAHOMA",Font.BOLD,12));

        window.drawString("Lab 58",20,40);
        window.drawString("Drawing Circles Using Recursion ",20,80);
        drawCircles(window,10,10);
    }

    public void drawCircles(Graphics window, int x, int y)
    {
        //base case: You need an if statement here (check if both x and y are less than 100
        // if the boolean condition is true, the three lines below will be executed, otherwise
        // nothing will happen and the method will return control back to the calling location
        if(x<100 && y<100)
        {
            window.setColor(Color.BLUE);
            window.drawOval(90+x, 90+y, 20+x, 20+x);

            drawCircles(window, x+10, y+10);
        }
    }
}