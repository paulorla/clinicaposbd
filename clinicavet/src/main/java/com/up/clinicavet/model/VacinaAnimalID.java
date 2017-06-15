package com.up.clinicavet.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class VacinaAnimalID implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "animal_id", referencedColumnName = "animal_id")
	private Animal animal;
	@ManyToOne
	@JoinColumn(name = "vacina_id", referencedColumnName = "vacina_id")
	private Vacina vacina;
	private Date dataVacinacao;
	
	public Animal getAnimal() {
		return animal;
	}
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	public Vacina getVacina() {
		return vacina;
	}
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	public Date getDataVacinacao() {
		return dataVacinacao;
	}
	public void setDataVacinacao(Date dataVacinacao) {
		this.dataVacinacao = dataVacinacao;
	}
	
}