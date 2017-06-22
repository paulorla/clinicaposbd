package com.up.clinicavet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PESSOA")
@NamedQueries({
@NamedQuery (name="Pessoa.findBycpf", query = "Select p FROM Pessoa p where p.cpf = :cpf" ),
@NamedQuery(name="Pessoa.listSemDataNascimento",
query="SELECT p FROM Pessoa p WHERE p.nascimento is null")
})
public class Pessoa {
	@Id
	@Column(name="pessoa_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private long cpf;
	@Column(length=50, nullable=false)
	private String nome;
	@Column(nullable=true)
	private Date nascimento;
	@OneToMany(mappedBy="dono", fetch=FetchType.LAZY)
	private List<Animal> animais;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
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
	public List<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
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
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
