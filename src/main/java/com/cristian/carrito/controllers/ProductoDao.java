package com.cristian.carrito.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cristian.carrito.models.Cliente;
import com.cristian.carrito.models.ElementoDeCarrito;
import com.cristian.carrito.models.Producto;

public class ProductoDao implements DaoInterface<Producto> {

	private List<Producto> listaProductos = new ArrayList<>();

	private String user;
	private String password;
	private String url;
	private Connection conn;
	private String sql;
	private int rowsAffected;
	private Statement stmt;
	private PreparedStatement preparedStatement;
	private ResultSet rs;

	public ProductoDao() {
		// initialize driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Fail to initialize Oracle JDBC driver in ClienteDao: " + e.toString());
		}

		user = "root";
		password = "0000";
		url = "jdbc:mysql://localhost:3306/partes";

		// connect
		conn = null;
		try {
			this.conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Connection failed in ClienteDao: " + e.toString());
		}

		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public List<Producto> getNProductsOrderBy(int init, int cuantity, String orden) {
		listaProductos = new ArrayList<>();
		
		if(orden.equals("id")) {
			sql = "SELECT * FROM productos ORDER BY ? ASC LIMIT ?, ?";
		} else if(orden.equals("ASC") || orden.equals("ASC")){
			sql = "SELECT * FROM productos ORDER BY precio ? LIMIT ?, ?";
		} else if(orden.equals("destacado")) {
			orden = "true";
			sql = "SELECT * FROM productos WHERE destacado = ? LIMIT ?, ?";
		}
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, orden);
			stmt.setInt(1, init);
			stmt.setInt(2, cuantity);
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					Producto producto = getProducto(rs);
					listaProductos.add(producto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return listaProductos;
	}

	
	public void saveAll(List<Producto> productosLista) {

		for (Producto p : productosLista) {
			save(p);
		}
		closeConnection();
	}

	@Override
	public Producto get(Producto t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Producto producto) {
		sql = "INSERT INTO productos (nombre, precio, img, destacado) VALUES (?, ?, ?, ?)";
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, producto.getNombre());
			preparedStatement.setDouble(2, producto.getPrecio());
			preparedStatement.setString(3, producto.getImg());
			preparedStatement.setBoolean(4, producto.isDestacado());

			rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				// System.out.println("Producto insertado correctamente");
			} else {
				System.out.println("Error al insertar Producto");
			}
		} catch (SQLException e) {
			System.out.println("Error al insertar el cliente en ClienteDao: " + e.getMessage());
		}

	}

	@Override
	public void update(Producto t, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Producto t) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Producto> getAll() {
		listaProductos = new ArrayList<>();
		sql = "SELECT * FROM productos";
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Producto producto = getProducto(rs);
				listaProductos.add(producto);
			}
		} catch (SQLException e1) {
			System.out.println("SQL exception en ClienteDao");
			e1.printStackTrace();
		} finally {
			closeConnection();
		}
		return listaProductos;
	}

	public ElementoDeCarrito getByid(int codigo) throws SQLException {
		Producto newProducto = null;
		System.out.println("CODIGO = " + codigo);
		ElementoDeCarrito elementoDeCarrito = new ElementoDeCarrito();
		sql = "SELECT * FROM productos WHERE codigo = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, codigo);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					newProducto = getProducto(rs);
					elementoDeCarrito.setProducto(newProducto);
				}
			}
		}

		return elementoDeCarrito;
	}

	public Producto getProducto(ResultSet rs) throws SQLException {
		Producto newProducto = new Producto();
		newProducto.setCodigo(rs.getInt("codigo"));
		newProducto.setNombre(rs.getString("nombre"));
		newProducto.setPrecio(Double.parseDouble(rs.getString("precio")));
		newProducto.setImg(rs.getString("img"));
		newProducto.setDestacado(rs.getBoolean("destacado"));
		return newProducto;
	}

	public void closeConnection() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			conn.close();
		} catch (SQLException e) {
			System.out.println("Close connection error in ClienteDao");
			e.printStackTrace();
		}
	}

}
