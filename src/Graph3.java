import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class Graph3 extends JPanel{
    
    /**
     * ImaginaryResources
     * A graph created only by using lines
     */
    
    private static final long serialVersionUID = 1L;
    
    private int x = 400;
    private int y = 0;
    private int R = 0;
    private int G = 0;
    private int B = 0;
    
    private static JToggleButton playButton;
    private Timer timer;
    private List <Line> Lines;
    private boolean doSomething;
    
    public Graph3()
    {
        playButton = new JToggleButton("Click to start");
        playButton.addActionListener(new PlayListener());
        
        timer = new Timer(100, new TimerListener());
        
        Lines = new ArrayList <Line>();
        
        doSomething = true;
    }
    
    public static void main (String [] args)
    {
        JFrame frame = new JFrame();
        frame.setTitle("The Graph");
        frame.setSize( new Dimension( 800, 800) );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setLocationRelativeTo(null);
        
        Graph3 panel = new Graph3();
        panel.setBackground(Color.WHITE);
        
        frame.add(panel);
        frame.add(playButton, BorderLayout.NORTH);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (x == 0)
            {
              timer.stop();
            }
            else
            {
              x -= 10;
              y += 10;
              R += 5;
              G += 5;
              B += 5; 
              repaint();
            }
            
        }
    }
    
    private class PlayListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if  (playButton.isSelected())
            {
              playButton.setText("Click to stop");
              timer.start();
            }
            else
            {
              playButton.setText("Click to resume");
              timer.stop();
             }
        }
    }
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.translate (400, 400);
        
        //R = (int)(Math.random( )*256);
        //G = (int)(Math.random( )*256);
        //B= (int)(Math.random( )*256);
        Color randColor = new Color(R / 255f, G / 255f, B /255f);
        
        if (doSomething)
        {
          Lines.add(new Line (0 , y, x , 0, randColor));
          Lines.add(new Line (0 , y,-x , 0, randColor));
          Lines.add(new Line (0 , -y, x , 0, randColor));
          Lines.add(new Line (0 , -y, -x , 0, randColor));
        }
        
        for (Line all: Lines)
        {
            g.setColor(all.color);
            g.drawLine(all.x1, all.y1, all.x2, all.y2);
        }
        
    }
    
    private class Line
    {
        public int x1, x2, y1, y2;
        public Color color;
        
        public Line(int x1, int x2, int y1, int y2, Color color)
        {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.color = color;
        }
    }
}