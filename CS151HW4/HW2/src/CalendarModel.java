import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**CalendarModel consist of
 * <ol>
 * <li>the current selectedDate
 * <li>List of events.
 * </ol>
 * 
 * 
 * @author Albert Chan
 *
 */
public class CalendarModel {
	
	private Calendar selectedDate;
	private ArrayList<CalendarEvent> eventList = new ArrayList<CalendarEvent>();
	
	private ArrayList<ChangeListener> cl = new ArrayList<ChangeListener>();
	/**Construct a CalendarModel which set today as the selectedDate
	 * <br>If events.txt is presented, model will try to deserialize it.
	 */
	public CalendarModel() {
		this.selectedDate = new GregorianCalendar();
		try {
			this.openCalendarEventList("events.txt");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("events.txt not found");
		}
	}
	
	/**attach a listener to the model
	 * @param listener
	 */
	public void attach(ChangeListener listener) {
		this.cl.add(listener);
	}
	
	/**update all ChangeListeners.
	 * 
	 */
	public void updateListener(){
		for (ChangeListener c:cl){
			c.stateChanged(new ChangeEvent(this));
		}
	}


	/**
	 * @return selectedDate
	 */
	public Calendar getSelectedDate() {
		return selectedDate;
	}
	
	/**new Selected day of the current Month.
	 * 
	 */
	public void selectADay(int day){
		this.selectedDate.set(Calendar.DAY_OF_MONTH, day);
		this.updateListener();
	}
	
	/**Set Calendar selectedDate as previous day
	 * 
	 */
	public void previousDay(){
		this.selectedDate.add(Calendar.DATE, -1);
		this.updateListener();
	}
	
	/**Set Calendar selectedDate as next day
	 * 
	 */
	public void nextDay(){
		this.selectedDate.add(Calendar.DATE, +1);
		this.updateListener();
	}
	
	/**
	 * @return the eventList
	 */
	public ArrayList<CalendarEvent> getEventList() {
		return eventList;
	}

	
	/////////////////////////////////////////////////////////////////////////////////
	/**Serialize and Save manager's eventList as fileName
	 * @param fileName
	 * @throws IOException
	 */
	public void saveCalendarEventList (String fileName) throws IOException  {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this.eventList);
	}
	
	
	/**Deserialize fileName as eventList and append the list to manager's list
	 * @param fileName
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void openCalendarEventList (String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<CalendarEvent> importedEvent = (ArrayList<CalendarEvent>) ois.readObject();
		this.eventList.addAll(importedEvent);
	}
	/////////////////////////////////////////////////////////////////////////////////
	
	/**Add event in eventList
	 * automatically parse string into data
	 * @param context Context of the event
	 * @param dateOfEvent Date of the event, in "MM/dd/yyyy" format
	 * @param startTime starting time of the event, in "hh:mm a" format.
	 * @param endTime ending time of the event, in "hh:mm a" format.
	 * @throws ParseException
	 */
	public void addEvent(String context, String dateOfEvent, String startTime, String endTime) throws ParseException {
		String format = "MM/dd/yyyy";
		Date date = new SimpleDateFormat(format).parse(dateOfEvent);
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		
		String formatTime = "hh:mm a";
		Date time0 = new SimpleDateFormat(formatTime).parse(startTime);
		Calendar c0 = new GregorianCalendar();
		c0.setTime(time0);
		int startHr = c0.get(Calendar.HOUR_OF_DAY);
		int startMin = c0.get(Calendar.MINUTE);
		
		Date time1 = new SimpleDateFormat(formatTime).parse(startTime);
		Calendar c1 = new GregorianCalendar();
		c1.setTime(time1);
		int endHr = c0.get(Calendar.HOUR_OF_DAY);
		int endMin = c0.get(Calendar.MINUTE);
		
		this.eventList.add(new CalendarEvent(context, c, startHr, endHr, startMin, endMin));
//		try {
//			this.saveCalendarEventList("events.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.updateListener();
	}
	
	/**Add event in eventList
	 * <br>Before calling the method, raw String data has been expected to be processed
	 * @param context
	 * @param date, will create a copy of the Calendar object in the process.
	 * @param startHr
	 * @param endHr
	 * @param startMin
	 * @param endMin
	 */
	public void addEvent(String context, Calendar date, 
			int startHr, int endHr, int startMin, int endMin){
		Calendar newDate = (Calendar) date.clone();
		this.eventList.add(new CalendarEvent(context, newDate, startHr, endHr, startMin, endMin));
//		try {
//			this.saveCalendarEventList("events.txt");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		this.updateListener();
	}
	
	/**Delete an Event
	 * @param date the date of the event
	 * @param hr the hour included in the event (24 Hr)
	 * @param min the minute included in the event
	 */
	public void deleteEvent(Calendar date, int hr, int min){
		for (int i=0;i<this.eventList.size();i++){
			CalendarEvent c = this.eventList.get(i);
			if (c.getDate().get(Calendar.YEAR) == date.get(Calendar.YEAR)&&
					c.getDate().get(Calendar.MONTH) == date.get(Calendar.MONTH)&&
					c.getDate().get(Calendar.DATE) == date.get(Calendar.DATE)){
				int numeric = 60*hr +min;
				if (c.getStartNumeric()<=numeric&&numeric<=c.getEndNumeric()){
					this.eventList.remove(i);
					this.updateListener();
					return;
				}
			}
		}
	}
	
	
}