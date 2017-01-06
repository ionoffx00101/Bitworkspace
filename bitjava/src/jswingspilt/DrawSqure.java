package jswingspilt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class DrawSqure extends JPanel
{

	@Override
	public void paint(Graphics g)
	{
		//super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.fillRect(410, 150, 250, 250);
		g2d.setColor(Color.black);
		
	}

}
