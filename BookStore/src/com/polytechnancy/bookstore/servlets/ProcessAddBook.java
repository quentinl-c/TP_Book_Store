package com.polytechnancy.bookstore.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polytechnancy.bookstore.data.dao.BooksDAO;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/ProcessAddBook")
public class ProcessAddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final String urlSuccess = "welcome";
	
	private final String urlForm = "/WEB-INF/addBook.jsp";
	@EJB
	private BooksDAO booksDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessAddBook() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = new String();
		
		request.setCharacterEncoding("utf-8");
		final String isbn = request.getParameter("ISBN");
		final String title = request.getParameter("title");
		final String author = request.getParameter("author");
		final String priceString = request.getParameter("price");
		
		if (isbn.isEmpty() || title.isEmpty() || author.isEmpty() || priceString.isEmpty()) {
			error = "Fill in all the fields of this form";
		} else if (booksDAO.findByISBN(isbn) != null) {
			error = "The book already exists";
		}
		
		if (error.isEmpty()) {
			double price;
			try {
				price = Double.parseDouble(request.getParameter("price"));
			} catch (NumberFormatException ex) {
				price = 1;
			}
			booksDAO.create(isbn, title, author, price);
			response.sendRedirect(this.urlSuccess);
		} else {
	
			request.setAttribute("error", error);
			request.setAttribute("isbn", isbn);
			request.setAttribute("title", title);
			request.setAttribute("author", author);
			request.setAttribute("price", priceString);
			
			getServletContext()
			.getRequestDispatcher(this.urlForm).
			forward(request, response);
		}
	}


}
