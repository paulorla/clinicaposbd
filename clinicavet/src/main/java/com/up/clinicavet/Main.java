package com.up.clinicavet;

import java.util.Date;

import com.up.clinicavet.dao.AnimalDAO;
import com.up.clinicavet.dao.PessoaDAO;
import com.up.clinicavet.model.Animal;
import com.up.clinicavet.model.Pessoa;

public class Main {

	public static void main(String[] args) {
		
		try{
			Pessoa p = new Pessoa();
			p.setCpf(56780);
			p.setNascimento(new Date());
			p.setNome("Marian");
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.persistir(p);
			
			System.out.println(p.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}