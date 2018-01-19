import java.lang.String;
import java.util.Calendar;
import java.io.Serializable;

/**
 * CalendarEvent consist of 4 data
 * <ol>
 * <li>context of the event
 * <li>Date of the event
 * <li>starting time of the event
 * <li>ending time of the event
 * </ol>
 * 
 * @author Albert Chan
 *
 */
public class CalendarEvent implements Serializable{
	
	public final static String [] MONTHS = {"January", "February", "March", "April", "May", "June", "July",
			"August", "September", "October", "November", "December"};
	public final static String [] WEEKDAYS = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
	
	private String context;
	private Calendar date;
	private int startHr;
	private int endHr;
	private int startMin;
	private int endMin;
	private int startNumeric; //Hr * 60 + Min
	private int endNumeric; //Hr * 60 + Min
	
	/**
	 * @return the numeric value of starting time
	 * <br> which is: Hour * 60 + Min
	 */
	public int getStartNumeric() {
		return startNumeric;
	}

	/**
	 * @return the numeric value of ending time
	 * <br> which is: Hour * 60 + Min
	 */
	public int getEndNumeric() {
		return endNumeric;
	}

	/**
	 * @param context of the event
	 * @param date of the event
	 * @param startHr starting Hour of the event in 24 Hours Clock
	 * @param endHr ending Hour of the event in 24 Hours Clock
	 * @param startMin starting Minute of the event
	 * @param endMin ending Minute of the event
	 */
	public CalendarEvent(String context, Calendar date, int startHr, int endHr, int startMin, int endMin) {
		super();
		this.context = context;
		this.date = date;
		this.startHr = startHr;
		this.endHr = endHr;
		this.startMin = startMin;
		this.endMin = endMin;
		
		this.startNumeric = this.startHr * 60 + this.startMin;
		this.endNumeric = this.endHr * 60 + this.endMin;
		
	}
	
	/**Return the context of the Event
	 * @return the context
	 */
	public String getContext() {
		return context;
	}
	/**
	 * @return the date
	 */
	public Calendar getDate() {
		return date;
	}

	/**
	 * @return the startHr in 24 Hours Clock
	 */
	public int getStartHr() {
		return startHr;
	}

	/**
	 * @return the endHr in 24 Hours Clock
	 */
	public int getEndHr() {
		return endHr;
	}

	/**
	 * @return the startMin
	 */
	public int getStartMin() {
		return startMin;
	}

	/**
	 * @return the endMin
	 */
	public int getEndMin() {
		return endMin;
	}	

}
