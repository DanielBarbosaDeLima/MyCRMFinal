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

import com.yourcodelab.controller.ServicoControler;
import com.yourcodelab.model.Servicos;

/**
 * Servlet implementation class InserirServicoServlet
 */
@WebServlet("/InserirServicoServlet")
public class InserirServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServicoControler control = new ServicoControler();
		
		String nome = request.getParameter("nome");
		String tempo = request.getParameter("tempo");
		Double valor = Double.parseDouble(request.getParameter("valor"));
		String descricao = request.getParameter("descricao");
		
		Servicos s = new Servicos(new Integer(0),nome,tempo,valor,descricao);
		
		control.inserirServico(s);
		
		List<Servicos> servicos = control.listarServico();
		
		if(servicos==null){
			servicos = new ArrayList<>();
		}
		request.setAttribute("listaServicos", servicos);
		
		String nextPage = "/servicos/listarServicos.jsp";
		RequestDispatcher dispacher = getServletContext().getRequestDispatcher(nextPage);
		dispacher.forward(request, response);
	}
	
}
