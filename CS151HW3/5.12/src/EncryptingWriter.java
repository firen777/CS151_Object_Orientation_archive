import javax.swing.JTextField;

public class EncryptingWriter implements TextPair{
	private TextPair pair;

	/**
	 * @param pair
	 */
	public EncryptingWriter(TextPair pair) {
		super();
		this.pair = pair;
	}

	@Override
	public JTextField getClearText() {
		// TODO Auto-generated method stub
		return pair.getClearText();
	}

	@Override
	public JTextField getCyperText() {
		// TODO Auto-generated method stub
		return pair.getCyperText();
	}

	@Override
	public void setClearText(String clear) {
		// TODO Auto-generated method stub
		pair.setClearText(clear);
	}

	@Override
	public void setCyperText(String cypher) {
		char [] encrypted = cypher.toCharArray();
		
		for (int i=0; i < encrypted.length; i++) {
			if ( encrypted[i] >= 'a' &&  encrypted[i] <=  'z') {
				encrypted[i] = (char)(encrypted[i]+3);
				if (encrypted[i] > 'z') {
					encrypted[i] = (char)(encrypted[i]-26);
				}
			}
			if ( encrypted[i] >= 'A' &&  encrypted[i] <=  'Z') {
				encrypted[i] = (char)(encrypted[i]+3);
				if (encrypted[i] > 'Z') {
					encrypted[i] = (char)(encrypted[i]-26);
				}
			}
		}
		
		String text = String.copyValueOf(encrypted);
		pair.setCyperText(text);
	}

}
