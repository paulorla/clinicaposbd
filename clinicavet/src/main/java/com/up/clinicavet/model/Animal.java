package com.up.clinicavet.model;

import java.util.Date;
import java.util.List;

public class Animal {
	
	private int id;
	private TipoAnimal tipo;
	private Pessoa dono;
	private String nome;
	private Date nascimento;
	private List<VacinaAnimal> vacinasAnimal;
	
	public int getId() {
		return id;
	}
	public List<VacinaAnimal> getVacinasAnimal() {
		return vacinasAnimal;
	}
	public void setVacinasAnimal(List<VacinaAnimal> vacinasAnimal) {
		this.vacinasAnimal = vacinasAnimal;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TipoAnimal getTipo() {
		return tipo;
	}
	public void setTipo(TipoAnimal tipo) {
		this.tipo = tipo;
	}
	public Pessoa getDono() {
		return dono;
	}
	public void setDono(Pessoa dono) {
		this.dono = dono;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
}
