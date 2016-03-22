package br.com.hamburgueria.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.hamburgueria.objs.Funcionario;
import br.com.hamburgueria.objs.Usuario;
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
    	
    	Usuario usuario = new Usuario();
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
				sessao.setAttribute("cod", usuario.getCod());
    			response.getOutputStream().println("Usuário");
    		}else if(service.buscarLoginFuncionario(func)){
				sessao.setAttribute("nome", func.getNomeFuncionario());
				sessao.setAttribute("administrador", func.getAdministrador());
				sessao.setAttribute("cod", func.getCodfuncionario());
				sessao.setAttribute("funcionario", "1");
    			response.getOutputStream().println("Funcionário");
    		} else{
    			response.getOutputStream().println("Olá");
    		}
    	}catch(Exception e){
    		response.sendRedirect(context + "/index.html");
    	}
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request, response);
	}
}
