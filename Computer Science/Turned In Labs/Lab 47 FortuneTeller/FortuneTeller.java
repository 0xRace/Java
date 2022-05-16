// This is the Fortune Teller applet

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;

/**
 * @author Please put your name and the name of anyone who you worked with on this lab
 * the purpose of this program is to display randome fortunes to the user 
 */
public class FortuneTeller extends JApplet
    implements ActionListener
{
  // Declare a String array of "fortunes".  Use an initializer list.
  String[] array={"Good fortune","Bad Fortune","Deathly Fortune","Love Awaits","Great Tragedy","Your wishes will come true"};

  private JTextField display;
  private AudioClip ding;

  public void init()
  {
    ding = getAudioClip(getDocumentBase(), "ding.wav");

    display = new JTextField("  Press \"Next\" to see your fortune...", 30);
    display.setBackground(Color.WHITE);
    display.setEditable(false);

    JButton go = new JButton("Next");
    go.addActionListener(this);

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
    c.add(display);
    c.add(go);
  }

  public void actionPerformed(ActionEvent e)
  {
    ding.play();

    // Pick a random fortune from your array.
    // Use Math.random().  Remember that Math.random() returns a double from 0.0 to 1.0, but not including 1.0.
    // Make sure that your random index is able to take on the value of every bucket number in the array.

    // Display the fortune
    display.setText(array[(int)(Math.random()*array.length)] );
  }
}

