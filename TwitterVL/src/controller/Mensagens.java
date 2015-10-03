package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;


@WebServlet("/mensagens")
public class Mensagens extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<String> msgs;
	private ArrayList<String> msgs2;
	private Usuario user;
	
	public Mensagens() {
		super();
		msgs = new ArrayList<String>();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(); 
		String msg = request.getParameter("mensagem");
		
		user = (Usuario) sessao.getAttribute("user");

		if(user.getLogin().equals("veve")){		
			user.addMensagens(msg);
			sessao.setAttribute("msgs", user.getMensagens());
		}
		else{
			user.addMensagens(msg);
			sessao.setAttribute("msgs2", user.getMensagens());
		}
		
		response.sendRedirect(request.getContextPath() + "/perfil.jsp");
	}

}
