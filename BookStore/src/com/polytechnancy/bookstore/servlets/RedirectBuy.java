package com.polytechnancy.bookstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.polytechnancy.bookstore.business.PurchaseInfo;

/**
 * Servlet implementation class RedirectBuy
 */
@WebServlet("/buy")
public class RedirectBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private final String errorUrl = "welcome";
	private final String url = "/WEB-INF/buy.jsp";  
	/**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectBuy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PurchaseInfo info = (PurchaseInfo) session.getAttribute("info");
		
		if (info == null) {
			response.sendRedirect(this.errorUrl);
		} else {
			request.setAttribute("info", info);
			getServletContext()
			.getRequestDispatcher(this.url).
			forward(request, response);
		}
		
	}

}
