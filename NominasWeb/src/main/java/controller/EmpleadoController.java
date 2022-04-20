package controller;

import persistence.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller")
public class EmpleadoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	public void init() {
    	
    }
	
    public EmpleadoController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "getEmpleadoAll": {

			request.setAttribute("listaEmp", EmpleadoDAO.getEmpleadoAll());
			
			RequestDispatcher rd = request.getRequestDispatcher("mostrarEmpleados.jsp");
			rd.forward(request, response);
			
			break;
		}

		case "searchEmpleado": {

			RequestDispatcher rd = request.getRequestDispatcher("buscarEmpleados.jsp");
			rd.forward(request, response);

			break;
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		String dni = request.getParameter("dni");

		switch (opcion) {
		case "getSalario": {

			request.setAttribute("emp", EmpleadoDAO.getEmpleado(dni));
			request.setAttribute("salario", EmpleadoDAO.getSalario(dni));

			RequestDispatcher rd = request.getRequestDispatcher("mostrarSalario.jsp");
			rd.forward(request, response);

			break;
		}
		}
	}
}
