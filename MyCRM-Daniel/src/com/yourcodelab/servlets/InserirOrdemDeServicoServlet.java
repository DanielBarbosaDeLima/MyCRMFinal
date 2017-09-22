package com.yourcodelab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourcodelab.controller.OrdemDeServicoController;
import com.yourcodelab.model.OrdemDeServico;

@WebServlet("/InserirOrdemDeServicoServlet")
public class InserirOrdemDeServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdemDeServicoController control = new OrdemDeServicoController();
		
		String servico = request.getParameter("servico");
		String cliente = request.getParameter("cliente");
		String data = request.getParameter("data");
		String hora = request.getParameter("hora");
		
		OrdemDeServico o = new OrdemDeServico(new Integer(0),servico,cliente,data,hora);
		
		control.inserirOrdem(o);
		
		List<OrdemDeServico> ordens = control.listarTodos();
		if(ordens==null){
			ordens = new ArrayList();
		}
		request.setAttribute("listaOrdens", ordens);
		String nextPage = "/OrdemDeServico/listarOrdens.jsp";
		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(nextPage);
		dispacher.forward(request, response);
	}

}
