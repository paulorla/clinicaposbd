package com.up.clinicavet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
			
			Pessoa p = null;
			Animal a = null;
			TipoAnimal ta = null;
			Vacina v = null;
			
			em.getTransaction().begin();
			p = em.find(Pessoa.class, 1);
			a = em.find(Animal.class, 1);
			ta = em.find(TipoAnimal.class, 1);
			v = em.find(Vacina.class, 1);
			em.getTransaction().commit();
			
			System.out.println(p.getNome());
			System.out.println(a.getNome());
			System.out.println(ta.getNomeRaca());
			System.out.println(v.getNome());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}