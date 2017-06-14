package com.up.clinicavet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.clinicavet.model.Alergia;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;
import com.up.clinicavet.model.TipoAnimal;
import com.up.clinicavet.model.Vacina;

public class Main {
	public static void main(String[] args) {
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("clinica_pu");
			EntityManager em = factory.createEntityManager();
			
			Pessoa p;
			
			em.getTransaction().begin();
			p = em.find(Pessoa.class, 0);
			em.getTransaction().commit();
			
			System.out.println(p.getNome());
			for(Animal a : p.getAnimais()){
				System.out.println(a.getNome() + "\t" + a.getDono().getNome());				
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}