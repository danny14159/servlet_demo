package servlet_demo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/world")
public class RedirectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Enumeration<String> attributeNames = req.getParameterNames();
		String result = "";
		while(attributeNames.hasMoreElements()){
			String key = attributeNames.nextElement();
			System.out.println(key);
			System.out.println(req.getParameter(key));
			result += key + ":"+req.getParameter(key);
		}	
		
		System.out.println(req.getInputStream());
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("hello");
		out.println("</body>");
		out.println("</html>");
		
	}
}
