import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * 
 */

/**
 * @author albertchan
 * This is the Model
 */
public class DataModel  {
	
	private ArrayList<ChangeListener> cList;
	private String data;
	
	public DataModel() {
		cList = new ArrayList<ChangeListener>();
		data = "";
	}
	
	public void attach(ChangeListener e) {
		cList.add(e);
	}
	
	public String getData() {
		return this.data;
	}
	
	public void update (String newText) {
		String trimmed = newText.trim();
		
		if (!trimmed.isEmpty()) {
			data = data + newText + "\n";
			for (ChangeListener c: this.cList) {
				c.stateChanged(new ChangeEvent(this));
			}	
		}
	
		
	}
	

}
