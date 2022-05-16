/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 */

import java.awt.Color; 
import java.awt.Graphics;

public class Shape
{
    //instance variables
    private int xPos;
    private int yPos;

    private int width;
    private int height;

    private Color color;

    private int xSpeed;
    private int ySpeed;

    /*
     *The constructor is used to initialize all instance variables.
     *The constructor makes the object.
     */
    public Shape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
    {
        xPos = x;
        yPos = y;
        width = wid;
        height = ht;
        color = col;
        xSpeed = xSpd;
        ySpeed = ySpd;

        //finish this constructor
    }

    /*
     *The draw method draws the shape on the screen.
     */
    public void draw(Graphics window)
    {
        int b=0;
        while(b<50){
            window.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
            window.fillRect(xPos+b, yPos+b, width+b, height+b);
            b=b+5;
        }

    }
    /*
     *This draw method will be used to erase the shape.
     */
    public void draw(Graphics window, Color col)
    {
        window.setColor(col);
        window.fillRect(xPos, yPos, width, height);
    }

    
    public void moveAndDraw(Graphics window)
    {
        int b=0;
        while(b<50){
            window.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
            window.fillRect(xPos+b, yPos+b, width+b, height+b);
            b=b+5;
        }
        xPos=xPos+xSpeed;
        yPos=yPos+ySpeed;

        
    }

    //add in set and get methods for xPos
    public int getX()
    {
        return xPos;
    }

    public void setX( int x )
    {
        xPos=x;
    }

    //add in set and get methods for yPos
    public int getY()
    {
        return yPos;
    }

    public void setY( int x )
    {
        yPos=x;
    }

    //add in set and get methods for xSpeed
    public int getXSpeed()
    {
        return xSpeed;
    }

    public void setXSpeed( int x )
    {
        xSpeed=x;
    }

    //add in set and get methods for ySpeed
    public int getYSpeed()
    {
        return ySpeed;
    }

    public void setYSpeed( int x )
    {
        ySpeed=x;
    }

    public String toString()
    {
        return xPos+" "+yPos+" "+width+" "+height+" "+color+" "+xSpeed+" "+ySpeed;
    }
}