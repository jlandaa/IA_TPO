package local.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClasesVO.ArticuloVO;
import webservice.ArticulosBusinessDelegate;

/**
 * Servlet implementation class ListarArticulosServlet
 */
@WebServlet("/ListarArticulosServlet")
public class ListarArticulosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarArticulosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ArticuloVO> articulos = new ArrayList<ArticuloVO>();

		try {
			
			//Obtengo todos los articulos que tengo en el sistema
			articulos = ArticulosBusinessDelegate.getInstance().listar();

		} catch (Exception e) {
		
			e.printStackTrace();
		}

		request.setAttribute("articulos", articulos);

		// Se envian al JSP correspondiente para que muestre los resultados
		// obtenidos
		RequestDispatcher dispatcher = request.getRequestDispatcher("Articulos/listar-articulos.jsp");

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
