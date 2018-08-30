package org.itstep.javaee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.itstep.javaee.dao.DBConnect;
import org.itstep.javaee.dao.UsuarioDao;
import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario create(Usuario usuario) throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "insert into usuario (nome, cpf, telefone, endereco) values (?, ?, ?,?)";
		try {
			PreparedStatement comandoJdbc = conexaoBD.prepareStatement(comandoSql);
			comandoJdbc.setString(1, usuario.getNome());
			comandoJdbc.setInt(2, usuario.getCpf());
			comandoJdbc.setString(3, usuario.getTelefone());
			comandoJdbc.setString(4, usuario.getEndereco());
			comandoJdbc.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Inclus�o do Usu�rio falhou.", e); 
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conex�o com o banco de dados falhou.", e); 
			}
		}
		return usuario;
	}

	@Override
	public Usuario delete(Usuario usuario) throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "delete from usuario where cpf = ?";
		try {
			PreparedStatement comandoJdbc = conexaoBD.prepareStatement(comandoSql);
			comandoJdbc.setInt(1, usuario.getCpf());
			comandoJdbc.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Exclus�o do Usu�rio falhou.", e); 
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conex�o com o banco de dados falhou.", e); 
			}
		}
		return usuario;
	}

	@Override
	public List<Usuario> findByAll() throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "select nome, cpf, telefone, endereco from usuario";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement comandoJdbc = conexaoBD.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = comandoJdbc.executeQuery(comandoSql);
			while (rs.next()) {
				usuarios.add(new Usuario(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			throw new DaoException("Leitura do usu�rios falhou.", e); 
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conex�o com o banco de dados falhou.", e); 
			}
		}
		return usuarios;
	}
	
	
}
