package javaOOP_lession10;

public class Book {
	private String ISBN;
	private String title;
	private String author;
	private int year;

	public Book(String ISBN, String author, String title, int year) {
		this.ISBN = ISBN;
		this.author = author;
		this.title = title;
		this.year = year;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
