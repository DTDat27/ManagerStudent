package testDao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import testDao.StudentDao;


public class StudentDaoImpl extends ConnectDBImpl implements StudentDao {

	@Override
	public List<Student> getListStudent() {
		List<Student> stuList = new ArrayList<>();
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append(" student.id_student,");
			sql.append(" student.student_name,");
			sql.append(" class.class_name,");
			sql.append(" department.department_name,");
			sql.append(" student.sexual,");
			sql.append(" student.phone, ");
			sql.append(" student.status");
			// Join các bảng
			sql.append(" FROM student");
			sql.append(" LEFT join class");
			sql.append(" ON student.id_class = class.id_class");
			sql.append(" LEFT join test.department");
			sql.append(" ON student.id_department = department.id_department");
			preparedStatement = connection.prepareStatement(sql.toString());
			result = preparedStatement.executeQuery();
			Student stud = null;
			while(result.next()) {
				stud = new Student();
				stud.setId(result.getString("id_student"));
				stud.setName(result.getString("student_name"));
				stud.setClass_name(result.getString("class_name"));
				stud.setDepartment_name(result.getString("department_name"));
				stud.setSexual(result.getString("sexual"));
				stud.setPhone(result.getInt("phone"));
				stud.setStatus(result.getString("status"));
				stuList.add(stud);
			}
			return stuList;
		} catch(SQLException e) {
			System.out.println("Error: "+ Thread.currentThread().getStackTrace()[1].getClassName()+ 
					" - " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + e.getMessage());
		} finally {
			closedConnection();
		}
		return null;
	}
	
	@Override
	public List<Student> getListStudentsEclass(String nameClass) {
		List<Student> stuList = new ArrayList<>();
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT ");
			sql.append(" student.id_student,");
			sql.append(" student.student_name,");
			sql.append(" class.class_name,");
			sql.append(" department.department_name,");
			sql.append(" student.sexual,");
			sql.append(" student.phone, ");
			sql.append(" student.status");
			// Join các bảng
			sql.append(" FROM student");
			sql.append(" LEFT join class");
			sql.append(" ON student.id_class = class.id_class");
			sql.append(" LEFT join test.department");
			sql.append(" ON student.id_department = department.id_department");
			sql.append(" where class.class_name = ? ");
			
			int i = 1;

			preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(i++, nameClass);
			result = preparedStatement.executeQuery();
			Student stud = null;
			while(result.next()) {
				stud = new Student();
				stud.setId(result.getString("id_student"));
				stud.setName(result.getString("student_name"));
				stud.setClass_name(result.getString("class_name"));
				stud.setDepartment_name(result.getString("department_name"));
				stud.setSexual(result.getString("sexual"));
				stud.setPhone(result.getInt("phone"));
				stud.setStatus(result.getString("status"));
				stuList.add(stud);
			}
			return stuList;
		} catch(SQLException e) {
			System.out.println("Error: "+ Thread.currentThread().getStackTrace()[1].getClassName()+ 
					" - " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + e.getMessage());
		} finally {
			closedConnection();
		}
		return null;
	}
}
