package testDao.Impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entity.ActivityClass;
import testDao.ActivityClassDao;

public class ActivityClassDaoImpl extends ConnectDBImpl implements ActivityClassDao {

	@Override
	public List<ActivityClass> getListClass() {
		List<ActivityClass> listClass = new ArrayList<>();
		try {
			connection = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT * ");
			sql.append(" FROM class");
			preparedStatement = connection.prepareStatement(sql.toString());
			result = preparedStatement.executeQuery();
			ActivityClass activityClass = null;
			while(result.next()) {
				activityClass = new ActivityClass();
				activityClass.setId_class(result.getString("id_class"));
				activityClass.setClass_name(result.getString("class_name"));
				activityClass.setId_department(result.getString("id_department"));
				listClass.add(activityClass);
			}
			return listClass;
		} catch(SQLException e) {
			System.out.println("Error: "+ Thread.currentThread().getStackTrace()[1].getClassName()+ 
					" - " + Thread.currentThread().getStackTrace()[1].getMethodName() + " : " + e.getMessage());
		} finally {
			closedConnection();
		}
		return null;
	}
}
