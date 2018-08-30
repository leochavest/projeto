package org.itstep.javaee.Controller;


import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.event.ListSelectionEvent;

import org.itstep.javaee.dao.PedidoDao;
import org.itstep.javaee.dao.UsuarioDao;
import org.itstep.javaee.dao.exception.DaoException;
import org.itstep.javaee.dao.impl.PedidoDaoImpl;
import org.itstep.javaee.dao.impl.UsuarioDaoImpl;
import org.itstep.javaee.model.Pedido;


/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/UsuarioServlet")
public class PedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PedidoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PedidoDao pedidoDao = new PedidoDaoImpl();
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			if (request.getParameter("operacao") != null) {
				Pedido pedido = new Pedido();
				String operacao = request.getParameter("operacao");
				if (operacao.equals("insert")) {
					Integer id=(Integer) Integer.parseInt(request.getParameter("id"));
					Integer idCardapio=(Integer) Integer.parseInt(request.getParameter("idCardapio"));
					Integer cpf=(Integer) Integer.parseInt(request.getParameter("cpf"));
					pedido.setId(id);
					pedido.setIdCardapio(idCardapio);
					pedido.setCpf(cpf);
					pedidoDao.create(pedido);
				} else if (operacao.equals("delete")) {
					Integer id=(Integer) Integer.parseInt(request.getParameter("id"));
					pedido.setId(id);
					pedidoDao.delete(pedido);
				}
			}
			pedidos = pedidoDao.findByAll();
			System.out.println(Arrays.toString(pedidos.toArray()));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("listaUsuarios", pedidos);
		RequestDispatcher rd = request.getRequestDispatcher("pedidos.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
