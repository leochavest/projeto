package org.itstep.javaee.dao;

import java.util.List;

import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.model.Pedido;

public interface PedidoDao {
	public Pedido create(Pedido pedido) throws DaoException;
	public List<Pedido> findByAll() throws DaoException;
	Pedido delete(Pedido pedido) throws DaoException;
}
