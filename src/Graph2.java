import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

public class Graph2 extends JPanel{
	
	/**
	 * ImaginaryResources
	 * A graph created only by using lines
	 */
	
	private static final long serialVersionUID = 1L;
	
	private int x = 400;
	private int y = 0;
	
	private static JToggleButton button;
	private Timer timer;
	
	public Graph2()
	{
		button = new JToggleButton("Click to start");
		button.addActionListener(new TogListener());
		timer = new Timer(100, new TimerListener());
	}
	public static void main (String [] args)
	{	
		JFrame frame = new JFrame();
		frame.setTitle("The coolest graph");
		frame.setSize( new Dimension( 800, 800) );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setLocationRelativeTo(null);
		
		Graph2 panel = new Graph2();
		panel.setBackground(Color.BLACK);
		
		frame.add(panel);
		frame.add(button, BorderLayout.NORTH);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (x == 10)
				timer.stop();
			x -= 10;
			y += 10;
			repaint();
		}
	}
	
	private class TogListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (button.isSelected())
			{
				button.setText("Click to stop");
				timer.start();
			}
			else
			{
				button.setText("Click to resume");
				timer.stop();
			}
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.translate (400, 400);
		//g.setColor(Color.WHITE);
		
		int R = (int)(Math.random( )*256);
        int G = (int)(Math.random( )*256);
        int B= (int)(Math.random( )*256);
        Color randColor = new Color(R / 255f, G / 255f, B /255f);
        g.setColor(randColor);
        
		g.drawLine(0, y, x, 0);
		g.drawLine(0, y, -x, 0);
		g.drawLine(0, -y, x, 0);
		g.drawLine(0, -y, -x, 0);
	}
}