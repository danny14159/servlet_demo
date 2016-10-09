package servlet_demo.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String month = req.getParameter("month");
		if(month == null || "".equals(month)){
			req.setAttribute("msg", "未输入月份");
		}
		else{
			req.setAttribute("msg", "输入的是"+month+"月");
		}
		
		req.getRequestDispatcher("hello.jsp").forward(req, resp);
	}

	
	
}
