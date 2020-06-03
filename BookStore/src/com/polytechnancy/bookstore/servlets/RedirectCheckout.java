package com.polytechnancy.bookstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectCheckout
 */
@WebServlet("/checkout")
public class RedirectCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String url = "/WEB-INF/checkout.jsp";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectCheckout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().
		getRequestDispatcher(url).
		forward(request, response);
	}


}
