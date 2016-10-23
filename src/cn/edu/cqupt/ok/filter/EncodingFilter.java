package cn.edu.cqupt.ok.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName = "EncodingFilter", urlPatterns = {"/*"}, initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8")
})
public class EncodingFilter implements Filter {
	
	protected String encoding = null;

	public void destroy() {
		encoding = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html; charset="+encoding);
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.encoding = fConfig.getInitParameter("encoding");
	}

}
