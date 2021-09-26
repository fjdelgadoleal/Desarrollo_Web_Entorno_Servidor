package es.iessoterohernandez.daw.dwes.accesobbdd_singleton_dao.main;

import es.iessoterohernandez.daw.dwes.accesobbdd_singleton_dao.db.ClassicModelsDAO;
import es.iessoterohernandez.daw.dwes.accesobbdd_singleton_dao.db.ConexionBD;

/**
 * 
 * @author pekechis
 * The sourde code from this project has been develop by pekechis
 *
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("-----------------------------");
		System.out.println("LISTA DE EMPLEADOS");
		System.out.println(ClassicModelsDAO.getEmpleados());
		System.out.println("-----------------------------");

		System.out.println("-----------------------------");
		System.out.println("LISTA DE OFICINAS");
		System.out.println(ClassicModelsDAO.getOffices());
		System.out.println("-----------------------------");

		// Cierro cualquier conexión que se haya abierto en otro lado
		ConexionBD.close();
	}

}
