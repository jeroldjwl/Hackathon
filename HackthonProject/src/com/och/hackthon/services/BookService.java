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

	public ResultSet getAllBooks(Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(getAllBooksSQL);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public boolean insertBook(Book book, int toNum, Connection conn) {
		PreparedStatement ps = null;
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(insertBookSQL);
			ps.setString(1, book.getBookNO());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getDescription());
			ps.setString(4, book.getAuthor());
			ps.setString(5, book.getPublisher());
			ps.setInt(6, book.getCategory());
			ps.setString(7, book.getImgPath());
			int flag1 = ps.executeUpdate();
			ps = conn.prepareStatement(insertInventorySQL);
			ps.setString(1, book.getBookNO());
			ps.setString(2, book.getBookName());
			ps.setInt(3, toNum);
			ps.setInt(4, toNum);
			int flag2 = ps.executeUpdate();
			conn.commit();
			if (flag1 == 0 || flag2 == 0) {
				conn.rollback();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean deleteBook(String bookNo, String bookName, int stock, Connection conn) {
		PreparedStatement ps = null;
		int remainStock = 0;
		try {
			conn.setAutoCommit(false);
			remainStock = getStock(bookNo, bookName, conn);
			if (remainStock == stock) {
				ps = conn.prepareStatement(deleteBookSQL);
				ps.setString(1, bookNo);
				ps.setString(2, bookName);
				int flag1 = ps.executeUpdate();
				ps = conn.prepareStatement(deleteInventorySQL);
				ps.setString(1, bookNo);
				ps.setString(2, bookName);
				int flag2 = ps.executeUpdate();
				conn.commit();
				if (flag1 == 0 || flag2 == 0) {
					conn.rollback();
					return false;
				}
			} else if (remainStock < stock) {
				return false;
			} else {
				remainStock = remainStock - stock;
				ps = conn.prepareStatement(updateInventorySQL);
				ps.setInt(1, remainStock);
				ps.setString(2, bookNo);
				ps.setString(3, bookName);
				int flag = ps.executeUpdate();
				conn.commit();
				if (flag == 0)
					return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	private int getStock(String bookNo, String bookName, Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int stock = 0;
		try {
			ps = conn.prepareStatement(checkStockSQL);
			ps.setString(1, bookNo);
			ps.setString(2, bookName);
			rs = ps.executeQuery();
			if (rs.next()) {
				stock = rs.getInt("Stock");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stock;
	}

	private String getBookSQL = "select * from Book where BookNo=? and BookName=?";

	private String insertBookSQL = "insert into Book (BookNo, BookName, Description, Author, Publisher, Category, ImgPath) values (?,?,?,?,?,?)";

	private String insertInventorySQL = "insert into Inventory(BookNo, BookName, ToNum, Stock) values (?,?,?,?)";

	private String updateInventorySQL = "update Inventory set Stock =? where BookNo=? and BookName=?";

	private String checkStockSQL = "select Stock from Inventory where BookNo=? and BookName=?";

	private String deleteInventorySQL = "delete from Inventory where BookNo=? and BookName=?";

	private String deleteBookSQL = "delete from Book where BookNo=? and BookName=?";

	private String getAllBooksSQL = "select b.BookNo, b.BookName, b.Description, b.Author, b.Publisher, b.Category, b.ImgPath from Book b, Inventory i where b.BookNo = i.BookNo and b.BookName=i.BookName ";

}
