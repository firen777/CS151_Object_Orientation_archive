

/**
 * @author albertchan
 *
 */
public class MVCTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataModel data = new DataModel();
		CustomFrame frame = new CustomFrame(data);
		
		data.attach(frame);

	}

}
