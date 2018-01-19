import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Albert
 *
 */
public class ClockTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int RADIUS = 100;
		
		double startSecond = GregorianCalendar.getInstance().get(Calendar.SECOND);
		double startMinute = GregorianCalendar.getInstance().get(Calendar.MINUTE);
		double startHour = GregorianCalendar.getInstance().get(Calendar.HOUR);
		System.out.printf("%d:%d:%d", (int)startHour, (int)startMinute, (int)startSecond);
		
		
		JFrame frame = new JFrame();
		
		ClockShape clock = new ClockShape(RADIUS);
		
		ClockHandIcon clockIcon = new ClockHandIcon(clock, RADIUS*2, RADIUS*2);
		
		JLabel clockLabel = new JLabel(clockIcon);
		
		JPanel panel = new JPanel();
		panel.setSize(RADIUS*2, RADIUS*2);
		panel.add(clockLabel);
		
		frame.add(clockLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		final int MILLIOFSEC = 1000;
		
		
		Timer tSec = new Timer (MILLIOFSEC, event -> {
			clock.tick();
			clockLabel.repaint();
		});
		
		tSec.start();

	}

}
