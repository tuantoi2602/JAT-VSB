package jat.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jat.dao.CustomerDAO;
import jat.dto.Customer;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet({"/CustomerServlet", "/Login"})
public class CustomerServlet extends HttpServlet {
	@Inject
	private CustomerDAO customerDAO;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username").trim();
		String password = request.getParameter("pwd").trim();
		Customer cus = customerDAO.findbyUsername(username, password);
		if(cus == null) {
		}
		else{
			request.getSession().setAttribute("loginCustomer", cus);
			
		}
		response.sendRedirect("/zzzzzzzzzzzzz/faces/login.xhtml");
	}

}
