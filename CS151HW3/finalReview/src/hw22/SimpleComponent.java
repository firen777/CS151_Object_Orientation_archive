package hw22;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class SimpleComponent extends JComponent {
	
	int x, y, width, height;

	public SimpleComponent(int x, int y, int width, int height){
	    this.x = x;
	    this.y = y;
	    this.width = width; // *** added
	    this.height = height;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    g2.setColor(Color.BLACK);
	    g2.fillRect(x, y, width, height);
	}

//	@Override
//	public Dimension getPreferredSize() {
//		// TODO Auto-generated method stub
//		return new Dimension(width, height);
//	}
	
	

}


