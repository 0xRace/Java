import java.awt.Graphics; 
import java.awt.Color;
import java.awt.Font;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JPanel;

public class RandomColoredBoxes extends JPanel
{
    private Timer timer;
    private final static int SLEEP = 110;

    public RandomColoredBoxes()
    {       
        setBackground(Color.BLACK);
        setVisible(true);

        ActionListener paintCaller = new ActionListener(){
                public void actionPerformed(ActionEvent event)
                {
                    repaint();  
                }
            };
        timer = new Timer(SLEEP, paintCaller);
        timer.start();
    }   

    public void paintComponent( Graphics window )
    {
        super.paintComponent(window);

        window.setColor(Color.RED);
        window.setFont(new Font("TAHOMA",Font.BOLD,12));
        window.drawString("Graphics Lab Lab11k ", 20, 40);
        window.drawString("Drawing boxes with nested loops ", 20, 80);

        drawBoxes(window);
    }

    /**
     * Method drawBoxes 
     * Draws random colored boxes
     *
     * @param window Graphics object
     */
    public void drawBoxes(Graphics window)
    {
        //for loop to to across the x - getWidth() might be useful
        
        //for loop to go down the y - getHeight() might be useful
        // draw random colored boxes
        // use Math.random to get random integer values of
        // red, blue, green (0-255) and store these
        // in local variables red, blue, green
        // Color col = new Color(red,blue,green);
        // window.setColor(col);
        // window.fillRect(?,?,?,?) review how fillRect works
        // x,y position depends on loop control variables
        // width,height are constant
         
        for (int i=100; i<=getHeight()-100;)
        {
            for(int b=50;b<=getWidth()-50;)
            {
                Color col= new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
                window.setColor(col); 
                window.fillRect(b,i,getHeight()/20,(getHeight()/20));
                b=b+(getWidth()/20)-10;
           }
            i=i+(getHeight()/20);
        }

    }
}