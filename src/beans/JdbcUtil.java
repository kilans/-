package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcUtil {
	
	public static Connection getConnection() throws Exception {
		String driverName = "com.mysql.cj.jdbc.Driver";
		String userName = "root"; 
		String userPwd ="123456";
		String dbName = "bookmanagement";
		String url1="jdbc:mysql://localhost:3306/"+dbName;
		String url2="?user="+userName+"&password="+userPwd;
		String url3="&useUnicode=true&characterEncoding=UTF-8" + "&serverTimezone=UTC";
		String url=url1+url2+url3;
		Class.forName(driverName); 
		Connection conn = DriverManager.getConnection(url, userName, userPwd);
		return conn;
	}
	
	public static void free(ResultSet rs,PreparedStatement pst,Connection conn) throws Exception {
		if(rs!=null) {
			rs.close();
		}
		if(pst!=null) {
			pst.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}

}
