package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import entidades.*;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		if("mostrar".equals(accion)) {
			mostrarUsuarios(request, response);
		}else if("guardar".equals(accion)) {
			System.out.println("Paso por el doget de guardar");
			mostrarUsuariosGuardar(request, response);
		}else if("modificar".equals(accion)) {
			System.out.println("Paso por el doget de guardar");
			mostrarUsuariosModificar(request, response);
		}else if("eliminar".equals(accion)) {
			System.out.println("Paso por el doget de guardar");
			mostrarUsuariosEliminar(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		if("guardar".equals(accion)) {
			guardarUsuarios(request, response);
		}else if("modificar".equals(accion)) {
			modificarUsuarios(request, response);
		}else if("eliminar".equals(accion)) {
			eliminarUsuarios(request, response);
		}
	}
	
	
	//Metodos para manejar la informacion
	public void guardarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nombres = request.getParameter("nombres");
		String appaterno = request.getParameter("appaterno");
		String apmaterno = request.getParameter("apmaterno");
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		usuariodao.insertarUsuario(nombres, appaterno, apmaterno, edad);
		
		mostrarUsuariosGuardar(request, response);
	}
	
	public void mostrarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		UsuarioDAO usuariodao = new UsuarioDAO();
		List<EntidadUsuario> usuarios =usuariodao.obtenerUsuarios();
		System.out.println("Paso por el mostrar");
		System.out.println(usuarios.get(0));
		request.setAttribute("listUsuario", usuarios);
		request.getRequestDispatcher("mostrarUsuarios.jsp").forward(request, response);
	}
	
	public void mostrarUsuariosGuardar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Paso por mostrar uysuarios guardar");

		UsuarioDAO usuariodao = new UsuarioDAO();
		List<EntidadUsuario> usuarios =usuariodao.obtenerUsuarios();
		System.out.println("Paso por el mostrar");
		System.out.println(usuarios.get(0));
		request.setAttribute("listUsuario", usuarios);
		request.getRequestDispatcher("guardarUsuario.jsp").forward(request, response);
	}
	
	public void modificarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		String nombres = request.getParameter("nombres");
		String appaterno = request.getParameter("appaterno");
		String apmaterno = request.getParameter("apmaterno");
		int edad = Integer.parseInt(request.getParameter("edad"));
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		usuariodao.modificarUsuario(id,nombres, appaterno, apmaterno, edad);
		
		mostrarUsuariosModificar(request, response);
	}
	
	public void mostrarUsuariosModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Paso por mostrar uysuarios guardar");

		UsuarioDAO usuariodao = new UsuarioDAO();
		List<EntidadUsuario> usuarios =usuariodao.obtenerUsuarios();
		System.out.println("Paso por el mostrar");
		System.out.println(usuarios.get(0));
		request.setAttribute("listUsuario", usuarios);
		request.getRequestDispatcher("modificarUsuarios.jsp").forward(request, response);
	}
	
	public void mostrarUsuariosEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("Paso por mostrar uysuarios guardar");

		UsuarioDAO usuariodao = new UsuarioDAO();
		List<EntidadUsuario> usuarios =usuariodao.obtenerUsuarios();
		System.out.println("Paso por el mostrar");
		System.out.println(usuarios.get(0));
		request.setAttribute("listUsuario", usuarios);
		request.getRequestDispatcher("eliminarUsuarios.jsp").forward(request, response);
	}
	
	public void eliminarUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		usuariodao.eliminarUsuario(id);
		
		mostrarUsuariosEliminar(request, response);
	}
}
