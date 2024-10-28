package itemservice;
import javax.servlet.http.Cookie;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/theFirst")
public class theFirst extends HttpServlet {
	
       
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String val = null;
		Cookie[] coo=request.getCookies();
		if(coo!=null) {			
			for(int i=0;i<coo.length;i++) {
				if(coo[i].getName().equals("go")) {
				val=coo[i].getValue().toString();
				break;
				}
			}
		}
		
		if(val=="true") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("ItemController");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
