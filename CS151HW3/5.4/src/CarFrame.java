import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class CarFrame extends JFrame implements ChangeListener{
	//private CarShape car;
	private final int CAR_WIDTH = 2;
	private CarShape carShape;
	private ShapeIcon icon;
	private DataModel data;
	private JLabel label;
	
	public CarFrame(DataModel data) {

		this.data = data;
		this.carShape = new CarShape(0, 0, CAR_WIDTH, data.getScale());
		this.icon = new ShapeIcon(carShape, CAR_WIDTH*100, CAR_WIDTH*100);
		
		label = new JLabel(icon);
		
		this.add(label);
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		this.carShape.scaling(data.getScale());
		this.repaint();
		
		
	}
}
