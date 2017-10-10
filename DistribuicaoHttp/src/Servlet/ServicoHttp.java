package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServicoHttp extends HttpServlet {

	
	
	/**
	 * Mesa de ping pong
	 * @Param acao
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	      System.out.println("Serviço ativo");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		
		System.out.println("Recebendo requisição via HTTP SERVLET");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
      
      
		String acao = request.getParameter("acao") == null?"":String.valueOf(request.getParameter("acao"));
      
		String message  = "Mesa de ping pong";
		if(acao.equalsIgnoreCase("ping"))    {
			message = "Pong";
		}
      
		out.println("<h1>" + message + "</h1>");
      
   }

	
	
	
}
