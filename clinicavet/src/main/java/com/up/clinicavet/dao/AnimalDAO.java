package com.up.clinicavet.dao;

import com.up.clinicavet.model.Animal;

public class AnimalDAO extends GenericDAO<Integer, Animal>{

	public AnimalDAO() {
		super(Animal.class);
	}

}
