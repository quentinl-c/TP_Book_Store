package com.polytechnancy.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.polytechnancy.bookstore.data.dao.BooksDAO;
import com.polytechnancy.bookstore.data.entities.Book;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String url = "/WEB-INF/index.jsp";
       
	@EJB
	private BooksDAO booksDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books = booksDAO.findAll();
		request.setAttribute("books", books);

		getServletContext().
		getRequestDispatcher(this.url).
		forward(request, response);
	}


}