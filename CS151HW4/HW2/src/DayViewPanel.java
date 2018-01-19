import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class DayViewPanel extends JPanel implements ChangeListener {
	
	private CalendarModel m;
	private ArrayList<JLabel> labelList = new ArrayList<JLabel>();

	/**
	 * @param m CalendarModel. Automatically attach itself to model.
	 */
	public DayViewPanel(CalendarModel m) {
		this.m = m;
		m.attach(this);
		this.setLayout(new GridLayout(0,2));
		for(int i=0;i<96;i++){
			JLabel label1 = new JLabel();
			final int tempInt = i;
			label1.addMouseListener(new MouseAdapter(){

				@Override
				public void mouseClicked(MouseEvent e) {
					deleteEvent(tempInt);
				}
				
			});
			
			label1.setOpaque(true);
			this.add(label1);
			this.labelList.add(label1);
		}
		this.highLightEvent();
	}
	
	/**Highlight Event(s) of the Day
	 * 
	 */
	private void highLightEvent(){
		//System.out.println("called highLightEvent");
		
		for (JLabel l: this.labelList){
			l.setText("");
			l.setBackground(null);
			l.setBorder(BorderFactory.createEmptyBorder());
		}
		for (int i=0;i<96;i++){
			if (i%4 == 0){
				if (i<48){
					int tempHR = i/4;
					String timeText = "" + tempHR + " AM";
					this.labelList.get(i).setText(timeText);
				} else {
					int tempHR = i/4-12;
					if (tempHR == 0) tempHR =12;
					String timeText = "" + tempHR + " PM";
					this.labelList.get(i).setText(timeText);
				}
			}
		}
		
//		reference:
//		label1.setOpaque(true);
//		label1.setBorder(BorderFactory.createRaisedBevelBorder());
//		label1.setBackground(Color.CYAN);
		
		for (CalendarEvent c : this.m.getEventList()){
			//if event date match selected date.
			if (c.getDate().get(Calendar.YEAR) == m.getSelectedDate().get(Calendar.YEAR)
					&& c.getDate().get(Calendar.MONTH) == m.getSelectedDate().get(Calendar.MONTH)
					&& c.getDate().get(Calendar.DATE) == m.getSelectedDate().get(Calendar.DATE)){
				int startIndex = c.getStartHr()*4 + (2*(c.getStartMin()/30));
				int endIndex = c.getEndHr()*4 + (2*c.getEndMin()/30);
				
				
				this.labelList.get(startIndex+1).setText(c.getContext());
				
				for (int i = startIndex; i < endIndex; i++){
					//System.out.println("paint something");
					this.labelList.get(i).setBorder(BorderFactory.createRaisedBevelBorder());
					this.labelList.get(i).setBackground(Color.cyan);
				}
			}
		}
			
		repaint();
	}
	
	/**if label[index] has an event scheduled, delete it
	 * @param index
	 */
	private void deleteEvent(int index){
		if (this.labelList.get(index).getBackground().equals(Color.CYAN)){
			int hr = index/4;
			int min = index % 4 * 15;
			
			this.m.deleteEvent(this.m.getSelectedDate(), hr, min);
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		this.highLightEvent();
		
	}

}
