package com.yourcodelab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourcodelab.controller.OrdemDeServicoController;
import com.yourcodelab.model.OrdemDeServico;

@WebServlet("/ListarOrdemDeServicoServlet")
public class ListarOrdemDeServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdemDeServicoController control = new OrdemDeServicoController();
		List<OrdemDeServico> ordens = control.listarTodos();
		
		request.setAttribute("listaOrdens", ordens);
		
		String nextPage = "/OrdemDeServico/listarOrdens.jsp";
		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(nextPage);
		dispacher.forward(request, response);
	}
}
