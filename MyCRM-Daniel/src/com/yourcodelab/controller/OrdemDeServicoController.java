package com.yourcodelab.controller;

import java.util.List;

import com.yourcodelab.dao.OrdemDeServicoDAO;
import com.yourcodelab.model.OrdemDeServico;

public class OrdemDeServicoController {
	private OrdemDeServicoDAO dao = new OrdemDeServicoDAO();
	
	public void inserirOrdem(OrdemDeServico o){
		if(o!=null){
			dao.inserir(o);
		}
	}
	
	public List<OrdemDeServico> listarTodos(){
		return dao.listarTodos();
	}
}
