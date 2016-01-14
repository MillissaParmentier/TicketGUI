import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class TicketGUIStatus extends JComponent{
	
	int X = 50;
	int Y = 25;
	int A = 300;
	int B = 50;
	Color tempC = Color.magenta;
	int tempW = 0;
	
	public void paintComponent(Graphics g) {
		
		//g.drawRect(0, 0, 100, 75);
		g.drawRect(X, Y, A, B);
		g.setColor(tempC);
		g.fillRect(X, Y, tempW, 50);
	
	}
	
	public void setNewValues (int tempX, int tempY, int tempWidth) {
		X = tempX;
		Y = tempY;
		//tempC = tempColor;
		tempW = tempWidth;
		
		repaint();
	}
}
