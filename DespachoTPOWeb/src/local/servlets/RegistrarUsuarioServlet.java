package local.servlets;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClasesVO.UsuarioVO;
import webservice.UsuariosBusinessDelegate;

/**
 * Servlet implementation class RegistrarUsuarioServlet
 */
@WebServlet("/RegistrarUsuarioServlet")
public class RegistrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LLEGO");
		
		UsuarioVO usu = new UsuarioVO();
		usu.setUsername(request.getParameter("user"));
		usu.setNombre(request.getParameter("nombre"));
		usu.setApellido(request.getParameter("apellido"));
		usu.setPassword(request.getParameter("password"));
		
		try {
			
			//Si no existe el UsuarioVO en el Sistema
			if (usu.getUsername() != " " && UsuariosBusinessDelegate.getInstance().get(usu.getUsername()) == null){
				
				try {
					
					// Se lo agrega
					UsuariosBusinessDelegate.getInstance().agregar(usu);
					
					//Se muestra el mensaje de Exito
					RequestDispatcher dispatcher = request.getRequestDispatcher("Mensajes/MensajeExito.html");

					dispatcher.forward(request, response);
				
				} catch (NamingException e) {
					e.printStackTrace();
				}
				
			}else{
				
				//Se muestra mensaje de Error
				RequestDispatcher dispatcher = request.getRequestDispatcher("Mensajes/MensajeError.html");

				dispatcher.forward(request, response);
			}
		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
