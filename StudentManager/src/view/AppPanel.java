package view;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class AppPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private int top = 5;
	private int left = 5;
	private int bottom = 5;
	private int right= 5;
	/**
	 * Create the panel.
	 */
	public AppPanel() {
		EmptyBorder emptyBorder = new EmptyBorder(top, left, bottom, right);
		
	}

}
