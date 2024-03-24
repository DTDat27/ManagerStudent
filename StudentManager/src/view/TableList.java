package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Student;
import testDao.StudentDao;
import testDao.Impl.StudentDaoImpl;

public class TableList extends JTable implements MouseListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StudentDao stu = new StudentDaoImpl();

	public DefaultTableModel createModel() {
        String[] columnNames = {"ID", "Name", "Class","Department","Sexual","Phone","Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		List<Student> stuList = stu.getListStu();
        for (Student student : stuList) {
            Object[] row = {student.getId(), student.getName(), student.getClass_name(), student.getDepartment_name(),
            				student.getSexual(), student.getPhone(), student.getStatus() };
            model.addRow(row);
        }
		return model;
	}
	
//	public DefaultTableModel createModel2 () {
//		Object[][] data = {
//	            {"John", "Doe", 30},
//	            {"Jane", "Smith", 25},
//	            {"Bob", "Johnson", 35}
//	        };
//
//	        // Tiêu đề cho các cột
//	        String[] columnNames = {"First Name", "Last Name", "Age"};
//
//	        // Tạo một DefaultTableModel với dữ liệu và tiêu đề
//	        DefaultTableModel model2 = new DefaultTableModel(data, columnNames);
//		return model2;
//		
//	}
	
	public JScrollPane createScrollPaneForTableList(JTable table, DefaultTableModel model) {
        // Đặt kích thước và vị trí cho JTable
        table.setBounds(233, 133, 1035, 609);
        table.setModel(model);
        // Tạo JScrollPane để chứa JTable
        JScrollPane scrollPane = new JScrollPane(table);
        // Đặt kích thước và vị trí cho JScrollPane
        scrollPane.setBounds(233, 133, 1035, 609);
		return scrollPane;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("click lcik");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
