package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import beans.JdbcUtil;
import beans.User;

public class UserDao {

	public void insert(User u) throws Exception {
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql="insert into user(sid,name,sex,major,lend,account,password) values(?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConnection();
		
		pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, u.getSid());
		pstmt.setString(2, u.getName());
		pstmt.setString(3, u.getSex());
		pstmt.setString(4, u.getMajor());
		pstmt.setInt(5, 0);
		pstmt.setString(6, u.getAccount());
		pstmt.setString(7, u.getPassword());
		pstmt.executeUpdate();
		JdbcUtil.free(null, pstmt, conn);
	}
	public void insert1(User u) throws Exception {
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql="insert into user(sid,name,sex,major,lend,account,password) values(?,?,?,?,?,?,?)";
		conn = JdbcUtil.getConnection();
		
		pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, u.getSid());
		pstmt.setString(2, u.getName());
		pstmt.setString(3, u.getSex());
		pstmt.setString(4, u.getMajor());
		pstmt.setInt(5, u.getLend());
		pstmt.setString(6, u.getAccount());
		pstmt.setString(7, u.getPassword());

		pstmt.executeUpdate();
		JdbcUtil.free(null, pstmt, conn);
	}
	public void delete(String s) throws Exception {
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql="delete from user where account=?";
		conn = JdbcUtil.getConnection();
		
		pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, s);

		pstmt.executeUpdate();
		JdbcUtil.free(null, pstmt, conn);
	}
	
	public List<User> findAll() throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from user";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);

		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		List<User> list=new ArrayList<User>();
		User cou=null;
		while(rs.next()) {
			String sid=rs.getString("sid");
			String name=rs.getString("name");
			String sex=rs.getString("sex");
			String major=rs.getString("major");
			int lend=rs.getInt("lend");
			String account=rs.getString("account");
			String password=rs.getString("password");
			cou=new User(sid,name,sex,major,lend,account,password);
			list.add(cou);
		}
		JdbcUtil.free(rs, pstmt, conn);
		return list;
	}

	public User findUser(String u) throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from user where account=?";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, u);

		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		User user=null;
		if(rs.next()) {
			String sid=rs.getString("sid");
			String name=rs.getString("name");
			String sex=rs.getString("sex");
			String major=rs.getString("major");
			int lend=rs.getInt("lend");
			String account=rs.getString("account");
			String password=rs.getString("password");
			user=new User(sid,name,sex,major,lend,account,password);
		}
		JdbcUtil.free(rs, pstmt, conn);
		return user;
	}
	public List<User> findUser1(String account1) throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from user where account=?";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, account1);

		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		List<User> list=new ArrayList<User>();
		User cou=null;
		while(rs.next()) {
			String sid=rs.getString("sid");
			String name=rs.getString("name");
			String sex=rs.getString("sex");
			String major=rs.getString("major");
			int lend=rs.getInt("lend");
			String account=rs.getString("account");
			String password=rs.getString("password");
			cou=new User(sid,name,sex,major,lend,account,password);
			list.add(cou);
		}
		JdbcUtil.free(rs, pstmt, conn);
		return list;
	}
	public void importFromExcel(File excelPath, int sheetNo) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql="insert into user(sid,name,sex,major,lend,account,password) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		Workbook workbook = Workbook.getWorkbook(excelPath);
		Sheet sheet = workbook.getSheet(sheetNo - 1);
		int r = sheet.getRows();
		int c = sheet.getColumns();
		for (int i = 1; i < r; i++) {
			for (int j = 1; j <= c; j++) {
				pstmt.setString(j, sheet.getCell(j - 1, i).getContents().trim());
			}
			pstmt.addBatch();
		}
		pstmt.executeBatch();
		if (workbook != null)
			workbook.close();
		JdbcUtil.free(null, pstmt, conn);
	}
}
