package com.och.hackthon.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.och.hackthon.models.Book;
import com.och.hackthon.util.DBConnUtil;

public class BookService {
	public Book getBook(String bookNo, String bookName, Connection conn) {
		PreparedStatement ps = null;
		Book book = null;
		try {
			ps = conn.prepareStatement(getBookSQL);
			ps.setString(1, bookNo);
			ps.setString(2, bookName);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				book = new Book(rs);
			}
			return book;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnUtil.releaseConn();
		}
		return book;
	}

	public boolean insertBook(Book book, Connection conn) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(insertSQL);
			ps.setString(1, book.getBookNO());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getDescription());
			ps.setString(4, book.getAuthor());
			ps.setString(5, book.getPublisher());
			ps.setInt(6, book.getCategory());
			int flag = ps.executeUpdate();
			if (flag == 0)
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	private String getBookSQL = "select * from Book where BookNo=? and BookName=?";

	private String insertSQL = "insert into Book (BookNo, BookName, Description, Author, Publisher, Category) values (?,?,?,?,?,?)";
}
