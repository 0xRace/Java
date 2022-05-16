/**
 * @author Pleae put your name and the name of anyone who you worked with on this lab
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class SmileyFace extends Canvas
{
    public SmileyFace()    //constructor - sets up the class
    {
        setSize(800,600);
        setBackground(Color.WHITE);
        setVisible(true);
    }

    public void paint( Graphics window )
    {
        smileyFace(window);
    }

    public void smileyFace( Graphics window )
    {
        window.setColor(Color.BLUE);
        window.drawString("SMILEY FACE LAB ", 35, 35);
        //draw yellow smiley background
        window.setColor(Color.YELLOW);
        window.fillOval( 210, 100, 400, 400 );
        //draw green smiley eyes
        window.setColor(Color.GREEN);
        window.fillOval( 300, 200, 70, 50 );
        window.fillOval( 450, 200, 70, 50 );
        //draw black smiley nose
        window.setColor(Color.BLACK);
        window.fillOval( 385, 300, 50, 50 );
        //draw red smiley smile
        window.setColor(Color.RED);
        window.drawArc(325,375,150,50,180,180);
    }
}