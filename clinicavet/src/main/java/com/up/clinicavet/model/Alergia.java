package com.up.clinicavet.model;

import java.util.List;

public class Alergia {
	private int id;
	private String nome;
	private String descricao;
	
	private List<Animal> animais;
	
	public int getId() {
		return id;
	}
	public List<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
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
}
