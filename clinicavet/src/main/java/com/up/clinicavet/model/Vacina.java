package com.up.clinicavet.model;

import java.util.List;

public class Vacina {
	private int id;
	private String nome;
	private String descricao;
	private List<VacinaAnimal> vacinasAnimal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<VacinaAnimal> getVacinasAnimal() {
		return vacinasAnimal;
	}
	public void setVacinasAnimal(List<VacinaAnimal> vacinasAnimal) {
		this.vacinasAnimal = vacinasAnimal;
	}
}