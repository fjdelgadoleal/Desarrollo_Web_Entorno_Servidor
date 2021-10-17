package es.iessoterohernandez.daw.dwes.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import es.iessoterohernandez.daw.dwes.dao.ProductoDAO;
import es.iessoterohernandez.daw.dwes.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet(urlPatterns = "/productos")
public class ProductoController extends HttpServlet {
 private static final long serialVersionUID = 1L;
 private static final Logger logger = Logger.getLogger(ProductoController.class); 
 
 /**
  * @see HttpServlet#HttpServlet()
  */
 public ProductoController() {
  super();
  BasicConfigurator.configure();

  // TODO Auto-generated constructor stub
 }
 
 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  // TODO Auto-generated method stub
 
  String opcion = request.getParameter("opcion");
 
  if (opcion.equals("crear")) {
   logger.info("Usted a presionado la opcion crear");
   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
   requestDispatcher.forward(request, response);
  } else if (opcion.equals("listar")) {
 
   ProductoDAO productoDAO = new ProductoDAO();
   List<Producto> lista = new ArrayList<>();
   try {
	logger.info("Leyendo la lista de productos de la base de datos");
    lista = productoDAO.obtenerProductos();
    request.setAttribute("lista", lista);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
    requestDispatcher.forward(request, response);
 
   } catch (SQLException e) {
	logger.error("Error al leer la lista de productos de la base de datos");
    e.printStackTrace();
   }
 
   logger.info("Usted a presionado la opcion listar");
  } else if (opcion.equals("meditar")) {
   int id = Integer.parseInt(request.getParameter("id"));
   logger.info("Editar id: " + id);
   ProductoDAO productoDAO = new ProductoDAO();
   Producto p = new Producto();
   try {
    p = productoDAO.obtenerProducto(id);
    logger.info(p);
    request.setAttribute("producto", p);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
    requestDispatcher.forward(request, response);
 
   } catch (SQLException e) {
	logger.error("Error al leer el producto de la base de datos");
    e.printStackTrace();
   }
 
  } else if (opcion.equals("eliminar")) {
   ProductoDAO productoDAO = new ProductoDAO();
   int id = Integer.parseInt(request.getParameter("id"));
   try {
    productoDAO.eliminar(id);
    logger.info("Registro eliminado satisfactoriamente...");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
    requestDispatcher.forward(request, response);
   } catch (SQLException e) {
	logger.error("Error al eliminar el producto de la base de datos");
    e.printStackTrace();
   }
 
  }
 }
 
 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
  *      response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  // TODO Auto-generated method stub
  String opcion = request.getParameter("opcion");
  Date fechaActual = new Date();
 
  if (opcion.equals("guardar")) {
   ProductoDAO productoDAO = new ProductoDAO();
   Producto producto = new Producto();
   producto.setNombre(request.getParameter("nombre"));
   producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
   producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
   producto.setFechaCrear(new java.sql.Date(fechaActual.getTime()));
   try {
    productoDAO.guardar(producto);
    logger.info("Registro guardado satisfactoriamente...");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
    requestDispatcher.forward(request, response);
 
   } catch (SQLException e) {
	logger.error("Error al guardar el producto de la base de datos");
    e.printStackTrace();
   }
  } else if (opcion.equals("editar")) {
   Producto producto = new Producto();
   ProductoDAO productoDAO = new ProductoDAO();
 
   producto.setId(Integer.parseInt(request.getParameter("id")));
   producto.setNombre(request.getParameter("nombre"));
   producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
   producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
   producto.setFechaActualizar(new java.sql.Date(fechaActual.getTime()));
   try {
    productoDAO.editar(producto);
    logger.info("Registro editado satisfactoriamente...");
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
    requestDispatcher.forward(request, response);
   } catch (SQLException e) {
	logger.error("Error al editar el producto en la base de datos");
    e.printStackTrace();
   }
  }
 
  // doGet(request, response);
 }
 
}
