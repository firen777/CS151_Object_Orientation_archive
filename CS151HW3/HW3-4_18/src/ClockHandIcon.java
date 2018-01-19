import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class ClockHandIcon implements Icon {
	private ClockShape hand;
	private int width;
	private int height;
	
	/**
	 * @param hand
	 * @param width
	 * @param height
	 */
	public ClockHandIcon(ClockShape hand, int width, int height) {
		super();
		this.hand = hand;
		this.width = width;
		this.height = height;
	}
	/* (non-Javadoc)
	 * @see javax.swing.Icon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO Auto-generated method stub
		hand.draw((Graphics2D)g);
	}

	/* (non-Javadoc)
	 * @see javax.swing.Icon#getIconWidth()
	 */
	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}

	/* (non-Javadoc)
	 * @see javax.swing.Icon#getIconHeight()
	 */
	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

}
