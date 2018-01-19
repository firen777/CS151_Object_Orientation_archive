import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DataModel {
	private int scale;
	private ArrayList<ChangeListener> cList;
	
	public DataModel (int scale) {
		this.cList = new ArrayList<ChangeListener>();
		this.scale = scale;
	}
	
	/**
	 * @return the scale
	 */
	public int getScale() {
		return scale;
	}

	public void attach(ChangeListener l) {
		this.cList.add(l);
	}
	
	public void update(int scale) {
		this.scale = scale;
		for (ChangeListener l : cList) {
			l.stateChanged(new ChangeEvent(this));
		}
	}
	
	
}
