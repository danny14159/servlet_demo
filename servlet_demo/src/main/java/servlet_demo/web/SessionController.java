package servlet_demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ses")
public class SessionController {
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping("/set")
	public Object ssetSession(String userName){
		httpSession.setAttribute("userName", userName);
		return httpSession.getId();
	}
	
	@RequestMapping("/get")
	public String ggetSession(){
		return (String) httpSession.getAttribute("userName");
	}

}
