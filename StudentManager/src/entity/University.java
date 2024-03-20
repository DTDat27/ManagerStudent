package entity;

public abstract class University {
	private String id_class;
	private String class_name;
	private String id_department;
	private String department_name;
	
	public String getId_class() {
		return id_class;
	}
	public void setId_class(String id_class) {
		this.id_class = id_class;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getId_department() {
		return id_department;
	}
	public void setId_department(String id_department) {
		this.id_department = id_department;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
}
