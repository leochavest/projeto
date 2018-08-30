package org.itstep.javaee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.itstep.javaee.dao.CardapioDao;
import org.itstep.javaee.dao.DBConnect;
import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.model.Cardapio;

public class CardapioDaoImpl implements CardapioDao {

	@Override
	public Cardapio create(Cardapio cardapio) throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "insert into usuario (id, proteina, acompanhamentos ) values (?, ?, ?)";
		try {
			PreparedStatement comandoJdbc = conexaoBD.prepareStatement(comandoSql);
			comandoJdbc.setInt(1, cardapio.getId());
			comandoJdbc.setString(2, cardapio.getProteina());
			comandoJdbc.setString(3, cardapio.getAcompanhamentos());
			comandoJdbc.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Inclusão do Cardapio falhou.", e);
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conexão com o banco de dados falhou.", e);
			}
		}
		return cardapio;
	}

	@Override
	public Cardapio delete(Cardapio cardapio) throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "delete from cardapio where id = ?";
		try {
			PreparedStatement comandoJdbc = conexaoBD.prepareStatement(comandoSql);
			comandoJdbc.setInt(1, cardapio.getId());
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
		return cardapio;
	}

	@Override
	public List<Cardapio> findByAll() throws DaoException {
		Connection conexaoBD = DBConnect.getConnection();
		String comandoSql = "select id, idCardapio, cpf from usuario";
		List<Cardapio> cardapios = new ArrayList<Cardapio>();
		try {
			Statement comandoJdbc = conexaoBD.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = comandoJdbc.executeQuery(comandoSql);
			while (rs.next()) {
				cardapios.add(new Cardapio(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			throw new DaoException("Leitura do cardapio falhou.", e);
		} finally {
			try {
				conexaoBD.close();
			} catch (SQLException e) {
				throw new DaoException("Close da conexão com o banco de dados falhou.", e);
			}
		}
		return cardapios;

	}

}
