package view;

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


public class SubTree extends JTree{	
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
	
	public SubTree createTree() {
		SubTree tree = new SubTree();
        tree.setModel(tree.createTreeModel());
        tree.setBounds(10, 133, 213, 609);
		return tree;
	}
}
