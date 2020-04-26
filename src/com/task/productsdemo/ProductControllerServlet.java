package com.task.productsdemo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductControllerServlet
 */
@WebServlet("/ProductControllerServlet")
public class ProductControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDbUtil productDbUtil;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		productDbUtil  = new ProductDbUtil();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		listProducts( request, response);
		}catch (Exception e) {
			throw new ServletException();
		}
	}

	private void listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = this.getServletContext().getRealPath("/WEB-INF/csv/Task-Java.csv");
		
		List<Product> products = productDbUtil.getProducts(path);
		
		
		request.setAttribute("PRODUCT_LIST", products);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-products.jsp");
		dispatcher.forward(request, response);
		
	}
	
	

}
