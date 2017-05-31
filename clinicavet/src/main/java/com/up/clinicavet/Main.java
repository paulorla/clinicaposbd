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
			p.setCpf(676767);
			p.setNascimento(new Date());
			p.setNome("Maria");
			p.setId(345);
			
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.persistir(p);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Fim!");
	}
}