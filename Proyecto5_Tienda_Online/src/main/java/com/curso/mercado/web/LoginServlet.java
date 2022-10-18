package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(urlPatterns="login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("nombre");
		String rol = request.getParameter("rol");
		
		String msgError = "";
		
		if(usuario == null || usuario.trim().length() == 0) {
			msgError = "Debes introducir un nombre de usuario";
		}
		
		if(rol == null || !rol.equals("admin") && !rol.equals("usuario")) {
			msgError = "Debes seleccionar tu rol";
		}
		
		if(msgError.length()>0) {
			request.setAttribute("error", msgError);
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			Usuario u = new Usuario(usuario,rol);
			request.setAttribute("usuario", u);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
