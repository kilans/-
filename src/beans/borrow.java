package beans;

public class borrow {
	private String id;
	private String bookid;
	private String bookname;
	private String bookstate;
	private String time;
	public borrow(){}
	public borrow(String id,String bookid,String bookname,String bookstate,String time)
	{
		this.id=id;
		this.bookid=bookid;
		this.bookname=bookname;
		this.bookstate=bookstate;
		this.time=time;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookstate() {
		return bookstate;
	}
	public void setBookstate(String bookstate) {
		this.bookstate = bookstate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
