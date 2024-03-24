package utils;

public class Constant {
	public static final String PROPERTIES_DATABASE_PATH = "\\DataConnect.properties";
	public static final String JDBC_URL = DatabaseProperties.getValueByKey("jdbcUrl");
	public static final String CLASS_FN = DatabaseProperties.getValueByKey("classForName");
	public static final String USER_NAME = DatabaseProperties.getValueByKey("username");
	public static final String PASSWORD = DatabaseProperties.getValueByKey("password");
	
	public static final String BUTTON_TEXT_PATH = "\\ButtonText.properties";
}
