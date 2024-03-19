package testDao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Department;
import testDao.DepartmentDao;

public class DepartmentDaoImpl extends ConnectDBImpl implements DepartmentDao {
	
	@Override
	public List<Department> getListDepartment() {
		List<Department> deparmentList = new ArrayList<>();
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append(" FROM department");
			preparedStatement = connection.prepareStatement(sql.toString());
			result = preparedStatement.executeQuery();
			Department dep = null;
			while(result.next()) {
				dep = new Department();
				dep.setId_department(result.getString("id_department"));
				dep.setDepartment_name(result.getString("department_name"));
				deparmentList.add(dep);
			}
			return deparmentList;
		} catch(SQLException e) {
			System.out.println("Error: "+ Thread.currentThread().getStackTrace()[1].getClassName()+ 
					" - " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + e.getMessage());
		} finally {
			closedConnection();
		}
		return null;
	}
}
