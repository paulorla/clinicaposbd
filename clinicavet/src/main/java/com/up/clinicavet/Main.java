package com.up.clinicavet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.clinicavet.model.Alergia;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;
import com.up.clinicavet.model.TipoAnimal;
import com.up.clinicavet.model.Vacina;
import com.up.clinicavet.model.VacinaAnimal;

public class Main {
	public static void main(String[] args) {
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("clinica_pu");
			EntityManager em = factory.createEntityManager();
			
			Animal a;
			
			em.getTransaction().begin();
			a = em.find(Animal.class, 0);
			em.getTransaction().commit();
			
			System.out.println(a.getNome());
			for(Alergia al : a.getAlergias()){
				System.out.println(al.getNome());				
			}
			for(VacinaAnimal va : a.getVacinasAnimal()){
				System.out.println(va.getVacina().getNome());
			}
			
			em.close();
			factory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}