package com.up.clinicavet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.dao.IGenericDAO;
import com.up.clinicavet.dao.PessoaDAO;
import com.up.clinicavet.dao.VacinaAnimalDAO;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;
import com.up.clinicavet.model.TipoAnimal;

public class Main {
	public static void main(String[] args) {		
		try{
			Animal a;
			AnimalDAO animalDAO = new AnimalDAO();
			a = animalDAO.buscar(0);
			
			System.out.println(a.getNome());			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}