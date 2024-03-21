package com.dao;

import java.util.*;

import com.entities.*;

public interface BookOrderDAO {
	
	public int getOrderNumber();
	public boolean saveOrder(List<BookOrder> blist);
	public List<BookOrder> getBooks(String email);
	public List<BookOrder> getAllOrders();
	
}
