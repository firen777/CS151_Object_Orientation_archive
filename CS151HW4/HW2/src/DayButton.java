import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class DayButton extends JButton {
	
	private int dayID;

	/**
	 * @param dayID
	 */
	public DayButton(int dayID) {
		super();
		this.dayID = dayID;
	}
	
	

	/**
	 * @return the dayID
	 */
	public int getDayID() {
		return dayID;
	}



	/**
	 * @param icon
	 */
	public DayButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 */
	public DayButton(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param a
	 */
	public DayButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param text
	 * @param icon
	 */
	public DayButton(String text, Icon icon) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

}
