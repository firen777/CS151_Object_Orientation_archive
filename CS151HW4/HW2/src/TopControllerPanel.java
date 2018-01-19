import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**TopControllerPanel only execute 3 tasks:
 * <ol>
 * <li> move day backward.
 * <li> move day forward.
 * <li> save and quit the program.
 * </ol>
 * @author albertchan
 *
 */
public class TopControllerPanel extends JPanel implements ChangeListener {

	private CalendarModel m;
	private static final String MONTHS[] = {"Jan", "Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}; 
	
	JLabel month = new JLabel();
	
	JButton back = new JButton(); 
	JButton fore = new JButton();
	JButton quit = new JButton();
	/**
	 * @param m the Model top panel controls.
	 */
	public TopControllerPanel(CalendarModel m) {
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		this.m = m;
		this.m.attach(this);
		
		back.addActionListener(e->{
			m.previousDay();
		});
		fore.addActionListener(e->{
			m.nextDay();
		});
		quit.addActionListener(e->{
			try {
				m.saveCalendarEventList("events.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally{
				System.exit(0);
			}
		});
		
		month.setText(MONTHS[this.m.getSelectedDate().get(Calendar.MONTH)] + " " + this.m.getSelectedDate().get(Calendar.YEAR));
		back.setText("<");
		fore.setText(">");
		quit.setText("Save and Quit");
		quit.setBackground(Color.RED);
		quit.setOpaque(true);
		quit.setBorder(BorderFactory.createRaisedBevelBorder());
		
		this.add(month);
		this.add(back);
		this.add(fore);
		this.add(quit);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		month.setText(MONTHS[this.m.getSelectedDate().get(Calendar.MONTH)] + " " + this.m.getSelectedDate().get(Calendar.YEAR));
	}

}
