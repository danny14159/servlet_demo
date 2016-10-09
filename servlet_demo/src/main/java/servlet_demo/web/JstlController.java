package servlet_demo.web;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import servlet_demo.bean.Student;

@Controller
@RequestMapping("/jstl")
public class JstlController {
	
	@Autowired
	private HttpServletRequest request;

	@RequestMapping("")
	public String jstl(){
		
		request.setAttribute("names", new String[]{"Danny","Sam","Jerry","Tom"});
		request.setAttribute("now", new Date());
		return "hello.jsp";
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String uploadFile(@RequestParam("file") MultipartFile multipartFile){
		
		try {  
            byte[] bytes = multipartFile.getBytes();  
            BufferedOutputStream stream =  
                    new BufferedOutputStream(
                    		new FileOutputStream(
                    				new File(multipartFile.getOriginalFilename())));  
            stream.write(bytes);  
            stream.close();  
        } catch (Exception e) {
        	e.printStackTrace();
        } 
		
		return "上传成功";
	}
	
	public void download(String fileName,HttpServletResponse response){
		
		
	}
	
	@RequestMapping("/stu")
	@ResponseBody
	public List<Student> listStudents(){
		
		return Arrays.asList(new Student("Danny",12),new Student("Jerry",20),new Student("Tom", 18));
	}
}
