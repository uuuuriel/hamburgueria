package br.com.hamburgueria.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.objs.Cliente;
import br.com.hamburgueria.service.LoginService;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String context = request.getServletContext().getContextPath();
    	
    	Cliente usuario = new Cliente();
    	Funcionario func = new Funcionario();
    	usuario.setEmail(request.getParameter("email"));
    	usuario.setSenha(request.getParameter("senha"));
    	func.setEmail(request.getParameter("email"));
    	func.setSenha(request.getParameter("senha"));
    	
    	try{
    		LoginService service = new LoginService(request);
    		HttpSession sessao = request.getSession(true);
    		if(service.buscarLoginUsuario(usuario)){
    			sessao.setAttribute("nome", usuario.getNome());
				sessao.setAttribute("administrador", "0");
				sessao.setAttribute("cod", Integer.toString(usuario.getCod()));
				sessao.setAttribute("funcionario", "0");
				sessao.setAttribute("log", "4");
				sessao.setAttribute("admRest", "0");
    		}else if(service.buscarLoginFuncionario(func)){
				sessao.setAttribute("nome", (String)func.getNome());
				sessao.setAttribute("administrador", Integer.toString(func.getAdministrador()));
				sessao.setAttribute("cod", Integer.toString(func.getCodfuncionario()));
				sessao.setAttribute("funcionario", "1");
				sessao.setAttribute("log", "4");
				sessao.setAttribute("admRest", Integer.toString(func.getAdministrador()));
    		} else{
    			response.getOutputStream().print(true);
    		}
    	}catch(Exception e){
    		response.sendRedirect(context + "/index");
    	}
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
}
