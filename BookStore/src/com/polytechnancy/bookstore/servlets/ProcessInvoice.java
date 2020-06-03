package com.polytechnancy.bookstore.servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.polytechnancy.bookstore.business.Cart;
import com.polytechnancy.bookstore.business.PurchaseInfo;
import com.polytechnancy.bookstore.data.dao.InvoiceDAO;
import com.polytechnancy.bookstore.data.entities.LineItem;

/**
 * Servlet implementation class ProcessInvoice
 */
@WebServlet("/ProcessInvoice")
public class ProcessInvoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String url = "buy";
    
	private final String urlForm = "/WEB-INF/checkout.jsp";

	@EJB
	private InvoiceDAO invoiceDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessInvoice() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * TODO : manage the creation of a new invoice and its persistence into the database
		 * conditions : all information is fulfilled and the cart is not empty
		 * If no error detected, then redirect to url (with right info passed into the session), else, forward to urlForm with the appropriate error message
		 * */
		
			
		response.sendRedirect(this.url);
		
		
	}

}
