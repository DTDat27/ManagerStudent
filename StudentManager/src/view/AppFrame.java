package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import javax.swing.border.EmptyBorder;



public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private AppPanel contentPane;
	private InforTable table;
	private SubTree tree;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppFrame frame = new AppFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AppFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1292, 789);
		contentPane = new AppPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        tree = new SubTree();
        contentPane.add(tree.createTree());   
		
		table = new InforTable();
		contentPane.add(table.createScrollPaneForTable());
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 213, 113);
		contentPane.add(lblNewLabel);
		
		JButton delete = new JButton("Delete");
		delete.setBounds(1164, 87, 104, 36);
		contentPane.add(delete);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(1050, 87, 104, 36);
		contentPane.add(btnNewButton_1);
		
		JButton edit = new JButton("Edit");
		edit.setBounds(936, 87, 104, 36);
		contentPane.add(edit);
		
		JButton addNew = new JButton("Add New");
		addNew.setBounds(822, 87, 104, 36);
		contentPane.add(addNew);
		
		textField = new JTextField();
		textField.setBounds(233, 87, 243, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton search = new JButton("Search");
		search.setBounds(486, 87, 104, 36);
		contentPane.add(search);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(233, 10, 1035, 36);
		contentPane.add(textPane);
	}
}
