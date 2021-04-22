package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crud.conexion.Conexion;
import com.crud.model.Producto;


public class ProductoDAO {
	
	//creo un variable de tipo Connection para realizar la conexion a la base de datos
	private Connection connection;
	//creo otra variable para realizar las sentencias SQL
	private PreparedStatement statement;
	private boolean estadoOperacion;
	
	/*
	 * DIFERENCIA EN STATEMENT Y PREPAREDSTATEMENT
	 * CON STATEMENT -> SE ESCRIBE DIRECTAMENTE LA SETENCIA SQL POR EJEMPLO sql = "SELECT * FROM ejemplo";
	 * CON PREPAREDSTATEMENT -> ES ESCRIBE LA SECUENCIA SQL POR PARAMETROS POR EJEMPLO sql = "SELECT * FROM ejemplo WHERE nombre = ?"
	 * */
	
	//Crear Producto
	public boolean crear(Producto p) throws SQLException {
		//creamos una variable donde guardaremos la setencia SQL
		String sql = null;
		estadoOperacion = false;
		//realizamos la conexion con base de datos
		connection = ObtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			
			sql = "INSERT INTO productos (id, nombre, cantidad, precio, fecha_crear, fecha_actualizar) VALUES (?, ?, ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, null);
			statement.setString(2, p.getNombre());
			statement.setDouble(3, p.getCantidad());
			statement.setDouble(4, p.getPrecio());
			statement.setDate(5, p.getFecha_crear());
			statement.setDate(6, p.getFecha_actualizar());
			
			//ejecuto la setencia query
			if(statement.executeUpdate() > 0) {
				 estadoOperacion = true; 
			}
			 			
			//cerramos la conexion con la base de datos
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			//si falla la conexion hacemos un rollback para dejar la base de datos en el estado anterior
			connection.rollback();
			e.printStackTrace();
		}
			
						
		return estadoOperacion;
	}
	
	//Editar Producto
	public boolean editar(Producto p) throws SQLException {
		//creamos una variable donde guardaremos la setencia SQL
		String sql = null;
		estadoOperacion = false;
		//realizamos la conexion con base de datos
		connection = ObtenerConexion();
		
		try {
			connection.setAutoCommit(false);
			
			sql = "UPDATE productos SET nombre=?, cantidad=?, precio=?, fecha_actualizar=? WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, p.getNombre());
			statement.setDouble(2, p.getCantidad());
			statement.setDouble(3, p.getPrecio());
			statement.setDate(4, p.getFecha_actualizar());
			statement.setInt(5, p.getId());
			
			//ejecuto la setencia query			
			if(statement.executeUpdate() > 0) {
				 estadoOperacion = true; 
			}
			
			//cerramos la conexion con la base de datos
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			//si falla la conexion hacemos un rollback para dejar la base de datos en el estado anterior
			connection.rollback();
			e.printStackTrace();
		}
		
		
		return estadoOperacion;
	}
	
	//Eliminar Producto
	public boolean eliminar(int idProducto) throws SQLException {
		//creamos una variable donde guardaremos la setencia SQL
		String sql = null;
		estadoOperacion = false;
		//realizamos la conexion con base de datos
		connection = ObtenerConexion();
				
		try {
			connection.setAutoCommit(false);
			
			sql = "DELETE FROM productos WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProducto);
			
			//ejecuto la setencia query			
			if(statement.executeUpdate() > 0) {
				 estadoOperacion = true; 
			}
			
			//cerramos la conexion con la base de datos
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			//si falla la conexion hacemos un rollback para dejar la base de datos en el estado anterior
			connection.rollback();
			e.printStackTrace();
		}
		
		
		return estadoOperacion;
	}
	
	//Ver Producto
	public Producto ObtenerProducto(int idProducto) throws SQLException {
		//creo una variable donde se almacenara todo los registros de la base de datos
		ResultSet resultset = null;
		//creamos un objeto producto donde almacenaremos el producto listado
		Producto p = new Producto();
		//creamos una variable donde guardaremos la setencia SQL
		String sql = null;
		estadoOperacion = false;
		//realizamos la conexion con base de datos
		connection = ObtenerConexion();
				
		try {
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM productos WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, idProducto);
			
			resultset = statement.executeQuery();
			
			if(resultset.next()) {
				//creo un producto donde ire almacenando cada producto de mi base de datos
				p.setId(resultset.getInt(1));
				p.setNombre(resultset.getString(2));
				p.setCantidad(resultset.getDouble(3));
				p.setPrecio(resultset.getDouble(4));
				p.setFecha_crear(resultset.getDate(5));
				p.setFecha_actualizar(resultset.getDate(6));
				
			}
			
			//cerramos la conexion con la base de datos
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//devolvemos el producto
		return p;
	}
	
	//Listar Producto
	public List<Producto> listar() throws SQLException {
		//creo una variable donde se almacenara todo los registros de la base de datos
		ResultSet resultset = null;
		///creo una lista de array donde almacenare los productos listados
		List<Producto> listaProductos = new ArrayList<Producto>();
		//creamos una variable donde guardaremos la setencia SQL
		String sql = null;
		estadoOperacion = false;
		//realizamos la conexion con base de datos
		connection = ObtenerConexion();
				
		try {
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM productos";
			statement = connection.prepareStatement(sql);
			
			resultset = statement.executeQuery();
			
			while(resultset.next()) {
				//creo un producto donde ire almacenando cada producto de mi base de datos
				Producto p = new Producto();
				p.setId(resultset.getInt(1));
				p.setNombre(resultset.getString(2));
				p.setCantidad(resultset.getDouble(3));
				p.setPrecio(resultset.getDouble(4));
				p.setFecha_crear(resultset.getDate(5));
				p.setFecha_actualizar(resultset.getDate(6));
			
				//Guardamos los productos obtenidos en una lista de array
				listaProductos.add(p);
			}
			
			//cerramos la conexion con la base de datos
			connection.commit();
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//devolvemos la lista de array
		return listaProductos;
			
	}
	
	//Metodo para realizar la conexion 
	@SuppressWarnings("unused")
	private Connection ObtenerConexion() throws SQLException {
		//nos devuelve la conexion
		return Conexion.getConnection();
	}
}
