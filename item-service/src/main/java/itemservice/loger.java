package itemservice;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.catalina.Session;


@WebServlet("/loger")
public class loger extends HttpServlet {
	@Resource(name = "jdbc/web_item")
	private DataSource DS;
	private usersUtil userUtil; 
	public void init() throws ServletException {
		userUtil= new usersUtil(DS);
	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			String userInput =request.getParameter("un"); 
			String passinput =request.getParameter("pass");
			HttpSession session = request.getSession();
			String log="yes";
		List<users> findUser=userUtil.getAllUsers();
		for(users u:findUser) {
		if(u.getUser_name().equals(userInput)&& u.getPassword().equals(passinput)) {
			String check=request.getParameter("keep");
			if(check!=null) {
				String t="true";
			Cookie coo=new Cookie("go",t);
			coo.setMaxAge(5*60*60);
			response.addCookie(coo);

			session.setAttribute("login", log);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ItemController");
			dispatcher.forward(request, response);
			
			}
			
			else {
				session.setAttribute("login", log);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ItemController");
				dispatcher.forward(request, response);
			}
			
		}
		
		}
			RequestDispatcher dispatcher = request.getRequestDispatcher("theFirst");
			dispatcher.forward(request, response);
		
		
		
				
			}catch(Exception e) {
				System.out.println(e.getMessage());	
			}
	}
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
