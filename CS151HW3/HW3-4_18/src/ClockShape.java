import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class ClockShape {
	private double radius;
	private Calendar cal;
	private int sec; private double lengthSec;
	private int min; private double lengthMin;
	private int hr;  private double lengthHr;
	
	/**Constructor for hand
	 * @param radius
	 */
	public ClockShape(double radius) {
		this.radius = radius;
		this.cal = GregorianCalendar.getInstance();
		this.sec = cal.get(Calendar.SECOND);
		this.min = cal.get(Calendar.MINUTE);
		this.hr = (int) (((cal.get(Calendar.HOUR))*1.0 + (this.min/60.0)) * 5);
		this.lengthSec = radius * 0.9;
		this.lengthMin = radius * 0.7;
		this.lengthHr = radius * 0.5;
	}

	void draw(Graphics2D g2) {
		Point2D.Double origin = new Point2D.Double(radius, radius);
		
		Point2D.Double endSec = new Point2D.Double(radius + lengthSec * (Math.sin(Math.toRadians(6 * sec))), 
												   radius - lengthSec * (Math.cos(Math.toRadians(6 * sec))));  // sin|cos ((Radian) 360* t/60)
		Point2D.Double endMin = new Point2D.Double(radius + lengthMin * (Math.sin(Math.toRadians(6 * min))), 
				   								   radius - lengthMin * (Math.cos(Math.toRadians(6 * min))));
		Point2D.Double endHr = new Point2D.Double(radius + lengthHr * (Math.sin(Math.toRadians(6 * hr))), 
												  radius - lengthHr * (Math.cos(Math.toRadians(6 * hr))));
		
		
		Line2D.Double handSec = new Line2D.Double(origin, endSec);
		Line2D.Double handMin = new Line2D.Double(origin, endMin);
		Line2D.Double handHr = new Line2D.Double(origin, endHr);
		
		Ellipse2D.Double face = new Ellipse2D.Double(0,0,radius*2,radius*2);
		
		g2.setStroke(new BasicStroke(5));
		
		g2.draw(handSec);
		g2.draw(handMin);
		g2.draw(handHr);
		g2.draw(face);
		
	}
	
	void tick () {
		this.cal.add(Calendar.SECOND, 1);
		this.sec = cal.get(Calendar.SECOND);
		this.min = cal.get(Calendar.MINUTE);
		this.hr = (int) (((cal.get(Calendar.HOUR))*1.0 + (this.min/60.0)) * 5);
		
	}

}
