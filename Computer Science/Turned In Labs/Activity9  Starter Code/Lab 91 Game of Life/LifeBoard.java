// Name:
// Names of anyone who you worked with on this lab:

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.StringTokenizer;

import javax.swing.JPanel;

public class LifeBoard extends JPanel implements MouseListener, MouseMotionListener 
{
    public static final int FINITE = 0, TORUS = 1;
    public static final String[] BOARDTYPES = {"Finite", "Torus"};

    private final Color backgroundColor = new Color(22, 107, 29),
    mouseCellColor = new Color(20, 60, 20);
    private final int panelWidth, panelHeight, imageHeight, imageWidth; 
    private int  numRows, numCols;
    private final Image image;

    private final boolean[][] grid, tempGrid;
    private boolean editable = true;
    private int boardType, mouseX, mouseY;

    public LifeBoard(final int boardType, final String imagePath, int numRows,
    int numCols) 
    {
        this.boardType = boardType;
        this.image = ImagePanel.getImage(imagePath);
        this.imageHeight = image.getHeight(this) + 1;
        this.imageWidth = image.getWidth(this) + 1;
        this.numRows = numRows;
        this.numCols = numCols;

        grid = new boolean[numRows][numCols];
        tempGrid = new boolean[numRows][numCols];
        setSize(getPreferredSize());

        //problem 1
        //initialize grid and tempGrid matrices so each element is false
        for(int r=0;r<numRows;r++)
        {
            for(int c=0;c<numCols;c++)
            {
                grid[r][c]=false;
                tempGrid[r][c]=false;
            }
        }

        //insert code here

        addMouseListener(this);
        addMouseMotionListener(this);
        panelWidth = this.getSize().width;
        panelHeight = this.getSize().height;
        mouseX = mouseY = -1;
        setDoubleBuffered(true);
    }

    //problem 2
    //count neighbors at grid[row][col]
    public int neighborCount( int row,   int col) 
    {  
        //de-bug the code below
        //there are some syntax errors and a major logic error in the nested loop
        int up, down, right,left;
        int count = 0;

        if( row == 0)
            up = 0;
        else
            up = -1;

        if (row == numRows-1)
            down = 0;
        else
            down = 1;

        if (col == 0)
            left = 0;
        else
            left = -1;

        if (col == numCols-1)
            right = 0;
        else
            right = 1;

        for (int horiz = left; horiz <= right; horiz++) // BUG in this line somewhere
            for (int vert = up; vert <= down; vert++)
            {
                if ((grid[row + vert][col + horiz] == true) && (horiz != 0 || vert != 0))
                    count++;
            }
        return count;

    }

    //problem 3
    // post: returns true if at least one cell on board is alive; otherwise returns false
    public boolean isAnyCellAlive() 
    {
        for(int r=0;r<numRows;r++)
        {
            for(int c=0;c<numCols;c++)
            {
               if(grid[r][c]==true){return true;}
            }
        }
        //insert code here
        return false;
    }

    //problem 4
    //post: sets all elements of grid and tempGrid to false, then repaints the board.
    public void clear() 
    { 
        //insert code here
        for(int r=0;r<numRows;r++)
        {
            for(int c=0;c<numCols;c++)
            {
                grid[r][c]=false;
                tempGrid[r][c]=false;
            }
        }

        repaint();
    }

    //problem 5
    //post: computes next generation in tempGrid using Conway's three rules. 
    //      Then copies tempGrid back into grid and repaints the board.
    public void makeNextGeneration() 
    { 
        //insert code here

        // loop through each matrix element in grid matrix
        // {
        //      count the neighbors for each cell (count) of grid (use neighborCount method)
        //      if (count=3) and grid[row][col] is empty
        //          cell is born (set to true) in next generation (tempGrid)
        //      else if (count = 2 or count = 3) and grid cell is occupied
        //          cell survives in next generation (tempGrid)
        //      else
        //          cell dies in next generation (tempGrid)
        // }
        
         for(int r=0;r<numRows;r++)
        {
            for(int c=0;c<numCols;c++)
            {
                if(neighborCount(r,c)==3 && grid[r][c]==false){tempGrid[r][c]=true;}
                else if((neighborCount(r,c)==3 ||neighborCount(r,c)==2  ) && grid[r][c]==true){tempGrid[r][c]=true;}
                else{tempGrid[r][c]=false;}
            }
            
        }
        
        //
        // copy contents of new board (tempGrid) into old board (grid)
        for(int r=0;r<numRows;r++)
        {
            for(int c=0;c<numCols;c++)
            {
                grid[r][c]=tempGrid[r][c];
            }
        }
        

        repaint();     
    }

    public Dimension getPreferredSize() 
    {
        return new Dimension(numCols * imageWidth + 1, numRows * imageHeight + 1);
    }

    public void setPresetConfig(final String pattern) 
    {
        final StringTokenizer st = new StringTokenizer(pattern, " ");
        while (st.hasMoreTokens()) 
        {
            try 
            {
                final int row = Integer.parseInt((st.nextToken()).trim()),
                col = Integer.parseInt((st.nextToken()).trim());
                if (row >= 0 && row < numRows &&
                col >= 0 && col < numCols) 
                {
                    grid[row][col] = true;
                }
            } 
            catch (final NumberFormatException nfe) 
            { }
        }
        repaint();
    }

    public void setRandomConfig() 
    {
        for (int row = numRows - 1; row >= 0; --row) 
        {
            for (int col = numCols - 1; col >= 0; --col) 
            {
                final int number = (int)(Math.random() * 100);
                grid[row][col] = number < 20 ? true : false;
            }
        }
        repaint();
    }

    public void setBoardType(final int boardType) 
    {
        this.boardType = boardType;
    }

    public void setEditable(final boolean editable) 
    {
        this.editable = editable;
    }

    public void mousePressed(final MouseEvent me) 
    {
        if (editable) 
        {
            final int row = me.getY() / imageHeight,
            col = me.getX() / imageWidth;
            if (row >= 0 && row < numRows &&
            col >= 0 && col < numCols) 
            {
                grid[row][col] = !grid[row][col];
                repaint();
            }
        }
    }

    public void mouseDragged(final MouseEvent me) 
    {
        if (editable) 
        {
            final int row = me.getY() / imageHeight,
            col = me.getX() / imageWidth;
            if (row >= 0 && row < numRows &&
            col >= 0 && col < numCols) 
            {
                mouseY = row;
                mouseX = col;
                grid[row][col] = true;
                repaint();
            }
        }
    }

    public void mouseEntered(final MouseEvent me) 
    { 

    }

    public void mouseExited(final MouseEvent me) 
    {
        mouseX = mouseY = -1;
        repaint();
    }

    public void mouseClicked(final MouseEvent me) 
    { 

    }

    public void mouseReleased(final MouseEvent me) 
    { 

    }

    public void mouseMoved(final MouseEvent me) 
    {
        if (editable) 
        {
            final int row = me.getY() / imageHeight,
            col = me.getX() / imageWidth;
            if (row >= 0 && row < numRows &&
            col >= 0 && col < numCols) 
            {
                mouseY = row;
                mouseX = col;
                repaint();
            }
        }
    }

    public void paint(final Graphics g) 
    {
        g.setColor(backgroundColor);
        g.fillRect(0, 0, panelWidth, panelHeight);
        if (mouseX != -1 && mouseY != -1) 
        {
            g.setColor(mouseCellColor);
            g.fillRect(mouseX * imageWidth, mouseY * imageHeight, imageWidth, imageHeight);
        }
        g.setColor(SystemColor.activeCaptionBorder);
        for (int row = numRows; row >= 0; --row) 
        {
            g.drawLine(0, row * imageHeight, numCols * imageWidth, row * imageHeight);
        }
        for (int col = numCols; col >= 0; --col) 
        {
            g.drawLine(col * imageWidth, 0, col * imageWidth, numRows * imageWidth);
        }

        for (int row = numRows - 1; row >= 0; --row) 
        {
            for (int col = numCols - 1; col >= 0; --col) 
            {
                if (grid[row][col]) 
                    g.drawImage(image, col * imageWidth + 1, row * imageHeight + 1, this);
            }
        }
    }

}
