package com.dao;

import java.util.*;
import com.entities.*;

public interface BookDAO {
	public boolean addBook(BookDetails b);
	public List<BookDetails> getAllBooks();
	public BookDetails getBookById(int id);
	public boolean editBook(BookDetails b);
	public boolean deleteBook(int id);
	public List<BookDetails> getRecentBook();
	public List<BookDetails> getNewBook();
	public List<BookDetails> getOldBook();
	public List<BookDetails> getAllRecentBook();
	public List<BookDetails> getAllNewBook();
	public List<BookDetails> getAllOldBook();
	public List<BookDetails> getOldBook(String email, String category);
	public boolean deleteOldBook(int id, String category, String email);
	public List<BookDetails> getBookBySearch(String ch);
}
