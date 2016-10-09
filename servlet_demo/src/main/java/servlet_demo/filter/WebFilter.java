package servlet_demo.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
class Book implements Comparable<Book>{
	private Date time;
	
	@Override
	public int compareTo(Book o) {
		return (int)(  o.getTime().getTime() -  this.getTime().getTime());
	}
	
	@Override
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(time);
	}
}
@javax.servlet.annotation.WebFilter(value="/*")
public class WebFilter implements Filter{
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Object arr[] = Arrays.asList(
				new Book(new Date()),
				new Book(new Date( new Date().getTime() - 222000 )))
				
			.toArray();
		Arrays.sort( arr  );
		
		for(Object arr_:arr){
			System.out.println(arr_);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		
		request.getParameter("month");
		HttpServletRequest reHttpServletRequest = (HttpServletRequest)request;
		System.out.println(reHttpServletRequest.getRequestURL());  //打印请求地址
		//if(!httpServletResponse.isCommitted()){
			//httpServletResponse.sendError(500);
			chain.doFilter(request, httpServletResponse);
			return;
		//}
	}

	public void destroy() {
		
	}

}
