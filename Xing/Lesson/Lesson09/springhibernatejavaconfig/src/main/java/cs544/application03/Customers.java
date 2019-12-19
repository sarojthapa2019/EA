package cs544.application03;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebServlet(name = "Customers", urlPatterns = { "/customers" })
public class Customers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	    ServletContext context = getServletContext();
	    WebApplicationContext applicationContext = 
	        WebApplicationContextUtils.getWebApplicationContext(context);
	    CustomerService custServ = applicationContext.getBean(
	        "customerService", CustomerService.class);

		
		request.setAttribute("customers", custServ.getCustomers());		
		String jsp = "/Customers.jsp";
		RequestDispatcher dispatcher = context.getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}
}
