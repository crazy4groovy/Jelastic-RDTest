package com.realdolmen.brains.demo.jelastic.service;

import java.util.List;

import com.realdolmen.brains.demo.jelastic.model.Book;

public interface BookService {

	List<Book> list();

	void create(String string, String string2);
	
}
