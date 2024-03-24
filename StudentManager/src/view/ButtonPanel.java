package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import utils.ButtonTextProperties;

public class ButtonPanel extends JButton {
	
	public JPanel buttonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(486, 87, 782, 36);
		buttonPanel.setLayout(null);
		
		JButton search = new JButton(ButtonTextProperties.getValueByKey("search.button"));
		search.setBounds(0, 0, 104, 36);
		buttonPanel.add(search);
		
		JButton delete = new JButton(ButtonTextProperties.getValueByKey("delete.button"));
		delete.setBounds(678, 0, 104, 36);
		buttonPanel.add(delete);
		
		JButton save = new JButton("Save");
		save.setBounds(336, 0, 104, 36);
		buttonPanel.add(save);
		
		JButton edit = new JButton("Edit");
		edit.setBounds(564, 0, 104, 36);
		buttonPanel.add(edit);
		
		JButton addNew = new JButton("Add New");
		addNew.setBounds(450, 0, 104, 36);
		buttonPanel.add(addNew);
		
		return buttonPanel;
	}
}
