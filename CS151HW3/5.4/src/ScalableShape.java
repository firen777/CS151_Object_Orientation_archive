import java.awt.*;

/**
   A shape that can be moved around.
*/
public interface ScalableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   /**
      Moves the shape.
      It is up to the shape to move itself, for example by tracking the time since 
      its last movement, its position, and velocity.
 * @param newScale TODO
   */
   void scaling(int newScale);
}
