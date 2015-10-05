package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

@WebServlet("/login")
public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> listaDeUsuarios = new ArrayList<>();
	
	public Autenticador() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();		
		String login = request.getParameter("username");
		String senha = request.getParameter("password");
		
		Usuario temp = new Usuario();
		
		Usuario veve = new Usuario();
		veve.setLogin("veve");
		veve.setSenha("123");
		veve.setNome("Ver�nica");
		veve.setFoto("img/ve.jpg");
		listaDeUsuarios.add(veve);
		
		Usuario luis = new Usuario();		
		luis.setLogin("luis");
		luis.setSenha("321");
		luis.setNome("Luis");	
		luis.setFoto("img/luis.jpg");
		listaDeUsuarios.add(luis);		
				
		for(Usuario u : listaDeUsuarios){
			if(u.getLogin().equals(login) && u.getSenha().equals(senha)){
				temp.setLogin(u.getLogin());
				temp.setSenha(u.getSenha());
				temp.setFoto(u.getFoto());
				temp.setNome(u.getNome());
			}
		}
		if(temp.getLogin()!=null){		
			request.getSession().setAttribute("usuario", temp);
			sessao.setAttribute("user", temp);
			response.sendRedirect(request.getContextPath() + "/perfil.jsp");
		}
		else {
			response.sendRedirect("index.html");
		}
		
	}
}
