package local.servlets;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClasesVO.SolicitudArticuloVO;
import webservice.SolicitudArticulosBusinessDelegate;

/**
 * Servlet implementation class ListarSolicitudesServlet
 */
@WebServlet("/ListarSolicitudesServlet")
public class ListarSolicitudesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarSolicitudesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SolicitudArticuloVO> solicitudes = null ;
		
		try {
			
			solicitudes = SolicitudArticulosBusinessDelegate.getInstance().listarSolicitudes();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("solicitudes", solicitudes);
		
		//Se envian al JSP correspondiente para que muestre los resultados obtenidos
		RequestDispatcher dispatcher = request.getRequestDispatcher("Solicitudes/listar-solicitudes.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
