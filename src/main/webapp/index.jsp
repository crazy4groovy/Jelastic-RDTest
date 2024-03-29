<?xml version="1.0" encoding="UTF-8" ?>

<%@page import="com.realdolmen.brains.demo.jelastic.action.Action"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.realdolmen.brains.demo.jelastic.model.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.realdolmen.brains.demo.jelastic.service.BookServiceBean"%>
<%@page import="com.realdolmen.brains.demo.jelastic.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html
	xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>RealDolmen Brains - Jelastic Hello World</title>
</head>
<body>
<h1>Hello world.</h1>

<%
	BookService bookService = new BookServiceBean();

	List<Book> books = bookService.list();
	
	pageContext.setAttribute("books", books);
	
%>

<h1>Create a book.</h1>
<form action="<%= Action.BOOK_CREATE %>" method="post">
	Isbn: <input type="text" name="isbn" /><br />
  	Title: <input type="text" name="title" /><br />
  	<input type="submit" value="Create" />
</form>

<h4>List of books.</h4>
<table>
	<thead>
		<tr>
			<th>Title</th><th>Isbn</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="item" >
			<tr>
				<td><c:out value="${item.title}" /></td>
				<td><c:out value="${item.isbn}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>