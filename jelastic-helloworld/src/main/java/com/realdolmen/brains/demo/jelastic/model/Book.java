package com.realdolmen.brains.demo.jelastic.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String isbn;
	
	private String title;
	
	public Book() {
		// Default JPA constructor.
	}
	
	public Book(String isbn) {
		if (isbn == null){
			throw new IllegalArgumentException("Isbn cannot be null.");
		}
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj){
			return false;
		}
		if (this == obj){
			return true;
		}
		if (!(obj instanceof Book)){
			return false;
		}
		final Book that = (Book) obj;
		return this.getIsbn().equals(that.getIsbn());
	}
	
	@Override
	public int hashCode() {
		return this.getIsbn().hashCode();
	}
	
	@Override
	public String toString() {
		return this.getIsbn();
	}
	
}
