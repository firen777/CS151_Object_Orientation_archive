


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author albertchan
 * CustomFrame is View
 */
public class CustomFrame extends JFrame implements ChangeListener {
	private DataModel data;
	private JButton button;
	private JTextField textField;
	private JTextArea textArea ;
	public CustomFrame (DataModel data) {
		this.data = data;
		
		button = new JButton();				//This is Controller
		textField = new JTextField(15); 
		textArea = new JTextArea(20,15);    
		button.setText("add");
		button.addActionListener(e -> {
			data.update(textField.getText());
		});
		
		
		this.setLayout(new BorderLayout());
		
		this.add(button, BorderLayout.NORTH);
		this.add(textArea, BorderLayout.CENTER);
		this.add(textField, BorderLayout.SOUTH);
		
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		this.textArea.setText(((DataModel)e.getSource()).getData());
		this.repaint();
	}
}
