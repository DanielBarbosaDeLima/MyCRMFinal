package com.yourcodelab.model;

public class OrdemDeServico {
	private Integer id;
	private String servico;
	private String cliente;
	private String data;
	private String hora;
	
	public OrdemDeServico(){
		
	}
	public OrdemDeServico(Integer id, String servico, String cliente, String data, String hora) {
		this.id = id;
		this.servico = servico;
		this.cliente = cliente;
		this.data = data;
		this.hora = hora;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
