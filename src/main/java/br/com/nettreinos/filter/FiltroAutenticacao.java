package br.com.nettreinos.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes={DispatcherType.REQUEST} , urlPatterns={"/*"})

public class FiltroAutenticacao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
		HttpServletResponse httpResp = (HttpServletResponse) resp;
		HttpServletRequest httpReq = (HttpServletRequest) req;
		
		String uri = httpReq.getRequestURI();
		HttpSession sessao = httpReq.getSession(false);
		
		if(sessao!=null || 
				uri.lastIndexOf("index.html")!=-1 || 
				uri.lastIndexOf("loginController.do")!=-1 || 
				uri.lastIndexOf("CriarUsuario.html")!=-1 ||
				uri.lastIndexOf("usuarionovocontroller.do")!=-1 ){
			chain.doFilter(req, resp);
		}else {
			httpResp.sendRedirect("index.html");
		}
	}
	
	@Override
	public void destroy(){
		
	}
}
