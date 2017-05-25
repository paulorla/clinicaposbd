package com.up.clinicavet;

import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.model.Animal;

public class Main {

	public static void main(String[] args) {
		
		try{
			AnimalDAO animalDAO = new AnimalDAO();
			Animal a = animalDAO.buscar(0);
			
			System.out.println(a.getNome());
			System.out.println(a.getDono().getId());
			
		}catch(Exception e){
			e.printStackTrace();
		}

		System.out.println("Fim!");
	}
}