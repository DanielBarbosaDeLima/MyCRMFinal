package com.yourcodelab.model;

public class Servicos {
	private Integer id;
	private String nome;
	private String tempo;
	private double valor;
	private String descri��o;
	
	public Servicos(){
		
	}
	public Servicos(Integer id, String nome, String tempo, double valor, String descri��o) {
		this.id = id;
		this.nome = nome;
		this.tempo = tempo;
		this.valor = valor;
		this.descri��o = descri��o;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescri��o() {
		return descri��o;
	}
	public void setDescri��o(String descri��o) {
		this.descri��o = descri��o;
	}
}
