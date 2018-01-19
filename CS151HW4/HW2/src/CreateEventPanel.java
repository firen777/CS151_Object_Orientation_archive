import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class CreateEventPanel extends JPanel implements ChangeListener{

	private CalendarModel m;
	private JTextField context, startTime, endTime;
	private JLabel currentDate, to;
	private JButton save;
	
	/**
	 * @param m CalendarModel <br> Automatically attach itself as ChangeListener
	 */
	public CreateEventPanel(CalendarModel m) {
		this.m = m;
		this.m.attach(this);
		
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		context = new JTextField();
		context.setColumns(60);
		context.setText("Untitled Event");
		
		currentDate = new JLabel(m.getSelectedDate().get(GregorianCalendar.MONTH)+1+"/"+ 
				m.getSelectedDate().get(GregorianCalendar.DATE)+"/"
				+m.getSelectedDate().get(GregorianCalendar.YEAR));
		
		startTime = new JTextField("00:00 AM");
		to = new JLabel("to");
		endTime = new JTextField("11:59 PM");
		
		save = new JButton("Save");
		save.addActionListener(e->{
			try {
				this.saveButtonLogic();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "ParseException Occured! Please check the format.");
			}
		});
		//context.setBorder(BorderFactory.createRaisedBevelBorder());
		this.add(context);
		this.add(currentDate);
		this.add(startTime);
		this.add(to);
		this.add(endTime);
		this.add(save);
	}
	
	/**Before invoking the mutator of Model, check whether if there is time conflict.
	 * @throws ParseException 
	 * 
	 */
	private void saveButtonLogic() throws ParseException{
		String contextString = this.context.getText();
		String startString = this.startTime.getText();
		String endString = this.endTime.getText();
		
		String formatTime = "hh:mm a";
		Date time0 = new SimpleDateFormat(formatTime).parse(startString);
		Calendar c0 = new GregorianCalendar();
		c0.setTime(time0);
		int startHr = c0.get(Calendar.HOUR_OF_DAY);
		int startMin = c0.get(Calendar.MINUTE);

		Date time1 = new SimpleDateFormat(formatTime).parse(endString);
		Calendar c1 = new GregorianCalendar();
		c1.setTime(time1);
		int endHr = c1.get(Calendar.HOUR_OF_DAY);
		int endMin = c1.get(Calendar.MINUTE);
		
		if (eventConflict(startHr, startMin, endHr, endMin)){
			JOptionPane.showMessageDialog(null, "Event Conflict Occured!\nPlease input a different time."); 
		} else {
			this.m.addEvent(contextString, m.getSelectedDate(), startHr, endHr, startMin, endMin);
		}
		
	}
	
	private boolean eventConflict(int startHr, int startMin, int endHr, int endMin){
		int startNumeric = startHr * 60 + startMin;
		int endNumeric = endHr * 60 + endMin;
		
		if (startNumeric >= endNumeric)
			return true;

		//iterating event list
		for (CalendarEvent c : this.m.getEventList()){
			//if event date match selected date.
			if (c.getDate().get(Calendar.YEAR) == m.getSelectedDate().get(Calendar.YEAR)
					&& c.getDate().get(Calendar.MONTH) == m.getSelectedDate().get(Calendar.MONTH)
					&& c.getDate().get(Calendar.DATE) == m.getSelectedDate().get(Calendar.DATE)){
//				System.out.println(c.getDate().get(Calendar.DATE));
//				System.out.println(m.getSelectedDate().get(Calendar.DATE));
				//time intersect logic
				if ((startNumeric < c.getStartNumeric() && c.getStartNumeric() < endNumeric)||
						(startNumeric < c.getEndNumeric() && c.getEndNumeric() < endNumeric)||
						(c.getStartNumeric() < startNumeric && startNumeric < c.getEndNumeric())||
						(c.getStartNumeric()==startNumeric && c.getEndNumeric()==endNumeric)){
					
					
					return true;
				}
			}
		}
				
		return false;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.currentDate.setText(m.getSelectedDate().get(GregorianCalendar.MONTH)+1+"/"+ 
				m.getSelectedDate().get(GregorianCalendar.DATE)+"/"
				+m.getSelectedDate().get(GregorianCalendar.YEAR));
		
	}
	
	

}
