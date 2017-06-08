package com.up.clinicavet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.up.clinicavet.model.Pessoa;

public class Main {
	public static void main(String[] args) {
		try{
			EntityManagerFactory factory = 
					Persistence.createEntityManagerFactory("clinica_pu");
			EntityManager em = factory.createEntityManager();
			
			Pessoa p = null;
			em.getTransaction().begin();
			p = em.find(Pessoa.class, 1);
			em.getTransaction().commit();
			
			System.out.println(p.getNome());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}