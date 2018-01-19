package hw22;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestFrame {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panel.setPreferredSize(new Dimension(400, 400));
	    frame.add(panel);
	    frame.pack();
	    //frame.setResizable(false);

	    SimpleComponent comp = new SimpleComponent(10, 10, 100, 100);
	    panel.add(comp);
	    frame.setVisible(true);

	}

}
