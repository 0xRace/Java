package test;

import javax.swing.*;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class AV_Driver extends JPanel implements KeyListener, ActionListener {
    JTextArea displayArea;
    JTextField typingArea;
    static final String newline = "\n";
    int x;
    int y;
    Finch myFinch;
    
	public AV_Driver() {
        super(new BorderLayout());
        
        myFinch = new Finch();
        x=0;
        y=0;
        
        JButton button = new JButton("Clear");
        button.addActionListener(this);

        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);

        //Uncomment this if you wish to turn off focus
        //traversal.  The focus subsystem consumes
        //focus traversal keys, such as Tab and Shift Tab.
        //If you uncomment the following line of code, this
        //disables focus traversal and the Tab events will
        //become available to the key event listener.
        //typingArea.setFocusTraversalKeysEnabled(false);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setPreferredSize(new Dimension(375, 125));

        add(typingArea, BorderLayout.PAGE_START);
        add(scrollPane, BorderLayout.CENTER);
        add(button, BorderLayout.PAGE_END);
    }

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()){
			case 37 : x = -255; y = 255; break;
			case 38: x = 255; y = 255; break;
			case 39: x = 255; y= -255; break;
			case 40 : x = -255; y = -255; break;
			
        
		}
		myFinch.setWheelVelocities(x, y);
	}

	public void keyReleased(KeyEvent arg0) {
		x=0;y=0;
		myFinch.setWheelVelocities(x,y);
		
	}
	public void finchMove(){
		myFinch.setWheelVelocities(x, y);
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    private static void createAndShowGUI() {
        //Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        //Create and set up the window.
        JFrame frame = new JFrame("Finch Controler");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        JComponent newContentPane = new AV_Driver();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}