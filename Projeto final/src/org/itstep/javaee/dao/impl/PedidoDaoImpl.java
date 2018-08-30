package org.itstep.javaee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.itstep.javaee.dao.DBConnect;
import org.itstep.javaee.dao.PedidoDao;
import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.model.Pedido;

public class PedidoDaoImpl implements PedidoDao{

	@Override
	public Pedido create(Pedido pedido) throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "insert into usuario (id, idCardapio, cpf ) values (?, ?, ?)";
		try {
			PreparedStatement comandoJdbc = conexaoBD.prepareStatement(comandoSql);
			comandoJdbc.setInt(1, pedido.getId());
			comandoJdbc.setInt(2, pedido.getIdCardapio());
			comandoJdbc.setInt(3, pedido.getCpf());
			comandoJdbc.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Inclusão do Usuário falhou.", e);
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conexão com o banco de dados falhou.", e);
			}
		}
		return pedido;
	}
	@Override
	public Pedido delete(Pedido pedido) throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "delete from pedido where id = ?";
		try {
			PreparedStatement comandoJdbc = conexaoBD.prepareStatement(comandoSql);
			comandoJdbc.setInt(1, pedido.getId());
			comandoJdbc.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Exclusão do Usuário falhou.", e); 
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conexão com o banco de dados falhou.", e); 
			}
		}
		return pedido;
	}
	@Override
	public List<Pedido> findByAll() throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "select id, idCardapio, cpf from usuario";
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			Statement comandoJdbc = conexaoBD.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = comandoJdbc.executeQuery(comandoSql);
			while (rs.next()) {
				pedidos.add(new Pedido(rs.getInt(1),rs.getInt(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			throw new DaoException("Leitura do pedido falhou.", e);
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conexão com o banco de dados falhou.", e);
			}
		}
		return pedidos;
	}

}
