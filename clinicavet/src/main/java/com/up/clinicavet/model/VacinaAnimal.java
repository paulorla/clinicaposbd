package com.up.clinicavet.model;

import java.util.Date;

public class VacinaAnimal {
	private Animal animal;
	private Vacina vacina;
	private Date dataVacinacao;
	private String descricaoVeterinario;
	
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
	public String getDescricaoVeterinario() {
		return descricaoVeterinario;
	}
	public void setDescricaoVeterinario(String descricaoVeterinario) {
		this.descricaoVeterinario = descricaoVeterinario;
	}
}
