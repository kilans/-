package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
	private String sid;
	private String name;
	private String sex;
	private String major;
	private int lend;
	private String account;
	private String password;
	
	public User() {
		super();
	}

	public User(String sid,String name,String sex,String major,int lend,String account,String password)
	{
		this.sid=sid;
		this.name=name;
		this.sex=sex;
		this.major=major;
		this.lend=lend;
		this.account=account;
		this.password=password;
	}
	public User(String account, String password) {
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

	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}


	public int getLend() {
		return lend;
	}

	public void setLend(int lend) {
		this.lend = lend;
	}

	public boolean judge(String account1, String password1) throws Exception {
		boolean f = false;
		Connection conn = JdbcUtil.getConnection();
		String sql = "select * from user where account=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, account1);
		pstmt.setString(2, password1);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			f = true;
		}
		JdbcUtil.free(rs, pstmt, conn);
		return f;
	}


}
