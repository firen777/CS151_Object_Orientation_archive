import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
   A car that can be moved around.
*/
public class CarShape implements ScalableShape
{
   /**
      Constructs a car item.
      @param x the left of the bounding rectangle
      @param y the top of the bounding rectangle
      @param width the width of the bounding rectangle
      @param scale car scale
   */
   public CarShape(int x, int y, int width, int scale)
   {
      this.x = x;
      this.y = y;
      this.width = width;
      this.scale = scale;
   }

   public void scaling(int newScale)
   {
	   this.scale = newScale;
   }

   public void draw(Graphics2D g2)
   {
      Rectangle2D.Double body
            = new Rectangle2D.Double(x  , y + width*scale / 6, 
                  width*scale - 1, width*scale / 6);
      Ellipse2D.Double frontTire
            = new Ellipse2D.Double(x + width*scale / 6, y + width*scale / 3, 
                  width*scale / 6, width*scale / 6);
      Ellipse2D.Double rearTire
            = new Ellipse2D.Double(x + width*scale * 2 / 3, y + width*scale / 3,
                  width*scale / 6, width*scale / 6);

      // The bottom of the front windshield
      Point2D.Double r1
            = new Point2D.Double(x + width*scale / 6 , y + width*scale / 6);
      // The front of the roof
      Point2D.Double r2
            = new Point2D.Double(x + width*scale / 3 , y);
      // The rear of the roof
      Point2D.Double r3
            = new Point2D.Double(x + width*scale * 2 / 3 , y);
      // The bottom of the rear windshield
      Point2D.Double r4
            = new Point2D.Double(x + width*scale * 5 / 6 , y + width*scale / 6);
      Line2D.Double frontWindshield
            = new Line2D.Double(r1, r2);
      Line2D.Double roofTop
            = new Line2D.Double(r2, r3);
      Line2D.Double rearWindshield
            = new Line2D.Double(r3, r4);
      
      g2.draw(body);
      g2.draw(frontTire);
      g2.draw(rearTire);
      g2.draw(frontWindshield);
      g2.draw(roofTop);
      g2.draw(rearWindshield);
   }
   
   private int x;
   private int y;
   private int width;
   private int scale;
}
