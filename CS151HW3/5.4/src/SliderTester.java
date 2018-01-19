/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class SliderTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int DEFAULT_SCALE = 50;
		DataModel data = new DataModel(DEFAULT_SCALE);
		
		SliderFrame slider = new SliderFrame(data);
		CarFrame carFrame = new CarFrame(data);
		
		data.attach(carFrame);

	}

}
