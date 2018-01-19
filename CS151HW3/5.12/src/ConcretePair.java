import javax.swing.JTextField;

/**
 * 
 */

/**
 * @author albertchan
 *
 */
public class ConcretePair implements TextPair {
	
	private JTextField clearText;
	private JTextField cyperText;
	
	public ConcretePair() {
		this.clearText = new JTextField(30);
		this.cyperText = new JTextField(30);
		
		
	}
	

	/* (non-Javadoc)
	 * @see TextPair#getClearText()
	 */
	@Override
	public JTextField getClearText() {
		// TODO Auto-generated method stub
		return this.clearText;
	}

	/* (non-Javadoc)
	 * @see TextPair#getCyperText()
	 */
	@Override
	public JTextField getCyperText() {
		// TODO Auto-generated method stub
		return this.cyperText;
	}

	/* (non-Javadoc)
	 * @see TextPair#setClearText(java.lang.String)
	 */
	@Override
	public void setClearText(String clear) {
		// TODO Auto-generated method stub
		
		this.clearText.setText(clear);

	}

	/* (non-Javadoc)
	 * @see TextPair#setCyperText(java.lang.String)
	 */
	@Override
	public void setCyperText(String cypher) {
		// TODO Auto-generated method stub
		
		this.cyperText.setText(cypher);

	}

}
