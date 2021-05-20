package co.parcial.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.empresa.TestCrud.modelo.Usuario;
import co.parcial.dao.countryDao;
import co.parcial.dao.cyclistDao;
import co.parcial.dao.teamDao;
import co.parcial.modelo.Country;
import co.parcial.modelo.Cyclist;
import co.parcial.modelo.Team;

/**
 * Servlet implementation class CyclistServlet
 */
@WebServlet("/CyclistServlet")
public class CyclistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private cyclistDao cyclistdao;
	private teamDao teamdao;
	private countryDao countrydao;
	

	public CyclistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(ServletConfig config) throws ServletException {
		this.cyclistdao = new cyclistDao();
		this.countrydao = new countryDao();
		this.teamdao = new teamDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertarCyclist(request, response);
				break;
			case "/delete":
				eliminarCyclist(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				actualizarCyclists(request, response);
				break;
			default:
				listCyclists(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	private void listCyclists(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException,ServletException, IOException{
		List<Cyclist>listcyclist = cyclistdao.selectAll();
		request.setAttribute("listcyclist", listcyclist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cyclistlist.jsp");
		dispatcher.forward(request, response);
		

	}

	private void actualizarCyclists(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cyclistdao.delete(id);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cyclist cyclistactual = cyclistdao.select(id);
		request.setAttribute("cyclist", cyclistactual);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);

	}

	private void eliminarCyclist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		cyclistdao.delete(id);
		response.sendRedirect("list");
	}

	private void insertarCyclist(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, IOException {
			String name = request.getParameter("nombre");
			String email = request.getParameter("email");
			String country = request.getParameter("country");
			String birthdate = request.getParameter("birthdate");
			String team = request.getParameter("team");
			Cyclist cyclist = new Cyclist(0, name, email, birthdate, country, team);
			cyclistdao.insert(cyclist);
			response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Country> listaCountrys = countrydao.selectAll();
		List<Team> listaTeams = teamdao.selectAll();
		request.setAttribute("listaTeams", listaTeams);
		request.setAttribute("listaCountrys", listaCountrys);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cyclist.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
