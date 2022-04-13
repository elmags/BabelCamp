package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.datos.Usuario;
import modelo.negocio.GestorUsuario;

@WebServlet("/usuarios/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GestorUsuario gu = new GestorUsuario();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "    " + password);

		if (username.equals("")) username = null;
		if (password.equals("")) password = null;
		
//		Map<String, Object> map = new HashMap(); 
//		json.put("validado", false);
		JSONObject json = new JSONObject();
		
		Usuario usuario = gu.get(username);
		 
		if (usuario != null && usuario.getPassword().equals(password)) {
//			map.put("validado", true);
			json.put("validado", true);
//			System.out.println(json.toString());
			System.out.println("El usuario es válido");
		} 
		else {
//			map.put("validado", false);
			json.put("validado", false);
			
//			System.out.println(json.toString());
			System.out.println("El usuario no es válido");
		}
//		JSONObject json = new JSONObject(map);
		System.out.println(json.toString());
	}

}
