package com.crud.controller;

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

import com.crud.dao.ProductoDAO;
import com.crud.model.Producto;

/**
 * Servlet implementation class ProductoController
 */
@WebServlet("/Producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "crear": {

			crear(request, response);

			break;
		}
		case "registrar": {
			
			registrar(request, response);
			
			break;
		}
		
		case "showeditar": {
			
			showeditar(request, response);
			
			break;
		}
		
		case "editar": {
			
			editar(request, response);
			
			break;
		}
		
		case "eliminar": {
			
			eliminar(request, response);
			
			break;
		}

		case "listar": {

			listar(request, response);		 

			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
	//Metodo que me redirecciona a la vista para crear un nuevo producto
	public void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Creo un RequestDispatcher para realizar la redireccion y enviar tambien las peticiones request
		RequestDispatcher rd = request.getRequestDispatcher("/views/crear.jsp");
		rd.forward(request, response);
	}
	
	//Metodo que me registra el producto en la base de datos
	public void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Instancio la clase ProductoDAO donde se encuentra los metodos crud
		ProductoDAO dao = new ProductoDAO();
		// Creo una clase producto ya que es lo que se almacena en los metodos crud
		Producto p = new Producto();
		// Creo la fecha actual
		Date fechaActual = new Date();

		// Obtengo los datos enviados del formulario
		String nombre = request.getParameter("nombre");
		double cantidad = Double.parseDouble(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));

		// Guardo los datos del formulario en la clase Producto
		p.setNombre(nombre);
		p.setCantidad(cantidad);
		p.setPrecio(precio);
		p.setFecha_crear(new java.sql.Date(fechaActual.getTime()));

		try {
			// Guardo el Producto
			dao.crear(p);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		//redirecciono
		RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	//Metodo que me lista los productos almacenados en mi base de datos
	public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Intancio el ProductoDao donde se encuentra el metodo para listar
		ProductoDAO dao = new ProductoDAO();
		// Creo un array de productos donde se almacenaran mis productos
		List<Producto> lista = new ArrayList<Producto>();

		try {
			// Obtengo los productos
			lista = dao.listar();

			//for (Producto producto : lista) {
			//System.out.println(producto);
			//}

			//paso los datos del servlet al jsp (Controlador a la vista listar.jsp)
			request.setAttribute("listaProducto", lista);
			// redirecciono enviando los datos a la vista
			RequestDispatcher rd = request.getRequestDispatcher("/views/listar.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	//Metodo para redireccionar a la vista de editar
	public void showeditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO dao = new ProductoDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Producto p = new Producto();
		
		try {
			p = dao.ObtenerProducto(id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//paso los datos del servlet al jsp (Controlador a la vista listar.jsp)
		request.setAttribute("producto", p);
		
		// Creo un RequestDispatcher para realizar la redireccion y enviar tambien las peticiones request
		RequestDispatcher rd = request.getRequestDispatcher("/views/editar.jsp");
		rd.forward(request, response);
		
	}
	
	public void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Instancio la clase ProductoDAO donde se encuentra los metodos crud
		ProductoDAO dao = new ProductoDAO();
		// Creo una clase producto ya que es lo que se almacena en los metodos crud
		Producto p = new Producto();
		// Creo la fecha actual
		Date fechaActualizar = new Date();
		
		// Obtengo los datos enviados del formulario
		String nombre = request.getParameter("nombre");
		double cantidad = Double.parseDouble(request.getParameter("cantidad"));
		double precio = Double.parseDouble(request.getParameter("precio"));
		int id = Integer.parseInt(request.getParameter("id"));
		
		// Guardo los datos del formulario en la clase Producto
		p.setNombre(nombre);
		p.setCantidad(cantidad);
		p.setPrecio(precio);
		p.setFecha_crear(new java.sql.Date(fechaActualizar.getTime()));
		p.setId(id);
		
		//Actualizo el Producto
		try {
			dao.editar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//redirecciono
		listar(request, response);
	}
	
	public void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductoDAO dao = new ProductoDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			dao.eliminar(id);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		//redirecciono
		listar(request, response);
	}

}
