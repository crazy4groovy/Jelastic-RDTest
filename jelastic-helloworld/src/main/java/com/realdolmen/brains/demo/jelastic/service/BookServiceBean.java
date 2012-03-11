package com.realdolmen.brains.demo.jelastic.service;

import java.util.List;

import org.hibernate.Session;

import com.realdolmen.brains.demo.jelastic.model.Book;

public class BookServiceBean implements BookService {

	@Override
	public List<Book> list() {
		final Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		List<Book> books = session.createQuery("from Book").list();

		System.out.println("Books: " + books.size() + "- " + books);
		
		session.getTransaction().commit();
		
		return books;
	}

	@Override
	public void create(String isbn, String title) {
		final Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Book book = new Book(isbn);
		book.setTitle(title);
		
		session.save(book);

		session.getTransaction().commit();

	}

}
