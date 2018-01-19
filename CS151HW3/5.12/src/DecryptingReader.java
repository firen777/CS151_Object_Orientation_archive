import javax.swing.JTextField;

public class DecryptingReader implements TextPair{
	
	private TextPair pair;

	/**
	 * @param pair
	 */
	public DecryptingReader(TextPair pair) {
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
		char [] decrypted = clear.toCharArray();
		
		for (int i=0; i < decrypted.length; i++) {
			if ( decrypted[i] >= 'a' &&  decrypted[i] <=  'z') {
				decrypted[i] = (char)(decrypted[i]-3);
				if (decrypted[i] < 'a') {
					decrypted[i] = (char)(decrypted[i]+26);
				}
			}
			if ( decrypted[i] >= 'A' &&  decrypted[i] <=  'Z') {
				decrypted[i] = (char)(decrypted[i]-3);
				if (decrypted[i] < 'A') {
					decrypted[i] = (char)(decrypted[i]+26);
				}
			}
		}
		
		String text = String.copyValueOf(decrypted);
		pair.setClearText(text);
	
	}
	
	
	@Override
	public void setCyperText(String cypher) {
		// TODO Auto-generated method stub
		pair.setCyperText(cypher);
	}

}
