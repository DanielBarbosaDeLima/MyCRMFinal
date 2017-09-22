package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.OrdemDeServico;

public class OrdemDeServicoDAO extends GenericDAO{
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO TBORDEMDESERVICO(servico, cliente, data_ordem, hora) VALUES (?, ?, ?, ?);";
	private String SQL_SELECT = "SELECT * FROM TBORDEMDESERVICO;";
	public void inserir(OrdemDeServico o){
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, o.getServico());
			ps.setString(2, o.getCliente());
			ps.setString(3, o.getData());
			ps.setString(4, o.getHora());
			
			// Executar o comando de INSERT, logo não se espera retorno
			ps.executeUpdate();
			
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
	}
	
	public List<OrdemDeServico> listarTodos(){
		List<OrdemDeServico> lista = new ArrayList<OrdemDeServico>();
		
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar comando de SELECT
			ps = connect.prepareStatement(SQL_SELECT);
			
			// Retorno da consulta com os dados no ResultSet
			ResultSet rs = ps.executeQuery();
			
			// Se houve retorno
			if(rs != null){
				while(rs.next()){
					// Para cada registro do ResultSet, instanciar um objeto Cliente
					OrdemDeServico o = new OrdemDeServico(rs.getInt("id"), rs.getString("servico"), rs.getString("cliente"), rs.getString("data_ordem"), rs.getString("hora"));
					
					// Adicionar na lista de Clientes
					lista.add(o);
				}
			}
			
			// Fechar conexão
			closeConnection();
		} catch (ClassNotFoundException e) {
			System.out.println("Class not Found");
		} catch (IOException e) {
			System.out.println("File not Found");
		} catch (SQLException e) {
			System.out.println("Error on Connecting");
		}
		
		// Se por acado não houve retorno do banco de dados, retorna
		return lista;
	}
}
