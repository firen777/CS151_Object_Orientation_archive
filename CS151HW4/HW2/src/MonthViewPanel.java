import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class MonthViewPanel extends JPanel implements ChangeListener {
	
	// 31 days + 6 possible empty days = 37 button needed
	ArrayList<DayButton> dayButton = new ArrayList<DayButton>();
	private final static String [] WEEKDAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
	private int currentMonth;
	private int currentDay;
	private CalendarModel m;
	//Reference:
	//Button.setBackground(hlButt.getBackground().darker());
	//Button.setBorder(BorderFactory.createEmptyBorder());
	//Button.setBorder(BorderFactory.createRaisedBevelBorder());

	/**
	 * @param m CalendarModel.<br> Automatically attach itself as ChangeListener
	 */
	public MonthViewPanel(CalendarModel m) {
		super();
		this.m = m;
		this.currentMonth = m.getSelectedDate().get(Calendar.MONTH);
		this.currentDay = m.getSelectedDate().get(Calendar.DAY_OF_MONTH);
		this.m.attach(this);
		initialize();
	}
	
	/**Initialize all components
	 * 
	 */
	private void initialize(){
		//initial panel dimension
		this.setLayout(new GridLayout(0,7));
		this.setPreferredSize(new Dimension(300,300));
		
		//Create and store buttons
		for (int i=0;i<37;i++){
			dayButton.add(new DayButton(i));
		}
		//Add actionListener for Button
		for (DayButton d: dayButton){
			d.addActionListener(e->{
				this.buttonClickedLogic(d.getDayID());
			});
		}
		//Add Labels
		for (int i=0;i<7;i++){
			this.add(new JLabel(WEEKDAYS[i],SwingConstants.CENTER));
		}
		//Add Buttons
		for (DayButton d: dayButton){
			this.add(d);
		}
		this.labelDayButton();
	}
	/**Label corresponding DayButton with days of the current month.
	 * as well as highlighting selected day.
	 */
	private void labelDayButton(){
		Border temp=BorderFactory.createEmptyBorder();
		//clear all label
		for (DayButton d:dayButton){
			d.setText("");
			d.setBorder(temp);
			d.setOpaque(true);
			d.setBackground(null);
		}
		
		
		Calendar tempC = new GregorianCalendar();
		tempC.setTime(m.getSelectedDate().getTime());
		tempC.set(Calendar.DATE, 1);
		int labelingStart = tempC.get(Calendar.DAY_OF_WEEK);
		labelingStart--; //Labeling start at Button[0] if Sunday(1), [1] if Monday[2] ...
		
		int labelingEnd = m.getSelectedDate().getActualMaximum(Calendar.DAY_OF_MONTH) + labelingStart; //1 + 30days = 31 days total
		
		int dayCounter = 1;
		while(labelingStart<labelingEnd){
			this.dayButton.get(labelingStart).setText(""+(dayCounter));
			if (dayCounter == this.currentDay){
				this.dayButton.get(labelingStart).setOpaque(true);
				//this.dayButton.get(labelingStart).setBorder(BorderFactory.createRaisedBevelBorder());
				this.dayButton.get(labelingStart).setBackground(Color.cyan);
			}
			
			labelingStart++;
			dayCounter++;
		}
		
		for (CalendarEvent c : this.m.getEventList()){
			//current month
			if (c.getDate().get(Calendar.YEAR) == m.getSelectedDate().get(Calendar.YEAR)
					&& c.getDate().get(Calendar.MONTH) == m.getSelectedDate().get(Calendar.MONTH)) {
				for (DayButton d:this.dayButton){
					if (d.getText()!="")
						if (Integer.parseInt(d.getText())==c.getDate().get(Calendar.DATE)){
							d.setOpaque(true);
							//this.dayButton.get(labelingStart).setBorder(BorderFactory.createRaisedBevelBorder());
							d.setBackground(Color.GREEN);
						}
				}
			}
		}
		repaint();
	}
	/**Control the logic of DayButton clicking
	 * <br>Parsing the text on DayButton(if any) into int and call mutator of model to change selectedDay.
	 * @param dayID indicate which button has been pressed
	 */
	private void buttonClickedLogic(int dayID){
		String temp = dayButton.get(dayID).getText();
		if (temp != "") {
			int dayClicked = Integer.parseInt(temp);
			m.selectADay(dayClicked);
		}
	}

	/** Update Current Month's view which:
	 * <ol>
	 * <li>Arrange the day buttons accordingly, if the selected month is changed
	 * <li>HighLight the selected day.
	 * </ol>
	 * 
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		this.currentMonth = m.getSelectedDate().get(Calendar.MONTH);
		this.currentDay = m.getSelectedDate().get(Calendar.DAY_OF_MONTH);
		this.labelDayButton();
	}
	

}
