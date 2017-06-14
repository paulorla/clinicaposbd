package com.up.clinicavet.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANIMAL")
public class Animal {
	
	@Id
	@Column(name="animal_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//private TipoAnimal tipo;
	@ManyToOne
	@JoinColumn(name = "pessoa_id",nullable=false)
	private Pessoa dono;
	@Column(nullable=false)
	private String nome;
	private Date nascimento;
	//private List<VacinaAnimal> vacinasAnimal;
	@ManyToMany
	@JoinTable(name="alergiaanimal",
				joinColumns={
						@JoinColumn(name="animal_id",referencedColumnName="animal_id")},
				inverseJoinColumns={
						@JoinColumn(name="alergia_id",referencedColumnName="alergia_id")})
	private List<Alergia> alergias;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Alergia> getAlergias() {
		return alergias;
	}
	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}
//	public List<VacinaAnimal> getVacinasAnimal() {
//		return vacinasAnimal;
//	}
//	public void setVacinasAnimal(List<VacinaAnimal> vacinasAnimal) {
//		this.vacinasAnimal = vacinasAnimal;
//	}
//	public TipoAnimal getTipo() {
//		return tipo;
//	}
//	public void setTipo(TipoAnimal tipo) {
//		this.tipo = tipo;
//	}
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
		Animal other = (Animal) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
