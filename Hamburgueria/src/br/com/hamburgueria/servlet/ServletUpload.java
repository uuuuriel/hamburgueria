package br.com.hamburgueria.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ServletUpload extends HttpServlet {

	public void init() throws ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMultiPart = FileUpload.isMultipartContent(request);
		if (isMultiPart) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			String formulario = "";
			try {
				List items = upload.parseRequest(request);
				Iterator iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();
					if (item.getFieldName().equals("tipoForm")) {
						formulario = item.getString();
					}
					if (!item.isFormField()) {
						if (item.getName().length() > 0) {
							this.inserirImagemDiretorio(item, response);						
						}
					}
				}
			}
			catch (FileUploadException ex) {
				ex.printStackTrace();
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	private void inserirImagemDiretorio(FileItem item,HttpServletResponse response) throws IOException {
		String caminho = "H:/hamburgueria/Hamburgueria/WebContent/resources/uploads/";
		File diretorio = new File(caminho);
		if (!diretorio.exists()) {
			diretorio.mkdir();
		}
		String nome = item.getName();
		String arq[] = nome.split("\\\\");
		for (int i = 0; i < arq.length; i++) {
			nome = arq[i];
		}
		File file = new File(diretorio, nome);
		FileOutputStream output = new FileOutputStream(file);
		InputStream is = item.getInputStream();
		byte[] buffer = new byte[2048];
		int nLidos;
		while ((nLidos = is.read(buffer)) >= 0) {
			output.write(buffer, 0, nLidos);
		}
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println(file);  
		output.flush();
		output.close();
	}
}