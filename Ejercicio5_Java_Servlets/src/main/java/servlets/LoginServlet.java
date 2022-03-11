package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Usuario;
import datos.Usuarios;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		
		if (username.equals("")) username = null;
		if (password.equals("")) password = null;
		
		Usuario user = new Usuario();
		user.setUsername(username);
		user.setPassword(password);
		
		Usuarios usuarios = new Usuarios();
		RequestDispatcher rd = null;
		
		for (int i = 0; rd == null && i < usuarios.getUsuarios().size(); i++) {
			Usuario userCheck = usuarios.getUsuarios().get(i);
			String name = user.getUsername();
			String passwd = user.getPassword();
			
			if (name != null && passwd != null && name.equals(userCheck.getUsername()) && passwd.equals(userCheck.getPassword())) {
				rd = request.getRequestDispatcher("bienvenida.jsp");
				request.setAttribute("User", user);
			}
			else {
				rd = request.getRequestDispatcher("error.html");
			}
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
