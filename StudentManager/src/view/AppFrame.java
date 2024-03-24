package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import utils.ButtonTextProperties;

public class AppFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private AppPanel contentPane;
	private JTable table;
	private JTree tree;
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
		
        tree = new JTree();
        SubTree subTree = new SubTree();
        contentPane.add(subTree.createTree(tree, subTree.createTreeModel()));
		
		table = new TableList();
		TableList tableList = new TableList();
		contentPane.add(tableList.createScrollPaneForTableList(table, tableList.loadModel()));
		

		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			    if (selectedNode != null && selectedNode.isLeaf()) {
			        table.setModel(tableList.loadModel(selectedNode.getUserObject().toString()));
			    }
			}
		});
		
		JButton gb = new JButton();
		gb.setText(getName());
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 213, 113);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(233, 87, 243, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(233, 10, 1035, 36);
		contentPane.add(textPane);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBounds(486, 87, 782, 36);
		contentPane.add(buttonPanel);
		buttonPanel.setLayout(null);
		
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
		
		JButton search = new JButton("Search");
		search.setBounds(0, 0, 104, 36);
		buttonPanel.add(search);
	}
}
