package com.och.hackthon.tests;

import java.sql.Connection;

import org.junit.Test;

import com.och.hackthon.models.Book;
import com.och.hackthon.services.BookService;
import com.och.hackthon.util.DBConnUtil;

public class BookOperationTest {
	@Test
	public void insertBookTest() {
		Book book = new Book("ISO8891", "Thinking In Java", "This is a book about JAVA", "SomeOne", "Which Publisher",
				1, "");
		int toNum = 5;
		Connection conn = DBConnUtil.getConnection();
		BookService bs = new BookService();
		boolean flag = bs.insertBook(book, toNum, conn);
		System.out.println(flag);
	}
}
