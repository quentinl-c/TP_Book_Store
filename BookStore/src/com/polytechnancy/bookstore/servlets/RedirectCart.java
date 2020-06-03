package com.polytechnancy.bookstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectCart
 */
@WebServlet("/cart")
public class RedirectCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String url = "/WEB-INF/cart.jsp";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().
		getRequestDispatcher(this.url).
		forward(request, response);
	}
}
