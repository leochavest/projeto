package org.itstep.javaee.dao;

import java.util.List;

import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.model.Cardapio;

public interface CardapioDao {
	public Cardapio create(Cardapio cardapio) throws DaoException;

	public List<Cardapio> findByAll() throws DaoException;

	Cardapio delete(Cardapio cardapio) throws DaoException;
}
