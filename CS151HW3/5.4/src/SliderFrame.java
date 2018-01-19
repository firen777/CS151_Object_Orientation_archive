import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class SliderFrame extends JFrame {
	private JSlider slider;
	private DataModel tempdata;
	
	private final int CAR_WIDTH = 2;
	
	public SliderFrame(DataModel data) {
		this.slider = new JSlider(SwingConstants.VERTICAL, 1, 100, data.getScale());
		
		this.slider.addChangeListener(e -> {
				// TODO Auto-generated method stub
				JSlider src= (JSlider) e.getSource();
				data.update(src.getValue());
				System.out.println(src.getValue());
			}	
		);
		
		this.setLayout(new FlowLayout());
		
		this.add(slider);
		
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
