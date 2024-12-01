package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.EntidadUsuario;

public class UsuarioDAO {
	public void insertarUsuario(String nombre, String appaterno, String apmaterno, int edad) {
		
		Connection con = null;
		PreparedStatement psm = null;
		
		try {
			con = ConexionDAO.obtenerConexion();
			String sql = "INSERT INTO usuarios(nombres, appaterno, apmaterno, edad) VALUES (?,?,?,?)";
			psm = con.prepareStatement(sql);
			
			psm.setString(1, nombre);
			psm.setString(2, appaterno);
			psm.setString(3, apmaterno);
			psm.setInt(4, edad);
			
			psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConexionDAO.cerrarConexion(con);
			try {
				if(psm != null) psm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	public List<EntidadUsuario> obtenerUsuarios(){
		List<EntidadUsuario> usuarios = new ArrayList<>();
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			con = ConexionDAO.obtenerConexion();
			String sql = "select * from usuarios";
			psm = con.prepareStatement(sql);
			rs = psm.executeQuery();
			
			while(rs.next()) {
				EntidadUsuario usuario = new EntidadUsuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNombres(rs.getString("nombres"));
				usuario.setAppaterno(rs.getString("appaterno"));
				usuario.setApmaterno(rs.getString("apmaterno"));
				usuario.setEdad(rs.getInt("edad"));
				
				usuarios.add(usuario);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConexionDAO.cerrarConexion(con);
			try {
				if(psm != null) psm.close();
				if(rs != null) rs.close();

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return usuarios;
	}
	
	public void modificarUsuario(int id,String nombre, String appaterno, String apmaterno, int edad) {
		
		Connection con = null;
		PreparedStatement psm = null;
		
		try {
			con = ConexionDAO.obtenerConexion();
			String sql = "UPDATE usuarios SET nombres= ?, appaterno=?, apmaterno=?, edad=? WHERE id=?";
			psm = con.prepareStatement(sql);
			
			psm.setString(1, nombre);
			psm.setString(2, appaterno);
			psm.setString(3, apmaterno);
			psm.setInt(4, edad);
			psm.setInt(5, id);
			
			psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConexionDAO.cerrarConexion(con);
			try {
				if(psm != null) psm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	public void eliminarUsuario(int id) {
		
		Connection con = null;
		PreparedStatement psm = null;
		
		try {
			con = ConexionDAO.obtenerConexion();
			String sql = "DELETE FROM usuarios where id=?";
			psm = con.prepareStatement(sql);
		
			psm.setInt(1, id);
			
			psm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ConexionDAO.cerrarConexion(con);
			try {
				if(psm != null) psm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
}
