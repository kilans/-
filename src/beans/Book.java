package beans;

public class Book {
	
	private String id;
	private String bookname;
	private String author;
	private double price;
    private String remark;
    private int number;
	public Book() {
		super();
	}

	public Book(String id,String bookname,String author,double price, String remark,int number) {
		super();
		this.id=id;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.remark=remark;
		this.number=number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	

}
