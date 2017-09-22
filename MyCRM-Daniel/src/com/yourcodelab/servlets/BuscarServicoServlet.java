package com.yourcodelab.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yourcodelab.controller.ServicoControler;
import com.yourcodelab.model.Servicos;

@WebServlet("/BuscarServicoServlet")
public class BuscarServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicoControler control = new ServicoControler();
		List<Servicos> servicos = control.listarServico();
		
		request.setAttribute("listaServicos", servicos);
		
		String nextPage = "/OrdemDeServico/inserirOrdem.jsp";
		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(nextPage);
		dispacher.forward(request, response);
	}
}
