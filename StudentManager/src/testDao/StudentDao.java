package testDao;

import java.util.List;

import entity.Student;

public interface StudentDao {
	public List<Student> getListStudent();
	public List<Student> getListStudentsEclass(String nameClass);
}
