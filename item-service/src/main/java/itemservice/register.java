package itemservice;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/register")
public class register extends HttpServlet {
	@Resource(name = "jdbc/web_item")
	private DataSource DS;
	private usersUtil userUtil; 
	public void init() throws ServletException {
		userUtil= new usersUtil(DS);
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {	
			String name1=request.getParameter("add_un");
			String pass1=request.getParameter("add_pass");	
			userUtil.addUser(name1,pass1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
