package com.och.hackthon.models;

import java.sql.ResultSet;

public class Book {
	private String bookNO;
	private String bookName;
	private String description;
	private String author;
	private String publisher;
	private int category;
	
	public Book(ResultSet rs)
	{
		
	}

	public String getBookNO() {
		return bookNO;
	}

	public void setBookNO(String bookNO) {
		this.bookNO = bookNO;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	
}
