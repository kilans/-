package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private String account;
	private String password;
	
	public Admin() {
		super();
	}

	public Admin(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean judge(String account, String password) throws Exception {
		boolean f = false;
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from admin where account=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, password);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			f = true;
		} else {
			f = false;
		}
		JdbcUtil.free(rs, pstmt, conn);
		return f;
	}

}
