package br.com.hamburgueria.servlet;
 
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Gera uma imagem com um texto passado por parâmetro
 *
 * @author Thiago Galbiatti Vespa
 */
@WebServlet("/imagem")
public class ImagemServlet extends HttpServlet {
 
    private static final long serialVersionUID = 201011231103L;
 
    public ImagemServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("image/jpg");
 
        String text = request.getParameter("caminho");

        response.setContentType("image/jpg");  
        OutputStream out = response.getOutputStream();  
        String image = "C:/Users/uriel_augusto/Hamburgueria/Hamburgueria/WebContent/resources/uploads/"+text;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(image));
        int b;
        while( (b = in.read()) != -1) {
          out.write(b);
        }                  
        in.close();  
        out.close();
    }
 
}