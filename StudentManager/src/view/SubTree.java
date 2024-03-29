package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import entity.ActivityClass;
import entity.Department;
import testDao.ActivityClassDao;
import testDao.DepartmentDao;
import testDao.Impl.ActivityClassDaoImpl;
import testDao.Impl.DepartmentDaoImpl;


public class SubTree extends JTree implements MouseListener{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ActivityClassDao activityClassDao = new ActivityClassDaoImpl();
	public DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	public DefaultTreeModel createTreeModel() {
		List<Department> departments = departmentDao.getListDepartment();	
		List<ActivityClass> lclass = activityClassDao.getListClass();
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("CLASS INFORMATION");
		for (Department department: departments) {	
			DefaultMutableTreeNode departmentNode = new DefaultMutableTreeNode(department.getDepartment_name());
			rootNode.add(departmentNode);
			for (ActivityClass classess: lclass) {
				if (classess.getId_department().equals(department.getId_department())) {
					DefaultMutableTreeNode classNode = new DefaultMutableTreeNode(classess.getClass_name());
					departmentNode.add(classNode);
				}
			}
		}
		DefaultTreeModel defaultTreeModel = new DefaultTreeModel(rootNode);
		return defaultTreeModel;
	}
	
	public JTree createTree(JTree tree,DefaultTreeModel model) {
        tree.setModel(model);
        tree.setBounds(10, 133, 213, 609);
        tree.addTreeSelectionListener(selectionRedirector);
		return tree;
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
