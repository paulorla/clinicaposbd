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
			Pessoa p = new Pessoa();
			p.setCpf(22233);
			p.setNascimento(new Date());
			p.setNome("Teste");
			
			PessoaFacade pf = new PessoaFacade();
			pf.save(p);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			GenericDAO.fecharEntityManagerFactory();
		}
		System.out.println("Fim!!!");
	}
}