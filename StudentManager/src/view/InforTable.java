package view;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.Student;
import testDao.StudentDao;
import testDao.Impl.StudentDaoImpl;

public class InforTable extends JTable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StudentDao stu = new StudentDaoImpl();

	public DefaultTableModel createModel () {
        String[] columnNames = {"ID", "Name", "Class","Department","Sexual","Phone","Status"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		List<Student> stuList = stu.getListStu();
        for (Student student : stuList) {
            Object[] row = {student.getId(), student.getName(), student.getPhone()};
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
	
	public JScrollPane createScrollPaneForTable() {
		InforTable table = new InforTable();
        // Đặt kích thước và vị trí cho JTable
        table.setBounds(233, 133, 1035, 609);
        table.setModel(table.createModel());
        // Tạo JScrollPane để chứa JTable
        JScrollPane scrollPane = new JScrollPane(table);
        // Đặt kích thước và vị trí cho JScrollPane
        scrollPane.setBounds(233, 133, 1035, 609);
		return scrollPane;
	}
}
