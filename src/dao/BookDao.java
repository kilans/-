package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import beans.JdbcUtil;
import beans.Book;
import beans.borrow;

public class BookDao {
	
	public void insert(Book u) throws Exception {
		Connection conn = JdbcUtil.getConnection();
		String sql="insert into book(bid,bookname,author,price,remark,number) values(?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, u.getId());
		pstmt.setString(2, u.getBookname());
		pstmt.setString(3, u.getAuthor());
		pstmt.setDouble(4, u.getPrice());
		pstmt.setString(5, u.getRemark());
		pstmt.setInt(6, u.getNumber());
		pstmt.executeUpdate();
		JdbcUtil.free(null, pstmt, conn);
	}
	
	public void delete(String s) throws Exception {
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql="delete from book where bid=?";
		conn = JdbcUtil.getConnection();
		
		pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, s);

		pstmt.executeUpdate();
		JdbcUtil.free(null, pstmt, conn);
	}
	
	public List<Book> findAll() throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from book";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);

		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		List<Book> list=new ArrayList<Book>();
		Book cou=null;
		while(rs.next()) {
			String id=rs.getString("bid");
			String bookname=rs.getString("bookname");
			String author=rs.getString("author");
			String price=rs.getString("price");
			String remark=rs.getString("remark");
			double price2=Double.parseDouble(price);
			int number=Integer.parseInt(rs.getString("number"));
			cou=new Book(id,bookname,author,price2,remark,number);
			list.add(cou);
		}
		JdbcUtil.free(rs, pstmt, conn);
		return list;
	}
	
	public List<Book> findBook1(String bookname1) throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from book where bookname like '%"+bookname1+"%'";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		List<Book> list=new ArrayList<Book>();
		Book cou=null;
		while(rs.next()) {
			String id=rs.getString("bid");
			String bookname=rs.getString("bookname");
			String author=rs.getString("author");
			String price=rs.getString("price");
			String remark=rs.getString("remark");
			int number=Integer.parseInt(rs.getString("number"));
			double price2=Double.parseDouble(price);
			cou=new Book(id,bookname,author,price2,remark,number);
			list.add(cou);
		}
		JdbcUtil.free(rs, pstmt, conn);
		return list;
	}
	
	public List<Book> findBook2(String id1) throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from book where bid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, id1);
		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		List<Book> list=new ArrayList<Book>();
		Book cou=null;
		while(rs.next()) {
			String id=rs.getString("bid");
			String bookname=rs.getString("bookname");
			String author=rs.getString("author");
			String price=rs.getString("price");
			String remark=rs.getString("remark");
			int number=Integer.parseInt(rs.getString("number"));
			double price2=Double.parseDouble(price);
			cou=new Book(id,bookname,author,price2,remark,number);
			list.add(cou);
		}
		JdbcUtil.free(rs, pstmt, conn);
		return list;
	}
	public boolean findBook3(String id) throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from book where bid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		if(rs.next()) {
			return true;
		}
		JdbcUtil.free(rs, pstmt, conn);
		return false;
	}
	public Book findBook4(String id1) throws Exception {
		Connection conn =JdbcUtil.getConnection();
		String sql = "select * from book where bid=?";
		PreparedStatement pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, id1);
		ResultSet rs = pstmt.executeQuery();
		rs.beforeFirst();
		Book cou=null;
		while(rs.next()) {
			String id=rs.getString("bid");
			String bookname=rs.getString("bookname");
			String author=rs.getString("author");
			String price=rs.getString("price");
			String remark=rs.getString("remark");
			int number=Integer.parseInt(rs.getString("number"));
			double price2=Double.parseDouble(price);
			cou=new Book(id,bookname,author,price2,remark,number);
		}
		return cou;
	}
	public void update(Book c) throws Exception {
		Connection conn = null;
		PreparedStatement  pstmt = null;
		String sql="update book set bid=?,bookname=?,author=?,price=?,remark=?,number=? where bid=?";
		conn = JdbcUtil.getConnection();
		
		pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
		pstmt.setString(1, c.getId());
		pstmt.setString(2, c.getBookname());
		pstmt.setString(3, c.getAuthor());
		pstmt.setDouble(4, c.getPrice());
		pstmt.setString(5, c.getRemark());
		pstmt.setInt(6, c.getNumber());
        pstmt.setString(7,c.getId());
		pstmt.executeUpdate();
		JdbcUtil.free(null, pstmt, conn);
	}
	//根据账号查询用户id
		public String find_ID(String account) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from user where account=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			String x=null;
			if(rs.next())
			{
				x=rs.getString("sid");
			}
			JdbcUtil.free(rs, pstmt, conn);
			return x;
		}
		
		//查询该用户下所有借阅记录
		public List<borrow> find_ALLRecord(String id) throws Exception 
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			List<borrow> list=new ArrayList<borrow>();
			String sql="select * from borrow where sid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				borrow borrow01=new borrow();
				borrow01.setId(rs.getString("sid"));
				borrow01.setBookid(rs.getString("bookid"));
				borrow01.setBookname(rs.getString("bookname"));
				borrow01.setBookstate(rs.getString("bookstate"));
				borrow01.setTime(rs.getString("time"));
				list.add(borrow01);
			}
			JdbcUtil.free(rs, pstmt, conn);
			return list;	
		}
		
		//根据序号判断该用户已借图书是否大于8本
		public boolean judge_borrow_num(String id) throws Exception
		{
			boolean flag=false;
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from user where sid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getInt("lend")>=0&&rs.getInt("lend")<=7)//已拥有图书7本及以下均可借阅
				{
					flag=true;
				}
			}
			return flag;
		}
		
		//获取用户借阅量
		public int lend_num(String id) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from user where sid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			int x=0;
			if(rs.next())
			{
				x=rs.getInt("lend");
			}
			return x;
		}
		
		//用户借阅量加1
		public int borrow_plus_one(String id) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="update user set lend=? where sid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			int x=lend_num(id);//获取借阅量
			pstmt.setInt(1, x+1);
			pstmt.setString(2, id);
			int n=pstmt.executeUpdate();
			return n;
		}
		
		//根据书号查书
		public Book query_book(String bid) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from book where bid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, bid);
			ResultSet rs = pstmt.executeQuery();
			Book book01=new Book();
			if(rs.next())
			{
				book01.setId(rs.getString("bid"));
				book01.setBookname(rs.getString("bookname"));
				book01.setAuthor(rs.getString("author"));
				book01.setPrice(rs.getDouble("price"));
				book01.setRemark(rs.getString("remark"));
				book01.setNumber(rs.getInt("number"));
			}
			return book01;
		}
		
		//借阅图书操作
		public void borrow_book01(String idx,Book book,String operation) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="insert into borrow(sid,bookid,bookname,bookstate,time) values(?,?,?,?,?)";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, idx);
			pstmt.setString(2, book.getId());
			pstmt.setString(3, book.getBookname());
			pstmt.setString(4, operation);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			String dateNow = sdf.format(new Date());  
			//System.out.println("当前时间为："+dateNow);
			//具体的年、月、日可利用substring截取
			//dateNow.substring(开始下标，结束下标),下标原则：从0开始，包前不包后
			//System.out.println(dateNow.substring(0,4)+"年"+dateNow.substring(5,7)+"月"+dateNow.substring(8,10)+"日");
			String time=dateNow.substring(0,4)+dateNow.substring(5,7)+dateNow.substring(8,10);
			pstmt.setString(5, time);
			pstmt.executeUpdate(); 
		}
		
		//判断图书数量，若图书数量<0则不可借书
		public boolean judge_book_num(String bid) throws Exception
		{
			boolean flag=false;
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from book where bid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, bid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getInt("number")<=0)
				{
					return true;
				}
			}
			return flag;
		}
		
		//借阅图书后图书数量减一
		public int book_num_subtract(Book book01,String bid) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="update book set number=? where bid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setInt(1, book01.getNumber()-1);
			pstmt.setString(2, bid);
			int n=pstmt.executeUpdate();
			return n;
		}
		
		//还书操作：1.根据书号在借阅记录中查询此书最后一次操作是什么
		public String borrow_query01(String bid,String id) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from borrow where bookid=? and sid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, bid);
			pstmt.setString(2, id);
			ResultSet rs = pstmt.executeQuery();
			String x=null;
			if(rs.next())//判断最后一次此人对此书状态
			{
				if(rs.last())
				{
					x=rs.getString("bookstate");
				}
			}
			else
			{
				x="null";
			}
			return x;
		}
		//还书：用户借阅量减一
		public int borrow_num_subtract01(String id) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="update user set lend=? where sid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			int x=lend_num(id);//获取借阅量
			pstmt.setInt(1, x-1);
			pstmt.setString(2, id);
			int n=pstmt.executeUpdate();
			return n;
		}
		
		
		//还书：此书数量加一
		public int book_num_plus01(Book book01,String bid) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="update book set number=? where bid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setInt(1, book01.getNumber()+1);
			pstmt.setString(2, bid);
			int n=pstmt.executeUpdate();
			return n;
		}
		
		//判断日期相差多少
		public int time_judge(String time1,String time2) throws ParseException
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        int days = 0;
	        String time1x=time1.substring(0, 4)+"-"+time1.substring(4, 6)+"-"+time1.substring(6, 8);
	        String time2x=time2.substring(0, 4)+"-"+time2.substring(4, 6)+"-"+time2.substring(6, 8);
			Date startDate = simpleDateFormat.parse(time1x);
	        Date endDate = simpleDateFormat.parse(time2x);
	        Calendar startCalendar = Calendar.getInstance();
	        startCalendar.setTime(startDate);
	        Calendar endCalendar = Calendar.getInstance();
	        endCalendar.setTime(endDate);
	        //计算两个日期相差的天数
	        //sartCalendar.getTime().getTime()返回long毫秒数形式,毫秒转为秒所以除以1000
	        //1天=24小时，1小时=60分，1分=60秒，所以两个时间的差再除以60 * 60 * 24换算成天的形式
	        days = ((int) (startCalendar.getTime().getTime() / 1000) - (int) (endCalendar.getTime().getTime() / 1000)) / (60 * 60 * 24);
	        return days;
		}
		
		public String time_query(String bid,String id,String operation) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from borrow where bookid=? and sid=? and bookstate=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, bid);
			pstmt.setString(2, id);
			pstmt.setString(3, operation);
			ResultSet rs = pstmt.executeQuery();
			String x=null;
			if(rs.next())
			{
				if(rs.last())
				{
					x=rs.getString("time");
				}
			}
			return x;
		}
		
		//获取今天时间
		public String time_get() throws Exception
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
			String dateNow = sdf.format(new Date());  
			//System.out.println("当前时间为："+dateNow);
			//具体的年、月、日可利用substring截取
			//dateNow.substring(开始下标，结束下标),下标原则：从0开始，包前不包后
			//System.out.println(dateNow.substring(0,4)+"年"+dateNow.substring(5,7)+"月"+dateNow.substring(8,10)+"日");
			String time=dateNow.substring(0,4)+dateNow.substring(5,7)+dateNow.substring(8,10);
			return time;
		}
		
		//获取人物姓名
		public String name_get(String id) throws Exception
		{
			Connection conn = null;
			PreparedStatement  pstmt = null;
			String sql="select * from user where sid=?";
			conn = JdbcUtil.getConnection();
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);//(sql);
			pstmt.setString(1, id);
			ResultSet rs=pstmt.executeQuery();
			String x=null;
			if(rs.next())
			{
				x=rs.getString("name");
			}
			return x;
		}
		
		//判断日期哪个更大
		public String time_judge02(String time1,String time2) throws ParseException
		{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String time3=null;
	        int days=0;
	        if(time1==null)
	        {
	        	return time2;
	        }
	        else if(time2==null)
	        {
	        	return time1;
	        }
	        else if(time1!=null&&time2!=null)
	        {
	        	String time1x=time1.substring(0, 4)+"-"+time1.substring(4, 6)+"-"+time1.substring(6, 8);
		        String time2x=time2.substring(0, 4)+"-"+time2.substring(4, 6)+"-"+time2.substring(6, 8);
				Date startDate = simpleDateFormat.parse(time1x);
		        Date endDate = simpleDateFormat.parse(time2x);
		        Calendar startCalendar = Calendar.getInstance();
		        startCalendar.setTime(startDate);
		        Calendar endCalendar = Calendar.getInstance();
		        endCalendar.setTime(endDate);
		        days = ((int) (startCalendar.getTime().getTime() / 1000) - (int) (endCalendar.getTime().getTime() / 1000)) / (60 * 60 * 24);
		        if(days>0)
		        {
		        	time3=time1;
		        }
		        else
		        {
		        	time3=time2;
		        }
	        }
	        return time3;
		}
		
}
