import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graph extends JPanel{
	
	/**
	 * ImaginaryResources
	 * A very basic JFrame and objects with a button
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean doSomething;
	private static JButton button;
	
	public Graph()
	{
		doSomething = false;
		button = new JButton("Click to start");
		button.addActionListener(new ButtonListener());
	}
	public static void main (String [] args)
	{	
		JFrame frame = new JFrame();
		frame.setTitle("The coolest graph");
		frame.setSize( new Dimension( 1000, 1000) );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setLocationRelativeTo(null);
		
		Graph panel = new Graph();
		panel.setBackground(Color.BLACK);
		
		frame.add(panel);
		frame.add(button, BorderLayout.NORTH);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			doSomething = true;
			button.setText("That is cool");
			repaint();
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if (doSomething == true)
		{
			int a = 0; int c = 1000;
			int b = 500; int d = 500;
			
			int counter = 0;
			
			g.setColor(Color.WHITE);
			g.drawLine(500, 0, 500, 1000);
			g.drawLine(0, 500, 1000, 500);
			
			while (counter != 200)
			{
				a = a + 10; d = d + 10;
				b = b - 10; c = c - 10;
				
				if (counter < 50)
					g.drawLine(500, b, a, 500);
				if (counter < 100 && c > 500)
					g.drawLine(500, b, c, 500);
				if (counter < 150 && d < 1000)
					g.drawLine( 500, d, a, 500);
				if (counter < 200 && d < 1000)
					g.drawLine(500, d, c, 500);
				
				counter++;
			}
		}
		
	}
}