package com.realdolmen.brains.demo.jelastic.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.realdolmen.brains.demo.jelastic.service.BookService;
import com.realdolmen.brains.demo.jelastic.service.BookServiceBean;

@WebServlet(value=Action.BOOK_CREATE)
public class CreateBookAction extends HttpServlet  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		String isbn = req.getParameter("isbn");
		String title = req.getParameter("title");
		
		BookService bookService = new BookServiceBean();
		
		bookService.create(isbn, title);

		resp.sendRedirect(Action.HOME);
		
	}
}
