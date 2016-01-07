package com.och.hackthon.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
	private String bookNO;
	private String bookName;
	private String description;
	private String author;
	private String publisher;
	private int category;
	private String imgPath;

	public Book() {

	}

	public Book(String bookNo, String bookName, String description, String author, String publisher, int category,
			String imgPath) {
		this.bookNO = bookNo;
		this.bookName = bookName;
		this.description = description;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.imgPath = imgPath;
	}

	public Book(ResultSet rs) {
		try {
			this.bookNO = rs.getString("BookNo");
			this.bookName = rs.getString("BookName");
			this.description = rs.getString("Description");
			this.author = rs.getString("Author");
			this.publisher = rs.getString("Publisher");
			this.category = rs.getInt("Category");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}
