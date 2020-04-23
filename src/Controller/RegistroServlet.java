package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GenericDao;
import DAO.UsuarioDao;
import model.Usuario;

/**
 * Servlet implementation class RegistroServlet
 */
@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuarioTxt = request.getParameter("usuario");
		String claveTxt = request.getParameter("clave");
		String nombreTxt = request.getParameter("nombre");
		String direccionTxt = request.getParameter("direccion");
		String telefonoTxt = request.getParameter("telefono");
		String correoTxt = request.getParameter("email");
		
		Usuario usuario = new Usuario();
		usuario.setUsuario(usuarioTxt);		
		usuario.setClave(claveTxt);
		usuario.setCorreo(correoTxt);
		usuario.setDireccion(direccionTxt);
		usuario.setNombre(nombreTxt);		
		usuario.setTelefono(telefonoTxt);
		
		System.out.println("Aca prueba");
		GenericDao usuarioDao = new UsuarioDao();
		usuarioDao.insert(usuario);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
