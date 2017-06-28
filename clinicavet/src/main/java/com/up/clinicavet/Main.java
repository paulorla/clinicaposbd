package com.up.clinicavet;

import java.util.Date;
import java.util.List;

import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.dao.GenericDAO;
import com.up.clinicavet.dao.PessoaDAO;
import com.up.clinicavet.facade.PessoaFacade;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;
import com.up.clinicavet.model.TipoAnimal;

public class Main {
	public static void main(String[] args) {
		try {
			
			PessoaFacade pf = new PessoaFacade();
			Pessoa p = pf.buscarEager(0);
			
			System.out.println(p.getNome());
			
			for(Animal a : p.getAnimais())
				System.out.println("\t" + a.getNome());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!!!");
	}
}