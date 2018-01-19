

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CryptoFrame extends JFrame {
	
	private JButton encrypt;
	private JButton decrypt;
	
	public CryptoFrame() {
		JPanel panel = new JPanel();
		this.setLayout(new FlowLayout());
		this.add(panel);
		panel.setSize(100, 100);
		
		TextPair pair = new ConcretePair();
		TextPair decryp = new DecryptingReader(pair);
		TextPair encryp = new EncryptingWriter(pair);
		
		this.encrypt = new JButton("encrypt");
		this.decrypt = new JButton("decrypt");
		encrypt.addActionListener(e -> {
			encryp.setCyperText(pair.getClearText().getText());
			this.repaint();
		});
		decrypt.addActionListener(e -> {
			decryp.setClearText(pair.getCyperText().getText());
			this.repaint();
		});
		
		
		panel.add(pair.getClearText());
		panel.add(encrypt);
		panel.add(decrypt);
		panel.add(pair.getCyperText());
		

		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
