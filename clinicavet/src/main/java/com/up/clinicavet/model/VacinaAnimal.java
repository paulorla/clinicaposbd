package com.up.clinicavet.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="VACINAANIMAL")
public class VacinaAnimal {
	@EmbeddedId
	private VacinaAnimalID id;
	@Column(length=200)
	private String descricaoVeterinario;
	
	public VacinaAnimal() {
		id = new VacinaAnimalID();
	}
	public VacinaAnimalID getId() {
		return id;
	}
	public void setId(VacinaAnimalID id) {
		this.id = id;
	}
	public Animal getAnimal() {
		return id.getAnimal();
	}
	public void setAnimal(Animal animal) {
		id.setAnimal(animal);
	}
	public Vacina getVacina() {
		return id.getVacina();
	}
	public void setVacina(Vacina vacina) {
		id.setVacina(vacina);
	}
	public Date getDataVacinacao() {
		return id.getDataVacinacao();
	}
	public void setDataVacinacao(Date dataVacinacao) {
		id.setDataVacinacao(dataVacinacao);
	}
	public String getDescricaoVeterinario() {
		return descricaoVeterinario;
	}
	public void setDescricaoVeterinario(String descricaoVeterinario) {
		this.descricaoVeterinario = descricaoVeterinario;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		VacinaAnimal other = (VacinaAnimal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
