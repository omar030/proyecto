package com.crud.conexion;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

//Creamos el Pool de conexiones
public class Conexion {
	
	//creamos un variable de tipo BasicDataSource
	private static BasicDataSource dataSource = null;
	
	//creamos un metodo de tipo DataSource donde se obtendra la conexion
	private static DataSource getDataSource() {
		
		//si el dataSource es vacio entra en la condicion y hace la conexion
		if(dataSource == null) {
			//creamos un BasicDataSource
			dataSource = new BasicDataSource();
			//Añadimos el driver 
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			//Añadimos el nombre del administrador de la base de datos
			dataSource.setUsername("root");
			//Añadimos la contraseña
			dataSource.setPassword("");
			//Añadimos la URL en la que se encuentra la base de datos
			dataSource.setUrl("jdbc:mysql://localhost:3306/crud");
			//Ponemos un numero inicial de conexiones
			dataSource.setInitialSize(20);
			//Creamos una cantidad de conexion
			dataSource.setMaxIdle(15);
			//Creamos una cantidad total de conexiones
			dataSource.setMaxTotal(20);
			//Ponemos una cantidad maxima de espera para la conexion hasta que salte error
			dataSource.setMaxWaitMillis(5000);
		}
		
		//devolvemos la conexion
		return dataSource;
	}
	
	//metodo para obtener la conexion
	public static Connection getConnection() throws SQLException {
		
		return getDataSource().getConnection();
		
	}
	
	
}
