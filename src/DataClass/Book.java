package DataClass;

public class Book {
	private String book_id;
    private String book_name;
    private String book_author;
    private String book_ISBN;
    private String book_price;
    private String book_state;

	
public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_ISBN() {
		return book_ISBN;
	}
	public void setBook_ISBN(String book_ISBN) {
		this.book_ISBN = book_ISBN;
	}
	public String getBook_price() {
		return book_price;
	}
	public void setBook_price(String book_price) {
		this.book_price = book_price;
	}
	public String getBook_state() {
		return book_state;
	}
	public void setBook_state(String book_state) {
		this.book_state = book_state;
	}
public Book() {}
public Book(String book_name, String book_author, String book_ISBN, String book_price,
		String book_state) {
//	this.book_id = book_id;
	this.book_name = book_name;
	this.book_author = book_author;
	this.book_ISBN = book_ISBN;
	this.book_price = book_price;
	this.book_state = book_state;
}
public Book(String book_ISBN) {
	super();
	this.book_ISBN = book_ISBN;
}
public Book(String book_ISBN, String book_state) {
	super();
	this.book_ISBN = book_ISBN;
	this.book_state = book_state;
}



     
}
