 
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends JFrame implements ActionListener 
{
    public static final String
        IDLE_MESSAGE = "Click on the cells where you want \"life\" to exist.",
        RUNNING_MESSAGE = "Game in progress...";
    public static final int FPS_MIN = 0, FPS_MAX = 30, FPS_INIT = 10;

    private static final NumberFormat nf = NumberFormat.getInstance();
    private final ApplicationStarter applicationStarter;
    private final JButton startResetButton;
    private final JLabel statusLabel, generationLabel;
    private final JSlider slider;
    private final LifeBoard lifeBoard;
    private final Timer timer;

    private long generationNumber;
    private boolean isGameRunning;

    public GUI(final ApplicationStarter appStarter) 
    {
       
        this.applicationStarter = appStarter;
     
        this.lifeBoard = new LifeBoard(LifeBoard.FINITE, "cell.gif", 20, 40);
        // Set up timer to drive animation events.
        timer = new Timer(fpsToMs(FPS_INIT), this);

        setJMenuBar(getCreatedMenuBar());

        startResetButton = new JButton("Start");
        startResetButton.setMnemonic('S');
        startResetButton.setPreferredSize(new Dimension(84, 26));
        startResetButton.addActionListener(new StartResetActionListener(this));

        final JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startResetButton);

        final JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new FlowLayout());
        boardPanel.add(lifeBoard);

        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(boardPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Playing Field"));

        final JLabel blankLabel = new JLabel();

        slider = new JSlider(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Serif", Font.ITALIC, 12));
        slider.addChangeListener(new ChangeListener() 
          {
            public void stateChanged(final ChangeEvent e) 
              {
                final JSlider source = (JSlider)e.getSource();
                if (!source.getValueIsAdjusting()) 
                  {
                    setSpeed(source.getValue());
                  }
              }
          });

        final JLabel speedLabel =
            new JLabel("Speed:", JLabel.RIGHT);
        speedLabel.setDisplayedMnemonic('F');
        speedLabel.setLabelFor(slider);

        final JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        controlPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED), "Options"));
       
        controlPanel.add(blankLabel);
      
        controlPanel.add(blankLabel);
        controlPanel.add(speedLabel);
        controlPanel.add(slider);

        statusLabel = new JLabel(IDLE_MESSAGE);
        generationLabel = new JLabel("Generation: 1");

        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 2, 0, 2);
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        final JPanel statusPanel1 = new JPanel();
        statusPanel1.setLayout(new GridBagLayout());
        statusPanel1.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel1.add(statusLabel, gbc);
        statusPanel1.setPreferredSize(new Dimension(250, 25));
        final JPanel statusPanel2 = new JPanel();
        statusPanel2.setLayout(new GridBagLayout());
        statusPanel2.setBorder(new BevelBorder(BevelBorder.LOWERED));
        statusPanel2.add(generationLabel, gbc);
        statusPanel2.setPreferredSize(new Dimension(250, 25));

        final JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(1, 0, 0, 0);
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.BOTH;
        statusPanel.add(statusPanel1, gbc);
        gbc.weightx = 0.5;
        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        statusPanel.add(statusPanel2, gbc);

        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(mainPanel, BorderLayout.PAGE_START);
        contentPane.add(controlPanel, BorderLayout.CENTER);
        contentPane.add(statusPanel, BorderLayout.PAGE_END);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new ClosingWindowListener(this));

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void start() 
    {
        timer.restart();
    }

    public void stop()
    {
        timer.stop();
    }

    public void actionPerformed(final ActionEvent e) 
    {
        generationLabel.setText("Generation: " + nf.format(++generationNumber));
        lifeBoard.makeNextGeneration();
        if (!lifeBoard.isAnyCellAlive()) 
           {
            final String message =
                generationNumber == 2 ?
                    "Your configuration killed everyone off in 1 generation." :
                    "Your configuration killed everyone off in " +
                    nf.format(generationNumber - 1)  + " generations.";
        
            resetGame();
           }
    }

    private JMenuBar getCreatedMenuBar() 
    {
        final JMenuBar menuBar = new JMenuBar();
        final JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F');

        KeyStroke ks;
        final JMenuItem exitItem = new JMenuItem("Exit");
        ks = KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.ALT_MASK);
        exitItem.setAccelerator(ks);
        exitItem.setMnemonic(KeyEvent.VK_X);
        exitItem.addActionListener(new ExitActionListener(this));
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
      
        return menuBar;
    }

    private void setSpeed(final int fps) 
    {
        if (fps == 0) 
           {
              stop();
           } 
        else 
           {
              timer.setDelay(fpsToMs(fps));
              if (isGameRunning && !timer.isRunning()) 
                 {
                    start();
                 }
           }
    }

    private int fpsToMs(final int fps) 
    {
        if (fps == 0) 
           {
              return Integer.MAX_VALUE;
           }
        return 1000 / fps;
    }

    private void doApplicationClosing(final JFrame parent) 
    {
        if (applicationStarter != null) 
           {
              applicationStarter.close();
           } 
        else 
           {
              System.exit(0);
           }
    }

    private void startGame() 
       {
        generationNumber = 1;
        isGameRunning = true;
        startResetButton.setText("Reset");
        startResetButton.setMnemonic('R');
        statusLabel.setText("Game in session...");
        
        lifeBoard.setEditable(false);
        setSpeed(slider.getValue());
       }

    private void resetGame() 
       {
        stop();
        isGameRunning = false;
        startResetButton.setText("Start");
        startResetButton.setMnemonic('S');
       
        statusLabel.setText(IDLE_MESSAGE);
        generationLabel.setText("Generation: 1");
        lifeBoard.clear();
        lifeBoard.setEditable(true);
    }

    class StartResetActionListener implements ActionListener 
       {
        private final JFrame parent;

        public StartResetActionListener(final JFrame parent) 
          {
            this.parent = parent;
          }

        public void actionPerformed(final ActionEvent e) 
           {
            if (!lifeBoard.isAnyCellAlive()) 
              {
             
                return;
              }
            if (startResetButton.getText().equals("Start")) 
              {
                startGame();
              } 
            else 
              {
                resetGame();
              }
        }
    }

    class ExitActionListener implements ActionListener 
      {
        private final JFrame parent;

        public ExitActionListener(final JFrame parent) 
          {
            this.parent = parent;
          }

        public void actionPerformed(final ActionEvent e) 
          {
            doApplicationClosing(parent);
          }
    }
 

    class ClosingWindowListener implements WindowListener 
      {
        private final JFrame parent;

        public ClosingWindowListener(final JFrame parent) 
          {
            this.parent = parent;
          }

        public void windowClosing(final WindowEvent e) 
          {
            doApplicationClosing(parent);
          }

        public void windowDeactivated(final WindowEvent e) 
        { }

        public void windowActivated(final WindowEvent e) 
        { }

        public void windowDeiconified(final WindowEvent e) 
        { }

        public void windowIconified(final WindowEvent e) 
        { }

        public void windowClosed(final WindowEvent e) 
        { }

        public void windowOpened(final WindowEvent e) 
        { }
    }
}
