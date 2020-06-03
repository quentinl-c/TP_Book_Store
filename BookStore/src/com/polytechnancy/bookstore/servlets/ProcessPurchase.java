package com.polytechnancy.bookstore.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.polytechnancy.bookstore.business.Cart;
import com.polytechnancy.bookstore.data.dao.BooksDAO;
import com.polytechnancy.bookstore.data.entities.Book;
import com.polytechnancy.bookstore.data.entities.LineItem;

/**
 * Servlet implementation class ProcessPurchase
 */
@WebServlet("/ProcessPurchase")
public class ProcessPurchase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final String url = "cart";
	
	private final String errorUrl = "welcome";

	@EJB
	private BooksDAO booksDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessPurchase() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirectUrl = this.url;
		
		final String code = request.getParameter("productCode");
		final Book book = booksDAO.findByISBN(code);

		if(book != null) {
			
			int quantity;
			try {
				quantity = Integer.parseInt(request.getParameter("quantity"));
				if(quantity < 0) {
					quantity = 0;
				}
			} catch (NumberFormatException ex) {
				quantity = 1;
			}
			
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			
			if (cart == null) {
				cart = new Cart();
			}
			
			if(quantity > 0) {
				LineItem lineItem = new LineItem(book, quantity);
				cart.addItem(lineItem);
			} else {
				cart.removeItem(code);
			}
			session.setAttribute("cart", cart);
		} else {
			redirectUrl = this.errorUrl;
		}
		response.sendRedirect(redirectUrl);
	}

}
