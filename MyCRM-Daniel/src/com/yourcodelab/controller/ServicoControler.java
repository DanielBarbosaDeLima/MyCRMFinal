package com.yourcodelab.controller;

import java.util.List;

import com.yourcodelab.dao.ServicoDAO;
import com.yourcodelab.model.Servicos;

public class ServicoControler {
	ServicoDAO dao = new ServicoDAO();
	
	
	public void inserirServico(Servicos s){
		dao.inserir(s);
	}
	
	public List<Servicos> listarServico(){
		return dao.listarTodos();
	}
}
