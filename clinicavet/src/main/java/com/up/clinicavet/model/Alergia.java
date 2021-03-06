package com.up.clinicavet.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ALERGIA")
public class Alergia {
	@Id
	@Column(name="alergia_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="nomealergia", nullable=false)
	private String nome;
	private String descricao;
	
	//private List<Animal> animais;
	
	public int getId() {
		return id;
	}
//	public List<Animal> getAnimais() {
//		return animais;
//	}
//	public void setAnimais(List<Animal> animais) {
//		this.animais = animais;
//	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alergia other = (Alergia) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
