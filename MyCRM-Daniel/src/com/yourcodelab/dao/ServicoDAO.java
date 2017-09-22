package com.yourcodelab.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Servicos;

public class ServicoDAO extends GenericDAO{
	private PreparedStatement ps;
	private String SQL_INSERT = "INSERT INTO TBSERVICO(nome, tempo, valor, descricao) VALUES (?, ?, ?, ?);";
	private String SQL_SELECT = "SELECT * FROM TBSERVICO;";
	public void inserir(Servicos s){
		try {
			// Abrir conexão
			openConnection();
			
			// Preparar o comando SQL a ser enviado ao BD
			ps = connect.prepareStatement(SQL_INSERT);
			ps.setString(1, s.getNome());
			ps.setString(2, s.getTempo());
			ps.setDouble(3, s.getValor());
			ps.setString(4, s.getDescrição());
			
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
	
	public List<Servicos> listarTodos(){
		List<Servicos> lista = new ArrayList<Servicos>();
		
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
					Servicos s = new Servicos(rs.getInt("id"), rs.getString("nome"), rs.getString("tempo"), rs.getDouble("valor"), rs.getString("descricao"));
					
					// Adicionar na lista de Clientes
					lista.add(s);
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
